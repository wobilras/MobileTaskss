package com.example.taskss.data;

import android.content.Context;

import com.example.taskss.R;
import com.example.taskss.domain.entity.LoginPerson;
import com.example.taskss.domain.entity.State;

import java.util.ArrayList;
import java.util.List;

public class DBRemoteDataSource {
    private Context context;

    public DBRemoteDataSource(Context context) {
        this.context = context;
    }

    public List<State> getCarList(){
        List<State> states = new ArrayList<>();
        String[] cars = context.getResources().getStringArray(R.array.MarksOfCars);
        for(int i=0;i<20;i++){
            states.add(new State (cars[i], R.drawable.ic_action_name));
        }
        return states;
    }
    public boolean PersonLogin(LoginPerson loginPerson){
        return true;
    }
}
