package com.example.taskss.ui;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.taskss.R;

public class AboutTheApp extends Fragment {
    public AboutTheApp() {
        super(R.layout.fragment_about_the_app);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView iv = view.findViewById(R.id.maskAbout);
        AnimatedVectorDrawable avd = (AnimatedVectorDrawable) iv.getDrawable();
        avd.start();
    }
}