package com.hexaware.cricketteam.service;

import com.hexaware.cricketteam.dto.PlayerDTO;
import com.hexaware.cricketteam.entity.Player;

import java.util.List;

public interface IPlayerService {

    Player addPlayer(PlayerDTO playerDTO);

    Player updatePlayer(int playerId, PlayerDTO playerDTO);

    Player getPlayerById(int playerId);

    List<Player> getAllPlayers();

    void deletePlayer(int playerId);
}
