package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MatchPairsRepo extends JpaRepository<MatchPairs, Long> {

    public MatchPairs findByMDay(String mDay);
}