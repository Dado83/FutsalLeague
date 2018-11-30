package dp.futsal.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DatabaseService {

    @Autowired
    private JsonRepository jsonRepository;

    public Json findJson(String jsonName) {
        return jsonRepository.findByJsonName(jsonName);
    }

    public void saveJson(Json json) {
        jsonRepository.save(json);
    }

}
