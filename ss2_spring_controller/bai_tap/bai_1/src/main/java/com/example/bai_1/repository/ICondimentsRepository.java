package com.example.bai_1.repository;

import com.example.bai_1.model.Condiments;

import java.util.List;

public interface ICondimentsRepository {
    List<Condiments> findAll();
}
