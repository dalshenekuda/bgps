package com.lab.lab_1.controllers;


import com.lab.lab_1.dao.JournalJdbc;
import com.lab.lab_1.model.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JournalController {
    private final JournalJdbc _jrnl;

    public JournalController(JournalJdbc mark) {
        _jrnl = mark;
    }

    @GetMapping("/journal/{id}")
    public JournalEntry getEntryById(@PathVariable int id) {
        return _jrnl.get(id);
    }

    @GetMapping("/journal/byStudent/{id}")
    public List<JournalEntry> getEntriesByStudent(@PathVariable int id) {
        return _jrnl.getByStudent(id);
    }

    @GetMapping("/journal/byStudyPlan/{id}")
    public List<JournalEntry> getEntriesByStudyPlanId(@PathVariable int id) {
        return _jrnl.getByStudyPlan(id);
    }

    @GetMapping("/journal")
    public List<JournalEntry> getJournal(){
        return _jrnl.getAll();
    }

    @PostMapping("/journal/new")
    public int addNewEntry(@RequestBody JournalEntry sg){
        return _jrnl.add(sg);
    }

    @PostMapping("/journal/update")
    public int updateEntry(@RequestBody JournalEntry sg){
        return _jrnl.update(sg);
    }

    @DeleteMapping("/journal/delete/{id}")
    public int deleteEntryById(@PathVariable int id){
        return _jrnl.delete(id);
    }
}
