package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Results5Repo extends JpaRepository<Results5, Long> {

    public List<Results5> findByMDay(int mDay);
}