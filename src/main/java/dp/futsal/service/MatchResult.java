package dp.futsal.service;

import java.util.Map;
import java.util.logging.Logger;


public class MatchResult {

    private String id;
    private int matchDay;
    private String homeTeam;
    private int homeTeamID;
    private String awayTeam;
    private int awayTeamID;
    private int goalsHome;
    private int goalsAway;

    public MatchResult() {

    }

    public MatchResult(int matchDay, Map<Integer, Team> teamMap, int homeTeam, int awayTeam, int goalsHome, int goalsAway,
            Map<Integer, String> postponed) {
        Team home;
        Team away;
        home = teamMap.get(homeTeam);
        away = teamMap.get(awayTeam);
        this.matchDay = matchDay;
        this.homeTeam = home.getTeamName();
        this.awayTeam = away.getTeamName();
        this.goalsHome = goalsHome;
        this.goalsAway = goalsAway;
        this.homeTeamID = home.getId();
        this.awayTeamID = away.getId();

        this.id = "" + matchDay + homeTeam + awayTeam;

        if (this.homeTeam.equals("pauza") || this.awayTeam.equals("pauza") || this.goalsHome == -1) {
            if (this.goalsHome == -1) {
                postponed.put(this.matchDay, this.homeTeam + " - " + this.awayTeam);
                Logger.getLogger(MatchResult.class.getName()).info("ponistena utakmica");
            }
            Logger.getLogger(MatchResult.class.getName()).info("utakmica gdje ekipa pauzira");
        } else {

            home.setGoalsScored(home.getGoalsScored() + goalsHome);
            home.setGoalsConceded(home.getGoalsConceded() + goalsAway);
            away.setGoalsScored(away.getGoalsScored() + goalsAway);
            away.setGoalsConceded(away.getGoalsConceded() + goalsHome);

            home.setGamesPlayed(home.getGamesPlayed() + 1);
            away.setGamesPlayed(away.getGamesPlayed() + 1);

            if (goalsHome > goalsAway) {
                home.setGamesWon(home.getGamesWon() + 1);
                away.setGamesLost(away.getGamesLost() + 1);
                home.setPoints(home.getPoints() + 3);
            } else if (goalsHome < goalsAway) {
                away.setGamesWon(away.getGamesWon() + 1);
                home.setGamesLost(home.getGamesLost() + 1);
                away.setPoints(away.getPoints() + 3);
            } else {
                home.setGamesDrew(home.getGamesDrew() + 1);
                away.setGamesDrew(away.getGamesDrew() + 1);
                home.setPoints(home.getPoints() + 1);
                away.setPoints(away.getPoints() + 1);
            }

            home.addResults(this);
            away.addResults(this);
        }
    }

    @Override
    public String toString() {
        return matchDay + ". kolo: " + homeTeam + " " + goalsHome + "-" + goalsAway + " " + awayTeam + " ID: " + id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(int matchDay) {
        this.matchDay = matchDay;
    }

    public int getHomeTeamID() {
        return homeTeamID;
    }

    public void setHomeTeamID(int homeTeamID) {
        this.homeTeamID = homeTeamID;
    }

    public int getAwayTeamID() {
        return awayTeamID;
    }

    public void setAwayTeamID(int awayTeamID) {
        this.awayTeamID = awayTeamID;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getGoalsHome() {
        return goalsHome;
    }

    public void setGoalsHome(int goalsHome) {
        this.goalsHome = goalsHome;
    }

    public int getGoalsAway() {
        return goalsAway;
    }

    public void setGoalsAway(int goalsAway) {
        this.goalsAway = goalsAway;
    }

}
