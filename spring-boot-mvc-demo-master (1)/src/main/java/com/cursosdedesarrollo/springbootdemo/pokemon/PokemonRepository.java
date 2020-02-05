package com.cursosdedesarrollo.springbootdemo.pokemon;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PokemonRepository extends MongoRepository<Pokemon, String> {

    public List<Pokemon> findByname(String name);
    public List<Pokemon> findBytype(String type);

    /*void deleteAll();

    List<Pokemon> findAll();

    void deleteById(String id);

    Pokemon save(Pokemon pokemon);

    Optional<Pokemon> findById(String id);*/
}