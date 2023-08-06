package com.lazyinlifegg.LazyInLifeGG.repositories;

import com.lazyinlifegg.LazyInLifeGG.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
