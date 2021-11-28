package com.example._3ld.Repositories;

import com.example._3ld.ds.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLoginAndPassword(String login, String password);
    User findByLogin(String login);
}
