# NFL-Team-Stat-Tracker-API

### REST API that provides up-to-date NFL stats

#### 4 Types of team stats:

:small_blue_diamond: Passing Stats<br/>
:small_blue_diamond: Rushing Stats<br/>
:small_blue_diamond: Receiving Stats<br/>
:small_blue_diamond: Winning Stats<br/>

The NFL Team Stat Tracker can provide updated stats with every endpoint call due to the webscraping service, which scrapes the [NFL website](https://www.nfl.com/)

## Try It Out!
### This API is deployed using Amazon EC2 and mangaged through AWS Elastic Beanstalk!
:small_blue_diamond: [Swagger UI Documentation](http://nflteamstatsapi-env.eba-ri96jifs.us-east-1.elasticbeanstalk.com/swagger-ui/): Test the API here! <br/>
:small_blue_diamond: [RapidAPI](https://rapidapi.com/DathanStoneDev/api/nfl-team-stats/): Access the API for free, public use. <br/>

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

## Technology
:small_blue_diamond: Language: Java 8 <br/>
:small_blue_diamond: Framework: Springboot (v2.5.5) <br/>
:small_blue_diamond: Webscraping Library: Jsoup <br/>
:small_blue_diamond: Spring HATEOAS <br/>
:small_blue_diamond: Documentation: Swagger-UI <br/>

## Reflection
This project is one of my favorites. Spring Boot is incredible as it allowed me to create an amazing REST API that now recieves about ~5000+ requests a month! This project didn't take too long to make...I'd say 5-8 hours total which includes research and recent updates. 

When I started to get comfortable with Java, I decided to dive into the Spring framework and its quite the beast. This was my main challange, as it was completely new to me but luckily the [Spring Boot docs](https://spring.io/projects/spring-boot#overview) are extensive and comprehensive. I followed the simple MVC pattern (Kind of, but without the "V" since this is a RESTFul API) and went to work! 

My second challange was figuring out how to parse the NFL website tables that contains the stats I wanted. JSoup to the rescue! JSoup is an open-sourced java library for webscraping. The [documentation](https://jsoup.org/) helped immensely and so did the google dev tools to inspect the html tables on the NFL website site.

Lastly, this project was originally hosted on Heroku, however the start-up time of the free server was about 10-15 seconds for the first response. Since this project is in my portfolio and on my resume, I decided to find better deployment/hosting options. Recently I've been diving into Amazon Web Services and even deployed my portfolio website using AWS. I decided to research into the services I could use with my free tier and landed on Amazon EC2 and AWS Elastic Beanstalk! Elastic Beanstalk is an amazing management tool, that had a useful environment wizard which helped set up an EC2 instance for deployment and CloudWatch for monitoring. In the future, I'd like to setup a database on AWS and maybe add an AWS Lambda function to run my web service at certain times so when users request data, it won't scrape the NFL website everytime, but instead pull the stats from the database which should be faster!
