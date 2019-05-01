package dp.futsal;

import dp.futsal.database.LeagueTable;
import dp.futsal.database.LeagueTableRepo;
import dp.futsal.database.MatchPairs;
import dp.futsal.database.MatchPairsRepo;
import dp.futsal.database.Results;
import dp.futsal.database.ResultsRepo;
import dp.futsal.database.Teams;
import dp.futsal.database.TeamsRepo;
import dp.futsal.database.Users;
import dp.futsal.database.UsersRepo;
import dp.futsal.database.Visitors;
import dp.futsal.database.VisitorsRepo;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.springframework.test.annotation.DirtiesContext;


@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class FutsalDBTests {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    TeamsRepo teamsRepo;
    @Autowired
    LeagueTableRepo leagueTableRepo;
    @Autowired
    ResultsRepo resultsRepo;
    @Autowired
    MatchPairsRepo matchPairsRepo;
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    VisitorsRepo visitorsRepo;

    @Before
    public void init() {
        Results results1 = new Results(1, "m utd", 1, "city", 2, 3, 0, 2009);
        Results results2 = new Results(2, "ars", 3, "chelsea", 4, 2, 2, 2006);
        entityManager.persist(results1);
        entityManager.persist(results2);

        Teams zeljo = new Teams("FK Zeljeznicar", "Doboj", "plava", "stadion Luke", "nedjelja");
        Teams ferplej = new Teams("OFK Fair Play", "Doboj", "zuta", "stadion Traford", "subota");
        entityManager.persist(zeljo);
        entityManager.persist(ferplej);

        LeagueTable table1 = new LeagueTable(2005, 1, 1, 1, 0, 0, 10, 0, 3);
        LeagueTable table2 = new LeagueTable(2005, 2, 1, 0, 0, 1, 0, 10, 0);
        entityManager.persist(table1);
        entityManager.persist(table2);

        MatchPairs match1 = new MatchPairs(1, 1, 2, "subota", true);
        MatchPairs match2 = new MatchPairs(1, 3, 4, "nedjelja", false);
        entityManager.persist(match1);
        entityManager.persist(match2);

        Users user = new Users("dado", "batman");
        entityManager.persist(user);

        Visitors visitor =
                new Visitors("local", "", "", "win10", "chrome", "", "", 0, "admin", (int) System.currentTimeMillis());
        entityManager.persist(visitor);
    }

    @Test
    public void findTeamById() {
        Teams foundTeam = teamsRepo.findById(2);
        assertThat(foundTeam.getTeamName()).isEqualTo("OFK Fair Play");
    }

    @Test
    public void searchTeams() {
        List<Teams> foundTeams = teamsRepo.searchTeams("FK Zeljeznicar");
        assertThat(foundTeams.get(0).getTeamName()).contains("Zelje");
    }

    @Test
    public void getTable() {
        List<LeagueTable> foundLeagueTables = leagueTableRepo.getOrderedTable(2005);
        assertThat(foundLeagueTables.size()).isEqualTo(2);
    }

    @Test
    public void getResultsByMDay() {
        List<Results> foundResults = resultsRepo.findByMDay(2);
        assertThat(foundResults.get(0).getYouthSelection()).isEqualTo(2006);
    }

    @Test
    public void getResultsById() {
        Results foundResult = resultsRepo.findById(1);
        assertThat(foundResult.getHomeTeam()).isEqualTo("m utd");
    }

    @Test
    public void getResultsByYouthSelection() {
        List<Results> foundResults = resultsRepo.findByYouthSelection(2009);
        assertThat(foundResults.get(0).getAwayTeam()).isEqualTo("city");
    }

    @Test
    public void getResultsByYouthSelectionAndMDay() {
        List<Results> foundResults = resultsRepo.findByYouthSelectionAndMDay(2009, 1);
        assertThat(foundResults.get(0).getAwayTeamid()).isEqualTo(2);
    }

    @Test
    public void findMatchPairsByMDay() {
        List<MatchPairs> foundMatchPair = matchPairsRepo.findByMDay(1);
        assertThat(foundMatchPair.size()).isEqualTo(2);

    }

    @Test
    public void findNotPlayedMatchPairs() {
        List<MatchPairs> foundMatchPair = matchPairsRepo.getPairsNotPlayed();
        assertThat(foundMatchPair.get(0).getGameDate()).isEqualTo("nedjelja");
    }

    @Test
    public void findUserById() {
        Users foundUser = usersRepo.findById(1);
        assertThat(foundUser.getUser()).isEqualTo("dado");
    }

    @Test
    public void findVisitorById() {
        Visitors foundVisitor = visitorsRepo.findById(1);
        assertThat(foundVisitor.getIp()).isEqualTo("local");
    }

}
