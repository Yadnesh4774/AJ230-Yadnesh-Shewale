/*
 * author : Yadnesh 
 * content : DTO class 
 */
package com.hexaware.cricketteam.dto;

public class PlayerDTO {
    private int playerId;
    private String playerName;
    private int jerseyNumber;
    private String role;
    private int totalMatches;
    private String teamName;
    private String countryOrStateName;
    private String description;

    public PlayerDTO() {}

    public PlayerDTO(int playerId, String playerName, int jerseyNumber, String role, int totalMatches, String teamName, String countryOrStateName, String description) {
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
