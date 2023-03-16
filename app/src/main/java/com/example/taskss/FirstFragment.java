package com.example.taskss;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FirstFragment extends Fragment{
    private final String TAG = "ApplicationMessage";
    public Button btnContinue;
    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        btnContinue = (Button) view.findViewById(R.id.btnContinue1);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btnContinue1) {
                    Log.d(TAG, "Clicked button continue");

                    Navigation.findNavController(v).navigate(R.id.action_firstFragment_to_secondFragment2);
                }
            }
        });
        TextView myTextView = (TextView) view.findViewById(R.id.editText);
        myTextView.setText("User_Login");
        ImageView myImageView = view.findViewById(R.id.imageOnOpenAct);
        myImageView.setImageResource(R.drawable.ic_action_name);
    }
}