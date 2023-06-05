package com.example.taskss.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.taskss.R;
import com.example.taskss.data.db.entity.State;
import com.example.taskss.ui.state_holder.AddingCarViewModel;
import com.example.taskss.ui.state_holder.Registration3ViewModel;

public class AddingCar extends Fragment {
    private AddingCarViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_adding_car, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AddingCarViewModel.class);
        EditText mark = view.findViewById(R.id.nameOfAddingCar);
        Button btnAdd = view.findViewById(R.id.buttonAddCarToList);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addCars(new State(
                        mark.getText().toString(),
                        2131230864
                        )
                );
            }
        });
    }
}