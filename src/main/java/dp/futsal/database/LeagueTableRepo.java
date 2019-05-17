package dp.futsal.database;

import java.util.List;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface LeagueTableRepo extends JpaRepository<LeagueTable, Integer> {

    final String QUERY =
	    "SELECT t FROM LeagueTable t WHERE t.teamId <> 10 AND t.youthSelection = :sel ORDER BY t.points DESC, t.goalsScored DESC";

    @Query(QUERY)
    public List<LeagueTable> getOrderedTable(@Param int sel);
}
