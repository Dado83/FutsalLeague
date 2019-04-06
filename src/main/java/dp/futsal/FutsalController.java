package dp.futsal;

import dp.futsal.database.DatabaseService;
import dp.futsal.database.MatchPairs;
import dp.futsal.database.NotPlaying;
import dp.futsal.database.NotPlaying9;
import dp.futsal.database.Results5;
import dp.futsal.database.Results6;
import dp.futsal.database.Results7;
import dp.futsal.database.Results8;
import dp.futsal.database.Results9;
import dp.futsal.database.Table5;
import dp.futsal.database.Table6;
import dp.futsal.database.Table7;
import dp.futsal.database.Table8;
import dp.futsal.database.Table9;
import dp.futsal.database.Teams;
import dp.futsal.database.Users;
import dp.futsal.database.Visitors;
import dp.futsal.service.FutsalService;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FutsalController {
    
    private static final Logger LOGGER = Logger.getLogger(FutsalController.class.getName());
    @Autowired
    private DatabaseService dbService;
    
    @GetMapping("/")
    public String index() {
        return "Fair Play Liga Buducih Sampiona";
    }
    
    @GetMapping("/pairs")
    public List<MatchPairs> getPairs() {
        return dbService.getPairs();
    }
    
    @GetMapping("/pairs/{mday}")
    public List<MatchPairs> getPairsByMday(@PathVariable int mday) {
        return dbService.getPairsByMday(mday);
    }
    
    @GetMapping("/notplaying")
    public List<NotPlaying> getNotPlaying() {
        return dbService.getNotPlaying();
    }
    
    @GetMapping("/notplaying/{mday}")
    public List<NotPlaying> getNotPlayingByMday(@PathVariable int mday) {
        return dbService.getNotPlayingByMday(mday);
    }
    
    @GetMapping("/notplaying9")
    public List<NotPlaying9> getNotPlaying9() {
        return dbService.getNotPlaying9();
    }
    
    @GetMapping("/notplaying9/{mday}")
    public List<NotPlaying9> getNotPlaying9ByMday(@PathVariable int mday) {
        return dbService.getNotPlaying9ByMday(mday);
    }
    
    @GetMapping("/results/{year}")
    public List getResults(@PathVariable int year) {
        return dbService.getResults(year);
    }
    
    @GetMapping("/results/{year}/{mday}")
    public List getResultsByMday(@PathVariable int year, @PathVariable int mday) {
        return dbService.getResultsByMday(year, mday);
    }
    
    @GetMapping("/table/{year}")
    public List getTable(@PathVariable int year) {
        return dbService.getTable(year);
    }
    
    @GetMapping("/teams")
    public List<Teams> getTeams() {
        return dbService.getTeams();
    }
    
    @GetMapping("/teams/{id}")
    public Teams getTeamsById(@PathVariable int id) {
        return dbService.getTeamsById(id);
    }
    
    @GetMapping("/users")
    public List<Users> getUsers() {
        return dbService.getUsers();
    }
    
    @GetMapping("/users/{id}")
    public Users getUsersById(@PathVariable int id) {
        return dbService.getUsersById(id);
    }
    
    @GetMapping("/visitors")
    public List<Visitors> getVisitors() {
        return dbService.getVisitors();
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError(Exception e) {
        LOGGER.severe("jebatanja bracala");
        e.printStackTrace();
    }
    
}
