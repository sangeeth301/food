package com.add.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FoodController {
    @Autowired
    FoodService service;

    @GetMapping("/home")
    public ModelAndView home(){
        List<FoodEntity> list=service.getAllFoods();
        return new ModelAndView("home","food",list);
    }

    @PostMapping("/save")
    public String addFood(@ModelAttribute FoodEntity f){
    service.save(f);
    return "redirect:/home";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/home";
    }

}
