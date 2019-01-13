package dp.futsal.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DatabaseService {

    @Autowired
    private MatchPairsRepo dbRepository;
    @Autowired
    private NotPlayingRepo notPlayingRepo;
    @Autowired
    private MatchResultsRepo matchResultsRepo;
    @Autowired
    private TeamsRepo teamsRepo;
    @Autowired
    private TablesRepo tablesRepo;

    public MatchPairs findRecord(String record) {
        return dbRepository.findByMDay(record);
    }

    public void saveRecord(MatchPairs table) {
        dbRepository.save(table);
    }
    
    public NotPlaying findRecordNotPlaying(String record) {
        return notPlayingRepo.findByMDay(record);
    }

    public void saveRecordNotPlaying(NotPlaying table) {
        notPlayingRepo.save(table);
    }
    
    public MatchResults findRecordMatchResults(String record) {
        return matchResultsRepo.findByMDay(record);
    }

    public void saveRecordMatchResults(MatchResults table) {
        matchResultsRepo.save(table);
    }

    public Teams findRecordTeams(String record) {
        return teamsRepo.findById(record);
    }

    public void saveRecordTeams(Teams table) {
        teamsRepo.save(table);
    }
    
    public Tables findRecordTables(String record) {
        return tablesRepo.findById(record);
    }

    public void saveRecordTables(Tables table) {
        tablesRepo.save(table);
    }
}