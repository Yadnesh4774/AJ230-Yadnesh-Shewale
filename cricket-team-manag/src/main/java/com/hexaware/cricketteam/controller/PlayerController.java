package com.hexaware.cricketteam.controller;

import com.hexaware.cricketteam.dto.PlayerDTO;
import com.hexaware.cricketteam.entity.Player;
import com.hexaware.cricketteam.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private IPlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody PlayerDTO playerDTO) {
        return ResponseEntity.ok(playerService.addPlayer(playerDTO));
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable int playerId) {
        return ResponseEntity.ok(playerService.getPlayerById(playerId));
    }

    @PutMapping("/{playerId}")
    public ResponseEntity<Player> updatePlayer(@PathVariable int playerId, @RequestBody PlayerDTO playerDTO) {
        return ResponseEntity.ok(playerService.updatePlayer(playerId, playerDTO));
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<String> deletePlayer(@PathVariable int playerId) {
        playerService.deletePlayer(playerId);
        return ResponseEntity.ok("Player deleted successfully");
    }
}
