package com.example.taskss.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.taskss.data.MainRepository;
import com.example.taskss.data.db.entity.State;

public class AddingCarViewModel extends AndroidViewModel {
    public AddingCarViewModel(@NonNull Application application) {
        super(application);
    }

    private MainRepository repository = new MainRepository(getApplication());

    public void addCars(State state) {
        repository.addCar(state);
    }
}
