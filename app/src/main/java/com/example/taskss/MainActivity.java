package com.example.taskss;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "ApplicationMessage";
    public Button btnContinue;
    static final String message ="Exit";

    ActivityResultLauncher<Intent> mStForRes = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            TextView tw = findViewById(R.id.tofromSecActTXT);
            Intent intent = result.getData();
            if (intent != null) {
                tw.setText(intent.getStringExtra(message));
            }
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

    public void onClickDoLog(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        EditText myEditText = (EditText) findViewById(R.id.editText);
        intent.putExtra("login",myEditText.getText());
        mStForRes.launch(intent);
        Log.d(TAG,"Clicked button continue");
    }
}