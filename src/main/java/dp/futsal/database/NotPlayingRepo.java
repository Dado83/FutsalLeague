package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotPlayingRepo extends JpaRepository<NotPlaying, Integer> {

    public List<NotPlaying> findByMDay(int mDay);
}