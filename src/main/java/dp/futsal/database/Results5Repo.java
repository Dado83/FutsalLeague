package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Results5Repo extends JpaRepository<Results5, Long> {

    public Results5[] findByMDay(int mDay);
}