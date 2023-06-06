package com.example.taskss.ui;

import static androidx.core.content.PermissionChecker.checkSelfPermission;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taskss.R;
import com.example.taskss.ui.state_holder.FirstViewModel;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    private static final String KEY_LOGIN = "login";
    private final String TAG = "ApplicationMessage";
    public Button btnContinue;
    public Button btnReg;

    private FirstViewModel viewModel;

    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(FirstViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        checkPermissions();
        EditText ed = view.findViewById(R.id.editText);
        EditText editTextTextPassword = view.findViewById(R.id.editTextTextPassword);
        /*Intent intent = requireActivity().getIntent();
        if (intent != null) {
            String action = intent.getAction();
            String type = intent.getType();
            if (Intent.ACTION_SEND.equals(action) && type != null) {
                if (type.equalsIgnoreCase("text/plain")) {
                    String textData = intent.getStringExtra(Intent.EXTRA_TEXT);
                    ed.setText(textData);
                }
            }
        }*/

        // read
//        SharedPreferences sharedPrefRead =
//                requireActivity().getPreferences(Context.MODE_PRIVATE);
//        String loginSP = sharedPrefRead.getString(KEY_LOGIN, "");
//        ed.setText(loginSP);

        btnContinue = (Button) view.findViewById(R.id.btnContinue1);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Clicked button continue");
                String data = ed.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("data", data);

                viewModel.login(
                        ed.getText().toString(),
                        editTextTextPassword.getText().toString()).observe(
                        getViewLifecycleOwner(),
                        aBoolean -> {
                            if (aBoolean) {
                                Navigation.findNavController(v).navigate(R.id.action_firstFragment_to_menuFragment, bundle);
                            }
                        });
            }
        });
        btnReg = view.findViewById(R.id.registrationButton);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Clicked button registration");
                Navigation.findNavController(v).navigate(R.id.action_firstFragment_to_registration);
            }
        });
//        TextView myTextView = (TextView) view.findViewById(R.id.editText);
//        myTextView.setText("User_Login");
        ImageView myImageView = view.findViewById(R.id.imageOnOpenAct);
        myImageView.setImageResource(R.drawable.ic_action_name);
    }

    /*private boolean allowedPermission() {
        if (checkSelfPermission(requireContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PermissionChecker.PERMISSION_GRANTED) {
            return true;
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            return false;
        }
    }*/
    private void checkPermissions() {
        String[] permissions = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.SYSTEM_ALERT_WINDOW};
        List<String> permissionsToRequest = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(requireActivity(), permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsToRequest.add(permission);
            }
        }
        if (!permissionsToRequest.isEmpty()) {
            ActivityCompat.requestPermissions(requireActivity(), permissionsToRequest.toArray(new String[0]), 1);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(requireActivity())) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + requireActivity().getPackageName()));
                ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (Settings.canDrawOverlays(requireActivity())) {
                        // Разрешение "Всегда сверху" было предоставлено
                    } else {
                        // Разрешение "Всегда сверху" не было предоставлено
                    }
                });
                launcher.launch(intent);
            }
        }
    }


}