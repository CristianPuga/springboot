package com.cursosdedesarrollo.springbootdemo.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokemon")
public class RestPokemon {

    @Autowired
    private PokemonRepository repository;

    @GetMapping
    List<Pokemon> all() {
        return repository.findAll();
    }

    @PostMapping
    Pokemon newPokemon(@Valid @RequestBody Pokemon pokemon) {
        return repository.save(pokemon);
    }

    @GetMapping("/{id}")
    Pokemon one(@PathVariable String id) {

        return repository.findById(id)
                .orElseThrow(() -> new PokemonNotFoundException(id));
    }

    @PutMapping("/{id}")
    Pokemon replacePokemon(@Valid @RequestBody Pokemon pokemon, @PathVariable String id) {

        return repository.findById(id)
                .map(pokemon1 -> {
                    pokemon1.name=pokemon.name;
                    pokemon1.type=pokemon.type;
                    return repository.save(pokemon);
                })
                .orElseGet(() -> {
                    pokemon.id=id;
                    return repository.save(pokemon);
                });
    }

    @DeleteMapping("/{id}")
    Pokemon deletePokemon(@PathVariable String id) {
        Optional<Pokemon> pokemon = repository.findById(id);
        repository.deleteById(id);
        return pokemon.get();
    }
}
