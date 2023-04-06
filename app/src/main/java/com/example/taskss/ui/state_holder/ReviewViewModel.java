package com.example.taskss.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.taskss.data.MainRepository;
import com.example.taskss.data.db.entity.State;

import java.util.List;

public class ReviewViewModel extends AndroidViewModel {

    private final MainRepository repository = new MainRepository(getApplication());

    public LiveData<List<State>> carListLd = repository.getCarList();

    public ReviewViewModel(@NonNull Application application) {
        super(application);
    }
}
