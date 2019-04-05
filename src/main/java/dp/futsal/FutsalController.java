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
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/notplaying")
    public List<NotPlaying> getNotPlaying() {
        return dbService.getNotPlaying();
    }

    @GetMapping("/notplaying9")
    public List<NotPlaying9> getNotPlaying9() {
        return dbService.getNotPlaying9();
    }

    @GetMapping("/results5")
    public List<Results5> getResults5() {
        return dbService.getResults5();
    }

    @GetMapping("/results6")
    public List<Results6> getResults6() {
        return dbService.getResults6();
    }

    @GetMapping("/results7")
    public List<Results7> getResults7() {
        return dbService.getResults7();
    }

    @GetMapping("/results8")
    public List<Results8> getResults8() {
        return dbService.getResults8();
    }

    @GetMapping("/results9")
    public List<Results9> getResults9() {
        return dbService.getResults9();
    }

    @GetMapping("/table5")
    public List<Table5> getTable5() {
        return dbService.getTable5();
    }

    @GetMapping("/table6")
    public List<Table6> getTable6() {
        return dbService.getTable6();
    }

    @GetMapping("/table7")
    public List<Table7> getTable7() {
        return dbService.getTable7();
    }

    @GetMapping("/table8")
    public List<Table8> getTable8() {
        return dbService.getTable8();
    }

    @GetMapping("/table9")
    public List<Table9> getTable9() {
        return dbService.getTable9();
    }

    @GetMapping("/teams")
    public List<Teams> getTeams() {
        return dbService.getTeams();
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        return dbService.getUsers();
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
