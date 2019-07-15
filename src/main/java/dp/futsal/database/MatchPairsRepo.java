package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;;

public interface MatchPairsRepo extends JpaRepository<MatchPairs, Integer> {

    @Query("SELECT m FROM MatchPairs m WHERE m.mDay = :mDay")
    public List<MatchPairs> findBymDay(@Param("mDay") int mDay);

    @Query("SELECT m FROM MatchPairs m WHERE m.isPlayed = FALSE")
    public List<MatchPairs> getPairsNotPlayed();
}
