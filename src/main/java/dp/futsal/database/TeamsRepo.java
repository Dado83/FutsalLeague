package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamsRepo extends JpaRepository<Teams, Integer> {

    public Teams findById(String id);
}