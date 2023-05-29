package com.example.taskss.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.taskss.R;

public class MenuFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv = view.findViewById(R.id.userName);
        tv.setText(getArguments().getString("data"));
        Button btnProfile = view.findViewById(R.id.buttonProfile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = tv.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("data", data);
                Navigation.findNavController(v).navigate(R.id.action_menuFragment_to_secondFragment2, bundle);
            }
        });
        Button btnCars = view.findViewById(R.id.buttonNearestCars);
        btnCars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_menuFragment_to_fragmentResview);
            }
        });
        Button btnAboutApp = view.findViewById(R.id.buttonAboutTheApp);
        btnAboutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_menuFragment_to_aboutTheApp);
            }
        });
        Button btnMap = view.findViewById(R.id.buttonMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_menuFragment_to_mapFragment);
            }
        });
        Button btnSettings = view.findViewById(R.id.buttonSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_menuFragment_to_settingsFragment);
            }
        });
    }
}