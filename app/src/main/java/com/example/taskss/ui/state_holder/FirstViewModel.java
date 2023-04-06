package com.example.taskss.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.taskss.data.MainRepository;
import com.example.taskss.data.models.LoginPerson;

public class FirstViewModel extends AndroidViewModel {

    private final MainRepository repository = new MainRepository(getApplication());

    public boolean login(String login) {
        LoginPerson loginPerson = new LoginPerson(login);
        return repository.personLogin(loginPerson);
    }

    public FirstViewModel(@NonNull Application application) {
        super(application);
    }
}
