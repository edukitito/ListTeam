package com.springwithmongo.listteam.config;

import com.springwithmongo.listteam.entities.Task;
import com.springwithmongo.listteam.entities.User;
import com.springwithmongo.listteam.repositories.TaskRepository;
import com.springwithmongo.listteam.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
   @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        /*
        User user = new User(null, "Marcos", "admin", "marcos@gmail.com", "fasdhfausdhfaushfasdfdasijfsd");
        User user1 = new User(null, "Patricia", "assistente","assistente@gmail.com", "fhudashufhuadsufhashudf");
        User user2 = new User(null, "Helena", "marketing", "marketing@gmail.com", "fsdhafuhsdauhfhwurfhaufhds");

       // userRepository.saveAll(Arrays.asList(user,user1,user2));
        Task task = new Task(null, "Desenvolvimento de banner site", "Fazer um banner pro dia das mulheres", Instant.now(), Instant.now().plus(30, ChronoUnit.DAYS), 3,3);
        Task task1 = new Task(null, "Desenvolvimento de banner site1", "Fazer um banner pro dia do consumidor", Instant.now(), Instant.now().plus(7, ChronoUnit.DAYS), 3,1);
        taskRepository.saveAll(Arrays.asList(task1, task));

        user.getTasks().add(task);
        user1.getTasks().add(task1);
        user.getTasks().add(task1);
        userRepository.saveAll(Arrays.asList(user, user1, user2));*/
    }
}
