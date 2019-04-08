package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface Table7Repo extends JpaRepository<Table7, Integer> {

    final String QUERY = "SELECT t FROM Table7 t WHERE NOT t.id=10 ORDER BY t.points DESC, t.goalsScored DESC";

    @Query(value = QUERY)
    public List<Table5> getOrderedTable();
}
