package com.hexaware.cricketteam.entity;

import jakarta.validation.constraints.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int playerId;

    @Pattern(regexp = "[A-Z][a-z]",message = "Player Name must begin with Uppercase ")
    @Column(name = "player_name", nullable = false, length = 100)
    private String playerName;

    @Min(value = 1, message = "Jersey number must be greater than 0")
    @Column(name = "jersey_number", nullable = false)
    private int jerseyNumber;

    
    @Column(name = "role", nullable = false, length = 50)
    private String role;

    @Size(min = 5, max = 20, message = "Total matches must be non-negative")
    @Column(name = "total_matches", nullable = false)
    private int totalMatches;

    
    @Column(name = "team_name", nullable = false, length = 100)
    private String teamName;

    
    @Column(name = "country_or_state_name", nullable = false, length = 100)
    private String countryOrStateName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Player() {}

    // All-Args and No-Args Constructors
    public Player(int playerId, String playerName, int jerseyNumber, String role, int totalMatches, String teamName, String countryOrStateName, String description) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.role = role;
        this.totalMatches = totalMatches;
        this.teamName = teamName;
        this.countryOrStateName = countryOrStateName;
        this.description = description;
    }

 // Getters and Setters
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCountryOrStateName() {
        return countryOrStateName;
    }

    public void setCountryOrStateName(String countryOrStateName) {
        this.countryOrStateName = countryOrStateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
