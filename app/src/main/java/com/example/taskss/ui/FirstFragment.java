package com.example.taskss.ui;

import static androidx.core.content.PermissionChecker.checkSelfPermission;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

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

public class FirstFragment extends Fragment {
    private static final String KEY_LOGIN = "login";
    private final String TAG = "ApplicationMessage";
    public Button btnContinue;

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
        EditText ed = view.findViewById(R.id.editText);

        // read
        SharedPreferences sharedPrefRead =
                requireActivity().getPreferences(Context.MODE_PRIVATE);
        String loginSP = sharedPrefRead.getString(KEY_LOGIN, "");
        ed.setText(loginSP);

        btnContinue = (Button) view.findViewById(R.id.btnContinue1);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Clicked button continue");
                String data = ed.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("data", data);

                // write
                SharedPreferences sharedPrefWrite =
                        requireActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefWrite.edit();
                editor.putString(KEY_LOGIN, data);
                editor.apply();

                if (viewModel.login(
                        ed.getText().toString(),
                        allowedPermission()
                )) {
                    Navigation.findNavController(v).navigate(R.id.action_firstFragment_to_secondFragment2, bundle);
                }
            }
        });
//        TextView myTextView = (TextView) view.findViewById(R.id.editText);
//        myTextView.setText("User_Login");
        ImageView myImageView = view.findViewById(R.id.imageOnOpenAct);
        myImageView.setImageResource(R.drawable.ic_action_name);
    }

    private boolean allowedPermission() {
        if (checkSelfPermission(requireContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PermissionChecker.PERMISSION_GRANTED) {
            return true;
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            return false;
        }
    }

}