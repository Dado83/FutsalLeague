package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface LeagueTableRepo extends JpaRepository<LeagueTable, Integer> {

    final String QUERY = "SELECT t FROM Table5 t WHERE NOT t.id=10 ORDER BY t.points DESC, t.goalsScored DESC";

    @Query(QUERY)
    public List<LeagueTable> getOrderedTable();
}
