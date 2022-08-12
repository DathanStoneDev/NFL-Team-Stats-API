# NFL-Team-Stat-Tracker-API

### REST API that provides up-to-date NFL stats

#### 4 Types of team stats:

:small_blue_diamond: Passing Stats<br/>
:small_blue_diamond: Rushing Stats<br/>
:small_blue_diamond: Receiving Stats<br/>
:small_blue_diamond: Winning Stats<br/>

The NFL Team Stat Tracker can provide updated stats with every endpoint call due to the webscraping service, which scrapes the [NFL website](https://www.nfl.com/)

## Example of Response:
```
{
  "_embedded": {
    "teamPassingStatsList": [
      {
        "name": "Buccaneers",
        "passYards": 5383,
        "completions": 492,
        "touchdowns": 43,
        "_links": {
          "passing-stats": {
            "href": "https://nfl-team-stat-tracker.herokuapp.com/v1/nfl-stats/teams/passing-stats/offense/2021"
          }
        }
      },
      {
        "name": "Chiefs",
        "passYards": 4937,
        "completions": 448,
        "touchdowns": 37,
        "_links": {
          "passing-stats": {
            "href": "https://nfl-team-stat-tracker.herokuapp.com/v1/nfl-stats/teams/passing-stats/offense/2021"
          }
        }
      },
      "_links": {
        "self": {
         "href": "https://nfl-team-stat-tracker.herokuapp.com/v1/nfl-stats/teams/passing-stats/offense/2021"
       }
    }
 }
```

# Technology
:small_blue_diamond: Language: Java 8 <br/>
:small_blue_diamond: Framework: Springboot (v2.5.5) <br/>
:small_blue_diamond: Webscraping Library: Jsoup <br/>
:small_blue_diamond: Spring HATEOAS <br/>
:small_blue_diamond: Documentation: Swagger-UI <br/>

# Try It Out!

### This API is hosted on a Free Tier of Heroku, so the initial response time for the first query may take 10+ Seconds, and then it's much faster after that!
:small_blue_diamond: [Swagger UI Documentation](https://nfl-team-stat-tracker.herokuapp.com/swagger-ui/#/NFL%20Stats%20Queries): Test the API here! <br/>
:small_blue_diamond: [RapidAPI](https://rapidapi.com/DathanStoneDev/api/nfl-team-stats/): Access the API for free, public use. <br/>

