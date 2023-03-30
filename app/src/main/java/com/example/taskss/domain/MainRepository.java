package com.example.taskss.domain;

import com.example.taskss.domain.entity.LoginPerson;
import com.example.taskss.domain.entity.State;

import java.util.List;

public interface MainRepository {
    List<State> getArchiveList();
    boolean personLogin(LoginPerson loginPerson);
}
