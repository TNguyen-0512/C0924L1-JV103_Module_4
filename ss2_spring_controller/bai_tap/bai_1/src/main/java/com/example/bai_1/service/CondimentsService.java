package com.example.bai_1.service;

import com.example.bai_1.model.Condiments;
import com.example.bai_1.repository.CondimentsRepository;
import com.example.bai_1.repository.ICondimentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondimentsService implements ICondimentsService {
    @Autowired
    private ICondimentsRepository repository;
    @Override
    public List<Condiments> findAll() {
        return repository.findAll();
    }
}
