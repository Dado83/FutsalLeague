package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Results9Repo extends JpaRepository<Results9, Long> {

    public Results9 findByMDay(String mDay);
}