package com.springwithmongo.listteam.repositories;

import com.springwithmongo.listteam.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);
}
