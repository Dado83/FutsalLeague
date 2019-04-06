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
    
    public List<NotPlaying> getNotPlayingByMday(int mDay) {
        return notPlaying.findByMDay(mDay);
    }
    
    public List<NotPlaying9> getNotPlaying9() {
        return notPlaying9.findAll();
    }
    
    public List<NotPlaying9> getNotPlaying9ByMday(int mDay) {
        return notPlaying9.findByMDay(mDay);
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
    
    public List getResultsByMday(int year, int mDay) {
        List results = new ArrayList();
        switch (year) {
            case 5:
                results = results5.findByMDay(mDay);
                break;
            case 6:
                results = results6.findByMDay(mDay);
                break;
            case 7:
                results = results7.findByMDay(mDay);
                break;
            case 8:
                results = results8.findByMDay(mDay);
                break;
            case 9:
                results = results9.findByMDay(mDay);
                break;
        }
        return results;
    }
    
    public List getTable(int year) {
        List table = new ArrayList();
        switch (year) {
            case 5:
                table = table5.findAll();
                break;
            case 6:
                table = table6.findAll();
                break;
            case 7:
                table = table7.findAll();
                break;
            case 8:
                table = table8.findAll();
                break;
            case 9:
                table = table9.findAll();
                break;
        }
        return table;
    }
    
    public List<Teams> getTeams() {
        return teams.findAll();
    }
    
    public Teams getTeamsById(int id) {
        return teams.findById(id);
    }
    
    public List<Users> getUsers() {
        return users.findAll();
    }
    
    public Users getUsersById(int id) {
        return users.findById(id);
    }
    
    public List<Visitors> getVisitors() {
        return visitors.findAll();
    }
}
