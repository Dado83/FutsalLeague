package dp.futsal.database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "liga")
public class Json implements Serializable {

    @Id
    private String jsonName;
    private String jsonData;

    public Json() {

    }

    public Json(String jsonName, String jsonData) {
        this.jsonName = jsonName;
        this.jsonData = jsonData;
    }

    public String getJsonName() {
        return jsonName;
    }

    public void setJsonName(String jsonName) {
        this.jsonName = jsonName;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

}