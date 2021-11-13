package com.example._3ld.Repositories;

import com.example._3ld.ds.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
