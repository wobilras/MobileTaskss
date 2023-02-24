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
        Bundle arg = getIntent().getExtras();
        TextView myTextView = (TextView) findViewById(R.id.userName);
        myTextView.setText(arg.getString("login"));
    }

    public void onClickLogout(View view) {
        Intent data = new Intent();
        data.putExtra(MainActivity.message,"Вы успешно вышли из аккаунта");
        finish();
    }
}