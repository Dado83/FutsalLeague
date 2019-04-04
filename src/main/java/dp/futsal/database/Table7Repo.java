package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Table7Repo extends JpaRepository<Table7, Integer> {

    public Table7 findById(String id);
}