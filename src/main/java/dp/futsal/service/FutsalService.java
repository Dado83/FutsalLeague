package dp.futsal.service;

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
    private Map<Integer, String> gamePostponed5;
    private Map<Integer, String> gamePostponed6;
    private Map<Integer, String> gamePostponed7;
    private Map<Integer, String> gamePostponed8;
    private Map<Integer, String> gamePostponed9;
    private Map<Integer, String> notPlaying5;
    private Map<Integer, String> notPlaying6;
    private Map<Integer, String> notPlaying7;
    private Map<Integer, String> notPlaying8;
    private Map<Integer, String> notPlaying9;

    public void init() {
        LOGGER.info("init");
        this.fixture = new Fixture();
        this.fixture.loadFixturePairsFromJsonFile("C:\\Users\\Wade\\Desktop\\berger9-10.json");
        this.matchDaypairs = fixture.getPairs();

        this.results5 = this.fixture.loadFixtureResultsFromJsonFile("C:\\Users\\Wade\\Desktop\\results5.json");
        this.results6 = this.fixture.loadFixtureResultsFromJsonFile("C:\\Users\\Wade\\Desktop\\results6.json");
        this.results7 = this.fixture.loadFixtureResultsFromJsonFile("C:\\Users\\Wade\\Desktop\\results7.json");
        this.results8 = this.fixture.loadFixtureResultsFromJsonFile("C:\\Users\\Wade\\Desktop\\results8.json");
        this.results9 = this.fixture.loadFixtureResultsFromJsonFile("C:\\Users\\Wade\\Desktop\\results9.json");

        this.teamCollection = new TeamCollection();
        this.teams5 = this.teamCollection.loadTeamCollectionFromJson("C:\\Users\\Wade\\Desktop\\teams5.json");
        this.teams6 = this.teamCollection.loadTeamCollectionFromJson("C:\\Users\\Wade\\Desktop\\teams6.json");
        this.teams7 = this.teamCollection.loadTeamCollectionFromJson("C:\\Users\\Wade\\Desktop\\teams7.json");
        this.teams8 = this.teamCollection.loadTeamCollectionFromJson("C:\\Users\\Wade\\Desktop\\teams8.json");
        this.teams9 = this.teamCollection.loadTeamCollectionFromJson("C:\\Users\\Wade\\Desktop\\teams9.json");

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

        gamePostponed5 = new HashMap<>();
        gamePostponed6 = new HashMap<>();
        gamePostponed7 = new HashMap<>();
        gamePostponed8 = new HashMap<>();
        gamePostponed9 = new HashMap<>();

        notPlaying5 = new HashMap<>();
        notPlaying6 = new HashMap<>();
        notPlaying7 = new HashMap<>();
        notPlaying8 = new HashMap<>();
        notPlaying9 = new HashMap<>();
    }

    public void updateTeamData5(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        this.teams5 = teamMap;
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
        this.leagueTable9 = new ArrayList<>(this.teams9.values());
        this.teamLinks9 = new ArrayList<>();
        this.teamLinks9.add(null);
        for (Team tab : this.leagueTable9) {
            teamLinks9.add(tab.getId(), tab);
        }
        Collections.sort(this.leagueTable9);
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

    public Map<Integer, String> getGamePostponed5() {
        return gamePostponed5;
    }

    public void setGamePostponed5(Map<Integer, String> gamePostponed) {
        this.gamePostponed5 = gamePostponed;
    }

    public Map<Integer, String> getGamePostponed6() {
        return gamePostponed6;
    }

    public void setGamePostponed6(Map<Integer, String> gamePostponed) {
        this.gamePostponed6 = gamePostponed;
    }

    public Map<Integer, String> getGamePostponed7() {
        return gamePostponed7;
    }

    public void setGamePostponed7(Map<Integer, String> gamePostponed) {
        this.gamePostponed7 = gamePostponed;
    }

    public Map<Integer, String> getGamePostponed8() {
        return gamePostponed8;
    }

    public void setGamePostponed8(Map<Integer, String> gamePostponed) {
        this.gamePostponed8 = gamePostponed;
    }

    public Map<Integer, String> getGamePostponed9() {
        return gamePostponed9;
    }

    public void setGamePostponed9(Map<Integer, String> gamePostponed) {
        this.gamePostponed9 = gamePostponed;
    }

    public Map<Integer, String> getNotPlaying5() {
        return notPlaying5;
    }

    public void setNotPlaying5(Map<Integer, String> notPlaying) {
        this.notPlaying5 = notPlaying;
    }

    public Map<Integer, String> getNotPlaying6() {
        return notPlaying6;
    }

    public void setNotPlaying6(Map<Integer, String> notPlaying) {
        this.notPlaying6 = notPlaying;
    }

    public Map<Integer, String> getNotPlaying7() {
        return notPlaying7;
    }

    public void setNotPlaying7(Map<Integer, String> notPlaying) {
        this.notPlaying7 = notPlaying;
    }

    public Map<Integer, String> getNotPlaying8() {
        return notPlaying8;
    }

    public void setNotPlaying8(Map<Integer, String> notPlaying) {
        this.notPlaying8 = notPlaying;
    }

    public Map<Integer, String> getNotPlaying9() {
        return notPlaying9;
    }

    public void setNotPlaying9(Map<Integer, String> notPlaying) {
        this.notPlaying9 = notPlaying;
    }

    public List<Team> getTeamLogos() {
        return teamLogos;
    }

    public void setTeamLogos(List<Team> teamLogos) {
        this.teamLogos = teamLogos;
    }

}
