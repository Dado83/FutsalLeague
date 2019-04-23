package dp.futsal.database;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;


@Entity
@Table(name = "table5")
@SecondaryTable(name = "teams")
public class LeagueTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(table = "teams")
    private String teamName;
    @Column(table = "teams")
    private String teamCity;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesDrew;
    private int gamesLost;
    private int goalsScored;
    private int goalsConceded;
    private int points;
    private int youthSelection;

    public LeagueTable() {

    }

    public LeagueTable(int gamesPlayed, int gamesWon, int gamesDrew, int gamesLost, int goalsScored, int goalsConceded, int points, int youth) {
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesDrew = gamesDrew;
        this.gamesLost = gamesLost;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        this.points = points;
        this.youthSelection = youth;
    }

    public LeagueTable(int id, int gamesPlayed, int gamesWon, int gamesDrew, int gamesLost, int goalsScored, int goalsConceded, int points, int youth) {
        this.id = id;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesDrew = gamesDrew;
        this.gamesLost = gamesLost;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        this.points = points;
        this.youthSelection = youth;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " || Club{" + ", gamesPlayed="
                + gamesPlayed + ", gamesWon=" + gamesWon + ", gamesDrew="
                + gamesDrew + ", gamesLost=" + gamesLost + ", goalsScored="
                + goalsScored + ", goalsConceded=" + goalsConceded
                + ", points=" + points
                + '}';
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

}
