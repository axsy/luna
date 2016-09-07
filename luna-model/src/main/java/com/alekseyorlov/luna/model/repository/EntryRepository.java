package com.alekseyorlov.luna.model.repository;

import com.alekseyorlov.luna.model.Entry;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EntryRepository extends PagingAndSortingRepository<Entry, Long> {
}
