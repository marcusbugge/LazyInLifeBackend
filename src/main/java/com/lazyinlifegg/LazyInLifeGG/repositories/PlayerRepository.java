package com.lazyinlifegg.LazyInLifeGG.repositories;

import com.lazyinlifegg.LazyInLifeGG.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lazyinlifegg.LazyInLifeGG.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByName(String name);
}