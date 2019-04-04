package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Table9Repo extends JpaRepository<Table9, Integer> {

    public Table9 findById(String id);
}