package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface Table6Repo extends JpaRepository<Table6, Integer> {

    final String QUERY = "SELECT t FROM Table6 t WHERE NOT t.id=10 ORDER BY t.points DESC, t.goalsScored DESC";

    @Query(value = QUERY)
    public List<Table6> getOrderedTable();
}
