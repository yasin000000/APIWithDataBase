package com.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curd.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
