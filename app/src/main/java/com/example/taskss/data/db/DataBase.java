package com.example.taskss.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.taskss.data.db.dao.StateDao;
import com.example.taskss.data.db.dao.UserDao;
import com.example.taskss.data.db.entity.State;
import com.example.taskss.data.db.entity.User;

@Database(entities = {State.class, User.class}, version = 1, exportSchema = false)
public abstract class DataBase extends RoomDatabase {

    private static volatile DataBase INSTANCE;

    public abstract StateDao stateDao();
    public abstract UserDao userDao();

    public static DataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DataBase.class, "carsharing_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
