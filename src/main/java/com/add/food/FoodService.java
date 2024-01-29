package com.add.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    FoodRepository repo;
    public void save(FoodEntity f){
        repo.save(f);
    }
    public List<FoodEntity> getAllFoods(){
        return repo.findAll();
    }

    public void deleteById(int id){
        repo.deleteById(id);
    }
}
