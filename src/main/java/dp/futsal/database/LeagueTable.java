package dp.futsal.database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "league_table")
public class LeagueTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesDrew;
    private int gamesLost;
    private int goalsScored;
    private int goalsConceded;
    private int points;
    private int youthSelection;
    private int teamId;

    public LeagueTable() {

    }

    public LeagueTable(int youth, int teamId, int gamesPlayed, int gamesWon, int gamesDrew, int gamesLost,
	    int goalsScored, int goalsConceded, int points) {
	this.gamesPlayed = gamesPlayed;
	this.gamesWon = gamesWon;
	this.gamesDrew = gamesDrew;
	this.gamesLost = gamesLost;
	this.goalsScored = goalsScored;
	this.goalsConceded = goalsConceded;
	this.points = points;
	this.youthSelection = youth;
	this.teamId = teamId;
    }

    public LeagueTable(int id, int youth, int teamId, int gamesPlayed, int gamesWon, int gamesDrew, int gamesLost,
	    int goalsScored, int goalsConceded, int points) {
	this.id = id;
	this.gamesPlayed = gamesPlayed;
	this.gamesWon = gamesWon;
	this.gamesDrew = gamesDrew;
	this.gamesLost = gamesLost;
	this.goalsScored = goalsScored;
	this.goalsConceded = goalsConceded;
	this.points = points;
	this.youthSelection = youth;
	this.teamId = teamId;
    }

    @Override
    public String toString() {
	return "ID: " + this.id + " || Club{" + ", gamesPlayed=" + gamesPlayed + ", gamesWon=" + gamesWon
		+ ", gamesDrew=" + gamesDrew + ", gamesLost=" + gamesLost + ", goalsScored=" + goalsScored
		+ ", goalsConceded=" + goalsConceded + ", points=" + points + '}';
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
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

    public int getYouthSelection() {
	return youthSelection;
    }

    public void setYouthSelection(int youthSelection) {
	this.youthSelection = youthSelection;
    }

    public int getTeamId() {
	return teamId;
    }

    public void setTeamId(int teamId) {
	this.teamId = teamId;
    }

}
