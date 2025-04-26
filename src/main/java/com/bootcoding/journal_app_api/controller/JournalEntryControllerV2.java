package com.bootcoding.journal_app_api.controller;

import com.bootcoding.journal_app_api.entity.JournalEntry;
import com.bootcoding.journal_app_api.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAllEntries();
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @GetMapping("/id/{myID}")
    public JournalEntry getJournalEntryId(@PathVariable String myID) {
        return journalEntryService.getJournalEntryById(myID);
    }

    @DeleteMapping("/id/{myID}")
    public String deleteJournalEntryId(@PathVariable String myID) {
        boolean deleted = journalEntryService.deleteJournalEntryById(myID);
        return deleted ? "Deleted successfully!" : "Entry not found!";
    }

    @PutMapping("/id/{myID}")
    public JournalEntry updateJournalById(@PathVariable String myID, @RequestBody JournalEntry myEntry) {
        return journalEntryService.updateJournalEntry(myID, myEntry);
    }
}
