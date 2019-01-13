package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface NotPlayingRepo extends JpaRepository<NotPlaying, Integer> {

    public NotPlaying findByMDay(String mDay);
}