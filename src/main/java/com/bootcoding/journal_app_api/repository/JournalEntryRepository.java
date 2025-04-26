package com.bootcoding.journal_app_api.repository;

import com.bootcoding.journal_app_api.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {
}
