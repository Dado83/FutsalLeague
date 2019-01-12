package dp.futsal.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface JsonRepository extends JpaRepository<Json, String> {

    public Json findByJsonName(String jsonName);
}