package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface VisitorsRepo extends JpaRepository<Visitors, Integer> {

    public Visitors findById(String id);
}