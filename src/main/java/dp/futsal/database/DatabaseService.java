package dp.futsal.database;

import dp.futsal.form.MatchResultForm;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class DatabaseService {

    private static final Logger LOGGER = Logger.getLogger(DatabaseService.class.getName());
    @Autowired
    private MatchPairsRepo matchPairs;
    @Autowired
    private NotPlayingRepo notPlaying;
    @Autowired
    private NotPlaying9Repo notPlaying9;
    @Autowired
    private ResultsRepo results5;
    @Autowired
    private Results6Repo results6;
    @Autowired
    private Results7Repo results7;
    @Autowired
    private Results8Repo results8;
    @Autowired
    private Results9Repo results9;
    @Autowired
    private LeagueTableRepo table5;
    @Autowired
    private Table6Repo table6;
    @Autowired
    private Table7Repo table7;
    @Autowired
    private Table8Repo table8;
    @Autowired
    private Table9Repo table9;
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

    public List<NotPlaying> getNotPlaying() {
        return notPlaying.findAll();
    }

    public List<NotPlaying> getNotPlayingByMday(int mDay) {
        return notPlaying.findByMDay(mDay);
    }

    public List<NotPlaying9> getNotPlaying9() {
        return notPlaying9.findAll();
    }

    public List<NotPlaying9> getNotPlaying9ByMday(int mDay) {
        return notPlaying9.findByMDay(mDay);
    }

    public List getResults(int year) {
        List results = new ArrayList();
        switch (year) {
            case 5:
                results = results5.findAll();
                break;
            case 6:
                results = results6.findAll();
                break;
            case 7:
                results = results7.findAll();
                break;
            case 8:
                results = results8.findAll();
                break;
            case 9:
                results = results9.findAll();
                break;
        }
        return results;
    }

    public List getResultsByMday(int year, int mDay) {
        List results = new ArrayList();
        switch (year) {
            case 5:
                results = results5.findByMDay(mDay);
                break;
            case 6:
                results = results6.findByMDay(mDay);
                break;
            case 7:
                results = results7.findByMDay(mDay);
                break;
            case 8:
                results = results8.findByMDay(mDay);
                break;
            case 9:
                results = results9.findByMDay(mDay);
                break;
        }
        return results;
    }

    public List getResultsById(int year, int id) {
        List results = new ArrayList();
        switch (year) {
            case 5:
                results = results5.findById(id);
                break;
            case 6:
                results = results6.findById(id);
                break;
            case 7:
                results = results7.findById(id);
                break;
            case 8:
                results = results8.findById(id);
                break;
            case 9:
                results = results9.findById(id);
                break;
        }
        return results;
    }

    public List getTable(int year) {
        List table = new ArrayList();
        switch (year) {
            case 5:
                table = table5.getOrderedTable();
                break;
            case 6:
                table = table6.getOrderedTable();
                break;
            case 7:
                table = table7.getOrderedTable();
                break;
            case 8:
                table = table8.getOrderedTable();
                break;
            case 9:
                table = table9.getOrderedTable();
                break;
        }
        return table;
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

        Results9 res9 = new Results9(matchDay, homeTeam, homeTeamID, awayTeam, awayTeamID, goalsHome9, goalsAway9);
        Table9 homeTable9 = table9.getOne(homeTeamID);
        Table9 awayTable9 = table9.getOne(awayTeamID);

        Results8 res8 = new Results8(matchDay, homeTeam, homeTeamID, awayTeam, awayTeamID, goalsHome8, goalsAway8);
        Table8 homeTable8 = table8.getOne(homeTeamID);
        Table8 awayTable8 = table8.getOne(awayTeamID);

        Results7 res7 = new Results7(matchDay, homeTeam, homeTeamID, awayTeam, awayTeamID, goalsHome7, goalsAway7);
        Table7 homeTable7 = table7.getOne(homeTeamID);
        Table7 awayTable7 = table7.getOne(awayTeamID);

        Results6 res6 = new Results6(matchDay, homeTeam, homeTeamID, awayTeam, awayTeamID, goalsHome6, goalsAway6);
        Table6 homeTable6 = table6.getOne(homeTeamID);
        Table6 awayTable6 = table6.getOne(awayTeamID);

        Results res5 = new Results(matchDay, homeTeam, homeTeamID, awayTeam, awayTeamID, goalsHome5, goalsAway5);
        LeagueTable homeTable5 = table5.getOne(homeTeamID);
        LeagueTable awayTable5 = table5.getOne(awayTeamID);

        updateTableNewGame9(res9, homeTable9, awayTable9);

        results9.save(res9);

    }

    private void updateTableNewGame9(Results9 res, Table9 ht, Table9 at) {
        if (res.getGoalsHome() > res.getGoalsAway()) {
            table9.save(new Table9(ht.getId(), ht.getGamesPlayed() + 1,
                    ht.getGamesWon() + 1,
                    ht.getGamesDrew(),
                    ht.getGamesLost(),
                    ht.getGoalsScored() + res.getGoalsHome(),
                    ht.getGoalsConceded() + res.getGoalsAway(),
                    ht.getPoints() + 3));

            table9.save(new Table9(at.getId(), at.getGamesPlayed() + 1,
                    at.getGamesWon(),
                    at.getGamesDrew(),
                    at.getGamesLost() + 1,
                    at.getGoalsScored() + res.getGoalsAway(),
                    at.getGoalsConceded() + res.getGoalsHome(),
                    at.getPoints()));

        } else if (res.getGoalsAway() > res.getGoalsHome()) {
            table9.save(new Table9(ht.getId(), ht.getGamesPlayed() + 1,
                    ht.getGamesWon(),
                    ht.getGamesDrew(),
                    ht.getGamesLost() + 1,
                    ht.getGoalsScored() + res.getGoalsHome(),
                    ht.getGoalsConceded() + res.getGoalsAway(),
                    ht.getPoints()));

            table9.save(new Table9(at.getId(), at.getGamesPlayed() + 1,
                    at.getGamesWon() + 1,
                    at.getGamesDrew(),
                    at.getGamesLost(),
                    at.getGoalsScored() + res.getGoalsAway(),
                    at.getGoalsConceded() + res.getGoalsHome(),
                    at.getPoints() + 3));
        } else {
            table9.save(new Table9(ht.getId(), ht.getGamesPlayed() + 1,
                    ht.getGamesWon(),
                    ht.getGamesDrew() + 1,
                    ht.getGamesLost(),
                    ht.getGoalsScored() + res.getGoalsHome(),
                    ht.getGoalsConceded() + res.getGoalsAway(),
                    ht.getPoints() + 1));

            table9.save(new Table9(at.getId(), at.getGamesPlayed() + 1,
                    at.getGamesWon(),
                    at.getGamesDrew() + 1,
                    at.getGamesLost(),
                    at.getGoalsScored() + res.getGoalsAway(),
                    at.getGoalsConceded() + res.getGoalsHome(),
                    at.getPoints() + 1));
        }
    }
    
    private void updateTableNewGame8(Results8 res, Table8 ht, Table8 at) {
        if (res.getGoalsHome() > res.getGoalsAway()) {
            table8.save(new Table8(ht.getId(), ht.getGamesPlayed() + 1,
                    ht.getGamesWon() + 1,
                    ht.getGamesDrew(),
                    ht.getGamesLost(),
                    ht.getGoalsScored() + res.getGoalsHome(),
                    ht.getGoalsConceded() + res.getGoalsAway(),
                    ht.getPoints() + 3));

            table8.save(new Table8(at.getId(), at.getGamesPlayed() + 1,
                    at.getGamesWon(),
                    at.getGamesDrew(),
                    at.getGamesLost() + 1,
                    at.getGoalsScored() + res.getGoalsAway(),
                    at.getGoalsConceded() + res.getGoalsHome(),
                    at.getPoints()));

        } else if (res.getGoalsAway() > res.getGoalsHome()) {
            table8.save(new Table8(ht.getId(), ht.getGamesPlayed() + 1,
                    ht.getGamesWon(),
                    ht.getGamesDrew(),
                    ht.getGamesLost() + 1,
                    ht.getGoalsScored() + res.getGoalsHome(),
                    ht.getGoalsConceded() + res.getGoalsAway(),
                    ht.getPoints()));

            table8.save(new Table8(at.getId(), at.getGamesPlayed() + 1,
                    at.getGamesWon() + 1,
                    at.getGamesDrew(),
                    at.getGamesLost(),
                    at.getGoalsScored() + res.getGoalsAway(),
                    at.getGoalsConceded() + res.getGoalsHome(),
                    at.getPoints() + 3));
        } else {
            table8.save(new Table8(ht.getId(), ht.getGamesPlayed() + 1,
                    ht.getGamesWon(),
                    ht.getGamesDrew() + 1,
                    ht.getGamesLost(),
                    ht.getGoalsScored() + res.getGoalsHome(),
                    ht.getGoalsConceded() + res.getGoalsAway(),
                    ht.getPoints() + 1));

            table8.save(new Table8(at.getId(), at.getGamesPlayed() + 1,
                    at.getGamesWon(),
                    at.getGamesDrew() + 1,
                    at.getGamesLost(),
                    at.getGoalsScored() + res.getGoalsAway(),
                    at.getGoalsConceded() + res.getGoalsHome(),
                    at.getPoints() + 1));
        }
    }
    
    private void updateTableNewGame7(Results7 res, Table7 ht, Table7 at) {
        if (res.getGoalsHome() > res.getGoalsAway()) {
            table7.save(new Table7(ht.getId(), ht.getGamesPlayed() + 1,
                    ht.getGamesWon() + 1,
                    ht.getGamesDrew(),
                    ht.getGamesLost(),
                    ht.getGoalsScored() + res.getGoalsHome(),
                    ht.getGoalsConceded() + res.getGoalsAway(),
                    ht.getPoints() + 3));

            table7.save(new Table7(at.getId(), at.getGamesPlayed() + 1,
                    at.getGamesWon(),
                    at.getGamesDrew(),
                    at.getGamesLost() + 1,
                    at.getGoalsScored() + res.getGoalsAway(),
                    at.getGoalsConceded() + res.getGoalsHome(),
                    at.getPoints()));

        } else if (res.getGoalsAway() > res.getGoalsHome()) {
            table7.save(new Table7(ht.getId(), ht.getGamesPlayed() + 1,
                    ht.getGamesWon(),
                    ht.getGamesDrew(),
                    ht.getGamesLost() + 1,
                    ht.getGoalsScored() + res.getGoalsHome(),
                    ht.getGoalsConceded() + res.getGoalsAway(),
                    ht.getPoints()));

            table7.save(new Table7(at.getId(), at.getGamesPlayed() + 1,
                    at.getGamesWon() + 1,
                    at.getGamesDrew(),
                    at.getGamesLost(),
                    at.getGoalsScored() + res.getGoalsAway(),
                    at.getGoalsConceded() + res.getGoalsHome(),
                    at.getPoints() + 3));
        } else {
            table7.save(new Table7(ht.getId(), ht.getGamesPlayed() + 1,
                    ht.getGamesWon(),
                    ht.getGamesDrew() + 1,
                    ht.getGamesLost(),
                    ht.getGoalsScored() + res.getGoalsHome(),
                    ht.getGoalsConceded() + res.getGoalsAway(),
                    ht.getPoints() + 1));

            table7.save(new Table7(at.getId(), at.getGamesPlayed() + 1,
                    at.getGamesWon(),
                    at.getGamesDrew() + 1,
                    at.getGamesLost(),
                    at.getGoalsScored() + res.getGoalsAway(),
                    at.getGoalsConceded() + res.getGoalsHome(),
                    at.getPoints() + 1));
        }
    }
    
    private void updateTableNewGame6(Results6 res, Table6 ht, Table6 at) {
        if (res.getGoalsHome() > res.getGoalsAway()) {
            table6.save(new Table6(ht.getId(), ht.getGamesPlayed() + 1,
                    ht.getGamesWon() + 1,
                    ht.getGamesDrew(),
                    ht.getGamesLost(),
                    ht.getGoalsScored() + res.getGoalsHome(),
                    ht.getGoalsConceded() + res.getGoalsAway(),
                    ht.getPoints() + 3));

            table6.save(new Table6(at.getId(), at.getGamesPlayed() + 1,
                    at.getGamesWon(),
                    at.getGamesDrew(),
                    at.getGamesLost() + 1,
                    at.getGoalsScored() + res.getGoalsAway(),
                    at.getGoalsConceded() + res.getGoalsHome(),
                    at.getPoints()));

        } else if (res.getGoalsAway() > res.getGoalsHome()) {
            table6.save(new Table6(ht.getId(), ht.getGamesPlayed() + 1,
                    ht.getGamesWon(),
                    ht.getGamesDrew(),
                    ht.getGamesLost() + 1,
                    ht.getGoalsScored() + res.getGoalsHome(),
                    ht.getGoalsConceded() + res.getGoalsAway(),
                    ht.getPoints()));

            table6.save(new Table6(at.getId(), at.getGamesPlayed() + 1,
                    at.getGamesWon() + 1,
                    at.getGamesDrew(),
                    at.getGamesLost(),
                    at.getGoalsScored() + res.getGoalsAway(),
                    at.getGoalsConceded() + res.getGoalsHome(),
                    at.getPoints() + 3));
        } else {
            table6.save(new Table6(ht.getId(), ht.getGamesPlayed() + 1,
                    ht.getGamesWon(),
                    ht.getGamesDrew() + 1,
                    ht.getGamesLost(),
                    ht.getGoalsScored() + res.getGoalsHome(),
                    ht.getGoalsConceded() + res.getGoalsAway(),
                    ht.getPoints() + 1));

            table6.save(new Table6(at.getId(), at.getGamesPlayed() + 1,
                    at.getGamesWon(),
                    at.getGamesDrew() + 1,
                    at.getGamesLost(),
                    at.getGoalsScored() + res.getGoalsAway(),
                    at.getGoalsConceded() + res.getGoalsHome(),
                    at.getPoints() + 1));
        }
    }
    
    private void updateTableNewGame5(Results res, LeagueTable ht, LeagueTable at) {
        if (res.getGoalsHome() > res.getGoalsAway()) {
            table5.save(new LeagueTable(ht.getId(), ht.getGamesPlayed() + 1,
                    ht.getGamesWon() + 1,
                    ht.getGamesDrew(),
                    ht.getGamesLost(),
                    ht.getGoalsScored() + res.getGoalsHome(),
                    ht.getGoalsConceded() + res.getGoalsAway(),
                    ht.getPoints() + 3));

            table5.save(new LeagueTable(at.getId(), at.getGamesPlayed() + 1,
                    at.getGamesWon(),
                    at.getGamesDrew(),
                    at.getGamesLost() + 1,
                    at.getGoalsScored() + res.getGoalsAway(),
                    at.getGoalsConceded() + res.getGoalsHome(),
                    at.getPoints()));

        } else if (res.getGoalsAway() > res.getGoalsHome()) {
            table5.save(new LeagueTable(ht.getId(), ht.getGamesPlayed() + 1,
                    ht.getGamesWon(),
                    ht.getGamesDrew(),
                    ht.getGamesLost() + 1,
                    ht.getGoalsScored() + res.getGoalsHome(),
                    ht.getGoalsConceded() + res.getGoalsAway(),
                    ht.getPoints()));

            table5.save(new LeagueTable(at.getId(), at.getGamesPlayed() + 1,
                    at.getGamesWon() + 1,
                    at.getGamesDrew(),
                    at.getGamesLost(),
                    at.getGoalsScored() + res.getGoalsAway(),
                    at.getGoalsConceded() + res.getGoalsHome(),
                    at.getPoints() + 3));
        } else {
            table5.save(new LeagueTable(ht.getId(), ht.getGamesPlayed() + 1,
                    ht.getGamesWon(),
                    ht.getGamesDrew() + 1,
                    ht.getGamesLost(),
                    ht.getGoalsScored() + res.getGoalsHome(),
                    ht.getGoalsConceded() + res.getGoalsAway(),
                    ht.getPoints() + 1));

            table5.save(new LeagueTable(at.getId(), at.getGamesPlayed() + 1,
                    at.getGamesWon(),
                    at.getGamesDrew() + 1,
                    at.getGamesLost(),
                    at.getGoalsScored() + res.getGoalsAway(),
                    at.getGoalsConceded() + res.getGoalsHome(),
                    at.getPoints() + 1));
        }
    }

    public String deleteGame(int id, Table9 ht, Table9 at) {
        if (!results9.existsById(id)) {
            LOGGER.info("nema tog rezultata, bibac...");
            return "nema tog rezultata, bibac...";
        } else {
            Results9 res = results9.getOne(id);

            if (res.getGoalsHome() > res.getGoalsAway()) {
                table9.save(new Table9(ht.getId(), ht.getGamesPlayed() - 1,
                        ht.getGamesWon() - 1,
                        ht.getGamesDrew(),
                        ht.getGamesLost(),
                        ht.getGoalsScored() - res.getGoalsHome(),
                        ht.getGoalsConceded() - res.getGoalsAway(),
                        ht.getPoints() - 3));

                table9.save(new Table9(at.getId(), at.getGamesPlayed() - 1,
                        at.getGamesWon(),
                        at.getGamesDrew(),
                        at.getGamesLost() - 1,
                        at.getGoalsScored() - res.getGoalsAway(),
                        at.getGoalsConceded() - res.getGoalsHome(),
                        at.getPoints()));
            } else if (res.getGoalsAway() > res.getGoalsHome()) {
                table9.save(new Table9(ht.getId(), ht.getGamesPlayed() - 1,
                        ht.getGamesWon(),
                        ht.getGamesDrew(),
                        ht.getGamesLost() - 1,
                        ht.getGoalsScored() - res.getGoalsHome(),
                        ht.getGoalsConceded() - res.getGoalsAway(),
                        ht.getPoints()));

                table9.save(new Table9(at.getId(), at.getGamesPlayed() - 1,
                        at.getGamesWon() - 1,
                        at.getGamesDrew(),
                        at.getGamesLost(),
                        at.getGoalsScored() - res.getGoalsAway(),
                        at.getGoalsConceded() - res.getGoalsHome(),
                        at.getPoints() - 3));
            } else {
                table9.save(new Table9(ht.getId(), ht.getGamesPlayed() - 1,
                        ht.getGamesWon(),
                        ht.getGamesDrew() - 1,
                        ht.getGamesLost(),
                        ht.getGoalsScored() - res.getGoalsHome(),
                        ht.getGoalsConceded() - res.getGoalsAway(),
                        ht.getPoints() - 1));

                table9.save(new Table9(at.getId(), at.getGamesPlayed() - 1,
                        at.getGamesWon(),
                        at.getGamesDrew() - 1,
                        at.getGamesLost(),
                        at.getGoalsScored() - res.getGoalsAway(),
                        at.getGoalsConceded() - res.getGoalsHome(),
                        at.getPoints() - 1));
            }

            results9.delete(res);
        }
        return "izbrisana tekma sa id = " + id;
    }
}
