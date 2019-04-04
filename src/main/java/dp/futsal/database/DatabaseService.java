package dp.futsal.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DatabaseService {

    @Autowired
    private Results5Repo dbRepository;
    @Autowired
    private NotPlayingRepo notPlayingRepo;
    
    @Autowired
    private TeamsRepo teamsRepo;
    

    public Results5 findRecord(String record) {
        return dbRepository.findByMDay(record);
    }

    public void saveRecord(Results5 table) {
        dbRepository.save(table);
    }
    
    public NotPlaying findRecordNotPlaying(String record) {
        return notPlayingRepo.findByMDay(record);
    }

    public void saveRecordNotPlaying(NotPlaying table) {
        notPlayingRepo.save(table);
    }
    
   

    public Teams findRecordTeams(String record) {
        return teamsRepo.findById(record);
    }

    public void saveRecordTeams(Teams table) {
        teamsRepo.save(table);
    }
    
    
}