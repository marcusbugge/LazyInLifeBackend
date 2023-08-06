package com.lazyinlifegg.LazyInLifeGG.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "players")
@Getter
@Setter
@NoArgsConstructor
public class Player {

    @Id
    private Long id;

    private String name;
    private String role;
    private String twitter;

    @ManyToMany
    private List<Game> games;
}
