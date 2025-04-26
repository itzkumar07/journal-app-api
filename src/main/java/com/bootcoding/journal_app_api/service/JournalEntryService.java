package com.bootcoding.journal_app_api.service;

import com.bootcoding.journal_app_api.entity.JournalEntry;
import com.bootcoding.journal_app_api.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAllEntries() {
        return journalEntryRepository.findAll();
    }

    public JournalEntry getJournalEntryById(String id) {
        return journalEntryRepository.findById(id).orElse(null);
    }

    public boolean deleteJournalEntryById(String id) {
        if (journalEntryRepository.existsById(id)) {
            journalEntryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public JournalEntry updateJournalEntry(String id, JournalEntry updatedEntry) {
        Optional<JournalEntry> optionalEntry = journalEntryRepository.findById(id);
        if (optionalEntry.isPresent()) {
            JournalEntry existingEntry = optionalEntry.get();
            existingEntry.setTitle(updatedEntry.getTitle());
            existingEntry.setContent(updatedEntry.getContent());
            existingEntry.setDate(updatedEntry.getDate());
            return journalEntryRepository.save(existingEntry);
        }
        return null;
    }
}
