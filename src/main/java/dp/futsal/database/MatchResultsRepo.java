package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MatchResultsRepo extends JpaRepository<MatchResults, Integer> {

    public MatchResults findByMDay(String mDay);
}