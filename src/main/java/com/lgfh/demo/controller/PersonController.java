package com.lgfh.demo.controller;

import com.lgfh.demo.model.Person;
import com.lgfh.demo.repository.PersonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/persons")
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    private final PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping
    public Flux<Person> listPersons() {
        return personRepo.list();
    }

    @PostMapping
    public Mono<Person> registerPerson(@RequestBody Person person) {
        return personRepo.register(person);
    }

    @PutMapping
    public Mono<Person> modifyPerson(@RequestBody Person person) {
        return personRepo.modify(person);
    }

    @GetMapping("/{id}")
    public Mono<Person> findPersonById(@PathVariable Integer id) {
        return personRepo.findById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePerson(@PathVariable Integer id) {
        return personRepo.delete(id);
    }
}
