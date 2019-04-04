package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Table6Repo extends JpaRepository<Table6, Integer> {

    public Table6 findById(String id);
}