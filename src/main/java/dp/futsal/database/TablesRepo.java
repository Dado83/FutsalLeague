package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TablesRepo extends JpaRepository<Tables, Integer> {

    public Tables findById(String id);
}