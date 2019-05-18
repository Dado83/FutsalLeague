package dp.futsal.form;

public class MatchResultForm {

    private int pairID;
    private int matchDay;
    private String homeTeam;
    private int homeTeamID;
    private String awayTeam;
    private int awayTeamID;

    private int goalsHome1;
    private int goalsAway1;
    private int goalsHome2;
    private int goalsAway2;
    private int goalsHome3;
    private int goalsAway3;
    private int goalsHome4;
    private int goalsAway4;
    private int goalsHome5;
    private int goalsAway5;

    public MatchResultForm() {

    }

    public MatchResultForm(int pairID, int matchDay, String homeTeam, int homeTeamID, String awayTeam, int awayTeamID,
	    int goalsHome1, int goalsAway1, int goalsHome2, int goalsAway2, int goalsHome3, int goalsAway3,
	    int goalsHome4, int goalsAway4, int goalsHome5, int goalsAway5) {
	this.pairID = pairID;
	this.matchDay = matchDay;
	this.homeTeam = homeTeam;
	this.homeTeamID = homeTeamID;
	this.awayTeam = awayTeam;
	this.awayTeamID = awayTeamID;
	this.goalsHome1 = goalsHome1;
	this.goalsAway1 = goalsAway1;
	this.goalsHome2 = goalsHome2;
	this.goalsAway2 = goalsAway2;
	this.goalsHome3 = goalsHome3;
	this.goalsAway3 = goalsAway3;
	this.goalsHome4 = goalsHome4;
	this.goalsAway4 = goalsAway4;
	this.goalsHome5 = goalsHome5;
	this.goalsAway5 = goalsAway5;
    }

    public int getMatchDay() {
	return matchDay;
    }

    @Override
    public String toString() {
	return "MatchResult{" + "matchDay=" + matchDay + ", pairID=" + pairID + ", homeTeam=" + homeTeam
		+ ", homeTeamID=" + homeTeamID + ", awayTeam=" + awayTeam + ", awayTeamID=" + awayTeamID
		+ ", goalsHome9=" + goalsHome1 + ", goalsAway9=" + goalsAway1 + ", goalsHome8=" + goalsHome2
		+ ", goalsAway8=" + goalsAway2 + ", goalsHome7=" + goalsHome3 + ", goalsAway7=" + goalsAway3
		+ ", goalsHome6=" + goalsHome4 + ", goalsAway6=" + goalsAway4 + ", goalsHome5=" + goalsHome5
		+ ", goalsAway5=" + goalsAway5 + '}';
    }

    public void setMatchDay(int matchDay) {
	this.matchDay = matchDay;
    }

    public String getHomeTeam() {
	return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
	this.homeTeam = homeTeam;
    }

    public int getHomeTeamID() {
	return homeTeamID;
    }

    public void setHomeTeamID(int homeTeamID) {
	this.homeTeamID = homeTeamID;
    }

    public String getAwayTeam() {
	return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
	this.awayTeam = awayTeam;
    }

    public int getAwayTeamID() {
	return awayTeamID;
    }

    public void setAwayTeamID(int awayTeamID) {
	this.awayTeamID = awayTeamID;
    }

    public int getGoalsHome9() {
	return goalsHome1;
    }

    public void setGoalsHome9(int goalsHome9) {
	this.goalsHome1 = goalsHome9;
    }

    public int getGoalsAway9() {
	return goalsAway1;
    }

    public void setGoalsAway9(int goalsAway9) {
	this.goalsAway1 = goalsAway9;
    }

    public int getGoalsHome8() {
	return goalsHome2;
    }

    public void setGoalsHome8(int goalsHome8) {
	this.goalsHome2 = goalsHome8;
    }

    public int getGoalsAway8() {
	return goalsAway2;
    }

    public void setGoalsAway8(int goalsAway8) {
	this.goalsAway2 = goalsAway8;
    }

    public int getGoalsHome7() {
	return goalsHome3;
    }

    public void setGoalsHome7(int goalsHome7) {
	this.goalsHome3 = goalsHome7;
    }

    public int getGoalsAway7() {
	return goalsAway3;
    }

    public void setGoalsAway7(int goalsAway7) {
	this.goalsAway3 = goalsAway7;
    }

    public int getGoalsHome6() {
	return goalsHome4;
    }

    public void setGoalsHome6(int goalsHome6) {
	this.goalsHome4 = goalsHome6;
    }

    public int getGoalsAway6() {
	return goalsAway4;
    }

    public void setGoalsAway6(int goalsAway6) {
	this.goalsAway4 = goalsAway6;
    }

    public int getGoalsHome5() {
	return goalsHome5;
    }

    public void setGoalsHome5(int goalsHome5) {
	this.goalsHome5 = goalsHome5;
    }

    public int getGoalsAway5() {
	return goalsAway5;
    }

    public void setGoalsAway5(int goalsAway5) {
	this.goalsAway5 = goalsAway5;
    }

    public int getPairID() {
	return pairID;
    }

    public void setPairID(int pairID) {
	this.pairID = pairID;
    }

}
