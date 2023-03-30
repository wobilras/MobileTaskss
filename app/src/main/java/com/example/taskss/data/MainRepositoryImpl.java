package com.example.taskss.data;

import android.content.Context;

import com.example.taskss.domain.MainRepository;
import com.example.taskss.domain.entity.LoginPerson;
import com.example.taskss.domain.entity.State;

import java.util.List;

public class MainRepositoryImpl implements MainRepository {
    private Context context;
    private DBRemoteDataSource dataSource;

    public MainRepositoryImpl(Context context) {
        this.context = context;
        dataSource = new DBRemoteDataSource(context);
    }

    @Override
    public List<State> getArchiveList() {
        return dataSource.getCarList();
    }

    @Override
    public boolean personLogin(LoginPerson loginPerson) {
        return dataSource.PersonLogin(loginPerson);
    }
}
