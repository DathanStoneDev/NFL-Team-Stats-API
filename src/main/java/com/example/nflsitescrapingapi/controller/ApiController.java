package com.example.nflsitescrapingapi.controller;

import com.example.nflsitescrapingapi.service.WebScrapingService;
import com.example.nflsitescrapingapi.stats.TeamPassingStats;
import com.example.nflsitescrapingapi.stats.TeamReceivingStats;
import com.example.nflsitescrapingapi.stats.TeamRushingStats;
import com.example.nflsitescrapingapi.stats.TeamWinStats;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
    public CollectionModel<EntityModel<TeamWinStats>> getTeamWinStats(@PathVariable("year") int year) {
        List<EntityModel<TeamWinStats>> stats = webScrapingService.getAllTeamWinStats(year).stream()
                .map(stat -> EntityModel.of(stat,
                        linkTo(methodOn(ApiController.class).getTeamWinStats(year)).withRel("win-stats")))
                .collect(Collectors.toList());

        return CollectionModel.of(stats, linkTo(methodOn(ApiController.class).getTeamWinStats(year)).withSelfRel());
    }

    @GetMapping(value = "/passing-stats/{side}/{year}")
    @ResponseBody
    @ApiOperation(value = "Get a list of passing stats for all teams. Side parameter must be: 'offense' or 'defense'.")
    public CollectionModel<EntityModel<TeamPassingStats>> getTeamPassingStats(@PathVariable("side") String side, @PathVariable("year") int year) {
        List<EntityModel<TeamPassingStats>> stats = webScrapingService.getAllTeamPassingStats(side, year).stream()
                .map(stat -> EntityModel.of(stat,
                        linkTo(methodOn(ApiController.class).getTeamPassingStats(side, year)).withRel("passing-stats")))
                .collect(Collectors.toList());

        return CollectionModel.of(stats, linkTo(methodOn(ApiController.class).getTeamPassingStats(side, year)).withSelfRel());
    }

    @GetMapping(value = "/rushing-stats/{side}/{year}")
    @ResponseBody
    @ApiOperation(value = "Get a list of rushing stats for all teams. Side parameter must be: 'offense' or 'defense'.")
    public CollectionModel<EntityModel<TeamRushingStats>> getTeamRushingStats(@PathVariable("side") String side, @PathVariable("year") int year) {
        List<EntityModel<TeamRushingStats>> stats = webScrapingService.getAllTeamRushingStats(side, year).stream()
                .map(stat -> EntityModel.of(stat,
                        linkTo(methodOn(ApiController.class).getTeamRushingStats(side, year)).withRel("rushing-stats")))
                .collect(Collectors.toList());

        return CollectionModel.of(stats, linkTo(methodOn(ApiController.class).getTeamRushingStats(side, year)).withSelfRel());
    }

    @GetMapping(value = "/receiving-stats/{side}/{year}")
    @ResponseBody
    @ApiOperation(value = "Get a list of receiving stats for all teams. Side parameter must be: 'offense' or 'defense'.")
    public CollectionModel<EntityModel<TeamReceivingStats>> getTeamReceivingStats(@PathVariable("side") String side, @PathVariable("year") int year) {
        List<EntityModel<TeamReceivingStats>> stats = webScrapingService.getAllTeamReceivingStats(side, year).stream()
                .map(stat -> EntityModel.of(stat,
                        linkTo(methodOn(ApiController.class).getTeamPassingStats(side, year)).withRel("receiving-stats")))
                .collect(Collectors.toList());

        return CollectionModel.of(stats, linkTo(methodOn(ApiController.class).getTeamReceivingStats(side, year)).withSelfRel());
    }

}
