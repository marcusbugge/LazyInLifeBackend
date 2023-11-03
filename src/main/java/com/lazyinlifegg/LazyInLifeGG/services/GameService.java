package com.lazyinlifegg.LazyInLifeGG.services;

import com.lazyinlifegg.LazyInLifeGG.models.Game;
import com.lazyinlifegg.LazyInLifeGG.models.Player;
import com.lazyinlifegg.LazyInLifeGG.repositories.GameRepository;
import com.lazyinlifegg.LazyInLifeGG.repositories.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGame(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    public Game findByIdWithPlayers(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        game.ifPresent(g -> g.getPlayers().size()); // Trigger the loading of players if using lazy fetching
        return game.orElse(null);
    }

    public List<Player> findPlayersByGameId(Long gameId) {
        return gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found")).getPlayers();
    }

    public Player updatePlayer(String gameName, Long playerId, Player updatedPlayer) {
        Game game = gameRepository.findByName(gameName)
                .orElseThrow(() -> new RuntimeException("Game not found"));

        Player player = playerRepository.findById(playerId)
                .orElse(new Player()); // Create a new player if not found

        System.out.println("gamename:" + gameName);

        player.setName(updatedPlayer.getName());
        player.setAge(updatedPlayer.getAge());
        player.setRole(updatedPlayer.getRole());
        player.setLeague(updatedPlayer.getLeague());
        player.setTwitter(updatedPlayer.getTwitter());
        player.setFullname(updatedPlayer.getFullname());
        player.setCountry(updatedPlayer.getCountry());
        player.setGamename(updatedPlayer.getGamename());

        player.setGame(game);

        return playerRepository.save(player);
    }

    public Game createGame(Game newGame) {
        return gameRepository.save(newGame);
    }


    public Game activateGame(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));
        game.setActive(true);
        return gameRepository.save(game);
    }

    public Game deactivateGame(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));
        game.setActive(false);
        return gameRepository.save(game);
    }

    public void removePlayer(Long gameId, Long playerId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found"));
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        // Unlink the player from the game
        game.getPlayers().remove(player);
        player.setGame(null); // Unlink from the player's side

        gameRepository.save(game);
        playerRepository.save(player); // Save the player as well
    }



}
