package com.example.data;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface UserRepository extends CrudRepository<UserTable, Long> {
    public Collection<UserTable> findByLastName(String lastName);
}
