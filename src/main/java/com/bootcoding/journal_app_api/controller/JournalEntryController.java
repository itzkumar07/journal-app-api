package com.bootcoding.journal_app_api.controller;

import com.bootcoding.journal_app_api.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/journal")     //http://localhost:7801/journal
public class JournalEntryController {

    private final Map<Long, JournalEntryController> journalEntries = new HashMap<>();

    @GetMapping     //Entry Checking
    public ArrayList<JournalEntryController> getall(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping        //Entry Create
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }

    @GetMapping("id/{myID}")        //Entry id find
    public JournalEntry getJournalEntryId(@PathVariable Long myID){
        return (JournalEntry) journalEntries.get(myID);

    }

    @DeleteMapping("id/{myID}")     //Entry Delete
    public JournalEntry deleteJournalEntryId(@PathVariable Long myID){
        return (JournalEntry) journalEntries.remove(myID);
    }

    @PutMapping("id/{id}")      //Enter Update
    public JournalEntry updateJournalById(@PathVariable Long id, @RequestBody JournalEntry myEntry){
        return (JournalEntry) journalEntries.put(id, myEntry);
    }
}
