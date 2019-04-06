package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MatchPairsRepo extends JpaRepository<MatchPairs, Integer> {

    public List<MatchPairs> findByMDay(int mDay);
}