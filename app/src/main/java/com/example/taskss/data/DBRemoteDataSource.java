package com.example.taskss.data;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.taskss.FileWorker;
import com.example.taskss.R;
import com.example.taskss.data.db.DataBase;
import com.example.taskss.data.db.dao.StateDao;
import com.example.taskss.data.db.dao.UserDao;
import com.example.taskss.data.db.entity.User;
import com.example.taskss.data.models.LoginPerson;
import com.example.taskss.data.db.entity.State;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class DBRemoteDataSource {
    private final Context context;
    private final WorkManager workManager;

    public DBRemoteDataSource(Context context) {
        this.context = context;
        workManager = WorkManager.getInstance(context);
    }

    public LiveData<List<State>> getCarList() {
        List<State> states = new ArrayList<>();
        String[] cars = context.getResources().getStringArray(R.array.MarksOfCars);
        for (int i = 0; i < 20; i++) {
            states.add(new State(cars[i], R.drawable.ic_action_name));
        }
        DataBase db = DataBase.getDatabase(context);
        StateDao stateDao = db.stateDao();
        SharedPreferences prefs = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        boolean isFirstRun = prefs.getBoolean("isFirstRun", true);
        if (isFirstRun) {
            // Добавление элемента в бд
            db.getQueryExecutor().execute(() -> {
                for (State state : states) {
                    stateDao.insert(state);
                }
                prefs.edit().putBoolean("isFirstRun", false).apply();
            });
        }
        return stateDao.getCarList();
    }

    public LiveData<Boolean> PersonLogin(String login, String pass) {
        DataBase db = DataBase.getDatabase(context);
        UserDao userDao = db.userDao();
        return userDao.getUserByLogin(login, pass);
//        String filename = "login";
//        String fileContents = loginPerson.getLogin();
//        File dir = context.getFilesDir();
//        File file_login = new File(dir, filename);
//        try {
//            FileOutputStream fos = new FileOutputStream(file_login);
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
//            writer.write(fileContents);
//            writer.close();
//            fos.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        if (allow) {
//            String filename2 = "login";
//            String fileContents2 = loginPerson.getLogin();
//            File file_login2 = new File("/storage/emulated/0/Android/data", filename2);
//            try {
//                FileOutputStream fos = new FileOutputStream(file_login2);
//                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
//                writer.write(fileContents2);
//                writer.close();
//                fos.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        OneTimeWorkRequest fileRequest =
//                new OneTimeWorkRequest.Builder(FileWorker.class)
//                        .setInputData(createInputData(loginPerson.getLogin()))
//                        .build();
//        workManager.enqueue(fileRequest);
//        return !loginPerson.getLogin().equals("");
    }

    private Data createInputData(String login) {
        Data.Builder builder = new Data.Builder();
        builder.putString(FileWorker.KEY_LOGIN, login);
        return builder.build();
    }

    public LiveData<State> getItem(int position) {
        DataBase db = DataBase.getDatabase(context);
        StateDao stateDao = db.stateDao();
        return stateDao.getItem(position + 1);
    }

    public void registration(User user) {
        DataBase db = DataBase.getDatabase(context);
        UserDao userDao = db.userDao();
        db.getQueryExecutor().execute(() -> {
            userDao.insert(user);
        });
    }

    public void addCar(State state){
        DataBase db = DataBase.getDatabase(context);
        StateDao stateDao = db.stateDao();
        db.getQueryExecutor().execute(() -> {
            stateDao.insert(state);
        });
    }
}
