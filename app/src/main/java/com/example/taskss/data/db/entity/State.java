package com.example.taskss.data.db.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cars_table")
public class State {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public Integer uid;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "carResource")
    private int carResource;

    public State(String name, int carResource) {
        this.name = name;
        this.carResource = carResource;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarResource() {
        return this.carResource;
    }

    public void setCarResource(int carResource) {
        this.carResource = carResource;
    }
}
