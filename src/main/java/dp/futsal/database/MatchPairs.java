package dp.futsal.database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "matchpairs")
public class MatchPairs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int mDay;
    private int homeTeam;
    private int awayTeam;
    private String gameDate;
    private int isPlayed;

    public MatchPairs() {
    }

    public MatchPairs(int mDay, int homeTeam, int awayTeam, String gameDate, int isPlayed) {
        this.mDay = mDay;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.gameDate = gameDate;
        this.isPlayed = isPlayed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(int homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(int awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public int getIsPlatyed() {
        return isPlayed;
    }

    public void setIsPlayed(int isPlayed) {
        this.isPlayed = isPlayed;
    }

    @Override
    public String toString() {
        return mDay + " " + homeTeam + " " + awayTeam;
    }
}
