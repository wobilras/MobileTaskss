package com.example.taskss.data;

import androidx.lifecycle.LiveData;

import com.example.taskss.data.models.LoginPerson;
import com.example.taskss.data.models.State;

import java.util.List;

public interface MainProtocol {
    LiveData<List<State>> getArchiveList();
    boolean personLogin(LoginPerson loginPerson);
}
