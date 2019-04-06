package dp.futsal.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotPlaying9Repo extends JpaRepository<NotPlaying9, Integer> {

    public List<NotPlaying9> findByMDay(int mDay);
}