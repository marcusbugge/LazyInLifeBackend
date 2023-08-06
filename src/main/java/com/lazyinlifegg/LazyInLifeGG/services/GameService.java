package com.lazyinlifegg.LazyInLifeGG.services;

import com.lazyinlifegg.LazyInLifeGG.models.Game;
import com.lazyinlifegg.LazyInLifeGG.models.Player;
import com.lazyinlifegg.LazyInLifeGG.repositories.GameRepository;
import com.lazyinlifegg.LazyInLifeGG.repositories.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public boolean addPlayerToGame(Long playerId, Long gameId) {
        Optional<Game> gameOpt = gameRepository.findById(gameId);
        Optional<Player> playerOpt = playerRepository.findById(playerId);

        if (gameOpt.isPresent() && playerOpt.isPresent()) {
            Game game = gameOpt.get();
            Player player = playerOpt.get();

            game.getPlayers().add(player);
            player.getGames().add(game);

            gameRepository.save(game);
            playerRepository.save(player);

            return true;
        }

        return false;
    }
}
