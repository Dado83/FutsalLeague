package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Results9Repo extends JpaRepository<Results9, Long> {

    public List<Results9> findByMDay(int mDay);
}