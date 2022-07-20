package com.lgfh.demo.repository;


import com.lgfh.demo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepoImpl implements PersonRepo {

    private static final Logger log = LoggerFactory.getLogger(PersonRepoImpl.class);

    @Override
    public Flux<Person> list() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Luis"));
        persons.add(new Person(2, "Camilo"));
        persons.add(new Person(3, "Laura"));
        log.info("list() -> " + persons.toString());
        return Flux.fromIterable(persons);
    }

    @Override
    public Mono<Person> register(Person person) {
        log.info("register() -> " + person.toString());
        return Mono.just(person);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        log.info("delete() -> " + id);
        return Mono.empty();
    }

    @Override
    public Mono<Person> findById(Integer id) {
        log.info("findById() -> " + "id: " + id);
        return Mono.just(new Person(id, "Guillermo"));
    }

    @Override
    public Mono<Person> modify(Person person) {
        log.info("modify() -> " + person.toString());
        return Mono.just(person);
    }
}
