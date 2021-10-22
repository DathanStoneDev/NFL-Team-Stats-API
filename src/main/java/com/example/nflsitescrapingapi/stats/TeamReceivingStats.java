package com.example.nflsitescrapingapi.stats;

public class TeamReceivingStats {

    private final String name;
    private final int receives;
    private final int touchdowns;
    private final int yards;

    public TeamReceivingStats(String name, int receives, int touchdowns, int yards) {
        this.name = name;
        this.receives = receives;
        this.touchdowns = touchdowns;
        this.yards = yards;
    }

    public String getName() {
        return name;
    }

    public int getReceives() {
        return receives;
    }

    public int getTouchdowns() {
        return touchdowns;
    }

    public int getYards() {
        return yards;
    }

    @Override
    public String toString() {
        return "TeamReceivingStats{" +
                "name='" + name + '\'' +
                ", Receives=" + receives +
                ", touchdowns=" + touchdowns +
                ", yards=" + yards +
                '}';
    }
}
