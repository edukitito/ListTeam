package com.springwithmongo.listteam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springwithmongo.listteam.entities.Enums.TaskPriority;
import com.springwithmongo.listteam.entities.Enums.TaskStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String description;
    private Instant startDate;
    private Instant finishDate;
    private TaskStatus taskStatus = TaskStatus.CREATED;
    private TaskPriority taskPriority;
    @ManyToMany(mappedBy = "tasks")
    @JsonIgnore
    private Set<User> workers = new HashSet<>();

    public Task(Integer id, String nome, String description, Instant startDate, Instant finishDate, int taskStatus, int taskPriority) {
        this.id = id;
        this.nome = nome;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.taskStatus = TaskStatus.valueOf(taskStatus);
        this.taskPriority = TaskPriority.valueOf(taskPriority);
    }

    public Task() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Instant finishDate) {
        this.finishDate = finishDate;
    }

    public Set<User> getWorkers() {
        return workers;
    }

    public void addWorkers(User worker) {
        workers.add(worker);
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
