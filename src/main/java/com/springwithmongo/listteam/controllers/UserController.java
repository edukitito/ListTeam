package com.springwithmongo.listteam.controllers;

import com.springwithmongo.listteam.entities.User;
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

    @GetMapping(value = "/login")
    public String index(Model model){
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam String useremail, @RequestParam String userpassword, Model model){
        User user = service.findByEmail(useremail);
        if(user!= null){
            if(userpassword.equals(user.getTokem())){
                model.addAttribute("message", "Usuário autenticado");
                return "login";
            }else {
                model.addAttribute("message", "Senha Inválida");
                return "login";
            }
        }else {
            model.addAttribute("message", "Usuário Não cadastrado");
            return "login";
        }

    }


}
