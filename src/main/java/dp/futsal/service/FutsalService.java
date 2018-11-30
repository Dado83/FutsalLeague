package dp.futsal.service;

import dp.futsal.database.DatabaseService;
import dp.futsal.database.Json;
import dp.futsal.form.TeamForm;
import dp.futsal.ftp.FTP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FutsalService {

    private static final Logger LOGGER = Logger.getLogger(FutsalService.class.getName());
    @Autowired
    private FTP ftpClient;
    @Autowired
    private Fixture fixture;
    @Autowired
    private TeamCollection teamCollection;
    @Autowired
    private DatabaseService databaseService;
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
    private Map<Integer, String> notPlaying9;

    public FutsalService() {

    }

    public void init() {
        LOGGER.info("init");

        matchDaypairs = fixture.loadFixturesFromJson(databaseService.findJson("berger9-10"));
        leagueDates = fixture.loadDatesFromJson(databaseService.findJson("leagueDates"));
        gamePostponed = fixture.loadGameNotPlayedFromJson(databaseService.findJson("gamePostponed"));
        notPlaying = fixture.loadGameNotPlayedFromJson(databaseService.findJson("notPlaying"));
        notPlaying9 = fixture.loadGameNotPlayedFromJson(databaseService.findJson("notPlaying9"));

        results5 = fixture.loadResultsFromJson(databaseService.findJson("results5"));
        results6 = fixture.loadResultsFromJson(databaseService.findJson("results6"));
        results7 = fixture.loadResultsFromJson(databaseService.findJson("results7"));
        results8 = fixture.loadResultsFromJson(databaseService.findJson("results8"));
        results9 = fixture.loadResultsFromJson(databaseService.findJson("results9"));

        teams5 = teamCollection.loadTeamsFromJson(databaseService.findJson("teams5"));
        teams6 = teamCollection.loadTeamsFromJson(databaseService.findJson("teams6"));
        teams7 = teamCollection.loadTeamsFromJson(databaseService.findJson("teams7"));
        teams8 = teamCollection.loadTeamsFromJson(databaseService.findJson("teams8"));
        teams9 = teamCollection.loadTeamsFromJson(databaseService.findJson("teams9"));

        teamLogos = new ArrayList<>(teams5.values());

        leagueTable5 = new ArrayList<>(teams5.values());
        teamLinks5 = new ArrayList<>();
        teamLinks5.add(null);
        for (Team tab : leagueTable5) {
            teamLinks5.add(tab.getId(), tab);
        }
        removeDummyTeam(getLeagueTable5());
        Collections.sort(leagueTable5);

        leagueTable6 = new ArrayList<>(teams6.values());
        teamLinks6 = new ArrayList<>();
        teamLinks6.add(null);
        for (Team tab : leagueTable6) {
            teamLinks6.add(tab.getId(), tab);
        }
        removeDummyTeam(getLeagueTable6());
        Collections.sort(leagueTable6);

        leagueTable7 = new ArrayList<>(teams7.values());
        teamLinks7 = new ArrayList<>();
        teamLinks7.add(null);
        for (Team tab : leagueTable7) {
            teamLinks7.add(tab.getId(), tab);
        }
        removeDummyTeam(getLeagueTable7());
        Collections.sort(leagueTable7);

        leagueTable8 = new ArrayList<>(teams8.values());
        teamLinks8 = new ArrayList<>();
        teamLinks8.add(null);
        for (Team tab : leagueTable8) {
            teamLinks8.add(tab.getId(), tab);
        }
        removeDummyTeam(getLeagueTable8());
        Collections.sort(leagueTable8);

        leagueTable9 = new ArrayList<>(teams9.values());
        teamLinks9 = new ArrayList<>();
        teamLinks9.add(null);
        for (Team tab : leagueTable9) {
            teamLinks9.add(tab.getId(), tab);
        }
        removeDummyTeam(getLeagueTable9());
        Collections.sort(leagueTable9);
    }

    public void saveDataToDatabase() {
        databaseService.saveJson(new Json("berger9-10", fixture.saveFixturesToJson(matchDaypairs)));
        databaseService.saveJson(new Json("leagueDates", fixture.saveLeagueDatesToJson(leagueDates)));

        databaseService.saveJson(new Json("gamePostponed", fixture.saveGameNotPlayedToJson(gamePostponed)));
        databaseService.saveJson(new Json("notPlaying", fixture.saveGameNotPlayedToJson(notPlaying)));
        databaseService.saveJson(new Json("notPlaying9", fixture.saveGameNotPlayedToJson(notPlaying9)));

        databaseService.saveJson(new Json("results5", fixture.saveResultsToJson(results5)));
        databaseService.saveJson(new Json("results6", fixture.saveResultsToJson(results6)));
        databaseService.saveJson(new Json("results7", fixture.saveResultsToJson(results7)));
        databaseService.saveJson(new Json("results8", fixture.saveResultsToJson(results8)));
        databaseService.saveJson(new Json("results9", fixture.saveResultsToJson(results9)));

        databaseService.saveJson(new Json("teams5", teamCollection.saveTeamsToJson(teams5)));
        databaseService.saveJson(new Json("teams6", teamCollection.saveTeamsToJson(teams6)));
        databaseService.saveJson(new Json("teams7", teamCollection.saveTeamsToJson(teams7)));
        databaseService.saveJson(new Json("teams8", teamCollection.saveTeamsToJson(teams8)));
        databaseService.saveJson(new Json("teams9", teamCollection.saveTeamsToJson(teams9)));
    }

    public void saveFutsalData() {
        String appDataLocalDir = "D:/Fair Play/Zimska liga 2018-2019/app data/";
        String appDataLocalDirGit = "E:/Java/JsonLiga/";
        String appDataServerDir = "public_html/futsal/";

        fixture.saveResultsToJson(appDataLocalDir + "results5.json", results5);
        fixture.saveResultsToJson(appDataLocalDir + "results6.json", results6);
        fixture.saveResultsToJson(appDataLocalDir + "results7.json", results7);
        fixture.saveResultsToJson(appDataLocalDir + "results8.json", results8);
        fixture.saveResultsToJson(appDataLocalDir + "results9.json", results9);
        fixture.saveGameNotPlayedToJson(appDataLocalDir + "gamePostponed.json", gamePostponed);
        fixture.saveGameNotPlayedToJson(appDataLocalDir + "notPlaying.json", notPlaying);
        fixture.saveGameNotPlayedToJson(appDataLocalDir + "notPlaying9.json", notPlaying9);
        fixture.saveResultsToJson(appDataLocalDirGit + "results5.json", results5);
        fixture.saveResultsToJson(appDataLocalDirGit + "results6.json", results6);
        fixture.saveResultsToJson(appDataLocalDirGit + "results7.json", results7);
        fixture.saveResultsToJson(appDataLocalDirGit + "results8.json", results8);
        fixture.saveResultsToJson(appDataLocalDirGit + "results9.json", results9);
        fixture.saveGameNotPlayedToJson(appDataLocalDirGit + "gamePostponed.json", gamePostponed);
        fixture.saveGameNotPlayedToJson(appDataLocalDirGit + "notPlaying.json", notPlaying);
        fixture.saveGameNotPlayedToJson(appDataLocalDirGit + "notPlaying9.json", notPlaying9);
        ftpClient.uploadFile(appDataServerDir + "results5.json", appDataLocalDir + "results5.json");
        ftpClient.uploadFile(appDataServerDir + "results6.json", appDataLocalDir + "results6.json");
        ftpClient.uploadFile(appDataServerDir + "results7.json", appDataLocalDir + "results7.json");
        ftpClient.uploadFile(appDataServerDir + "results8.json", appDataLocalDir + "results8.json");
        ftpClient.uploadFile(appDataServerDir + "results9.json", appDataLocalDir + "results9.json");
        ftpClient.uploadFile(appDataServerDir + "gamePostponed.json", appDataLocalDir + "gamePostponed.json");
        ftpClient.uploadFile(appDataServerDir + "notPlaying.json", appDataLocalDir + "notPlaying.json");
        ftpClient.uploadFile(appDataServerDir + "notPlaying9.json", appDataLocalDir + "notPlaying9.json");

        teamCollection.saveTeamsToJson(appDataLocalDir + "teams5.json", teams5);
        teamCollection.saveTeamsToJson(appDataLocalDir + "teams6.json", teams6);
        teamCollection.saveTeamsToJson(appDataLocalDir + "teams7.json", teams7);
        teamCollection.saveTeamsToJson(appDataLocalDir + "teams8.json", teams8);
        teamCollection.saveTeamsToJson(appDataLocalDir + "teams9.json", teams9);
        teamCollection.saveTeamsToJson(appDataLocalDirGit + "teams5.json", teams5);
        teamCollection.saveTeamsToJson(appDataLocalDirGit + "teams6.json", teams6);
        teamCollection.saveTeamsToJson(appDataLocalDirGit + "teams7.json", teams7);
        teamCollection.saveTeamsToJson(appDataLocalDirGit + "teams8.json", teams8);
        teamCollection.saveTeamsToJson(appDataLocalDirGit + "teams9.json", teams9);
        ftpClient.uploadFile(appDataServerDir + "teams5.json", appDataLocalDir + "teams5.json");
        ftpClient.uploadFile(appDataServerDir + "teams6.json", appDataLocalDir + "teams6.json");
        ftpClient.uploadFile(appDataServerDir + "teams7.json", appDataLocalDir + "teams7.json");
        ftpClient.uploadFile(appDataServerDir + "teams8.json", appDataLocalDir + "teams8.json");
        ftpClient.uploadFile(appDataServerDir + "teams9.json", appDataLocalDir + "teams9.json");
    }

    public void updateTeam(TeamForm team) {
        Team t5 = getTeam5(team.getId());
        Team t6 = getTeam6(team.getId());
        Team t7 = getTeam7(team.getId());
        Team t8 = getTeam8(team.getId());
        Team t9 = getTeam9(team.getId());

        Team[] teams = {t5, t6, t7, t8, t9};
        for (Team t : teams) {
            if (t.getTeamName().equals("pauza") || t.getTeamName().equals("pauza9")) {
                LOGGER.info("nisam dirao pauza9 tim");
            } else {
                t.setId(team.getId());
                t.setTeamName(team.getTeamName());
                t.setTeamCity(team.getTeamCity());
                t.setKitColor(team.getKitColor());
                t.setVenue(team.getVenue());
                t.setGameTime(team.getGameTime());
            }
        }
        updateTeamData5(getTeams5());
        updateTeamData6(getTeams6());
        updateTeamData7(getTeams7());
        updateTeamData8(getTeams8());
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
        removeDummyTeam(getLeagueTable5());
        Collections.sort(leagueTable5);
    }

    public void updateTeamData6(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        teams6 = teamMap;
        leagueTable6 = new ArrayList<>(teams6.values());
        teamLinks6 = new ArrayList<>();
        teamLinks6.add(null);
        for (Team tab : leagueTable6) {
            teamLinks6.add(tab.getId(), tab);
        }
        removeDummyTeam(getLeagueTable6());
        Collections.sort(leagueTable6);
    }

    public void updateTeamData7(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        teams7 = teamMap;
        leagueTable7 = new ArrayList<>(teams7.values());
        teamLinks7 = new ArrayList<>();
        teamLinks7.add(null);
        for (Team tab : leagueTable7) {
            teamLinks7.add(tab.getId(), tab);
        }
        removeDummyTeam(getLeagueTable7());
        Collections.sort(leagueTable7);
    }

    public void updateTeamData8(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        teams8 = teamMap;
        leagueTable8 = new ArrayList<>(teams8.values());
        teamLinks8 = new ArrayList<>();
        teamLinks8.add(null);
        for (Team tab : leagueTable8) {
            teamLinks8.add(tab.getId(), tab);
        }
        removeDummyTeam(getLeagueTable8());
        Collections.sort(leagueTable8);
    }

    public void updateTeamData9(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        teams9 = teamMap;
        leagueTable9 = new ArrayList<>(teams9.values());
        teamLinks9 = new ArrayList<>();
        teamLinks9.add(null);
        for (Team tab : leagueTable9) {
            teamLinks9.add(tab.getId(), tab);
        }
        removeDummyTeam(getLeagueTable9());
        Collections.sort(leagueTable9);
    }

    public void removeDummyTeam(List<Team> teams) {
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getTeamName().equals("pauza")) {
                teams.remove(i);
            }
        }
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getTeamName().equals("pauza9")) {
                teams.remove(i);
            }
        }
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

    public Map<Integer, String> getNotPlaying9() {
        return notPlaying9;
    }

    public void setNotPlaying9(Map<Integer, String> notPlaying9) {
        this.notPlaying9 = notPlaying9;
    }

    public List<Team> getTeamLogos() {
        return teamLogos;
    }

    public void setTeamLogos(List<Team> teamLogos) {
        this.teamLogos = teamLogos;
    }

}
