package com.lab.lab_1.controllers;


import com.lab.lab_1.dao.StudyGroupJdbc;
import com.lab.lab_1.model.StudyGroup;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudyGroupController {
    private final StudyGroupJdbc _sg;

    public StudyGroupController(StudyGroupJdbc mark) {
        _sg = mark;
    }

    @GetMapping("/studyGroups/{id}")
    public StudyGroup getGroupById(@PathVariable int id) {
        return _sg.get(id);
    }

    @GetMapping("/studyGroups/all")
    public List<StudyGroup> getAllGroups(){
        return _sg.getAll();
    }

    @PostMapping("/studyGroups/new")
    public int addNewGroup(@RequestBody StudyGroup sg){
        return _sg.add(sg);
    }

    @PostMapping("/studyGroups/update")
    public int updateGroup(@RequestBody StudyGroup sg){
        return _sg.update(sg);
    }

    @DeleteMapping("/studyGroups/delete/{id}")
    public int deleteGroupById(@PathVariable int id){
        return _sg.delete(id);
    }
}
