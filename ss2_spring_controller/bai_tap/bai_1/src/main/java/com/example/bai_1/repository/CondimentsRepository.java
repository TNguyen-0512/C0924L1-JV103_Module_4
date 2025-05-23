package com.example.bai_1.repository;

import com.example.bai_1.model.Condiments;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CondimentsRepository implements ICondimentsRepository {
    private static List<Condiments> condimentsList = new ArrayList<>();
    static {
        condimentsList.add(new Condiments("Lettuce"));
        condimentsList.add(new Condiments("Tomato"));
        condimentsList.add(new Condiments("Mustard"));
        condimentsList.add(new Condiments("Sprouts"));
    }
    @Override
    public List<Condiments> findAll() {
        return condimentsList;
    }

}
