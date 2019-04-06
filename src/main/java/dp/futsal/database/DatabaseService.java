package dp.futsal.database;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DatabaseService {

    @Autowired
    private MatchPairsRepo matchPairs;
    @Autowired
    private NotPlayingRepo notPlaying;
    @Autowired
    private NotPlaying9Repo notPlaying9;
    @Autowired
    private Results5Repo results5;
    @Autowired
    private Results6Repo results6;
    @Autowired
    private Results7Repo results7;
    @Autowired
    private Results8Repo results8;
    @Autowired
    private Results9Repo results9;
    @Autowired
    private Table5Repo table5;
    @Autowired
    private Table6Repo table6;
    @Autowired
    private Table7Repo table7;
    @Autowired
    private Table8Repo table8;
    @Autowired
    private Table9Repo table9;
    @Autowired
    private TeamsRepo teams;
    @Autowired
    private UsersRepo users;
    @Autowired
    private VisitorsRepo visitors;

    public List<MatchPairs> getPairs() {
        return matchPairs.findAll();
    }

    public List<MatchPairs> getPairsByMday(int mDay) {
        return matchPairs.findByMDay(mDay);
    }

    public List<NotPlaying> getNotPlaying() {
        return notPlaying.findAll();
    }

    public List<NotPlaying9> getNotPlaying9() {
        return notPlaying9.findAll();
    }

    public List getResults(int year) {
        List results = new ArrayList();
        switch (year) {
            case 5:
                results = results5.findAll();
                break;
            case 6:
                results = results6.findAll();
                break;
            case 7:
                results = results7.findAll();
                break;
            case 8:
                results = results8.findAll();
                break;
            case 9:
                results = results9.findAll();
                break;
        }
        return results;
    }

    

    public List<Table5> getTable5() {
        return table5.findAll();
    }

    public List<Table6> getTable6() {
        return table6.findAll();
    }

    public List<Table7> getTable7() {
        return table7.findAll();
    }

    public List<Table8> getTable8() {
        return table8.findAll();
    }

    public List<Table9> getTable9() {
        return table9.findAll();
    }

    public List<Teams> getTeams() {
        return teams.findAll();
    }

    public List<Users> getUsers() {
        return users.findAll();
    }

    public List<Visitors> getVisitors() {
        return visitors.findAll();
    }
}
