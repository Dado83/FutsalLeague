package dp.futsal.form;


public class MatchResultForm {

    private int pairID;
    private int matchDay;
    private String homeTeam;
    private int homeTeamID;
    private String awayTeam;
    private int awayTeamID;

    private int goalsHome9;
    private int goalsAway9;
    private int goalsHome8;
    private int goalsAway8;
    private int goalsHome7;
    private int goalsAway7;
    private int goalsHome6;
    private int goalsAway6;
    private int goalsHome5;
    private int goalsAway5;

    public MatchResultForm() {

    }

    public MatchResultForm(int pairID, int matchDay, String homeTeam, int homeTeamID, String awayTeam, int awayTeamID,
            int goalsHome9, int goalsAway9, int goalsHome8, int goalsAway8, int goalsHome7, int goalsAway7,
            int goalsHome6, int goalsAway6, int goalsHome5, int goalsAway5) {
        this.pairID = pairID;
        this.matchDay = matchDay;
        this.homeTeam = homeTeam;
        this.homeTeamID = homeTeamID;
        this.awayTeam = awayTeam;
        this.awayTeamID = awayTeamID;
        this.goalsHome9 = goalsHome9;
        this.goalsAway9 = goalsAway9;
        this.goalsHome8 = goalsHome8;
        this.goalsAway8 = goalsAway8;
        this.goalsHome7 = goalsHome7;
        this.goalsAway7 = goalsAway7;
        this.goalsHome6 = goalsHome6;
        this.goalsAway6 = goalsAway6;
        this.goalsHome5 = goalsHome5;
        this.goalsAway5 = goalsAway5;
    }

    public int getMatchDay() {
        return matchDay;
    }

    @Override
    public String toString() {
        return "MatchResult{" + "matchDay=" + matchDay
                + ", pairID=" + pairID
                + ", homeTeam=" + homeTeam + ", homeTeamID=" + homeTeamID
                + ", awayTeam=" + awayTeam + ", awayTeamID=" + awayTeamID
                + ", goalsHome9=" + goalsHome9 + ", goalsAway9=" + goalsAway9
                + ", goalsHome8=" + goalsHome8 + ", goalsAway8=" + goalsAway8
                + ", goalsHome7=" + goalsHome7 + ", goalsAway7=" + goalsAway7
                + ", goalsHome6=" + goalsHome6 + ", goalsAway6=" + goalsAway6
                + ", goalsHome5=" + goalsHome5 + ", goalsAway5=" + goalsAway5 + '}';
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
        return goalsHome9;
    }

    public void setGoalsHome9(int goalsHome9) {
        this.goalsHome9 = goalsHome9;
    }

    public int getGoalsAway9() {
        return goalsAway9;
    }

    public void setGoalsAway9(int goalsAway9) {
        this.goalsAway9 = goalsAway9;
    }

    public int getGoalsHome8() {
        return goalsHome8;
    }

    public void setGoalsHome8(int goalsHome8) {
        this.goalsHome8 = goalsHome8;
    }

    public int getGoalsAway8() {
        return goalsAway8;
    }

    public void setGoalsAway8(int goalsAway8) {
        this.goalsAway8 = goalsAway8;
    }

    public int getGoalsHome7() {
        return goalsHome7;
    }

    public void setGoalsHome7(int goalsHome7) {
        this.goalsHome7 = goalsHome7;
    }

    public int getGoalsAway7() {
        return goalsAway7;
    }

    public void setGoalsAway7(int goalsAway7) {
        this.goalsAway7 = goalsAway7;
    }

    public int getGoalsHome6() {
        return goalsHome6;
    }

    public void setGoalsHome6(int goalsHome6) {
        this.goalsHome6 = goalsHome6;
    }

    public int getGoalsAway6() {
        return goalsAway6;
    }

    public void setGoalsAway6(int goalsAway6) {
        this.goalsAway6 = goalsAway6;
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
