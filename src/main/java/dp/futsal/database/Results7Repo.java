package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Results7Repo extends JpaRepository<Results7, Long> {

    public List<Results7> findByMDay(int mDay);

    public List<Results7> findById(int id);
}
