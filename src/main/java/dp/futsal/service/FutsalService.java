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
    private Map<Integer, List<MatchResult>> resultsMap;
    private Map<Integer, Team> teamMap;
    private List<Team> teamListSorted;
    private List<Team> teamListIDindexed;
    private Map<Integer, String> gamePostponed;
    private Map<Integer, String> notPlaying;

    public void init() {
        LOGGER.info("init");
        this.fixture = new Fixture();
        this.fixture.loadFixturePairsFromJsonFile("C:\\Users\\Wade\\Desktop\\berger9-10.json");
        this.fixture.loadFixtureResultsFromJsonFile("C:\\Users\\Wade\\Desktop\\results.json");
        this.pairsMap = fixture.getPairs();
        this.resultsMap = fixture.getResults();

        this.teamCollection = new TeamCollection();
        this.teamCollection.loadTeamCollectionFromJson("C:\\Users\\Wade\\Desktop\\timovi.json");
        this.teamMap = teamCollection.getTeamCollection();
        this.teamListSorted = new ArrayList<>(teamMap.values());
        this.teamListIDindexed = new ArrayList<>();
        this.teamListIDindexed.add(null);
        for (Team tab : this.teamListSorted) {
            this.teamListIDindexed.add(tab.getId(), tab);
        }
        Collections.sort(this.teamListSorted);

        gamePostponed = new HashMap<>();
        notPlaying = new HashMap<>();
    }

    public void updateTeamData(Map<Integer, Team> teamMap) {
        LOGGER.info("update team data");
        this.teamMap = teamMap;
        this.teamListSorted = new ArrayList<>(this.teamMap.values());
        this.teamListIDindexed = new ArrayList<>();
        this.teamListIDindexed.add(null);
        for (Team tab : this.teamListSorted) {
            teamListIDindexed.add(tab.getId(), tab);
        }
        Collections.sort(this.teamListSorted);
    }

    public Map<Integer, List<MatchPair>> getPairs() {
        return pairsMap;
    }

    public void setPairs(Map<Integer, List<MatchPair>> pairs) {
        this.pairsMap = pairs;
    }

    public Map<Integer, List<MatchResult>> getResults() {
        return resultsMap;
    }

    public void setResults(Map<Integer, List<MatchResult>> results) {
        this.resultsMap = results;
    }

    public List<Team> getTeamListSorted() {
        return teamListSorted;
    }

    public void setTeamListSorted(List<Team> teamListSorted) {
        this.teamListSorted = teamListSorted;
    }

    public List<Team> getTeamListIDindexed() {
        return teamListIDindexed;
    }

    public void setTeamListIDindexed(List<Team> teamListIDindexed) {
        this.teamListIDindexed = teamListIDindexed;
    }

    public Map<Integer, Team> getTeamMap() {
        return teamMap;
    }

    public void setTeamMap(Map<Integer, Team> teamMap) {
        this.teamMap = teamMap;
    }

    public Team getTeam(int index) {
        return this.teamMap.get(index);
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

}
