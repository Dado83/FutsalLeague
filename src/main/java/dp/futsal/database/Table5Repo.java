package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Table5Repo extends JpaRepository<Table5, Integer> {

    public Table5 findById(String id);
}