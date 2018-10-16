package dp.futsal.service;


public class MatchPair {

    private int homeTeam;
    private int awayTeam;

    public MatchPair(int homeTeam, int awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return "par (" + homeTeam + "-" + awayTeam + ")";
    }

    public int getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(int homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(int awayTeam) {
        this.awayTeam = awayTeam;
    }

}
