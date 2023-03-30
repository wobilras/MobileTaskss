package com.example.taskss.domain.usecase;

import com.example.taskss.domain.MainRepository;
import com.example.taskss.domain.entity.LoginPerson;

public class PersonLoginUseCase {
    private final MainRepository repository;

    public PersonLoginUseCase(MainRepository repository) {
        this.repository = repository;
    }

    public boolean personLogin(LoginPerson loginPerson){
        return repository.personLogin(loginPerson);
    }
}
