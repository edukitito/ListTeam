package com.springwithmongo.listteam.controllers;

import com.springwithmongo.listteam.entities.User;
import com.springwithmongo.listteam.entities.UserLogin;
import com.springwithmongo.listteam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService service;
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable int id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        service.insertUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Void> login(@RequestBody UserLogin userLogin){
        User user = service.findByEmail(userLogin.getEmail());
        if(user!= null){
            if(userLogin.getTokem().equals(user.getTokem())){
                return ResponseEntity.ok().build();
            }else {
                return ResponseEntity.notFound().build();
            }
        }else {
            return ResponseEntity.notFound().build();
        }

    }


}
