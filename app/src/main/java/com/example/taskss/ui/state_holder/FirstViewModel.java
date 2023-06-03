package com.example.taskss.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.taskss.data.MainRepository;
import com.example.taskss.data.models.LoginPerson;

public class FirstViewModel extends AndroidViewModel {

    private final MainRepository repository = new MainRepository(getApplication());


    public LiveData<Boolean> login(String login, String pass) {
        return repository.personLogin(login, pass);
    }

    public FirstViewModel(@NonNull Application application) {
        super(application);
    }
}
