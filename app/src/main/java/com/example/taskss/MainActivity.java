package com.example.taskss;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "ApplicationMessage";
    Button btnContinue;
    static final String message ="Exit";

    ActivityResultLauncher<Intent> mStForRes = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            TextView tw = findViewById(R.id.tofromSecActTXT);
            Intent intent = result.getData();
            tw.setText(intent.getStringExtra(message));
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnContinue = findViewById(R.id.btnContinue1);
        btnContinue.setOnClickListener((View.OnClickListener) this);

        TextView myTextView = (TextView) findViewById(R.id.editText);
        myTextView.setText("User_Login");
        ImageView myImageView = findViewById(R.id.imageOnOpenAct);
        myImageView.setImageResource(R.drawable.ic_action_name);

        //Toast.makeText(getApplicationContext(), "Created", Toast.LENGTH_SHORT).show();
        //Log.v(TAG, "Создано снова");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnContinue1)
                Log.d(TAG,"Clicked button continue");
    }
    public void onClickDoLog(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        EditText myEditText = (EditText) findViewById(R.id.editText);
        intent.putExtra("login",myEditText.getText());
        mStForRes.launch(intent);
        Log.d(TAG,"Clicked button continue");
    }

    /*@Override
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
    }*/
}