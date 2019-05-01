package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ResultsRepo extends JpaRepository<Results, Integer> {

    public List<Results> findByMDay(int mDay);

    public Results findById(int id);

    public List<Results> findByYouthSelection(int sel);

    public List<Results> findByYouthSelectionAndMDay(int sel, int mday);
}
