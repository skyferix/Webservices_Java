package com.example._3ld.Repositories;

import com.example._3ld.ds.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
}
