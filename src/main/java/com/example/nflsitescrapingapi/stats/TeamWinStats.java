package com.example.nflsitescrapingapi.stats;

public class TeamWinStats {

    private final String name;
    private final int wins;
    private final int losses;
    private final double winRatePercentage;

    public TeamWinStats(String name, int wins, int losses, double winRatePercentage) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.winRatePercentage = winRatePercentage;
    }


    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public double getWinRatePercentage() {
        return winRatePercentage;
    }

    @Override
    public String toString() {
        return "TeamStats{" +
                "name='" + name + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                ", winRatePercentage=" + winRatePercentage +
                '}';
    }
}
