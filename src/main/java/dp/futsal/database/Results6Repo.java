package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Results6Repo extends JpaRepository<Results6, Long> {

    public Results6 findByMDay(String mDay);
}