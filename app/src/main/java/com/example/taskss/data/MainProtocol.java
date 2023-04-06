package com.example.taskss.data;

import androidx.lifecycle.LiveData;

import com.example.taskss.data.models.LoginPerson;
import com.example.taskss.data.db.entity.State;

import java.util.List;

public interface MainProtocol {
    LiveData<List<State>> getCarList();

    boolean personLogin(LoginPerson loginPerson, boolean allow);

    LiveData<State> getItem(int position);
}
