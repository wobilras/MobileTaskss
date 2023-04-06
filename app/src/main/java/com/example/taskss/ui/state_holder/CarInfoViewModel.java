package com.example.taskss.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.taskss.data.MainRepository;
import com.example.taskss.data.models.State;

public class CarInfoViewModel extends AndroidViewModel {

    private final MainRepository repository = new MainRepository(getApplication());

    public LiveData<State> carListItemLd;

    public void getListItem(int position) {
        carListItemLd = repository.getItem(position);
    }

    public CarInfoViewModel(@NonNull Application application) {
        super(application);
    }
}
