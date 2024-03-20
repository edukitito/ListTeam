package com.springwithmongo.listteam.services;

import com.springwithmongo.listteam.entities.Task;
import com.springwithmongo.listteam.entities.User;
import com.springwithmongo.listteam.repositories.UserRepository;
import com.springwithmongo.listteam.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    private TaskService taskService = new TaskService();
    public List<User> findAll(){
        return repository.findAll();

    }

    public User findById(int id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insertUser(User user){
        return repository.save(user);
    }

    public void deleteUser(int id){
        repository.deleteById(id);
    }

    public User updateUser(int id, User user){
        User entity = repository.getOne(id);
        updateData(entity, user);
        return repository.save(entity);
    }

    private void updateData(User entity, User user){
        entity.setNome(user.getNome());
        entity.setEmail(user.getEmail());
        entity.setCargo(user.getCargo());
        entity.setTokem(user.getTokem());
    }
    public User addTask(int idUser, int idTask){
        User user = repository.getReferenceById(idUser);
        Task task = taskService.findById(idTask);
        user.addtask(task);
        repository.save(user);
        return user;
    }

    public User findByEmail(String email){
        return repository.findUserByEmail(email);
    }
}
