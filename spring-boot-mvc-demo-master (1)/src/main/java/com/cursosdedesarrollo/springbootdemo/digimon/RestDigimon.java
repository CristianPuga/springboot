package com.cursosdedesarrollo.springbootdemo.digimon;

import com.cursosdedesarrollo.springbootdemo.pokemon.Pokemon;
import com.cursosdedesarrollo.springbootdemo.pokemon.PokemonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cursosdedesarrollo.springbootdemo.digimon.DigimonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/digimon")
public class RestDigimon {

    @Autowired
    private DigimonRepository repository;

    @GetMapping
    Flux<Pokemon> all() {
        return repository.findAll();
    }

    @PostMapping
    private Mono<Pokemon> newPokemon(@Valid @RequestBody Pokemon pokemon) {

        return repository.save(pokemon);
    }

    @GetMapping("/{id}")
    Mono<Pokemon> onePokemon(@PathVariable String id) {

        return repository.findById(id);
    }

        @PutMapping("/{id}")
        public Mono<Pokemon> updatePokemon(@Valid @RequestBody Pokemon pokemon, @PathVariable String id){

            return repository.findById(id)
                    .flatMap(pokemon1 -> {
                        pokemon1.name = pokemon.name;
                        pokemon1.type = pokemon.type;
                        return repository.save(pokemon);
                    })
                    /*.orElseGet(() -> {
                        pokemon.id = id;
                        return repository.save(pokemon);
                    })*/;
        }

        @DeleteMapping("/{id}")
       public Mono<ResponseEntity<Pokemon>> deletePokemon (@PathVariable(value = "id") String id){

            return repository.findById(id)
                    .flatMap(pokemon ->
                            repository.delete(pokemon).then(Mono.just(new ResponseEntity<Pokemon>(pokemon, HttpStatus.OK)))
                                .defaultIfEmpty(new ResponseEntity<Pokemon>(HttpStatus.NOT_FOUND)));
        }
    }
