package dp.futsal.service;

import dp.futsal.form.TeamForm;
import dp.futsal.ftp.FTP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;


@Service
public class FutsalService {

    private static final Logger LOGGER = Logger.getLogger(FutsalService.class.getName());
    private FTP ftpClient;
    private Fixture fixture;
    private TeamCollection teamCollection;
    private Map<Integer, List<MatchPair>> matchDaypairs;
    private Map<Integer, String> leagueDates;
    private Map<Integer, List<MatchResult>> results5;
    private Map<Integer, List<MatchResult>> results6;
    private Map<Integer, List<MatchResult>> results7;
    private Map<Integer, List<MatchResult>> results8;
    private Map<Integer, List<MatchResult>> results9;
    private Map<Integer, Team> teams5;
    private Map<Integer, Team> teams6;
    private Map<Integer, Team> teams7;
    private Map<Integer, Team> teams8;
    private Map<Integer, Team> teams9;
    private List<Team> leagueTable5;
    private List<Team> leagueTable6;
    private List<Team> leagueTable7;
    private List<Team> leagueTable8;
    private List<Team> leagueTable9;
    private List<Team> teamLinks5;
    private List<Team> teamLinks6;
    private List<Team> teamLinks7;
    private List<Team> teamLinks8;
    private List<Team> teamLinks9;
    private List<Team> teamLogos;
    private Map<Integer, String> gamePostponed;
    private Map<Integer, String> notPlaying;

    public void init() {
        LOGGER.info("init");
        ftpClient = new FTP();
        fixture = new Fixture();
        fixture.loadFixturesFromJson("http://fairplay.hol.es/futsal/berger9-10.json");
        matchDaypairs = fixture.getPairs();
        leagueDates = fixture.loadDatesFromJson("http://fairplay.hol.es/futsal/leagueDates.json");

        results5 = fixture.loadResultsFromJson("http://fairplay.hol.es/futsal/results5.json");
        results6 = fixture.loadResultsFromJson("http://fairplay.hol.es/futsal/results6.json");
        results7 = fixture.loadResultsFromJson("http://fairplay.hol.es/futsal/results7.json");
        results8 = fixture.loadResultsFromJson("http://fairplay.hol.es/futsal/results8.json");
        results9 = fixture.loadResultsFromJson("http://fairplay.hol.es/futsal/results9.json");

        teamCollection = new TeamCollection();
        teams5 = teamCollection.loadTeamsFromJson("http://fairplay.hol.es/futsal/teams5.json");
        teams6 = teamCollection.loadTeamsFromJson("http://fairplay.hol.es/futsal/teams6.json");
        teams7 = teamCollection.loadTeamsFromJson("http://fairplay.hol.es/futsal/teams7.json");
        teams8 = teamCollection.loadTeamsFromJson("http://fairplay.hol.es/futsal/teams8.json");
        teams9 = teamCollection.loadTeamsFromJson("http://fairplay.hol.es/futsal/teams9.json");

        teamLogos = new ArrayList<>(teams5.values());
        leagueTable5 = new ArrayList<>(teams5.values());
        teamLinks5 = new ArrayList<>();
        teamLinks5.add(null);
        for (Team tab : leagueTable5) {
            teamLinks5.add(tab.getId(), tab);
        }
        Collections.sort(leagueTable5);

        leagueTable6 = new ArrayList<>(teams6.values());
        teamLinks6 = new ArrayList<>();
        teamLinks6.add(null);
        for (Team tab : leagueTable6) {
            teamLinks6.add(tab.getId(), tab);
        }
        Collections.sort(leagueTable6);

        leagueTable7 = new ArrayList<>(teams7.values());
        teamLinks7 = new ArrayList<>();
        teamLinks7.add(null);
        for (Team tab : leagueTable7) {
            teamLinks7.add(tab.getId(), tab);
        }
        Collections.sort(leagueTable7);

        leagueTable8 = new ArrayList<>(teams8.values());
        teamLinks8 = new ArrayList<>();
        teamLinks8.add(null);
        for (Team tab : leagueTable8) {
            teamLinks8.add(tab.getId(), tab);
        }
        Collections.sort(leagueTable8);

        leagueTable9 = new ArrayList<>(teams9.values());
        teamLinks9 = new ArrayList<>();
        teamLinks9.add(null);
        for (Team tab : leagueTable9) {
            teamLinks9.add(tab.getId(), tab);
        }
        Collections.sort(leagueTable9);

        gamePostponed = new HashMap<>();
        notPlaying = new HashMap<>();
    }

    public void saveFutsalData() {
        String results5localFile = "D:/fer plej/Zimska liga 2018-2019/app data/results5.json";
        String results6localFile = "D:/fer plej/Zimska liga 2018-2019/app data/results6.json";
        String results7localFile = "D:/fer plej/Zimska liga 2018-2019/app data/results7.json";
        String results8localFile = "D:/fer plej/Zimska liga 2018-2019/app data/results8.json";
        String results9localFile = "D:/fer plej/Zimska liga 2018-2019/app data/results9.json";
        String teams5localFile = "D:/fer plej/Zimska liga 2018-2019/app data/teams5.json";
        String teams6localFile = "D:/fer plej/Zimska liga 2018-2019/app data/teams6.json";
        String teams7localFile = "D:/fer plej/Zimska liga 2018-2019/app data/teams7.json";
        String teams8localFile = "D:/fer plej/Zimska liga 2018-2019/app data/teams8.json";
        String teams9localFile = "D:/fer plej/Zimska liga 2018-2019/app data/teams9.json";
        
        String results5serverFile = "futsal/results5.json";
        String results6serverFile = "futsal/results6.json";
        String results7serverFile = "futsal/results7.json";
        String results8serverFile = "futsal/results8.json";
        String results9serverFile = "futsal/results9.json";
        String teams5serverFile = "futsal/teams5.json";
        String teams6serverFile = "futsal/teams6.json";
        String teams7serverFile = "futsal/teams7.json";
        String teams8serverFile = "futsal/teams8.json";
        String teams9serverFile = "futsal/teams9.json";
        
        
        fixture.saveResultsToJson(results5localFile, results5);
        fixture.saveResultsToJson(results6localFile, results6);
        fixture.saveResultsToJson(results7localFile, results7);
        fixture.saveResultsToJson(results8localFile, results8);
        fixture.saveResultsToJson(results9localFile, results9);
        ftpClient.uploadFile(results5serverFile, results5localFile);
        ftpClient.uploadFile(results6serverFile, results6localFile);
        ftpClient.uploadFile(results7serverFile, results7localFile);
        ftpClient.uploadFile(results8serverFile, results8localFile);
        ftpClient.uploadFile(results9serverFile, results9localFile);

        teamCollection.saveTeamsToJson(teams5localFile, teams5);
        teamCollection.saveTeamsToJson(teams6localFile, teams6);
        teamCollection.saveTeamsToJson(teams7localFile, teams7);
        teamCollection.saveTeamsToJson(teams8localFile, teams8);
        teamCollection.saveTeamsToJson(teams9localFile, teams9);
        ftpClient.uploadFile(teams5serverFile, teams5localFile);
        ftpClient.uploadFile(teams6serverFile, teams6localFile);
        ftpClient.uploadFile(teams7serverFile, teams7localFile);
        ftpClient.uploadFile(teams8serverFile, teams8localFile);
        ftpClient.uploadFile(teams9serverFile, teams9localFile);
    }

    public void updateTeam(TeamForm team) {
        Team team5 = getTeam5(team.getId());
        team5.setId(team.getId());
        team5.setTeamName(team.getTeamName());
        team5.setTeamCity(team.getTeamCity());
        team5.setKitColor(team.getKitColor());
        team5.setVenue(team.getVenue());
        team5.setGameTime(team.getGameTime());
        updateTeamData5(getTeams5());
        Team team6 = getTeam6(team.getId());
        team6.setId(team.getId());
        team6.setTeamName(team.getTeamName());
        team6.setTeamCity(team.getTeamCity());
        team6.setKitColor(team.getKitColor());
        team6.setVenue(team.getVenue());
        team6.setGameTime(team.getGameTime());
        updateTeamData6(getTeams6());
        Team team7 = getTeam7(team.getId());
        team7.setId(team.getId());
        team7.setTeamName(team.getTeamName());
        team7.setTeamCity(team.getTeamCity());
        team7.setKitColor(team.getKitColor());
        team7.setGameTime(team.getGameTime());
        team7.setVenue(team.getVenue());
        updateTeamData7(getTeams7());
        Team team8 = getTeam8(team.getId());
        team8.setId(team.getId());
        team8.setTeamName(team.getTeamName());
        team8.setTeamCity(team.getTeamCity());
        team8.setKitColor(team.getKitColor());
        team8.setVenue(team.getVenue());
        team8.setGameTime(team.getGameTime());
        updateTeamData8(getTeams8());
        Team team9 = getTeam9(team.getId());
        team9.setId(team.getId());
        team9.setTeamName(team.getTeamName());
        team9.setTeamCity(team.getTeamCity());
        team9.setKitColor(team.getKitColor());
        team9.setVenue(team.getVenue());
        team9.setGameTime(team.getGameTime());
        updateTeamData9(getTeams9());
    }

    public void deleteLastMDay() {
        int md = results5.size();
        for (int i = 1; i < 11; i++) {
            teams5.get(i).delMatchDay(md + "");
            teams6.get(i).delMatchDay(md + "");
            teams7.get(i).delMatchDay(md + "");
            teams8.get(i).delMatchDay(md + "");
            teams9.get(i).delMatchDay(md + "");
        }
        results5.remove(md);
        results6.remove(md);
        results7.remove(md);
        results8.remove(md);
        results9.remove(md);
    }

    public void updateTeamData5(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        teams5 = teamMap;
        teamLogos = new ArrayList<>(teamMap.values());
        leagueTable5 = new ArrayList<>(teams5.values());
        teamLinks5 = new ArrayList<>();
        teamLinks5.add(null);
        for (Team tab : leagueTable5) {
            teamLinks5.add(tab.getId(), tab);
        }
        Collections.sort(leagueTable5);
    }

    public void updateTeamData6(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        teams6 = teamMap;
        teamLogos = new ArrayList<>(teamMap.values());
        leagueTable6 = new ArrayList<>(teams6.values());
        teamLinks6 = new ArrayList<>();
        teamLinks6.add(null);
        for (Team tab : leagueTable6) {
            teamLinks6.add(tab.getId(), tab);
        }
        Collections.sort(leagueTable6);
    }

    public void updateTeamData7(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        teams7 = teamMap;
        teamLogos = new ArrayList<>(teamMap.values());
        leagueTable7 = new ArrayList<>(teams7.values());
        teamLinks7 = new ArrayList<>();
        teamLinks7.add(null);
        for (Team tab : leagueTable7) {
            teamLinks7.add(tab.getId(), tab);
        }
        Collections.sort(leagueTable7);
    }

    public void updateTeamData8(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        teams8 = teamMap;
        teamLogos = new ArrayList<>(teamMap.values());
        leagueTable8 = new ArrayList<>(teams8.values());
        teamLinks8 = new ArrayList<>();
        teamLinks8.add(null);
        for (Team tab : leagueTable8) {
            teamLinks8.add(tab.getId(), tab);
        }
        Collections.sort(leagueTable8);
    }

    public void updateTeamData9(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        teams9 = teamMap;
        teamLogos = new ArrayList<>(teamMap.values());
        leagueTable9 = new ArrayList<>(teams9.values());
        teamLinks9 = new ArrayList<>();
        teamLinks9.add(null);
        for (Team tab : leagueTable9) {
            teamLinks9.add(tab.getId(), tab);
        }
        Collections.sort(leagueTable9);
    }

    public void removeDummyTeam(List<Team> teams) {
        Team toRemove = null;
        for (Team t : teams) {
            if (t.getTeamName().equals("pauza")) {
                toRemove = t;
            }
        }
        teams.remove(toRemove);
    }

    public Map<Integer, List<MatchPair>> getPairs() {
        return matchDaypairs;
    }

    public void setPairs(Map<Integer, List<MatchPair>> pairs) {
        this.matchDaypairs = pairs;
    }

    public Map<Integer, String> getLeagueDates() {
        return leagueDates;
    }

    public void setLeagueDates(Map<Integer, String> leagueDates) {
        this.leagueDates = leagueDates;
    }

    public Map<Integer, List<MatchResult>> getResults5() {
        return results5;
    }

    public void setResults5(Map<Integer, List<MatchResult>> results) {
        this.results5 = results;
    }

    public Map<Integer, List<MatchResult>> getResults6() {
        return results6;
    }

    public void setResults6(Map<Integer, List<MatchResult>> results) {
        this.results6 = results;
    }

    public Map<Integer, List<MatchResult>> getResults7() {
        return results7;
    }

    public void setResults7(Map<Integer, List<MatchResult>> results) {
        this.results7 = results;
    }

    public Map<Integer, List<MatchResult>> getResults8() {
        return results8;
    }

    public void setResults8(Map<Integer, List<MatchResult>> results) {
        this.results8 = results;
    }

    public Map<Integer, List<MatchResult>> getResults9() {
        return results9;
    }

    public void setResults9(Map<Integer, List<MatchResult>> results) {
        this.results9 = results;
    }

    public List<Team> getLeagueTable5() {
        return leagueTable5;
    }

    public void setLeagueTable5(List<Team> teamListSorted) {
        this.leagueTable5 = teamListSorted;
    }

    public List<Team> getLeagueTable6() {
        return leagueTable6;
    }

    public void setLeagueTable6(List<Team> teamListSorted) {
        this.leagueTable6 = teamListSorted;
    }

    public List<Team> getLeagueTable7() {
        return leagueTable7;
    }

    public void setLeagueTable7(List<Team> teamListSorted) {
        this.leagueTable7 = teamListSorted;
    }

    public List<Team> getLeagueTable8() {
        return leagueTable8;
    }

    public void setLeagueTable8(List<Team> teamListSorted) {
        this.leagueTable8 = teamListSorted;
    }

    public List<Team> getLeagueTable9() {
        return leagueTable9;
    }

    public void setLeagueTable9(List<Team> teamListSorted) {
        this.leagueTable9 = teamListSorted;
    }

    public List<Team> getTeamLinks5() {
        return teamLinks5;
    }

    public void setTeamLinks5(List<Team> teamListIDindexed) {
        this.teamLinks5 = teamListIDindexed;
    }

    public List<Team> getTeamLinks6() {
        return teamLinks6;
    }

    public void setTeamLinks6(List<Team> teamListIDindexed) {
        this.teamLinks6 = teamListIDindexed;
    }

    public List<Team> getTeamLinks7() {
        return teamLinks7;
    }

    public void setTeamLinks7(List<Team> teamListIDindexed) {
        this.teamLinks7 = teamListIDindexed;
    }

    public List<Team> getTeamLinks8() {
        return teamLinks8;
    }

    public void setTeamLinks8(List<Team> teamListIDindexed) {
        this.teamLinks8 = teamListIDindexed;
    }

    public List<Team> getTeamLinks9() {
        return teamLinks9;
    }

    public void setTeamLinks9(List<Team> teamListIDindexed) {
        this.teamLinks9 = teamListIDindexed;
    }

    public Map<Integer, Team> getTeams5() {
        return teams5;
    }

    public void setTeams5(Map<Integer, Team> teamMap) {
        this.teams5 = teamMap;
    }

    public Team getTeam5(int index) {
        return teams5.get(index);
    }

    public Map<Integer, Team> getTeams6() {
        return teams6;
    }

    public void setTeams6(Map<Integer, Team> teamMap) {
        this.teams6 = teamMap;
    }

    public Team getTeam6(int index) {
        return teams6.get(index);
    }

    public Map<Integer, Team> getTeams7() {
        return teams7;
    }

    public void setTeams7(Map<Integer, Team> teamMap) {
        this.teams7 = teamMap;
    }

    public Team getTeam7(int index) {
        return teams7.get(index);
    }

    public Map<Integer, Team> getTeams8() {
        return teams8;
    }

    public void setTeams8(Map<Integer, Team> teamMap) {
        this.teams8 = teamMap;
    }

    public Team getTeam8(int index) {
        return teams8.get(index);
    }

    public Map<Integer, Team> getTeams9() {
        return teams9;
    }

    public void setTeams9(Map<Integer, Team> teamMap) {
        this.teams9 = teamMap;
    }

    public Team getTeam9(int index) {
        return teams9.get(index);
    }

    public Map<Integer, String> getGamePostponed() {
        return gamePostponed;
    }

    public void setGamePostponed(Map<Integer, String> gamePostponed) {
        this.gamePostponed = gamePostponed;
    }

    public Map<Integer, String> getNotPlaying() {
        return notPlaying;
    }

    public void setNotPlaying(Map<Integer, String> notPlaying) {
        this.notPlaying = notPlaying;
    }

    public List<Team> getTeamLogos() {
        return teamLogos;
    }

    public void setTeamLogos(List<Team> teamLogos) {
        this.teamLogos = teamLogos;
    }

}
