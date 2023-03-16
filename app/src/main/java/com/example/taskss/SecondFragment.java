package com.example.taskss;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;


public class SecondFragment extends Fragment implements View.OnClickListener {
    public Button btnCountry;
    public Button btnCars;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCountry = (Button) view.findViewById(R.id.buttonCountry);
        btnCountry.setOnClickListener(this);
        btnCars = (Button) view.findViewById(R.id.buttonChooseAuto);
        btnCars.setOnClickListener(this);
        /*btnCountry.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.buttonCountry:
                        Log.d("111","Clicked country choose");
                        Navigation.findNavController(view).navigate(R.id.action_secondFragment2_to_chooseCountryFragment);
                        break;
                    case R.id.buttonChooseAuto:
                        Log.d("111","Clicked auto choose");
                        Navigation.findNavController(view).navigate(R.id.action_secondFragment2_to_fragmentResview);
                        break;
                }
            }
        });*/
    }

    public void setSelectedItem(String selectedItem) {
        TextView view = getView().findViewById(R.id.countryAcc);
        view.setText(selectedItem);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonCountry:
                Log.d("111","Clicked country choose");
                Navigation.findNavController(v).navigate(R.id.action_secondFragment2_to_chooseCountryFragment);
                break;
            case R.id.buttonChooseAuto:
                Log.d("111","Clicked auto choose");
                Navigation.findNavController(v).navigate(R.id.action_secondFragment2_to_fragmentResview);
                break;
        }
    }
}