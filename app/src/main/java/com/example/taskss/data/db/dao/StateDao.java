package com.example.taskss.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.taskss.data.db.entity.State;

import java.util.List;

@Dao
public interface StateDao {
    @Query("SELECT * FROM cars_table")
    LiveData<List<State>> getCarList();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(State state);

    @Query("SELECT * FROM cars_table WHERE :id LIKE id")
    LiveData<State> getItem(int id);
}
