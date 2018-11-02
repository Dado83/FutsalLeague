package dp.futsal.service;

import java.util.ArrayList;
import java.util.List;


public class Team implements Comparable<Team> {

    private int id;
    private String teamName;
    private String teamCity;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesDrew;
    private int gamesLost;
    private int goalsScored;
    private int goalsConceded;
    private int points;
    private List<MatchResult> results;
    private String kitColor;
    private String venue;

    public Team() {

    }

    public Team(int id, String clubName, String clubCity, int gamesPlayed, int gamesWon, int gamesDrew, int gamesLost,
            int goalsScored, int goalsConceded, int points, String kitColor) {
        this.id = id;
        this.teamName = clubName;
        this.teamCity = clubCity;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesDrew = gamesDrew;
        this.gamesLost = gamesLost;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        this.points = points;
        this.kitColor = kitColor;
        results = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " || Club{" + "clubName=" + teamName + ", gamesPlayed="
                + gamesPlayed + ", gamesWon=" + gamesWon + ", gamesDrew="
                + gamesDrew + ", gamesLost=" + gamesLost + ", goalsScored="
                + goalsScored + ", goalsConceded=" + goalsConceded
                + ", points=" + points
                + ", results=" + results
                + '}';
    }

    @Override
    public int compareTo(Team other) {
        int goalScored = this.getGoalsScored();
        int goalScoredOther = other.getGoalsScored();
        int goalDiff = goalScored - this.getGoalsConceded();
        int goalDiffOther = goalScoredOther - other.getGoalsConceded();
        int sortGoalDiff = Integer.compare(goalDiffOther, goalDiff);
        int sort = Integer.compare(other.getPoints(), this.getPoints());
        if (sort != 0) {
            return sort;
        }
        if (sort == 0) {
            sort = sortGoalDiff;
            if (sortGoalDiff == 0) {
                sort = Integer.compare(goalScoredOther, goalScored);
            }
        }
        return sort;
    }

    public void delMatchDay(String s) {
        List<MatchResult> resultsToRemove = new ArrayList<>();
        for (MatchResult m : results) {
            if (m.getId().startsWith(s)) {
                gamesPlayed--;
                if (m.getHomeTeamID() == id) {
                    goalsScored -= m.getGoalsHome();
                    goalsConceded -= m.getGoalsAway();
                    if (m.getGoalsHome() > m.getGoalsAway()) {
                        gamesWon--;
                        points -= 3;
                    } else if (m.getGoalsHome() < m.getGoalsAway()) {
                        gamesLost--;
                    } else {
                        gamesDrew--;
                        points--;
                    }
                } else {
                    goalsScored -= m.getGoalsAway();
                    goalsConceded -= m.getGoalsHome();
                    if (m.getGoalsAway() > m.getGoalsHome()) {
                        gamesWon--;
                        points -= 3;
                    } else if (m.getGoalsAway() < m.getGoalsHome()) {
                        gamesLost--;
                    } else {
                        gamesDrew--;
                        points--;
                    }
                }
                resultsToRemove.add(m);
            }
        }
        results.removeAll(resultsToRemove);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String clubName) {
        this.teamName = clubName;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamCity(String clubCity) {
        this.teamCity = clubCity;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesDrew() {
        return gamesDrew;
    }

    public void setGamesDrew(int gamesDrew) {
        this.gamesDrew = gamesDrew;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<MatchResult> getResults() {
        return results;
    }

    public void setResults(List<MatchResult> game) {
        this.results = game;
    }

    public void addResults(MatchResult game) {
        this.results.add(game);
    }

    public String getKitColor() {
        return kitColor;
    }

    public void setKitColor(String kitColor) {
        this.kitColor = kitColor;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

}
