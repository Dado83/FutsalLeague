package dp.futsal.database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "postponed")
public class NotPlaying implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int mDay;
    private String game;

    public NotPlaying() {

    }

    public NotPlaying(int mDay, String team) {
        this.mDay = mDay;
        this.game = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getmDay() {
        return mDay;
    }

    public void setmDay(int mDay) {
        this.mDay = mDay;
    }

    public String getTeam() {
        return game;
    }

    public void setTeam(String team) {
        this.game = team;
    }

    @Override
    public String toString() {
        return mDay + " " + game;
    }
}
