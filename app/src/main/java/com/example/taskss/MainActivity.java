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


        //Toast.makeText(getApplicationContext(), "Created", Toast.LENGTH_SHORT).show();
        //Log.i(TAG,"Created");
        //Log.v(TAG, "Создано снова");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(getApplicationContext(), "Started", Toast.LENGTH_SHORT).show();
        //Log.i(TAG,"Started");
    }
    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(getApplicationContext(), "Resumed", Toast.LENGTH_SHORT).show();
        //Log.i(TAG,"Resumed");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Paused", Toast.LENGTH_SHORT).show();
        //Log.i(TAG,"Paused");
        //Log.v(TAG, "приложение было свернуто уже много раз");
    }
    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(getApplicationContext(), "Stopped", Toast.LENGTH_SHORT).show();
        //Log.i(TAG,"Stopped");
        //Log.d(TAG,"Stopped");
        //Log.w(TAG, "Заканчивается память");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        //Toast.makeText(getApplicationContext(), "Restarted", Toast.LENGTH_SHORT).show();
        //Log.i(TAG,"Restarted");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(getApplicationContext(), "Destroyed", Toast.LENGTH_SHORT).show();
        //Log.i(TAG,"Destroyed");
    }
}