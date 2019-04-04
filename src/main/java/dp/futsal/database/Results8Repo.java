package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Results8Repo extends JpaRepository<Results8, Long> {

    public Results8 findByMDay(String mDay);
}