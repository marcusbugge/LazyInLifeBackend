package com.lazyinlifegg.LazyInLifeGG.repositories;

import com.lazyinlifegg.LazyInLifeGG.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
