package com.example.taskss.ui.registration;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.taskss.R;

public class Registration2 extends Fragment {
    private ImageView im;
    private ActivityResultLauncher<String> launcher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        im = view.findViewById(R.id.imageCarLicense);
        Button btnDownImage = view.findViewById(R.id.buttonDownCarLicense);
        launcher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri uri) {
                im.setImageURI(uri);
            }
        });
        btnDownImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcher.launch("image/*");
            }
        });

        EditText licenceNum = view.findViewById(R.id.licenseNumber);
        //Switch licenceType = view.findViewById(R.id.switchLicense);//крашит
        //Boolean licenceTypeSave = licenceType.isChecked();


        Button btnContinue = view.findViewById(R.id.buttonContinueReg2);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String licenceNumS = licenceNum.getText().toString();
                Bundle bundle = getArguments();
                bundle.putString("licenceNum", licenceNumS);
                Navigation.findNavController(v).navigate(R.id.action_registration2_to_registration3, bundle);
            }
        });
    }
}