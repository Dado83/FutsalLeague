package dp.futsal.service;

import dp.futsal.ftp.FTP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;


@Service
public class FutsalServiceB {

    private static final Logger LOGGER = Logger.getLogger(FutsalServiceB.class.getName());
    private FTP ftpClient;
    private Fixture fixture;
    private TeamCollection teamCollection;
    private Map<Integer, List<MatchPair>> matchDaypairs;
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

    public void init() {
        LOGGER.info("init");
        ftpClient = new FTP();
        this.fixture = new Fixture();
        this.fixture.loadFixturesFromJson("http://fairplay.hol.es/futsal/berger4.json");
        this.matchDaypairs = fixture.getPairs();

        this.results5 = this.fixture.loadResultsFromJson("http://fairplay.hol.es/futsal/results5b.json");
        this.results6 = this.fixture.loadResultsFromJson("http://fairplay.hol.es/futsal/results6b.json");
        this.results7 = this.fixture.loadResultsFromJson("http://fairplay.hol.es/futsal/results7b.json");
        this.results8 = this.fixture.loadResultsFromJson("http://fairplay.hol.es/futsal/results8b.json");
        this.results9 = this.fixture.loadResultsFromJson("http://fairplay.hol.es/futsal/results9b.json");

        this.teamCollection = new TeamCollection();
        this.teams5 = this.teamCollection.loadTeamsFromJson("http://fairplay.hol.es/futsal/teams5b.json");
        this.teams6 = this.teamCollection.loadTeamsFromJson("http://fairplay.hol.es/futsal/teams6b.json");
        this.teams7 = this.teamCollection.loadTeamsFromJson("http://fairplay.hol.es/futsal/teams7b.json");
        this.teams8 = this.teamCollection.loadTeamsFromJson("http://fairplay.hol.es/futsal/teams8b.json");
        this.teams9 = this.teamCollection.loadTeamsFromJson("http://fairplay.hol.es/futsal/teams9b.json");

        this.teamLogos = new ArrayList<>(teams5.values());
        this.leagueTable5 = new ArrayList<>(teams5.values());
        this.teamLinks5 = new ArrayList<>();
        this.teamLinks5.add(null);
        for (Team tab : this.leagueTable5) {
            this.teamLinks5.add(tab.getId(), tab);
        }
        Collections.sort(this.leagueTable5);

        this.leagueTable6 = new ArrayList<>(teams6.values());
        this.teamLinks6 = new ArrayList<>();
        this.teamLinks6.add(null);
        for (Team tab : this.leagueTable6) {
            this.teamLinks6.add(tab.getId(), tab);
        }
        Collections.sort(this.leagueTable6);

        this.leagueTable7 = new ArrayList<>(teams7.values());
        this.teamLinks7 = new ArrayList<>();
        this.teamLinks7.add(null);
        for (Team tab : this.leagueTable7) {
            this.teamLinks7.add(tab.getId(), tab);
        }
        Collections.sort(this.leagueTable7);

        this.leagueTable8 = new ArrayList<>(teams8.values());
        this.teamLinks8 = new ArrayList<>();
        this.teamLinks8.add(null);
        for (Team tab : this.leagueTable8) {
            this.teamLinks8.add(tab.getId(), tab);
        }
        Collections.sort(this.leagueTable8);

        this.leagueTable9 = new ArrayList<>(teams9.values());
        this.teamLinks9 = new ArrayList<>();
        this.teamLinks9.add(null);
        for (Team tab : this.leagueTable9) {
            this.teamLinks9.add(tab.getId(), tab);
        }
        Collections.sort(this.leagueTable9);

        gamePostponed = new HashMap<>();
    }

    public void saveFutsalData() {
        fixture.saveResultsToJson("D:/fer plej/Zimska liga 2018-2019/app data/results5b.json", results5);
        fixture.saveResultsToJson("D:/fer plej/Zimska liga 2018-2019/app data/results6b.json", results6);
        fixture.saveResultsToJson("D:/fer plej/Zimska liga 2018-2019/app data/results7b.json", results7);
        fixture.saveResultsToJson("D:/fer plej/Zimska liga 2018-2019/app data/results8b.json", results8);
        fixture.saveResultsToJson("D:/fer plej/Zimska liga 2018-2019/app data/results9b.json", results9);
        ftpClient.uploadFile("futsal/results5b.json", "D:/fer plej/Zimska liga 2018-2019/app data/results5b.json");
        ftpClient.uploadFile("futsal/results6b.json", "D:/fer plej/Zimska liga 2018-2019/app data/results6b.json");
        ftpClient.uploadFile("futsal/results7b.json", "D:/fer plej/Zimska liga 2018-2019/app data/results7b.json");
        ftpClient.uploadFile("futsal/results8b.json", "D:/fer plej/Zimska liga 2018-2019/app data/results8b.json");
        ftpClient.uploadFile("futsal/results9b.json", "D:/fer plej/Zimska liga 2018-2019/app data/results9b.json");

        teamCollection.saveTeamsToJson("D:/fer plej/Zimska liga 2018-2019/app data/teams5b.json", teams5);
        teamCollection.saveTeamsToJson("D:/fer plej/Zimska liga 2018-2019/app data/teams6b.json", teams6);
        teamCollection.saveTeamsToJson("D:/fer plej/Zimska liga 2018-2019/app data/teams7b.json", teams7);
        teamCollection.saveTeamsToJson("D:/fer plej/Zimska liga 2018-2019/app data/teams8b.json", teams8);
        teamCollection.saveTeamsToJson("D:/fer plej/Zimska liga 2018-2019/app data/teams9b.json", teams9);
        ftpClient.uploadFile("futsal/teams5b.json", "D:/fer plej/Zimska liga 2018-2019/app data/teams5b.json");
        ftpClient.uploadFile("futsal/teams6b.json", "D:/fer plej/Zimska liga 2018-2019/app data/teams6b.json");
        ftpClient.uploadFile("futsal/teams7b.json", "D:/fer plej/Zimska liga 2018-2019/app data/teams7b.json");
        ftpClient.uploadFile("futsal/teams8b.json", "D:/fer plej/Zimska liga 2018-2019/app data/teams8b.json");
        ftpClient.uploadFile("futsal/teams9b.json", "D:/fer plej/Zimska liga 2018-2019/app data/teams9b.json");
    }

    public void updateTeam(TeamForm team) {
        Team team5 = getTeam5(team.getId());
        team5.setId(team.getId());
        team5.setTeamName(team.getTeamName());
        team5.setTeamCity(team.getTeamCity());
        team5.setKitColor(team.getKitColor());
        team5.setVenue(team.getVenue());
        updateTeamData5(getTeams5());
        Team team6 = getTeam6(team.getId());
        team6.setId(team.getId());
        team6.setTeamName(team.getTeamName());
        team6.setTeamCity(team.getTeamCity());
        team6.setKitColor(team.getKitColor());
        team6.setVenue(team.getVenue());
        updateTeamData6(getTeams6());
        Team team7 = getTeam7(team.getId());
        team7.setId(team.getId());
        team7.setTeamName(team.getTeamName());
        team7.setTeamCity(team.getTeamCity());
        team7.setKitColor(team.getKitColor());
        team7.setVenue(team.getVenue());
        updateTeamData7(getTeams7());
        Team team8 = getTeam8(team.getId());
        team8.setId(team.getId());
        team8.setTeamName(team.getTeamName());
        team8.setTeamCity(team.getTeamCity());
        team8.setKitColor(team.getKitColor());
        team8.setVenue(team.getVenue());
        updateTeamData8(getTeams8());
        Team team9 = getTeam9(team.getId());
        team9.setId(team.getId());
        team9.setTeamName(team.getTeamName());
        team9.setTeamCity(team.getTeamCity());
        team9.setKitColor(team.getKitColor());
        team9.setVenue(team.getVenue());
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
        this.teams5 = teamMap;
        this.teamLogos = new ArrayList<>(teamMap.values());
        this.leagueTable5 = new ArrayList<>(this.teams5.values());
        this.teamLinks5 = new ArrayList<>();
        this.teamLinks5.add(null);
        for (Team tab : this.leagueTable5) {
            teamLinks5.add(tab.getId(), tab);
        }
        Collections.sort(this.leagueTable5);
    }

    public void updateTeamData6(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        this.teams6 = teamMap;
        this.teamLogos = new ArrayList<>(teamMap.values());
        this.leagueTable6 = new ArrayList<>(this.teams6.values());
        this.teamLinks6 = new ArrayList<>();
        this.teamLinks6.add(null);
        for (Team tab : this.leagueTable6) {
            teamLinks6.add(tab.getId(), tab);
        }
        Collections.sort(this.leagueTable6);
    }

    public void updateTeamData7(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        this.teams7 = teamMap;
        this.teamLogos = new ArrayList<>(teamMap.values());
        this.leagueTable7 = new ArrayList<>(this.teams7.values());
        this.teamLinks7 = new ArrayList<>();
        this.teamLinks7.add(null);
        for (Team tab : this.leagueTable7) {
            teamLinks7.add(tab.getId(), tab);
        }
        Collections.sort(this.leagueTable7);
    }

    public void updateTeamData8(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        this.teams8 = teamMap;
        this.teamLogos = new ArrayList<>(teamMap.values());
        this.leagueTable8 = new ArrayList<>(this.teams8.values());
        this.teamLinks8 = new ArrayList<>();
        this.teamLinks8.add(null);
        for (Team tab : this.leagueTable8) {
            teamLinks8.add(tab.getId(), tab);
        }
        Collections.sort(this.leagueTable8);
    }

    public void updateTeamData9(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        this.teams9 = teamMap;
        this.teamLogos = new ArrayList<>(teamMap.values());
        this.leagueTable9 = new ArrayList<>(this.teams9.values());
        this.teamLinks9 = new ArrayList<>();
        this.teamLinks9.add(null);
        for (Team tab : this.leagueTable9) {
            teamLinks9.add(tab.getId(), tab);
        }
        Collections.sort(this.leagueTable9);
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
        return this.teams5.get(index);
    }

    public Map<Integer, Team> getTeams6() {
        return teams6;
    }

    public void setTeams6(Map<Integer, Team> teamMap) {
        this.teams6 = teamMap;
    }

    public Team getTeam6(int index) {
        return this.teams6.get(index);
    }

    public Map<Integer, Team> getTeams7() {
        return teams7;
    }

    public void setTeams7(Map<Integer, Team> teamMap) {
        this.teams7 = teamMap;
    }

    public Team getTeam7(int index) {
        return this.teams7.get(index);
    }

    public Map<Integer, Team> getTeams8() {
        return teams8;
    }

    public void setTeams8(Map<Integer, Team> teamMap) {
        this.teams8 = teamMap;
    }

    public Team getTeam8(int index) {
        return this.teams8.get(index);
    }

    public Map<Integer, Team> getTeams9() {
        return teams9;
    }

    public void setTeams9(Map<Integer, Team> teamMap) {
        this.teams9 = teamMap;
    }

    public Team getTeam9(int index) {
        return this.teams9.get(index);
    }

    public Map<Integer, String> getGamePostponed() {
        return gamePostponed;
    }

    public void setGamePostponed(Map<Integer, String> gamePostponed) {
        this.gamePostponed = gamePostponed;
    }

    public List<Team> getTeamLogos() {
        return teamLogos;
    }

    public void setTeamLogos(List<Team> teamLogos) {
        this.teamLogos = teamLogos;
    }

}
