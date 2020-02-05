package com.cursosdedesarrollo.springbootdemo.digimon;

import com.cursosdedesarrollo.springbootdemo.pokemon.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.List;

public interface DigimonRepository extends ReactiveMongoRepository<Pokemon, String> {

}