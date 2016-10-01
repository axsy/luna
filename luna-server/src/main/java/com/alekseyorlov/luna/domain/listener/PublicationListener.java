package com.alekseyorlov.luna.domain.listener;

import com.alekseyorlov.luna.domain.Entry;
import com.alekseyorlov.luna.domain.Entry.Status;
import org.apache.commons.lang3.SerializationUtils;

import javax.persistence.*;
import java.time.Instant;

public class PublicationListener {

    @PreUpdate
    @PrePersist
    public void publicationAudit(Entry entry) {
        Entry savedStateEntry = entry.getSavedState();

        // Published
        if ((savedStateEntry != null && savedStateEntry.getStatus() != Status.PUBLISHED
                && entry.getStatus() == Status.PUBLISHED) || entry.getStatus() == Status.PUBLISHED) {
            entry.setPublishedAt(Instant.now());
        }

        // Unpublished
        if (savedStateEntry != null && savedStateEntry.getStatus() == Status.PUBLISHED
                && entry.getStatus() != Status.PUBLISHED) {
            entry.setUnpublishedAt(Instant.now());
        }
    }

    @PostLoad
    @PostUpdate
    @PostPersist
    public void saveState(Entry entry) {
        entry.setSavedState(SerializationUtils.clone(entry));
    }

}
