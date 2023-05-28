package com.example.taskss.ui.registration;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.taskss.R;

public class Registration1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText mail = view.findViewById(R.id.elMailReg);
        String mailSave = mail.getText().toString();
        EditText login = view.findViewById(R.id.loginReg);
        String loginSave = login.getText().toString();
        EditText pass = view.findViewById(R.id.passReg);
        String passSave = pass.getText().toString();

        EditText pass2 = view.findViewById(R.id.pass2Reg);
        Button btnContinue = view.findViewById(R.id.buttonContinueReg);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pass.getText().toString().equals(pass2.getText().toString())) {
                    Log.d("111", "Clicked button continue");
                    Navigation.findNavController(v).navigate(R.id.action_registration_to_registration2);
                }
                else
                    Toast.makeText(getContext(), "Повторный пароль введен неверно!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}