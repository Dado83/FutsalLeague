package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Results8Repo extends JpaRepository<Results8, Long> {

    public List<Results8> findByMDay(int mDay);
}