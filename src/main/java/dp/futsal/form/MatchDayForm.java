package dp.futsal.form;

import dp.futsal.service.MatchPair;
import dp.futsal.service.MatchResult;
import dp.futsal.service.Team;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class MatchDayForm {

    private static final Logger LOGGER = Logger.getLogger(MatchDayForm.class.getName());
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

    private int teamH3;
    private int teamA3;
    private String home3;
    private String away3;
    private int goalsH3;
    private int goalsA3;

    private int teamH4;
    private int teamA4;
    private String home4;
    private String away4;
    private int goalsH4;
    private int goalsA4;

    private int teamH5;
    private int teamA5;
    private String home5;
    private String away5;
    private int goalsH5;
    private int goalsA5;

    public MatchDayForm() {
        LOGGER.info("konstruktor");
    }

    public void loadForm(int index, List<Team> teamListIndexed, Map<Integer, List<MatchPair>> pairs) {
        LOGGER.info("load form");
        setmDay(index);
        setTeam(teamListIndexed);
        setPair(pairs.get(index));
        setTeamData();
    }

    private void setTeamData() {
        LOGGER.info("pocetak team data");
        teamH1 = team.get(pair.get(0).getHomeTeam()).getId();
        teamA1 = team.get(pair.get(0).getAwayTeam()).getId();
        home1 = team.get(pair.get(0).getHomeTeam()).getTeamName();
        away1 = team.get(pair.get(0).getAwayTeam()).getTeamName();

        teamH2 = team.get(pair.get(1).getHomeTeam()).getId();
        teamA2 = team.get(pair.get(1).getAwayTeam()).getId();
        home2 = team.get(pair.get(1).getHomeTeam()).getTeamName();
        away2 = team.get(pair.get(1).getAwayTeam()).getTeamName();

        teamH3 = team.get(pair.get(2).getHomeTeam()).getId();
        teamA3 = team.get(pair.get(2).getAwayTeam()).getId();
        home3 = team.get(pair.get(2).getHomeTeam()).getTeamName();
        away3 = team.get(pair.get(2).getAwayTeam()).getTeamName();

        teamH4 = team.get(pair.get(3).getHomeTeam()).getId();
        teamA4 = team.get(pair.get(3).getAwayTeam()).getId();
        home4 = team.get(pair.get(3).getHomeTeam()).getTeamName();
        away4 = team.get(pair.get(3).getAwayTeam()).getTeamName();

        teamH5 = team.get(pair.get(4).getHomeTeam()).getId();
        teamA5 = team.get(pair.get(4).getAwayTeam()).getId();
        home5 = team.get(pair.get(4).getHomeTeam()).getTeamName();
        away5 = team.get(pair.get(4).getAwayTeam()).getTeamName();
    }

    public void saveResults(Map<Integer, List<MatchResult>> resultsMap, Map<Integer, String> postponed, Map<Integer, String> notPlaying) {
        LOGGER.info("addresults");

        MatchResult m1 = new MatchResult(mDay, teamMap, teamH1, teamA1, goalsH1, goalsA1, postponed);
        MatchResult m2 = new MatchResult(mDay, teamMap, teamH2, teamA2, goalsH2, goalsA2, postponed);
        MatchResult m3 = new MatchResult(mDay, teamMap, teamH3, teamA3, goalsH3, goalsA3, postponed);
        MatchResult m4 = new MatchResult(mDay, teamMap, teamH4, teamA4, goalsH4, goalsA4, postponed);
        MatchResult m5 = new MatchResult(mDay, teamMap, teamH5, teamA5, goalsH5, goalsA5, postponed);

        if (m1.getHomeTeam().equals("pauza") || m1.getAwayTeam().equals("pauza") || m1.getGoalsHome() == -1) {
            if (m1.getAwayTeam().equals("pauza")) {
                notPlaying.put(mDay, m1.getHomeTeam());
            }
            if (m1.getHomeTeam().equals("pauza")) {
                notPlaying.put(mDay, m1.getAwayTeam());
            }
            LOGGER.info("ekipa slobodna");
        } else {
            results.add(m1);
        }
        if (m2.getHomeTeam().equals("pauza") || m2.getAwayTeam().equals("pauza") || m2.getGoalsHome() == -1) {
            if (m2.getAwayTeam().equals("pauza")) {
                notPlaying.put(mDay, m2.getHomeTeam());
            }
            if (m1.getHomeTeam().equals("pauza")) {
                notPlaying.put(mDay, m2.getAwayTeam());
            }
            LOGGER.info("ekipa slobodna");
        } else {
            results.add(m2);
        }
        if (m3.getHomeTeam().equals("pauza") || m3.getAwayTeam().equals("pauza") || m3.getGoalsHome() == -1) {
            if (m3.getAwayTeam().equals("pauza")) {
                notPlaying.put(mDay, m3.getHomeTeam());
            }
            if (m1.getHomeTeam().equals("pauza")) {
                notPlaying.put(mDay, m3.getAwayTeam());
            }
            LOGGER.info("ekipa slobodna");
        } else {
            results.add(m3);
        }
        if (m4.getHomeTeam().equals("pauza") || m4.getAwayTeam().equals("pauza") || m4.getGoalsHome() == -1) {
            if (m4.getAwayTeam().equals("pauza")) {
                notPlaying.put(mDay, m4.getHomeTeam());
            }
            if (m1.getHomeTeam().equals("pauza")) {
                notPlaying.put(mDay, m4.getAwayTeam());
            }
            LOGGER.info("ekipa slobodna");
        } else {
            results.add(m4);
        }
        if (m5.getHomeTeam().equals("pauza") || m5.getAwayTeam().equals("pauza") || m5.getGoalsHome() == -1) {
            if (m5.getAwayTeam().equals("pauza")) {
                notPlaying.put(mDay, m5.getHomeTeam());
            }
            if (m1.getHomeTeam().equals("pauza")) {
                notPlaying.put(mDay, m5.getAwayTeam());
            }
            LOGGER.info("ekipa slobodna");
        } else {
            results.add(m5);
        }

        resultsMap.put(mDay, results);

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

    public int getTeamH3() {
        return teamH3;
    }

    public void setTeamH3(int teamH3) {
        this.teamH3 = teamH3;
    }

    public int getTeamA3() {
        return teamA3;
    }

    public void setTeamA3(int teamA3) {
        this.teamA3 = teamA3;
    }

    public int getGoalsH3() {
        return goalsH3;
    }

    public void setGoalsH3(int goalsH3) {
        this.goalsH3 = goalsH3;
    }

    public int getGoalsA3() {
        return goalsA3;
    }

    public void setGoalsA3(int goalsA3) {
        this.goalsA3 = goalsA3;
    }

    public int getTeamH4() {
        return teamH4;
    }

    public void setTeamH4(int teamH4) {
        this.teamH4 = teamH4;
    }

    public int getTeamA4() {
        return teamA4;
    }

    public void setTeamA4(int teamA4) {
        this.teamA4 = teamA4;
    }

    public int getGoalsH4() {
        return goalsH4;
    }

    public void setGoalsH4(int goalsH4) {
        this.goalsH4 = goalsH4;
    }

    public int getGoalsA4() {
        return goalsA4;
    }

    public void setGoalsA4(int goalsA4) {
        this.goalsA4 = goalsA4;
    }

    public int getTeamH5() {
        return teamH5;
    }

    public void setTeamH5(int teamH5) {
        this.teamH5 = teamH5;
    }

    public int getTeamA5() {
        return teamA5;
    }

    public void setTeamA5(int teamA5) {
        this.teamA5 = teamA5;
    }

    public int getGoalsH5() {
        return goalsH5;
    }

    public void setGoalsH5(int goalsH5) {
        this.goalsH5 = goalsH5;
    }

    public int getGoalsA5() {
        return goalsA5;
    }

    public void setGoalsA5(int goalsA5) {
        this.goalsA5 = goalsA5;
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

    public String getHome3() {
        return home3;
    }

    public void setHome3(String home3) {
        this.home3 = home3;
    }

    public String getAway3() {
        return away3;
    }

    public void setAway3(String away3) {
        this.away3 = away3;
    }

    public String getHome4() {
        return home4;
    }

    public void setHome4(String home4) {
        this.home4 = home4;
    }

    public String getAway4() {
        return away4;
    }

    public void setAway4(String away4) {
        this.away4 = away4;
    }

    public String getHome5() {
        return home5;
    }

    public void setHome5(String home5) {
        this.home5 = home5;
    }

    public String getAway5() {
        return away5;
    }

    public void setAway5(String away5) {
        this.away5 = away5;
    }

}
