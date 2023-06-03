package com.example.taskss.ui.registration;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.taskss.R;
import com.example.taskss.data.db.entity.User;
import com.example.taskss.ui.state_holder.Registration3ViewModel;

public class Registration3 extends Fragment {
    private ActivityResultLauncher<String> launcher;

    private Registration3ViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(Registration3ViewModel.class);

        EditText passportNum = view.findViewById(R.id.passportNumber);
        EditText fio = view.findViewById(R.id.fullName);
        EditText birthDate = view.findViewById(R.id.birthDate);

        Button btnDownImage = view.findViewById(R.id.buttonDownloadPass);
        launcher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri uri) {
                //im.setImageURI(uri);
                Bitmap bitmap = BitmapFactory.decodeFile(String.valueOf(uri));
            }
        });
        btnDownImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcher.launch("image/*");
            }
        });

        Button btnContinue = view.findViewById(R.id.buttonContinueReg3);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getArguments();
                String mail = bundle.getString("mail");
                String login = bundle.getString("login");
                String pass = bundle.getString("pass");
                String licenceNum = bundle.getString("licenceNum");

                viewModel.registration(new User(
                        mail,
                        login,
                        pass,
                        fio.getText().toString(),
                        licenceNum,
                        passportNum.getText().toString(),
                        birthDate.getText().toString()
                ));
                Navigation.findNavController(v).navigate(R.id.action_registration3_to_firstFragment);
            }
        });
    }
}