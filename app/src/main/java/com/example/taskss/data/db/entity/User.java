package com.example.taskss.data.db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = {"login"},unique = true)})
public class User {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public Integer uid;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "login")
    public String login;

    @ColumnInfo(name = "pass")
    public String pass;

    @ColumnInfo(name = "fullName")
    public String fullName;

    @ColumnInfo(name = "licenceNum")
    public String licenceNum;

    @ColumnInfo(name = "passportNum")
    public String passportNum;

    @ColumnInfo(name = "birthDate")
    public String birthDate;

    public User(String email, String login, String pass, String fullName, String licenceNum, String passportNum, String birthDate) {
        this.email = email;
        this.login = login;
        this.pass = pass;
        this.fullName = fullName;
        this.licenceNum = licenceNum;
        this.passportNum = passportNum;
        this.birthDate = birthDate;
    }

    @NonNull
    public Integer getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLicenceNum() {
        return licenceNum;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
