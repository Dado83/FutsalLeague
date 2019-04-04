package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Results7Repo extends JpaRepository<Results7, Long> {

    public Results7 findByMDay(String mDay);
}