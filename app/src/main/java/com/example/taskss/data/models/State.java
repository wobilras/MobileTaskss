package com.example.taskss.data.models;

public class State {
    private String name;
    private int carResource;

    public State(String name, int flag){
        this.name=name;
        this.carResource=flag;
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
