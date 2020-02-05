package com.cursosdedesarrollo.springbootdemo.pokemon;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Document(collection = "pokemons")
public class Pokemon {

    @Id
    public String id;

    @NotNull
    @NotBlank
    public String name;
    @NotNull
    @NotBlank
    public String type;

    public String power;


    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }


}
