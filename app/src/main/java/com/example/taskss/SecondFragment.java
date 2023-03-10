package com.example.taskss;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;


public class SecondFragment extends Fragment {
    public Button btnCountry;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCountry = view.findViewById(R.id.buttonCountry);
        btnCountry.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.buttonCountry:
                        Log.d("111","Clicked country choose");
                        break;
                    case R.id.buttonChooseAuto:
                        Log.d("111","Clicked auto choose");
                        break;
                }
            }
        });
    }

    public void setSelectedItem(String selectedItem) {
        TextView view = getView().findViewById(R.id.countryAcc);
        view.setText(selectedItem);
    }
}