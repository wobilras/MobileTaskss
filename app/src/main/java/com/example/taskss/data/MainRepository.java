package com.example.taskss.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.taskss.data.models.LoginPerson;
import com.example.taskss.data.db.entity.State;

import java.util.List;

public class MainRepository implements MainProtocol {
    private Context context;
    private DBRemoteDataSource dataSource;

    public MainRepository(Context context) {
        this.context = context;
        dataSource = new DBRemoteDataSource(context);
    }

    @Override
    public LiveData<List<State>> getCarList() {
        return dataSource.getCarList();
    }


    @Override
    public boolean personLogin(LoginPerson loginPerson, boolean allow) {
        return dataSource.PersonLogin(loginPerson, allow);
    }

    @Override
    public LiveData<State> getItem(int position) {
        return dataSource.getItem(position);
    }
}
