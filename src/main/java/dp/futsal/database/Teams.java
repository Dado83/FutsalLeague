package dp.futsal.database;

import dp.futsal.service.MatchResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "teams")
public class Teams implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String teamName;
    private String teamCity;
    private String kitColor;
    private String venue;
    private String gameTime;

    public Teams() {

    }

    public Teams(String teamName, String teamCity, String kitColor, String venue, String gameTime) {
        this.teamName = teamName;
        this.teamCity = teamCity;
        this.kitColor = kitColor;
        this.venue = venue;
        this.gameTime = gameTime;
    }

   

    

    @Override
    public String toString() {
        return "ID: " + this.id + " || Club{" + "clubName=" + teamName 
                + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

    public String getKitColor() {
        return kitColor;
    }

    public void setKitColor(String kitColor) {
        this.kitColor = kitColor;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getGameTime() {
        return gameTime;
    }

    public void setGameTime(String gameTime) {
        this.gameTime = gameTime;
    }
    
    
}
