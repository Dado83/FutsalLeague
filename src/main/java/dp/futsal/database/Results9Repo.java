package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Results9Repo extends JpaRepository<Results9, Integer> {

    public List<Results9> findByMDay(int mDay);

    public List<Results9> findById(int id);
}
