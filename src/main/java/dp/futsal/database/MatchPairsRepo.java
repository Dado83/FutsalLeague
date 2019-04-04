package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MatchPairsRepo extends JpaRepository<MatchPairs, Integer> {

    public MatchPairs findByMDay(String mDay);
}