package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Table8Repo extends JpaRepository<Table8, Integer> {

    public Table8 findById(String id);
}