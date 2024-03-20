package com.springwithmongo.listteam.services;


import com.springwithmongo.listteam.entities.Task;
import com.springwithmongo.listteam.entities.User;
import com.springwithmongo.listteam.repositories.TaskRepository;
import com.springwithmongo.listteam.repositories.UserRepository;
import com.springwithmongo.listteam.services.exceptions.NotFoundException;
import com.springwithmongo.listteam.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;
    @Autowired
    private UserRepository userRepository;

    public List<Task> findAll(){
        return repository.findAll();

    }
    public Task findById(int id){
        Optional<Task> task = repository.findById(id);
        return task.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public Task update(int id, Task task){
        Optional<Task> update = repository.findById(id);
        return updateTaks(update.orElseThrow(()-> new ResourceNotFoundException(id)), task);
    }

    private Task updateTaks(Task updateTask, Task task) {
        updateTask.setTaskStatus(task.getTaskStatus());
        updateTask.setDescription(task.getDescription());
        for (User user : task.getWorkers()) {
            updateTask.addWorkers(user);
        }
        updateTask.setFinishDate(task.getFinishDate());
        updateTask.setNome(task.getNome());
        return updateTask;
    }

    public Task insert(Task task){
        return repository.save(task);
    }

    public Task addUsers(List<Integer> users, int taskid){
        Optional<Task> task = repository.findById(taskid);
        for (int id : users){
            Optional<User> user = userRepository.findById(id);
            task.orElseThrow(()-> new NotFoundException(id, "User")).addWorkers(user.orElseThrow(()-> new ResourceNotFoundException(id)));
        }
        return  task.orElseThrow(()->new NotFoundException(taskid, "Task"));
    }
}
