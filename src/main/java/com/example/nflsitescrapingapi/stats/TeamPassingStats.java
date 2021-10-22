package com.example.nflsitescrapingapi.stats;

public class TeamPassingStats {

    private final String name;
    private final int passYards;
    private final int completions;
    private final int touchdowns;

    public TeamPassingStats(String name, int passYards, int completions, int touchdowns) {
        this.name = name;
        this.passYards = passYards;
        this.completions = completions;
        this.touchdowns = touchdowns;
    }

    public String getName() {
        return name;
    }

    public int getPassYards() {
        return passYards;
    }

    public int getCompletions() {
        return completions;
    }

    public int getTouchdowns() {
        return touchdowns;
    }

    @Override
    public String toString() {
        return "TeamPassingStats{" +
                "name='" + name + '\'' +
                ", passYards=" + passYards +
                ", completions=" + completions +
                ", touchdowns=" + touchdowns +
                '}';
    }
}
