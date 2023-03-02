package com.example.taskss;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    private final String TAG = "ApplicationMessage";
    public Button btnContinue;

    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        btnContinue = view.findViewById(R.id.btnContinue1);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG,"Clicked button continue");
            }
        });

        TextView myTextView = (TextView) view.findViewById(R.id.editText);
        myTextView.setText("User_Login");
        ImageView myImageView = view.findViewById(R.id.imageOnOpenAct);
        myImageView.setImageResource(R.drawable.ic_action_name);
    }

}