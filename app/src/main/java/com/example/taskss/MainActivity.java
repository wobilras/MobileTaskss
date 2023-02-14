package com.example.taskss;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "ApplicationMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "Created", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"Created");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(getApplicationContext(), "Started", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"Started");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(getApplicationContext(), "Resumed", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(getApplicationContext(), "Paused", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(getApplicationContext(), "Stopped", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"Stopped");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(getApplicationContext(), "Restarted", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"Restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(getApplicationContext(), "Destroyed", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"Destroyed");
    }
}