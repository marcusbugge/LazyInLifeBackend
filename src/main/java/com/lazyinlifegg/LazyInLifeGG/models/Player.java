package com.lazyinlifegg.LazyInLifeGG.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String fullname;
    private String age;
    private String country;
    private String role;
    private String league;
    private String twitter;
    private String gamename;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonBackReference // Add this annotation
    private Game game;
}

