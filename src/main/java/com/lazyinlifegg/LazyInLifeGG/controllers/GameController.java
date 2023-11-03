package com.lazyinlifegg.LazyInLifeGG.controllers;

import com.lazyinlifegg.LazyInLifeGG.models.Game;
import com.lazyinlifegg.LazyInLifeGG.models.Player;
import com.lazyinlifegg.LazyInLifeGG.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}/players")
    public ResponseEntity<List<Player>> getPlayersByGameId(@PathVariable Long id) {
        List<Player> players = gameService.findPlayersByGameId(id);
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable Long id) {
        return gameService.getGame(id);
    }

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game newGame) {
        Game game = gameService.createGame(newGame);
        return ResponseEntity.ok(game);
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<Game> getGameWithPlayers(@PathVariable Long id) {
        Game game = gameService.findByIdWithPlayers(id);
        return ResponseEntity.ok(game);
    }

    @PutMapping("/{gameName}/players/{playerId}")
    public ResponseEntity<Player> updatePlayer(@PathVariable String gameName, @PathVariable Long playerId, @RequestBody Player updatedPlayer) {
        Player player = gameService.updatePlayer(gameName, playerId, updatedPlayer);
        return ResponseEntity.ok(player);
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<Game> activateGame(@PathVariable Long id) {
        Game game = gameService.activateGame(id);
        return ResponseEntity.ok(game);
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Game> deactivateGame(@PathVariable Long id) {
        Game game = gameService.deactivateGame(id);
        return ResponseEntity.ok(game);
    }

    @DeleteMapping("/{gameId}/players/{playerId}")
    public ResponseEntity<Void> removePlayer(@PathVariable Long gameId, @PathVariable Long playerId) {
        gameService.removePlayer(gameId, playerId);
        return ResponseEntity.ok().build(); // Return a 200 OK status
    }
}
