package com.alekseyorlov.luna.domain.repository;

import com.alekseyorlov.luna.domain.Entry;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EntryRepository extends PagingAndSortingRepository<Entry, Long>, JpaSpecificationExecutor {
}
