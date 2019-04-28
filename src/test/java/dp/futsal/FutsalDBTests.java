package dp.futsal;

import dp.futsal.database.Teams;
import dp.futsal.database.TeamsRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class FutsalDBTests {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    TeamsRepo teamsRepo;

    @Test
    public void findTeam() {
        Teams zeljo = new Teams("FK Zeljeznicar", "Doboj", "plava", "stadion Luke", "nedjelja");
        Teams ferplej = new Teams("OFK Fair Play", "Doboj", "zuta", "stadion Traford", "subota");
        entityManager.persist(zeljo);
        entityManager.persist(ferplej);
        entityManager.flush();

        Teams foundTeam = teamsRepo.findById(1);
        assertThat(zeljo.getTeamName()).isEqualTo(foundTeam.getTeamName());
    }

}
