package com.lgfh.demo.repository;

import com.lgfh.demo.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepo {

    Flux<Person> list();

    Mono<Person> register(Person person);

    Mono<Void> delete(Integer id);

    Mono<Person> findById(Integer id);

    Mono<Person> modify(Person person);
}
