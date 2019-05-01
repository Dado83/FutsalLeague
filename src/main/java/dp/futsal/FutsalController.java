package dp.futsal;

import dp.futsal.database.DatabaseService;
import dp.futsal.database.MatchPairs;
import dp.futsal.database.Results;
import dp.futsal.database.Teams;
import dp.futsal.database.Users;
import dp.futsal.database.Visitors;
import dp.futsal.form.MatchResultForm;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
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

    @GetMapping("/pairsToPlay")
    public List<MatchPairs> getPairsToPlay() {
        return dbService.getPairsNotPlayed();
    }

    @GetMapping("/pairs/{mday}")
    public List<MatchPairs> getPairsByMday(@PathVariable int mDay) {
        return dbService.getPairsByMday(mDay);
    }

    @GetMapping("/results/{year}")
    public List getResults(@PathVariable int sel) {
        return dbService.getResults(sel);
    }

    @GetMapping("/results/{year}/{mday}")
    public List getResultsByMday(@PathVariable int sel, @PathVariable int mDay) {
        return dbService.getResultsByMday(sel, mDay);
    }

    @GetMapping("/results/id/{id}")
    public Results getResultsById(@PathVariable int id) {
        return dbService.getResultsById(id);
    }

    @PostMapping("/result/input")
    public String inputResult(@ModelAttribute MatchResultForm form) {
        LOGGER.info("test metoda pozvana");

        dbService.saveGame(form);

        return form.toString();

    }

    @GetMapping("/result/delete/{id}")
    public String deleteResult(@PathVariable int id) {
        return "";
    }

    @GetMapping("/table/{year}")
    public List getTable(@PathVariable int sel) {
        return dbService.getTable(sel);
    }

    @GetMapping("/teams")
    public List<Teams> getTeams() {
        return dbService.getTeams();
    }

    @GetMapping("/teams/id/{id}")
    public Teams getTeamsById(@PathVariable int id) {
        return dbService.getTeamsById(id);
    }

    @GetMapping("/teams/search/{search}")
    public List<Teams> searchTeams(@PathVariable String search) {
        return dbService.searchTeams(search);
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        return dbService.getUsers();
    }

    @GetMapping("/users/id/{id}")
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
