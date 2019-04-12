package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Results6Repo extends JpaRepository<Results6, Integer> {

    public List<Results6> findByMDay(int mDay);

    public List<Results6> findById(int id);
}
