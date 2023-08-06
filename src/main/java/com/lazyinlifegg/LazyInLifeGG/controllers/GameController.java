package com.lazyinlifegg.LazyInLifeGG.controllers;

import com.lazyinlifegg.LazyInLifeGG.models.Game;
import com.lazyinlifegg.LazyInLifeGG.repositories.GameRepository;
import com.lazyinlifegg.LazyInLifeGG.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameService gameService;

    @PostMapping("/addplayer")
    public ResponseEntity<String> addPlayerToGame(@RequestParam Long playerId, @RequestParam Long gameId) {
        boolean success = gameService.addPlayerToGame(playerId, gameId);

        if (success) {
            return ResponseEntity.ok("Player added to game successfully");
        } else {
            return ResponseEntity.badRequest().body("Error: Unable to add player to game");
        }
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Game addGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    @DeleteMapping("/{id}")
    public void removeGame(@PathVariable Long id) {
        gameRepository.deleteById(id);
    }
}
