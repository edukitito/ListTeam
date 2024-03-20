package com.springwithmongo.listteam.repositories;

import com.springwithmongo.listteam.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
