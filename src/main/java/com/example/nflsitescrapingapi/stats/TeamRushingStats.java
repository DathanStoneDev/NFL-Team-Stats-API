package com.example.nflsitescrapingapi.stats;

public class TeamRushingStats {

    private final String name;
    private final int yards;
    private final int touchdowns;

    public TeamRushingStats(String name, int yards, int touchdowns) {
        this.name = name;
        this.yards = yards;
        this.touchdowns = touchdowns;
    }

    public String getName() {
        return name;
    }

    public int getYards() {
        return yards;
    }

    public int getTouchdowns() {
        return touchdowns;
    }

    @Override
    public String toString() {
        return "TeamRushingStats{" +
                "name='" + name + '\'' +
                ", yards=" + yards +
                ", touchdowns=" + touchdowns +
                '}';
    }
}
