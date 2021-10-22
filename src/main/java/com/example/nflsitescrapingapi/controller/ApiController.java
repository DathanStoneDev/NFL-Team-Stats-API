package com.example.nflsitescrapingapi.controller;

import com.example.nflsitescrapingapi.service.WebScrapingService;
import com.example.nflsitescrapingapi.stats.TeamPassingStats;
import com.example.nflsitescrapingapi.stats.TeamReceivingStats;
import com.example.nflsitescrapingapi.stats.TeamRushingStats;
import com.example.nflsitescrapingapi.stats.TeamWinStats;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/nfl-stats/teams")
@CrossOrigin
@Api(tags = "NFL Stats Queries", value = "NFL Stats Queries")
public class ApiController {

    @Autowired
    WebScrapingService webScrapingService;

    @GetMapping(value = "/win-stats/{year}")
    @ResponseBody
    @ApiOperation(value = "Get a list of Win/Loss stats for all teams.")
    public List<TeamWinStats> getTeamWinStats(@PathVariable("year") int year) {
        return webScrapingService.getAllTeamWinStats(year);
    }

    @GetMapping(value = "/passing-stats/{side}/{year}")
    @ResponseBody
    @ApiOperation(value = "Get a list of passing stats for all teams. Side parameter must be: 'offense' or 'defense'.")
    public List<TeamPassingStats> getTeamPassingStats(@PathVariable("side") String side, @PathVariable("year") int year) {
        return webScrapingService.getAllTeamPassingStats(side, year);
    }

    @GetMapping(value = "/rushing-stats/{side}/{year}")
    @ResponseBody
    @ApiOperation(value = "Get a list of rushing stats for all teams. Side parameter must be: 'offense' or 'defense'.")
    public List<TeamRushingStats> getTeamRushingStats(@PathVariable("side") String side, @PathVariable("year") int year) {
        return webScrapingService.getAllTeamRushingStats(side, year);
    }

    @GetMapping(value = "/receiving-stats/{side}/{year}")
    @ResponseBody
    @ApiOperation(value = "Get a list of receiving stats for all teams. Side parameter must be: 'offense' or 'defense'.")
    public List<TeamReceivingStats> getTeamReceivingStats(@PathVariable("side") String side, @PathVariable("year") int year) {
        return webScrapingService.getAllTeamReceivingStats(side, year);
    }
}
