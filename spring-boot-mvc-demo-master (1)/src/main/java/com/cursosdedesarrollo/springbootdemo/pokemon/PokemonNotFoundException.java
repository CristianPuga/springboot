package com.cursosdedesarrollo.springbootdemo.pokemon;

public class PokemonNotFoundException extends RuntimeException {

    PokemonNotFoundException(String id) {
        super("Could not find customer " + id);
    }
}
