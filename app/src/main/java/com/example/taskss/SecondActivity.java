package com.example.taskss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onSendData(String selectedItem) {
        SecondFragment fragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.secondFragment);
        if (fragment != null)
            fragment.setSelectedItem(selectedItem);
    }

}