package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepo extends JpaRepository<Users, Integer> {

    public Users findByMDay(String mDay);
}