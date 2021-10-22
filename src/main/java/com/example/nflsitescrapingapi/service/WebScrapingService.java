package com.example.nflsitescrapingapi.service;

import com.example.nflsitescrapingapi.exceptions.RequestException;
import com.example.nflsitescrapingapi.stats.TeamPassingStats;
import com.example.nflsitescrapingapi.stats.TeamReceivingStats;
import com.example.nflsitescrapingapi.stats.TeamRushingStats;
import com.example.nflsitescrapingapi.stats.TeamWinStats;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebScrapingService {

    private final String TEAM_WINS_BASE_URL = "https://www.nfl.com/standings/league/";
    private final String TEAM_STATS_BASE_URL = "https://www.nfl.com/stats/team-stats/";
    private final String defense = "defense";
    private final String offense = "offense";

    public List<TeamWinStats> getAllTeamWinStats(int year) {

        List<TeamWinStats> teamWinStatsList = new ArrayList<>();

        if(checkYear(year)) {
            try {
                final Document document = Jsoup.connect(TEAM_WINS_BASE_URL + year + "/REG").get();

                Elements body = document.select("tbody");

                for (Element e : body.select("tr")) {
                    String name = e.select("td div.d3-o-club-fullname").text();
                    int wins = Integer.parseInt(e.select("td:nth-of-type(2)").text());
                    int losses = Integer.parseInt(e.select("td:nth-of-type(3)").text());
                    double winRate = Double.parseDouble(e.select("td:nth-of-type(5)").text());
                    TeamWinStats teamWinStats = new TeamWinStats(name, wins, losses, winRate);
                    teamWinStatsList.add(teamWinStats);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return teamWinStatsList;
    }

    public List<TeamPassingStats> getAllTeamPassingStats(String side, int year) {

        List<TeamPassingStats> teamPassingStatsList = new ArrayList<>();


        if (checkSide(side)) {
            if (checkYear(year)) {
                try {
                    final Document document = Jsoup.connect(TEAM_STATS_BASE_URL + side + "/passing/" + year + "/reg/all").get();

                    Elements body = document.select("tbody");

                    for (Element e : body.select("tr")) {
                        String name = e.select("td div.d3-o-club-info div.d3-o-club-fullname").text();
                        int passYards = Integer.parseInt(e.select("td:nth-of-type(6)").text());
                        int completions = Integer.parseInt(e.select("td:nth-of-type(3)").text());
                        int touchdowns = Integer.parseInt(e.select("td:nth-of-type(7)").text());
                        TeamPassingStats teamPassingStats = new TeamPassingStats(name, passYards, completions, touchdowns);
                        teamPassingStatsList.add(teamPassingStats);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return teamPassingStatsList;
    }

    public List<TeamReceivingStats> getAllTeamReceivingStats(String side, int year) {

        List<TeamReceivingStats> teamReceivingStatsList = new ArrayList<>();

        if (checkSide(side)) {
            if (checkYear(year)) {
                try {
                    final Document document = Jsoup.connect(TEAM_STATS_BASE_URL + side + "/receiving/" + year + "/reg/all").get();

                    Elements body = document.select("tbody");

                    for (Element e : body.select("tr")) {
                        String name = e.select("td div.d3-o-club-info div.d3-o-club-fullname").text();
                        int receives = Integer.parseInt(e.select("td:nth-of-type(2)").text());
                        int touchdowns = Integer.parseInt(e.select("td:nth-of-type(5)").text());
                        int yards = Integer.parseInt(e.select("td:nth-of-type(3)").text());
                        TeamReceivingStats teamReceivingStats = new TeamReceivingStats(name, receives, touchdowns, yards);
                        teamReceivingStatsList.add(teamReceivingStats);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return teamReceivingStatsList;
    }

    public List<TeamRushingStats> getAllTeamRushingStats(String side, int year) {

        List<TeamRushingStats> teamRushingStatsList = new ArrayList<>();

        if (checkSide(side)) {
            if (checkYear(year)) {
                try {
                    final Document document = Jsoup.connect(TEAM_STATS_BASE_URL + side + "/rushing/" + year + "/reg/all").get();

                    Elements body = document.select("tbody");

                    for (Element e : body.select("tr")) {
                        String name = e.select("td div.d3-o-club-info div.d3-o-club-fullname").text();
                        int yards = Integer.parseInt(e.select("td:nth-of-type(3)").text());
                        int touchdowns = Integer.parseInt(e.select("td:nth-of-type(5)").text());
                        TeamRushingStats teamRushingStats = new TeamRushingStats(name, yards, touchdowns);
                        teamRushingStatsList.add(teamRushingStats);
                    }
                    System.out.println(teamRushingStatsList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return teamRushingStatsList;
    }


    //CHECKS FOR YEAR AND SIDE PATH VARIABLES
    private Boolean checkYear(int year) {
        if(year > Year.now().getValue() || year < 1920) {
            throw new RequestException(year + " is not a valid year");
        }
        return true;
    }

    private Boolean checkSide(String side) {
        if(side.equals(defense) || side.equals(offense)) {
            return true;
        }
        throw new RequestException(side + " is not a valid path parameter. Please use either 'offense' or 'defense'.");
    }
}
