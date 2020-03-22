package com.lab.lab_1.controllers;


import com.lab.lab_1.dao.MarkJdbc;
import com.lab.lab_1.model.Mark;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkController {
    private final MarkJdbc _mark;

    public MarkController(MarkJdbc mark) {
        _mark = mark;
    }

    @GetMapping("/marks/{id}")
    public Mark getMarkById(@PathVariable int id){
        return _mark.get(id);
    }
}
