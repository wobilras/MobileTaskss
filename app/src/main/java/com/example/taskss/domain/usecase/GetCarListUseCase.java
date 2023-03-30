package com.example.taskss.domain.usecase;



import com.example.taskss.domain.MainRepository;
import com.example.taskss.domain.entity.State;

import java.util.List;

public class GetCarListUseCase {
    private final MainRepository repository;

    public GetCarListUseCase(MainRepository repository) {
        this.repository = repository;
    }
    public List<State> getArchiveList(){
        return repository.getArchiveList();
    }
}
