package com.example.taskss.domain.entity;

public class State {
    private String name; // название
    private int carResource; // ресурс флага

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
