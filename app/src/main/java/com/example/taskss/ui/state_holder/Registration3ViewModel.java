package com.example.taskss.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.taskss.data.MainRepository;
import com.example.taskss.data.db.entity.User;

public class Registration3ViewModel extends AndroidViewModel {
    public Registration3ViewModel(@NonNull Application application) {
        super(application);
    }

    private MainRepository repository = new MainRepository(getApplication());

    public void registration(User user) {
        repository.registration(user);
    }

}
