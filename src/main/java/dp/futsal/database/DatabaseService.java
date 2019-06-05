package dp.futsal.database;

import dp.futsal.form.MatchResultForm;
import dp.futsal.form.TeamForm;
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

    public String saveGame(MatchResultForm form) {
	int pairID = form.getPairID();
	int matchDay = form.getMatchDay();
	String homeTeam = form.getHomeTeam();
	int homeTeamID = form.getHomeTeamID();
	String awayTeam = form.getAwayTeam();
	int awayTeamID = form.getAwayTeamID();

	int goalsHome1 = form.getGoalsHome1();
	int goalsAway1 = form.getGoalsAway1();
	int goalsHome2 = form.getGoalsHome2();
	int goalsAway2 = form.getGoalsAway2();
	int goalsHome3 = form.getGoalsHome3();
	int goalsAway3 = form.getGoalsAway3();
	int goalsHome4 = form.getGoalsHome4();
	int goalsAway4 = form.getGoalsAway4();
	int goalsHome5 = form.getGoalsHome5();
	int goalsAway5 = form.getGoalsAway5();
	int youthSel1 = form.getYouthSelection1();
	int youthSel2 = form.getYouthSelection2();
	int youthSel3 = form.getYouthSelection3();
	int youthSel4 = form.getYouthSelection4();
	int youthSel5 = form.getYouthSelection5();

	Results res1 =
		new Results(matchDay, homeTeam, homeTeamID, awayTeam, awayTeamID, goalsHome1, goalsAway1, youthSel1);
	LeagueTable homeTable1 = table.getOne(homeTeamID);
	LeagueTable awayTable1 = table.getOne(awayTeamID);

	Results res2 =
		new Results(matchDay, homeTeam, homeTeamID, awayTeam, awayTeamID, goalsHome2, goalsAway2, youthSel2);
	LeagueTable homeTable2 = table.getOne(homeTeamID);
	LeagueTable awayTable2 = table.getOne(awayTeamID);

	Results res3 =
		new Results(matchDay, homeTeam, homeTeamID, awayTeam, awayTeamID, goalsHome3, goalsAway3, youthSel3);
	LeagueTable homeTable3 = table.getOne(homeTeamID);
	LeagueTable awayTable3 = table.getOne(awayTeamID);

	Results res4 =
		new Results(matchDay, homeTeam, homeTeamID, awayTeam, awayTeamID, goalsHome4, goalsAway4, youthSel4);
	LeagueTable homeTable4 = table.getOne(homeTeamID);
	LeagueTable awayTable4 = table.getOne(awayTeamID);

	Results res5 =
		new Results(matchDay, homeTeam, homeTeamID, awayTeam, awayTeamID, goalsHome5, goalsAway5, youthSel5);
	LeagueTable homeTable5 = table.getOne(homeTeamID);
	LeagueTable awayTable5 = table.getOne(awayTeamID);

	updateTableNewGame(res1, homeTable1, awayTable1);
	updateTableNewGame(res2, homeTable2, awayTable2);
	updateTableNewGame(res3, homeTable3, awayTable3);
	updateTableNewGame(res4, homeTable4, awayTable4);
	updateTableNewGame(res5, homeTable5, awayTable5);

	results.save(res1);
	results.save(res2);
	results.save(res3);
	results.save(res4);
	results.save(res5);

	return String.format("Utakmica: %1$s - %2$s je snimljena", form.getHomeTeam(), form.getAwayTeam());
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

    public String deleteGame(int id) {
	if (!results.existsById(id)) {
	    LOGGER.info("nema tog rezultata, bibac...");
	    return "nema tog rezultata, bibac...";
	} else {
	    Results res = results.getOne(id);
	    LeagueTable ht = table.getOne(res.getHomeTeamid());
	    LeagueTable at = table.getOne(res.getAwayTeamid());

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

    public Teams saveTeam(TeamForm form) {
	String teamName = form.getTeamName();
	String teamCity = form.getTeamCity();
	String kitColor = form.getKitColor();
	String venue = form.getVenue();
	String gameTime = form.getGameTime();

	Teams team = new Teams(teamName, teamCity, kitColor, venue, gameTime);

	teams.save(team);
	return team;
    }

    public Teams updateTeam(TeamForm form) {
	int id = form.getId();
	String teamName = form.getTeamName();
	String teamCity = form.getTeamCity();
	String kitColor = form.getKitColor();
	String venue = form.getVenue();
	String gameTime = form.getGameTime();

	Teams team = new Teams(id, teamName, teamCity, kitColor, venue, gameTime);

	teams.save(team);
	return team;
    }

    public String deleteTeam(int id) {
	Teams team = teams.getOne(id);
	teams.delete(team);
	return "team deleted: " + team.getTeamName();
    }
}
