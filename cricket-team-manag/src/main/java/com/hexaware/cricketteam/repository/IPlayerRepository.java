package com.hexaware.cricketteam.repository;

import com.hexaware.cricketteam.entity.Player;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Integer> {

	//Player save(Player player);

	//Optional<Player> findById(int playerId);
}
