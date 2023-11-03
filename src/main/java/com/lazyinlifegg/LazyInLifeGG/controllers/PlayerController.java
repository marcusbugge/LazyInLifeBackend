package com.lazyinlifegg.LazyInLifeGG.controllers;

import com.lazyinlifegg.LazyInLifeGG.models.Player;
import com.lazyinlifegg.LazyInLifeGG.repositories.PlayerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/profile/{name}")
    public ResponseEntity<Player> getPlayerByName(@PathVariable String name) {
        Optional<Player> player = playerRepository.findByName(name);
        return player.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable Long id) {
        Optional<Player> player = playerRepository.findById(id);
        return player.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        return playerRepository.findById(id)
                .map(player -> {
                    player.setName(updatedPlayer.getName());
                    player.setAge(updatedPlayer.getAge());
                    player.setRole(updatedPlayer.getRole());
                    player.setLeague(updatedPlayer.getLeague());
                    player.setTwitter(updatedPlayer.getTwitter());
                    player.setFullname(updatedPlayer.getFullname());
                    player.setCountry(updatedPlayer.getCountry());
                    player.setGamename(updatedPlayer.getGamename());

                    // Update other fields as necessary
                    // e.g., player.setAge(updatedPlayer.getAge());
                    Player savedPlayer = playerRepository.save(player);
                    return ResponseEntity.ok(savedPlayer);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
