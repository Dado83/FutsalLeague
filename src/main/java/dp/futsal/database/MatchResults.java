package dp.futsal.database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "results9")
public class MatchResults implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int mDay;
    private String homeTeam;
    private int homeTeamID;
    private String awayTeam;
    private int awayTeamID;
    private int goalsHome;
    private int goalsAway;

    public MatchResults() {

    }

    public MatchResults(int mDay, String homeTeam,int homeTeamID, String awayTeam,int awayTeamID, int goalsHome, int goalsAway) {
        this.mDay = mDay;
        this.homeTeam = homeTeam;
        this.homeTeamID = homeTeamID;
        this.awayTeam = awayTeam;
        this.awayTeamID = awayTeamID;
        this.goalsHome = goalsHome;
        this.goalsAway = goalsAway;
    }

    

    @Override
    public String toString() {
        return mDay + " " + homeTeam + " " + awayTeam + " (" + goalsHome + ":" + goalsAway +")";
    }
}
