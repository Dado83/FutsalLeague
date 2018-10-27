package dp.futsal;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import dp.futsal.service.FutsalServiceB;
import dp.futsal.service.MatchDayFormA;
import dp.futsal.service.MatchDayFormB;
import dp.futsal.service.TeamForm;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FutsalControllerB {

    private static final Logger LOGGER = Logger.getLogger(FutsalControllerA.class.getName());
    @Autowired
    private FutsalServiceB serviceB;

    @PostConstruct
    public void init() {
        LOGGER.info("inside controller postconstruct");
        serviceB.init();
    }

    @GetMapping("/teamB")
    public String team(Model model, int index) {
        model.addAttribute("team5", serviceB.getTeamLinks5().get(index));
        model.addAttribute("team6", serviceB.getTeamLinks6().get(index));
        model.addAttribute("team7", serviceB.getTeamLinks7().get(index));
        model.addAttribute("team8", serviceB.getTeamLinks8().get(index));
        model.addAttribute("team9", serviceB.getTeamLinks9().get(index));
        model.addAttribute("results5", serviceB.getTeamLinks5().get(index).getResults());
        model.addAttribute("results6", serviceB.getTeamLinks6().get(index).getResults());
        model.addAttribute("results7", serviceB.getTeamLinks7().get(index).getResults());
        model.addAttribute("results8", serviceB.getTeamLinks8().get(index).getResults());
        model.addAttribute("results9", serviceB.getTeamLinks9().get(index).getResults());
        model.addAttribute("leagueTable", serviceB.getLeagueTable5());
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        return "teamInfo";
    }

    @GetMapping("/editTeamB")
    public String editTeam5(Model model, int index) {
        model.addAttribute("team", serviceB.getTeamLinks5().get(index));
        model.addAttribute("results", serviceB.getTeamLinks5().get(index).getResults());
        model.addAttribute("leagueTable", serviceB.getLeagueTable5());
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        return "editTeam";
    }

    @PostMapping("/updatedTeamB")
    public String updateTeam5(Model model, @ModelAttribute TeamForm team) {
        LOGGER.info("" + team.getTeamName());
        serviceB.updateTeam(team);
        model.addAttribute("updatedTeam", team);
        model.addAttribute("leagueTable", serviceB.getLeagueTable5());
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        LOGGER.info(serviceB.getTeams5().toString());
        return "updatedTeam";
    }

    @GetMapping("/enterMatchDayResults5B")
    public String enterResults5(Model model, int index) {
        MatchDayFormA mDayForm = new MatchDayFormA();
        mDayForm.loadForm(index, serviceB.getTeamLinks5(), serviceB.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("leagueTable", serviceB.getLeagueTable5());
        model.addAttribute("results", serviceB.getResults5().get(index));
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        return "enterMatchDayResults5B";
    }

    @GetMapping("/enterMatchDayResults6B")
    public String enterResults6(Model model, int index) {
        MatchDayFormA mDayForm = new MatchDayFormA();
        mDayForm.loadForm(index, serviceB.getTeamLinks6(), serviceB.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("leagueTable", serviceB.getLeagueTable6());
        model.addAttribute("results", serviceB.getResults6().get(index));
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        return "enterMatchDayResults6B";
    }

    @GetMapping("/enterMatchDayResults7B")
    public String enterResults7(Model model, int index) {
        MatchDayFormA mDayForm = new MatchDayFormA();
        mDayForm.loadForm(index, serviceB.getTeamLinks7(), serviceB.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("leagueTable", serviceB.getLeagueTable7());
        model.addAttribute("results", serviceB.getResults7().get(index));
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        return "enterMatchDayResults7B";
    }

    @GetMapping("/enterMatchDayResults8B")
    public String enterResults8(Model model, int index) {
        MatchDayFormA mDayForm = new MatchDayFormA();
        mDayForm.loadForm(index, serviceB.getTeamLinks8(), serviceB.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("leagueTable", serviceB.getLeagueTable8());
        model.addAttribute("results", serviceB.getResults8().get(index));
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        return "enterMatchDayResults8B";
    }

    @GetMapping("/enterMatchDayResults9B")
    public String enterResults9(Model model, int index) {
        MatchDayFormA mDayForm = new MatchDayFormA();
        mDayForm.loadForm(index, serviceB.getTeamLinks9(), serviceB.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("leagueTable", serviceB.getLeagueTable9());
        model.addAttribute("results", serviceB.getResults9().get(index));
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        return "enterMatchDayResults9B";
    }

    @PostMapping("/addedMatchDayResults5B")
    public String addedResults5(Model model, @ModelAttribute MatchDayFormB form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceB.getTeams5());

        for (int i = 1; i < 4; i++) {
            serviceB.getTeam5(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceB.getResults5(), serviceB.getGamePostponed(), serviceB.getNotPlaying());
        serviceB.setTeams5(form.getTeamMap());
        serviceB.updateTeamData5(serviceB.getTeams5());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("leagueTable", serviceB.getLeagueTable5());
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        LOGGER.info(serviceB.getGamePostponed().toString());
        LOGGER.info(serviceB.getNotPlaying().toString());
        return "addedResults";
    }

    @PostMapping("/addedMatchDayResults6B")
    public String addedResults6(Model model, @ModelAttribute MatchDayFormB form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceB.getTeams6());

        for (int i = 1; i < 4; i++) {
            serviceB.getTeam6(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceB.getResults6(), serviceB.getGamePostponed(), serviceB.getNotPlaying());
        serviceB.setTeams6(form.getTeamMap());
        serviceB.updateTeamData6(serviceB.getTeams6());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("leagueTable", serviceB.getLeagueTable6());
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        return "addedResults";
    }

    @PostMapping("/addedMatchDayResults7B")
    public String addedResults7(Model model, @ModelAttribute MatchDayFormB form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceB.getTeams7());

        for (int i = 1; i < 4; i++) {
            serviceB.getTeam7(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceB.getResults7(), serviceB.getGamePostponed(), serviceB.getNotPlaying());
        serviceB.setTeams7(form.getTeamMap());
        serviceB.updateTeamData7(serviceB.getTeams7());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("leagueTable", serviceB.getLeagueTable7());
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        return "addedResults";
    }

    @PostMapping("/addedMatchDayResults8B")
    public String addedResults8(Model model, @ModelAttribute MatchDayFormB form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceB.getTeams8());

        for (int i = 1; i < 4; i++) {
            serviceB.getTeam8(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceB.getResults8(), serviceB.getGamePostponed(), serviceB.getNotPlaying());
        serviceB.setTeams8(form.getTeamMap());
        serviceB.updateTeamData8(serviceB.getTeams8());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("leagueTable", serviceB.getLeagueTable8());
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        return "addedResults";
    }

    @PostMapping("/addedMatchDayResults9B")
    public String addedResults9(Model model, @ModelAttribute MatchDayFormB form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceB.getTeams9());

        for (int i = 1; i < 4; i++) {
            serviceB.getTeam9(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceB.getResults9(), serviceB.getGamePostponed(), serviceB.getNotPlaying());
        serviceB.setTeams9(form.getTeamMap());
        serviceB.updateTeamData9(serviceB.getTeams9());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("leagueTable", serviceB.getLeagueTable9());
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        return "addedResults";
    }

    @GetMapping("/resultsB")
    public String results(Model model) {
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("results5", serviceB.getResults5());
        model.addAttribute("results6", serviceB.getResults6());
        model.addAttribute("results7", serviceB.getResults7());
        model.addAttribute("results8", serviceB.getResults8());
        model.addAttribute("results9", serviceB.getResults9());
        model.addAttribute("leagueTable5", serviceB.getLeagueTable5());
        model.addAttribute("leagueTable6", serviceB.getLeagueTable6());
        model.addAttribute("leagueTable7", serviceB.getLeagueTable7());
        model.addAttribute("leagueTable8", serviceB.getLeagueTable8());
        model.addAttribute("leagueTable9", serviceB.getLeagueTable9());
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        return "results";
    }

    @GetMapping("/fixturesB")
    public String fixtures(Model model) {
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("results5", serviceB.getResults5());
        model.addAttribute("results6", serviceB.getResults6());
        model.addAttribute("results7", serviceB.getResults7());
        model.addAttribute("results8", serviceB.getResults8());
        model.addAttribute("results9", serviceB.getResults9());
        model.addAttribute("leagueTable5", serviceB.getLeagueTable5());
        model.addAttribute("leagueTable6", serviceB.getLeagueTable6());
        model.addAttribute("leagueTable7", serviceB.getLeagueTable7());
        model.addAttribute("leagueTable8", serviceB.getLeagueTable8());
        model.addAttribute("leagueTable9", serviceB.getLeagueTable9());
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        return "fixtures";
    }

    @GetMapping("/saveB")
    public String save(Model model) {
        LOGGER.info("save");
        model.addAttribute("leagueTable", serviceB.getLeagueTable5());
        model.addAttribute("results", serviceB.getResults5());
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        serviceB.saveFutsalData();
        return "adminDashboard";
    }

    @GetMapping("/deleteMDayB")
    public String delMDay(Model model) {
        LOGGER.info("save");
        model.addAttribute("leagueTable", serviceB.getLeagueTable5());
        model.addAttribute("results", serviceB.getResults5());
        model.addAttribute("pairs", serviceB.getPairs());
        model.addAttribute("teamLinks", serviceB.getTeamLinks5());
        model.addAttribute("teamLogos", serviceB.getTeamLogos());
        serviceB.deleteLastMDay();
        serviceB.updateTeamData5(serviceB.getTeams5());
        serviceB.updateTeamData6(serviceB.getTeams6());
        serviceB.updateTeamData7(serviceB.getTeams7());
        serviceB.updateTeamData8(serviceB.getTeams8());
        serviceB.updateTeamData9(serviceB.getTeams9());
        return "adminDashboard";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError(Exception e) {
        LOGGER.severe("jebatanja bracala");
        e.printStackTrace();
    }

}
