package dp.futsal.service.notUsed;

import dp.futsal.service.MatchPair;
import dp.futsal.service.MatchResult;
import dp.futsal.service.Team;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class MatchDayFormB {

    private static final Logger LOGGER = Logger.getLogger(MatchDayFormB.class.getName());
    private List<Team> team;
    private List<MatchPair> pair;
    private Map<Integer, Team> teamMap;

    private List<MatchResult> results = new ArrayList<>();

    private int mDay;

    private int teamH1;
    private int teamA1;
    private String home1;
    private String away1;
    private int goalsH1;
    private int goalsA1;

    private int teamH2;
    private int teamA2;
    private String home2;
    private String away2;
    private int goalsH2;
    private int goalsA2;

    public MatchDayFormB() {
        LOGGER.info("konstruktor");
    }

    public void loadForm(int index, List<Team> teamListIndexed, Map<Integer, List<MatchPair>> pairs) {
        LOGGER.info("load form");
        this.setmDay(index);
        this.setTeam(teamListIndexed);
        this.setPair(pairs.get(index));
        this.setTeamData();
    }

    private void setTeamData() {
        LOGGER.info("pocetak team data");
        this.teamH1 = team.get(pair.get(0).getHomeTeam()).getId();
        this.teamA1 = team.get(pair.get(0).getAwayTeam()).getId();
        this.home1 = team.get(pair.get(0).getHomeTeam()).getTeamName();
        this.away1 = team.get(pair.get(0).getAwayTeam()).getTeamName();

        this.teamH2 = team.get(pair.get(1).getHomeTeam()).getId();
        this.teamA2 = team.get(pair.get(1).getAwayTeam()).getId();
        this.home2 = team.get(pair.get(1).getHomeTeam()).getTeamName();
        this.away2 = team.get(pair.get(1).getAwayTeam()).getTeamName();

    }

    public void saveResults(Map<Integer, List<MatchResult>> resultsMap, Map<Integer, String> postponed, Map<Integer, String> notPlaying) {
        LOGGER.info("addresults");

        MatchResult m1 = new MatchResult(this.mDay, this.teamMap, this.teamH1, this.teamA1, this.goalsH1, this.goalsA1, postponed);
        MatchResult m2 = new MatchResult(this.mDay, this.teamMap, this.teamH2, this.teamA2, this.goalsH2, this.goalsA2, postponed);

        if (m1.getHomeTeam().equals("pauza") || m1.getAwayTeam().equals("pauza") || m1.getGoalsHome() == -1) {
            if (m1.getAwayTeam().equals("pauza")) {
                notPlaying.put(this.mDay, m1.getHomeTeam());
            }
            if (m1.getHomeTeam().equals("pauza")) {
                notPlaying.put(this.mDay, m1.getAwayTeam());
            }
            LOGGER.info("ekipa slobodna");
        } else {
            results.add(m1);
        }
        if (m2.getHomeTeam().equals("pauza") || m2.getAwayTeam().equals("pauza") || m2.getGoalsHome() == -1) {
            if (m2.getAwayTeam().equals("pauza")) {
                notPlaying.put(this.mDay, m2.getHomeTeam());
            }
            if (m1.getHomeTeam().equals("pauza")) {
                notPlaying.put(this.mDay, m2.getAwayTeam());
            }
            LOGGER.info("ekipa slobodna");
        } else {
            results.add(m2);
        }

        resultsMap.put(this.mDay, results);

        LOGGER.info(" kraj addresults");
    }

    @Override
    public String toString() {
        return mDay + ". kolo. ";
    }

    public List<MatchResult> getResults() {
        return results;
    }

    public Map<Integer, Team> getTeamMap() {
        return teamMap;
    }

    public void setTeamMap(Map<Integer, Team> teamMap) {
        LOGGER.info("set map");
        this.teamMap = teamMap;
    }

    public List<MatchPair> getPair() {
        return pair;
    }

    public void setPair(List<MatchPair> pair) {
        LOGGER.info("set pair");
        this.pair = pair;
    }

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        LOGGER.info("set team");
        this.team = team;
    }

    public int getmDay() {
        return mDay;
    }

    public void setmDay(int mDay) {
        this.mDay = mDay;
    }

    public int getTeamH1() {
        return teamH1;
    }

    public void setTeamH1(int teamH1) {
        this.teamH1 = teamH1;
    }

    public int getTeamA1() {
        return teamA1;
    }

    public void setTeamA1(int teamA1) {
        this.teamA1 = teamA1;
    }

    public int getGoalsH1() {
        return goalsH1;
    }

    public void setGoalsH1(int goalsH1) {
        this.goalsH1 = goalsH1;
    }

    public int getGoalsA1() {
        return goalsA1;
    }

    public void setGoalsA1(int goalsA1) {
        this.goalsA1 = goalsA1;
    }

    public int getTeamH2() {
        return teamH2;
    }

    public void setTeamH2(int teamH2) {
        this.teamH2 = teamH2;
    }

    public int getTeamA2() {
        return teamA2;
    }

    public void setTeamA2(int teamA2) {
        this.teamA2 = teamA2;
    }

    public int getGoalsH2() {
        return goalsH2;
    }

    public void setGoalsH2(int goalsH2) {
        this.goalsH2 = goalsH2;
    }

    public int getGoalsA2() {
        return goalsA2;
    }

    public void setGoalsA2(int goalsA2) {
        this.goalsA2 = goalsA2;
    }

    public String getHome1() {
        return home1;
    }

    public void setHome1(String home1) {
        this.home1 = home1;
    }

    public String getAway1() {
        return away1;
    }

    public void setAway1(String away1) {
        this.away1 = away1;
    }

    public String getHome2() {
        return home2;
    }

    public void setHome2(String home2) {
        this.home2 = home2;
    }

    public String getAway2() {
        return away2;
    }

    public void setAway2(String away2) {
        this.away2 = away2;
    }

}
