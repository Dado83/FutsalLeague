package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface NotPlaying9Repo extends JpaRepository<NotPlaying9, Integer> {

    public NotPlaying9 findByMDay(String mDay);
}