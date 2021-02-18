package com.example.footballinfo;

public class MatchInfo {
    private long id;

    public MatchInfo(long id, String teamhouse, String teamguest, int goalshouse, int goalsguest) {
        this.id = id;
        this.teamhouse = teamhouse;
        this.teamguest = teamguest;
        this.goalshouse = goalshouse;
        this.goalsguest = goalsguest;
    }

    private String teamhouse;
    private String teamguest;
    private int goalshouse;

    public void setId(long id) {
        this.id = id;
    }

    public void setTeamhouse(String teamhouse) {
        this.teamhouse = teamhouse;
    }

    public void setTeamguest(String teamguest) {
        this.teamguest = teamguest;
    }

    public void setGoalshouse(int goalshouse) {
        this.goalshouse = goalshouse;
    }

    public void setGoalsguest(int goalsguest) {
        this.goalsguest = goalsguest;
    }

    private int goalsguest;

    public long getId() {
        return id;
    }

    public String getTeamhouse() {
        return teamhouse;
    }

    public String getTeamguest() {
        return teamguest;
    }

    public int getGoalshouse() {
        return goalshouse;
    }

    public int getGoalsguest() {
        return goalsguest;
    }
}
