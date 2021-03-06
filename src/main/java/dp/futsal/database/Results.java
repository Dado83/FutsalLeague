package dp.futsal.database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "results")
public class Results implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int mDay;
    private String homeTeam;
    private int homeTeamid;
    private String awayTeam;
    private int awayTeamid;
    private int goalsHome;
    private int goalsAway;
    private int youthSelection;

    public Results() {

    }

    public Results(int mDay, String homeTeam, int homeTeamid, String awayTeam, int awayTeamid, int goalsHome,
	    int goalsAway, int youth) {
	this.mDay = mDay;
	this.homeTeam = homeTeam;
	this.homeTeamid = homeTeamid;
	this.awayTeam = awayTeam;
	this.awayTeamid = awayTeamid;
	this.goalsHome = goalsHome;
	this.goalsAway = goalsAway;
	this.youthSelection = youth;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getmDay() {
	return mDay;
    }

    public void setmDay(int mDay) {
	this.mDay = mDay;
    }

    public String getHomeTeam() {
	return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
	this.homeTeam = homeTeam;
    }

    public int getHomeTeamid() {
	return homeTeamid;
    }

    public void setHomeTeamid(int homeTeamid) {
	this.homeTeamid = homeTeamid;
    }

    public String getAwayTeam() {
	return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
	this.awayTeam = awayTeam;
    }

    public int getAwayTeamid() {
	return awayTeamid;
    }

    public void setAwayTeam(int awayTeamid) {
	this.awayTeamid = awayTeamid;
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

    public int getYouthSelection() {
	return youthSelection;
    }

    public void setYouthSelection(int youthSelection) {
	this.youthSelection = youthSelection;
    }

    @Override
    public String toString() {
	return id + ": " + mDay + " " + homeTeam + " " + awayTeam + " " + goalsHome + " " + goalsAway;
    }
}
