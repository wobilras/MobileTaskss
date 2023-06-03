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
import com.example.taskss.data.MainRepository;
import com.example.taskss.data.db.entity.User;

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
        EditText login = view.findViewById(R.id.loginReg);
        EditText pass = view.findViewById(R.id.passReg);

        EditText pass2 = view.findViewById(R.id.pass2Reg);
        Button btnContinue = view.findViewById(R.id.buttonContinueReg);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pass.getText().toString().equals(pass2.getText().toString())) {
                    Log.d("111", "Clicked button continue");
                    String mailS = mail.getText().toString();
                    String loginS = login.getText().toString();
                    String passS = pass.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("mail", mailS);
                    bundle.putString("login", loginS);
                    bundle.putString("pass", passS);

                    Navigation.findNavController(v).navigate(R.id.action_registration_to_registration2, bundle);
                }
                else
                    Toast.makeText(getContext(), "Повторный пароль введен неверно!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}