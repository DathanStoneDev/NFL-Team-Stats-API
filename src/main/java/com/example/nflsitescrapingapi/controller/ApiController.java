package com.example.nflsitescrapingapi.controller;

import com.example.nflsitescrapingapi.service.WebScrapingService;
import com.example.nflsitescrapingapi.stats.TeamPassingStats;
import com.example.nflsitescrapingapi.stats.TeamReceivingStats;
import com.example.nflsitescrapingapi.stats.TeamRushingStats;
import com.example.nflsitescrapingapi.stats.TeamWinStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/nfl-stats/teams")
@CrossOrigin
public class ApiController {

    @Autowired
    WebScrapingService webScrapingService;

    @GetMapping(value = "/win-stats/{year}")
    @ResponseBody
    public List<TeamWinStats> getTeamWinStats(@PathVariable("year") int year) {
        return webScrapingService.getAllTeamWinStats(year);
    }

    @GetMapping(value = "/passing-stats/{side}/{year}")
    @ResponseBody
    public List<TeamPassingStats> getTeamPassingStats(@PathVariable("side") String side, @PathVariable("year") int year) {
        return webScrapingService.getAllTeamPassingStats(side, year);
    }

    @GetMapping(value = "/rushing-stats/{side}/{year}")
    @ResponseBody
    public List<TeamRushingStats> getTeamRushingStats(@PathVariable("side") String side, @PathVariable("year") int year) {
        return webScrapingService.getAllTeamRushingStats(side, year);
    }

    @GetMapping(value = "/receiving-stats/{side}/{year}")
    @ResponseBody
    public List<TeamReceivingStats> getTeamReceivingStats(@PathVariable("side") String side, @PathVariable("year") int year) {
        return webScrapingService.getAllTeamReceivingStats(side, year);
    }
}
