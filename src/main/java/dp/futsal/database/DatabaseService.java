package dp.futsal.database;

import dp.futsal.form.MatchResultForm;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DatabaseService {

    private static final Logger LOGGER = Logger.getLogger(DatabaseService.class.getName());
    @Autowired
    private MatchPairsRepo matchPairs;
    @Autowired
    private ResultsRepo results;
    @Autowired
    private LeagueTableRepo table;
    @Autowired
    private TeamsRepo teams;
    @Autowired
    private UsersRepo users;
    @Autowired
    private VisitorsRepo visitors;

    public List<MatchPairs> getPairs() {
	return matchPairs.findAll();
    }

    public List<MatchPairs> getPairsByMday(int mDay) {
	return matchPairs.findByMDay(mDay);
    }

    public List<MatchPairs> getPairsNotPlayed() {
	return matchPairs.getPairsNotPlayed();
    }

    public List getResults(int sel) {
	return results.findByYouthSelection(sel);
    }

    public List getResultsByMday(int sel, int mDay) {
	return results.findByYouthSelectionAndMDay(sel, mDay);
    }

    public Results getResultsById(int id) {
	return results.findById(id);
    }

    public List getTable(int sel) {
	return table.getOrderedTable(sel);
    }

    public List<Teams> getTeams() {
	return teams.findAll();
    }

    public Teams getTeamsById(int id) {
	return teams.findById(id);
    }

    public List<Teams> searchTeams(String search) {
	return teams.searchTeams("%" + search + "%");
    }

    public List<Users> getUsers() {
	return users.findAll();
    }

    public Users getUsersById(int id) {
	return users.findById(id);
    }

    public List<Visitors> getVisitors() {
	return visitors.findAll();
    }

    public void saveGame(MatchResultForm form) {
	int pairID = form.getPairID();
	int matchDay = form.getMatchDay();
	String homeTeam = form.getHomeTeam();
	int homeTeamID = form.getHomeTeamID();
	String awayTeam = form.getAwayTeam();
	int awayTeamID = form.getAwayTeamID();

	int goalsHome9 = form.getGoalsHome9();
	int goalsAway9 = form.getGoalsAway9();
	int goalsHome8 = form.getGoalsHome8();
	int goalsAway8 = form.getGoalsAway8();
	int goalsHome7 = form.getGoalsHome7();
	int goalsAway7 = form.getGoalsAway7();
	int goalsHome6 = form.getGoalsHome6();
	int goalsAway6 = form.getGoalsAway6();
	int goalsHome5 = form.getGoalsHome5();
	int goalsAway5 = form.getGoalsAway5();

	Results res9 = new Results(matchDay, homeTeam, homeTeamID, awayTeam, awayTeamID, goalsHome9, goalsAway9, 2009);
	LeagueTable homeTable9 = table.getOne(homeTeamID);
	LeagueTable awayTable9 = table.getOne(awayTeamID);

	updateTableNewGame(res9, homeTable9, awayTable9);

	results.save(res9);

    }

    private void updateTableNewGame(Results res, LeagueTable ht, LeagueTable at) {
	if (res.getGoalsHome() > res.getGoalsAway()) {
	    table.save(new LeagueTable(ht.getId(), ht.getYouthSelection(), ht.getTeamId(), ht.getGamesPlayed() + 1,
		    ht.getGamesWon() + 1, ht.getGamesDrew(), ht.getGamesLost(),
		    ht.getGoalsScored() + res.getGoalsHome(), ht.getGoalsConceded() + res.getGoalsAway(),
		    ht.getPoints() + 3));

	    table.save(new LeagueTable(at.getId(), at.getYouthSelection(), at.getTeamId(), at.getGamesPlayed() + 1,
		    at.getGamesWon(), at.getGamesDrew(), at.getGamesLost() + 1,
		    at.getGoalsScored() + res.getGoalsAway(), at.getGoalsConceded() + res.getGoalsHome(),
		    at.getPoints()));

	} else if (res.getGoalsAway() > res.getGoalsHome()) {
	    table.save(new LeagueTable(ht.getId(), ht.getYouthSelection(), ht.getTeamId(), ht.getGamesPlayed() + 1,
		    ht.getGamesWon(), ht.getGamesDrew(), ht.getGamesLost() + 1,
		    ht.getGoalsScored() + res.getGoalsHome(), ht.getGoalsConceded() + res.getGoalsAway(),
		    ht.getPoints()));

	    table.save(new LeagueTable(at.getId(), at.getYouthSelection(), at.getTeamId(), at.getGamesPlayed() + 1,
		    at.getGamesWon() + 1, at.getGamesDrew(), at.getGamesLost(),
		    at.getGoalsScored() + res.getGoalsAway(), at.getGoalsConceded() + res.getGoalsHome(),
		    at.getPoints() + 3));
	} else {
	    table.save(new LeagueTable(ht.getId(), ht.getYouthSelection(), ht.getTeamId(), ht.getGamesPlayed() + 1,
		    ht.getGamesWon(), ht.getGamesDrew() + 1, ht.getGamesLost(),
		    ht.getGoalsScored() + res.getGoalsHome(), ht.getGoalsConceded() + res.getGoalsAway(),
		    ht.getPoints() + 1));

	    table.save(new LeagueTable(at.getId(), at.getYouthSelection(), at.getTeamId(), at.getGamesPlayed() + 1,
		    at.getGamesWon(), at.getGamesDrew() + 1, at.getGamesLost(),
		    at.getGoalsScored() + res.getGoalsAway(), at.getGoalsConceded() + res.getGoalsHome(),
		    at.getPoints() + 1));
	}
    }

    public String deleteGame(int id, LeagueTable ht, LeagueTable at) {
	if (!results.existsById(id)) {
	    LOGGER.info("nema tog rezultata, bibac...");
	    return "nema tog rezultata, bibac...";
	} else {
	    Results res = results.getOne(id);

	    if (res.getGoalsHome() > res.getGoalsAway()) {
		table.save(new LeagueTable(ht.getId(), ht.getYouthSelection(), ht.getTeamId(), ht.getGamesPlayed() - 1,
			ht.getGamesWon() - 1, ht.getGamesDrew(), ht.getGamesLost(),
			ht.getGoalsScored() - res.getGoalsHome(), ht.getGoalsConceded() - res.getGoalsAway(),
			ht.getPoints() - 3));

		table.save(new LeagueTable(at.getId(), at.getYouthSelection(), at.getTeamId(), at.getGamesPlayed() - 1,
			at.getGamesWon(), at.getGamesDrew(), at.getGamesLost() - 1,
			at.getGoalsScored() - res.getGoalsAway(), at.getGoalsConceded() - res.getGoalsHome(),
			at.getPoints()));
	    } else if (res.getGoalsAway() > res.getGoalsHome()) {
		table.save(new LeagueTable(ht.getId(), ht.getYouthSelection(), ht.getTeamId(), ht.getGamesPlayed() - 1,
			ht.getGamesWon(), ht.getGamesDrew(), ht.getGamesLost() - 1,
			ht.getGoalsScored() - res.getGoalsHome(), ht.getGoalsConceded() - res.getGoalsAway(),
			ht.getPoints()));

		table.save(new LeagueTable(at.getId(), at.getYouthSelection(), at.getTeamId(), at.getGamesPlayed() - 1,
			at.getGamesWon() - 1, at.getGamesDrew(), at.getGamesLost(),
			at.getGoalsScored() - res.getGoalsAway(), at.getGoalsConceded() - res.getGoalsHome(),
			at.getPoints() - 3));
	    } else {
		table.save(new LeagueTable(ht.getId(), ht.getYouthSelection(), ht.getTeamId(), ht.getGamesPlayed() - 1,
			ht.getGamesWon(), ht.getGamesDrew() - 1, ht.getGamesLost(),
			ht.getGoalsScored() - res.getGoalsHome(), ht.getGoalsConceded() - res.getGoalsAway(),
			ht.getPoints() - 1));

		table.save(new LeagueTable(at.getId(), at.getYouthSelection(), at.getTeamId(), at.getGamesPlayed() - 1,
			at.getGamesWon(), at.getGamesDrew() - 1, at.getGamesLost(),
			at.getGoalsScored() - res.getGoalsAway(), at.getGoalsConceded() - res.getGoalsHome(),
			at.getPoints() - 1));
	    }

	    results.delete(res);
	}
	return "izbrisana tekma sa id = " + id;
    }
}
