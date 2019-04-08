package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TeamsRepo extends JpaRepository<Teams, Integer> {

    public Teams findById(int id);

    final String QUERY = "SELECT t FROM Teams t WHERE teamName LIKE ?1 OR teamCity LIKE ?1";

    @Query(QUERY)
    public List<Teams> searchTeams(String search);
}
