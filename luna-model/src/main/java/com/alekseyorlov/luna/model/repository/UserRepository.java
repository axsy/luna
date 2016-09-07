package com.alekseyorlov.luna.model.repository;

import com.alekseyorlov.luna.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
