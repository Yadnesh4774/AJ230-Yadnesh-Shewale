package com.hexaware.cricketteam.service;

import com.hexaware.cricketteam.dto.PlayerDTO;
import com.hexaware.cricketteam.entity.Player;
import com.hexaware.cricketteam.exception.PlayerNotFoundException;
import com.hexaware.cricketteam.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements IPlayerService {

    @Autowired
    private IPlayerRepository playerRepository;

    @Override
    public Player addPlayer(PlayerDTO playerDTO) {
        Player player = convertToEntity(playerDTO);

        if (validatePlayer(player)) {
            return playerRepository.save(player);
        } else {
            throw new IllegalArgumentException("Invalid Player data");
        }
    }

    @Override
    public Player updatePlayer(int playerId, PlayerDTO playerDTO) {
        Player existingPlayer = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with ID: " + playerId));
        existingPlayer.setPlayerName(playerDTO.getPlayerName());
        existingPlayer.setJerseyNumber(playerDTO.getJerseyNumber());
        existingPlayer.setRole(playerDTO.getRole());
        existingPlayer.setTotalMatches(playerDTO.getTotalMatches());
        existingPlayer.setTeamName(playerDTO.getTeamName());
        existingPlayer.setCountryOrStateName(playerDTO.getCountryOrStateName());
        existingPlayer.setDescription(playerDTO.getDescription());

        if (validatePlayer(existingPlayer)) {
            return playerRepository.save(existingPlayer);
        } else {
            throw new IllegalArgumentException("Invalid Player data");
        }
    }

    @Override
    public Player getPlayerById(int playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with ID: " + playerId));
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public void deletePlayer(int playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with ID: " + playerId));
        playerRepository.delete(player);
    }

    // Helper Method: Convert DTO to Entity
    private Player convertToEntity(PlayerDTO playerDTO) {
        return new Player(0, playerDTO.getPlayerName(), playerDTO.getJerseyNumber(), playerDTO.getRole(),
                playerDTO.getTotalMatches(), playerDTO.getTeamName(), playerDTO.getCountryOrStateName(),
                playerDTO.getDescription());
    }

    // Helper Method: Validate Player
    private static boolean validatePlayer(Player player) {
        boolean isValid = false;

        if (player != null &&
            player.getPlayerName() != null && !player.getPlayerName().isBlank() && player.getPlayerName().length() >= 3 &&
            player.getJerseyNumber() > 0 &&
            player.getRole() != null && !player.getRole().isBlank() &&
            player.getTotalMatches() >= 0 &&
            player.getTeamName() != null && !player.getTeamName().isBlank() &&
            player.getCountryOrStateName() != null && !player.getCountryOrStateName().isBlank()) {
            isValid = true;
        }

        return isValid;
    }
}
