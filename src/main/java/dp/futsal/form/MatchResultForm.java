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
    private int youthSelection1;
    private int youthSelection2;
    private int youthSelection3;
    private int youthSelection4;
    private int youthSelection5;

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

    public int getGoalsHome1() {
	return goalsHome1;
    }

    public void setGoalsHome1(int goalsHome1) {
	this.goalsHome1 = goalsHome1;
    }

    public int getGoalsAway1() {
	return goalsAway1;
    }

    public void setGoalsAway1(int goalsAway1) {
	this.goalsAway1 = goalsAway1;
    }

    public int getGoalsHome2() {
	return goalsHome2;
    }

    public void setGoalsHome2(int goalsHome2) {
	this.goalsHome2 = goalsHome2;
    }

    public int getGoalsAway2() {
	return goalsAway2;
    }

    public void setGoalsAway2(int goalsAway2) {
	this.goalsAway2 = goalsAway2;
    }

    public int getGoalsHome3() {
	return goalsHome3;
    }

    public void setGoalsHome3(int goalsHome3) {
	this.goalsHome3 = goalsHome3;
    }

    public int getGoalsAway3() {
	return goalsAway3;
    }

    public void setGoalsAway3(int goalsAway3) {
	this.goalsAway3 = goalsAway3;
    }

    public int getGoalsHome4() {
	return goalsHome4;
    }

    public void setGoalsHome4(int goalsHome4) {
	this.goalsHome4 = goalsHome4;
    }

    public int getGoalsAway4() {
	return goalsAway4;
    }

    public void setGoalsAway4(int goalsAway4) {
	this.goalsAway4 = goalsAway4;
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

    public int getYouthSelection1() {
	return youthSelection1;
    }

    public void setYouthSelection1(int youthSelection) {
	this.youthSelection1 = youthSelection;
    }

    public int getYouthSelection2() {
	return youthSelection2;
    }

    public void setYouthSelection2(int youthSelection2) {
	this.youthSelection2 = youthSelection2;
    }

    public int getYouthSelection3() {
	return youthSelection3;
    }

    public void setYouthSelection3(int youthSelection3) {
	this.youthSelection3 = youthSelection3;
    }

    public int getYouthSelection4() {
	return youthSelection4;
    }

    public void setYouthSelection4(int youthSelection4) {
	this.youthSelection4 = youthSelection4;
    }

    public int getYouthSelection5() {
	return youthSelection5;
    }

    public void setYouthSelection5(int youthSelection5) {
	this.youthSelection5 = youthSelection5;
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

}
