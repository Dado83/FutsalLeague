package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MatchPairsRepo extends JpaRepository<MatchPairs, Integer> {

    public List<MatchPairs> findBymDay(int mDay);

    @Query("SELECT m FROM MatchPairs m WHERE m.isPlayed = FALSE")
    public List<MatchPairs> getPairsNotPlayed();
}
