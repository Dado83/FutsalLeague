package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Results6Repo extends JpaRepository<Results6, Long> {

    public List<Results6> findByMDay(int mDay);
}