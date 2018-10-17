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
    private Map<Integer, List<MatchPair>> pairsMap;
    private Map<Integer, List<MatchResult>> resultsMap5;
    private Map<Integer, List<MatchResult>> resultsMap6;
    private Map<Integer, List<MatchResult>> resultsMap7;
    private Map<Integer, List<MatchResult>> resultsMap8;
    private Map<Integer, List<MatchResult>> resultsMap9;
    private Map<Integer, Team> teamMap5;
    private Map<Integer, Team> teamMap6;
    private Map<Integer, Team> teamMap7;
    private Map<Integer, Team> teamMap8;
    private Map<Integer, Team> teamMap9;
    private List<Team> teamListSorted5;
    private List<Team> teamListSorted6;
    private List<Team> teamListSorted7;
    private List<Team> teamListSorted8;
    private List<Team> teamListSorted9;
    private List<Team> teamListIDindexed5;
    private List<Team> teamListIDindexed6;
    private List<Team> teamListIDindexed7;
    private List<Team> teamListIDindexed8;
    private List<Team> teamListIDindexed9;
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
        this.pairsMap = fixture.getPairs();

        this.resultsMap5 = this.fixture.loadFixtureResultsFromJsonFile("C:\\Users\\Wade\\Desktop\\results5.json");
        this.resultsMap6 = this.fixture.loadFixtureResultsFromJsonFile("C:\\Users\\Wade\\Desktop\\results6.json");
        this.resultsMap7 = this.fixture.loadFixtureResultsFromJsonFile("C:\\Users\\Wade\\Desktop\\results7.json");
        this.resultsMap8 = this.fixture.loadFixtureResultsFromJsonFile("C:\\Users\\Wade\\Desktop\\results8.json");
        this.resultsMap9 = this.fixture.loadFixtureResultsFromJsonFile("C:\\Users\\Wade\\Desktop\\results9.json");

        this.teamCollection = new TeamCollection();
        this.teamMap5 = this.teamCollection.loadTeamCollectionFromJson("C:\\Users\\Wade\\Desktop\\teams5.json");
        this.teamMap6 = this.teamCollection.loadTeamCollectionFromJson("C:\\Users\\Wade\\Desktop\\teams6.json");
        this.teamMap7 = this.teamCollection.loadTeamCollectionFromJson("C:\\Users\\Wade\\Desktop\\teams7.json");
        this.teamMap8 = this.teamCollection.loadTeamCollectionFromJson("C:\\Users\\Wade\\Desktop\\teams8.json");
        this.teamMap9 = this.teamCollection.loadTeamCollectionFromJson("C:\\Users\\Wade\\Desktop\\teams9.json");

        this.teamListSorted5 = new ArrayList<>(teamMap5.values());
        this.teamListIDindexed5 = new ArrayList<>();
        this.teamListIDindexed5.add(null);
        for (Team tab : this.teamListSorted5) {
            this.teamListIDindexed5.add(tab.getId(), tab);
        }
        Collections.sort(this.teamListSorted5);

        this.teamListSorted6 = new ArrayList<>(teamMap6.values());
        this.teamListIDindexed6 = new ArrayList<>();
        this.teamListIDindexed6.add(null);
        for (Team tab : this.teamListSorted6) {
            this.teamListIDindexed6.add(tab.getId(), tab);
        }
        Collections.sort(this.teamListSorted6);

        this.teamListSorted7 = new ArrayList<>(teamMap7.values());
        this.teamListIDindexed7 = new ArrayList<>();
        this.teamListIDindexed7.add(null);
        for (Team tab : this.teamListSorted7) {
            this.teamListIDindexed7.add(tab.getId(), tab);
        }
        Collections.sort(this.teamListSorted7);

        this.teamListSorted8 = new ArrayList<>(teamMap8.values());
        this.teamListIDindexed8 = new ArrayList<>();
        this.teamListIDindexed8.add(null);
        for (Team tab : this.teamListSorted8) {
            this.teamListIDindexed8.add(tab.getId(), tab);
        }
        Collections.sort(this.teamListSorted8);

        this.teamListSorted9 = new ArrayList<>(teamMap9.values());
        this.teamListIDindexed9 = new ArrayList<>();
        this.teamListIDindexed9.add(null);
        for (Team tab : this.teamListSorted9) {
            this.teamListIDindexed9.add(tab.getId(), tab);
        }
        Collections.sort(this.teamListSorted9);

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
        this.teamMap5 = teamMap;
        this.teamListSorted5 = new ArrayList<>(this.teamMap5.values());
        this.teamListIDindexed5 = new ArrayList<>();
        this.teamListIDindexed5.add(null);
        for (Team tab : this.teamListSorted5) {
            teamListIDindexed5.add(tab.getId(), tab);
        }
        Collections.sort(this.teamListSorted5);
    }

    public void updateTeamData6(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        this.teamMap6 = teamMap;
        this.teamListSorted6 = new ArrayList<>(this.teamMap6.values());
        this.teamListIDindexed6 = new ArrayList<>();
        this.teamListIDindexed6.add(null);
        for (Team tab : this.teamListSorted6) {
            teamListIDindexed6.add(tab.getId(), tab);
        }
        Collections.sort(this.teamListSorted6);
    }

    public void updateTeamData7(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        this.teamMap7 = teamMap;
        this.teamListSorted7 = new ArrayList<>(this.teamMap7.values());
        this.teamListIDindexed7 = new ArrayList<>();
        this.teamListIDindexed7.add(null);
        for (Team tab : this.teamListSorted7) {
            teamListIDindexed7.add(tab.getId(), tab);
        }
        Collections.sort(this.teamListSorted7);
    }

    public void updateTeamData8(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        this.teamMap8 = teamMap;
        this.teamListSorted8 = new ArrayList<>(this.teamMap8.values());
        this.teamListIDindexed8 = new ArrayList<>();
        this.teamListIDindexed8.add(null);
        for (Team tab : this.teamListSorted8) {
            teamListIDindexed8.add(tab.getId(), tab);
        }
        Collections.sort(this.teamListSorted8);
    }

    public void updateTeamData9(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        this.teamMap9 = teamMap;
        this.teamListSorted9 = new ArrayList<>(this.teamMap9.values());
        this.teamListIDindexed9 = new ArrayList<>();
        this.teamListIDindexed9.add(null);
        for (Team tab : this.teamListSorted9) {
            teamListIDindexed9.add(tab.getId(), tab);
        }
        Collections.sort(this.teamListSorted9);
    }

    public Map<Integer, List<MatchPair>> getPairs() {
        return pairsMap;
    }

    public void setPairs(Map<Integer, List<MatchPair>> pairs) {
        this.pairsMap = pairs;
    }

    public Map<Integer, List<MatchResult>> getResults5() {
        return resultsMap5;
    }

    public void setResults5(Map<Integer, List<MatchResult>> results) {
        this.resultsMap5 = results;
    }

    public Map<Integer, List<MatchResult>> getResults6() {
        return resultsMap6;
    }

    public void setResults6(Map<Integer, List<MatchResult>> results) {
        this.resultsMap6 = results;
    }

    public Map<Integer, List<MatchResult>> getResults7() {
        return resultsMap7;
    }

    public void setResults7(Map<Integer, List<MatchResult>> results) {
        this.resultsMap7 = results;
    }

    public Map<Integer, List<MatchResult>> getResults8() {
        return resultsMap8;
    }

    public void setResults8(Map<Integer, List<MatchResult>> results) {
        this.resultsMap8 = results;
    }

    public Map<Integer, List<MatchResult>> getResults9() {
        return resultsMap9;
    }

    public void setResults9(Map<Integer, List<MatchResult>> results) {
        this.resultsMap9 = results;
    }

    public List<Team> getTeamListSorted5() {
        return teamListSorted5;
    }

    public void setTeamListSorted5(List<Team> teamListSorted) {
        this.teamListSorted5 = teamListSorted;
    }

    public List<Team> getTeamListSorted6() {
        return teamListSorted6;
    }

    public void setTeamListSorted6(List<Team> teamListSorted) {
        this.teamListSorted6 = teamListSorted;
    }

    public List<Team> getTeamListSorted7() {
        return teamListSorted7;
    }

    public void setTeamListSorted7(List<Team> teamListSorted) {
        this.teamListSorted7 = teamListSorted;
    }

    public List<Team> getTeamListSorted8() {
        return teamListSorted8;
    }

    public void setTeamListSorted8(List<Team> teamListSorted) {
        this.teamListSorted8 = teamListSorted;
    }

    public List<Team> getTeamListSorted9() {
        return teamListSorted9;
    }

    public void setTeamListSorted9(List<Team> teamListSorted) {
        this.teamListSorted9 = teamListSorted;
    }

    public List<Team> getTeamListIDindexed5() {
        return teamListIDindexed5;
    }

    public void setTeamListIDindexed5(List<Team> teamListIDindexed) {
        this.teamListIDindexed5 = teamListIDindexed;
    }

    public List<Team> getTeamListIDindexed6() {
        return teamListIDindexed6;
    }

    public void setTeamListIDindexed6(List<Team> teamListIDindexed) {
        this.teamListIDindexed6 = teamListIDindexed;
    }

    public List<Team> getTeamListIDindexed7() {
        return teamListIDindexed7;
    }

    public void setTeamListIDindexed7(List<Team> teamListIDindexed) {
        this.teamListIDindexed7 = teamListIDindexed;
    }

    public List<Team> getTeamListIDindexed8() {
        return teamListIDindexed8;
    }

    public void setTeamListIDindexed8(List<Team> teamListIDindexed) {
        this.teamListIDindexed8 = teamListIDindexed;
    }

    public List<Team> getTeamListIDindexed9() {
        return teamListIDindexed9;
    }

    public void setTeamListIDindexed9(List<Team> teamListIDindexed) {
        this.teamListIDindexed9 = teamListIDindexed;
    }

    public Map<Integer, Team> getTeamMap5() {
        return teamMap5;
    }

    public void setTeamMap5(Map<Integer, Team> teamMap) {
        this.teamMap5 = teamMap;
    }

    public Team getTeam5(int index) {
        return this.teamMap5.get(index);
    }

    public Map<Integer, Team> getTeamMap6() {
        return teamMap6;
    }

    public void setTeamMap6(Map<Integer, Team> teamMap) {
        this.teamMap6 = teamMap;
    }

    public Team getTeam6(int index) {
        return this.teamMap6.get(index);
    }

    public Map<Integer, Team> getTeamMap7() {
        return teamMap7;
    }

    public void setTeamMap7(Map<Integer, Team> teamMap) {
        this.teamMap7 = teamMap;
    }

    public Team getTeam7(int index) {
        return this.teamMap7.get(index);
    }

    public Map<Integer, Team> getTeamMap8() {
        return teamMap8;
    }

    public void setTeamMap8(Map<Integer, Team> teamMap) {
        this.teamMap8 = teamMap;
    }

    public Team getTeam8(int index) {
        return this.teamMap8.get(index);
    }

    public Map<Integer, Team> getTeamMap9() {
        return teamMap9;
    }

    public void setTeamMap9(Map<Integer, Team> teamMap) {
        this.teamMap9 = teamMap;
    }

    public Team getTeam9(int index) {
        return this.teamMap9.get(index);
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

}
