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
import dp.futsal.service.FutsalServiceA;
import dp.futsal.service.FutsalServiceB;
import dp.futsal.service.MatchDayForm;
import dp.futsal.service.TeamForm;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FutsalControllerA {

    private static final Logger LOGGER = Logger.getLogger(FutsalControllerA.class.getName());
    @Autowired
    private FutsalServiceA serviceA;
    @Autowired
    private FutsalServiceB serviceB;

    @PostConstruct
    public void init() {
        LOGGER.info("inside controller postconstruct");
        serviceA.init();
    }

    @GetMapping("/")
    public String index(Model model) {
        LOGGER.info("inside index");
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("results5", serviceA.getResults5());
        model.addAttribute("results6", serviceA.getResults6());
        model.addAttribute("results7", serviceA.getResults7());
        model.addAttribute("results8", serviceA.getResults8());
        model.addAttribute("results9", serviceA.getResults9());
        int lastMDay = serviceA.getResults5().size();
        model.addAttribute("lastMDay", lastMDay);
        serviceA.removeDummyTeam(serviceA.getLeagueTable5());
        serviceA.removeDummyTeam(serviceA.getLeagueTable6());
        serviceA.removeDummyTeam(serviceA.getLeagueTable7());
        serviceA.removeDummyTeam(serviceA.getLeagueTable8());
        serviceA.removeDummyTeam(serviceA.getLeagueTable9());
        model.addAttribute("leagueTable5", serviceA.getLeagueTable5());
        model.addAttribute("leagueTable6", serviceA.getLeagueTable6());
        model.addAttribute("leagueTable7", serviceA.getLeagueTable7());
        model.addAttribute("leagueTable8", serviceA.getLeagueTable8());
        model.addAttribute("leagueTable9", serviceA.getLeagueTable9());
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        return "index";
    }

    @GetMapping("/team")
    public String team(Model model, int index) {
        model.addAttribute("team5", serviceA.getTeamLinks5().get(index));
        model.addAttribute("team6", serviceA.getTeamLinks6().get(index));
        model.addAttribute("team7", serviceA.getTeamLinks7().get(index));
        model.addAttribute("team8", serviceA.getTeamLinks8().get(index));
        model.addAttribute("team9", serviceA.getTeamLinks9().get(index));
        model.addAttribute("results5", serviceA.getTeamLinks5().get(index).getResults());
        model.addAttribute("results6", serviceA.getTeamLinks6().get(index).getResults());
        model.addAttribute("results7", serviceA.getTeamLinks7().get(index).getResults());
        model.addAttribute("results8", serviceA.getTeamLinks8().get(index).getResults());
        model.addAttribute("results9", serviceA.getTeamLinks9().get(index).getResults());
        model.addAttribute("leagueTable", serviceA.getLeagueTable5());
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        return "teamInfo";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("leagueTable", serviceA.getLeagueTable5());
        model.addAttribute("results", serviceA.getResults5());
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        return "adminDashboard";
    }

    @GetMapping("/editTeam")
    public String editTeam5(Model model, int index) {
        model.addAttribute("team", serviceA.getTeamLinks5().get(index));
        model.addAttribute("results", serviceA.getTeamLinks5().get(index).getResults());
        model.addAttribute("leagueTable", serviceA.getLeagueTable5());
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        return "editTeam";
    }

    @PostMapping("/updatedTeam")
    public String updateTeam5(Model model, @ModelAttribute TeamForm team) {
        LOGGER.info("" + team.getTeamName());
        serviceA.updateTeam(team);
        model.addAttribute("updatedTeam", team);
        model.addAttribute("leagueTable", serviceA.getLeagueTable5());
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        LOGGER.info(serviceA.getTeams5().toString());
        return "updatedTeam";
    }

    @GetMapping("/enterMatchDayResults5")
    public String enterResults5(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, serviceA.getTeamLinks5(), serviceA.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("leagueTable", serviceA.getLeagueTable5());
        model.addAttribute("results", serviceA.getResults5().get(index));
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        return "enterMatchDayResults5";
    }

    @GetMapping("/enterMatchDayResults6")
    public String enterResults6(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, serviceA.getTeamLinks6(), serviceA.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("leagueTable", serviceA.getLeagueTable6());
        model.addAttribute("results", serviceA.getResults6().get(index));
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        return "enterMatchDayResults6";
    }

    @GetMapping("/enterMatchDayResults7")
    public String enterResults7(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, serviceA.getTeamLinks7(), serviceA.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("leagueTable", serviceA.getLeagueTable7());
        model.addAttribute("results", serviceA.getResults7().get(index));
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        return "enterMatchDayResults7";
    }

    @GetMapping("/enterMatchDayResults8")
    public String enterResults8(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, serviceA.getTeamLinks8(), serviceA.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("leagueTable", serviceA.getLeagueTable8());
        model.addAttribute("results", serviceA.getResults8().get(index));
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        return "enterMatchDayResults8";
    }

    @GetMapping("/enterMatchDayResults9")
    public String enterResults9(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, serviceA.getTeamLinks9(), serviceA.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("leagueTable", serviceA.getLeagueTable9());
        model.addAttribute("results", serviceA.getResults9().get(index));
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        return "enterMatchDayResults9";
    }

    @PostMapping("/addedMatchDayResults5")
    public String addedResults5(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceA.getTeams5());

        for (int i = 1; i < 11; i++) {
            serviceA.getTeam5(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceA.getResults5(), serviceA.getGamePostponed(), serviceA.getNotPlaying());
        serviceA.setTeams5(form.getTeamMap());
        serviceA.updateTeamData5(serviceA.getTeams5());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("leagueTable", serviceA.getLeagueTable5());
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        LOGGER.info(serviceA.getGamePostponed().toString());
        LOGGER.info(serviceA.getNotPlaying().toString());
        return "addedResults";
    }

    @PostMapping("/addedMatchDayResults6")
    public String addedResults6(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceA.getTeams6());

        for (int i = 1; i < 11; i++) {
            serviceA.getTeam6(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceA.getResults6(), serviceA.getGamePostponed(), serviceA.getNotPlaying());
        serviceA.setTeams6(form.getTeamMap());
        serviceA.updateTeamData6(serviceA.getTeams6());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("leagueTable", serviceA.getLeagueTable6());
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        return "addedResults";
    }

    @PostMapping("/addedMatchDayResults7")
    public String addedResults7(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceA.getTeams7());

        for (int i = 1; i < 11; i++) {
            serviceA.getTeam7(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceA.getResults7(), serviceA.getGamePostponed(), serviceA.getNotPlaying());
        serviceA.setTeams7(form.getTeamMap());
        serviceA.updateTeamData7(serviceA.getTeams7());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("leagueTable", serviceA.getLeagueTable7());
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        return "addedResults";
    }

    @PostMapping("/addedMatchDayResults8")
    public String addedResults8(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceA.getTeams8());

        for (int i = 1; i < 11; i++) {
            serviceA.getTeam8(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceA.getResults8(), serviceA.getGamePostponed(), serviceA.getNotPlaying());
        serviceA.setTeams8(form.getTeamMap());
        serviceA.updateTeamData8(serviceA.getTeams8());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("leagueTable", serviceA.getLeagueTable8());
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        return "addedResults";
    }

    @PostMapping("/addedMatchDayResults9")
    public String addedResults9(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceA.getTeams9());

        for (int i = 1; i < 11; i++) {
            serviceA.getTeam9(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceA.getResults9(), serviceA.getGamePostponed(), serviceA.getNotPlaying());
        serviceA.setTeams9(form.getTeamMap());
        serviceA.updateTeamData9(serviceA.getTeams9());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("leagueTable", serviceA.getLeagueTable9());
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        return "addedResults";
    }

    @GetMapping("/results")
    public String results(Model model) {
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("results5", serviceA.getResults5());
        model.addAttribute("results6", serviceA.getResults6());
        model.addAttribute("results7", serviceA.getResults7());
        model.addAttribute("results8", serviceA.getResults8());
        model.addAttribute("results9", serviceA.getResults9());
        model.addAttribute("leagueTable5", serviceA.getLeagueTable5());
        model.addAttribute("leagueTable6", serviceA.getLeagueTable6());
        model.addAttribute("leagueTable7", serviceA.getLeagueTable7());
        model.addAttribute("leagueTable8", serviceA.getLeagueTable8());
        model.addAttribute("leagueTable9", serviceA.getLeagueTable9());
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        return "results";
    }

    @GetMapping("/fixtures")
    public String fixtures(Model model) {
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("results5", serviceA.getResults5());
        model.addAttribute("results6", serviceA.getResults6());
        model.addAttribute("results7", serviceA.getResults7());
        model.addAttribute("results8", serviceA.getResults8());
        model.addAttribute("results9", serviceA.getResults9());
        model.addAttribute("leagueTable5", serviceA.getLeagueTable5());
        model.addAttribute("leagueTable6", serviceA.getLeagueTable6());
        model.addAttribute("leagueTable7", serviceA.getLeagueTable7());
        model.addAttribute("leagueTable8", serviceA.getLeagueTable8());
        model.addAttribute("leagueTable9", serviceA.getLeagueTable9());
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        return "fixtures";
    }

    @GetMapping("/save")
    public String save(Model model) {
        LOGGER.info("save");
        model.addAttribute("leagueTable", serviceA.getLeagueTable5());
        model.addAttribute("results", serviceA.getResults5());
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        serviceA.saveFutsalData();
        return "adminDashboard";
    }

    @GetMapping("/deleteMDay")
    public String delMDay(Model model) {
        LOGGER.info("save");
        model.addAttribute("leagueTable", serviceA.getLeagueTable5());
        model.addAttribute("results", serviceA.getResults5());
        model.addAttribute("pairs", serviceA.getPairs());
        model.addAttribute("teamLinks", serviceA.getTeamLinks5());
        model.addAttribute("teamLogos", serviceA.getTeamLogos());
        serviceA.deleteLastMDay();
        serviceA.updateTeamData5(serviceA.getTeams5());
        serviceA.updateTeamData6(serviceA.getTeams6());
        serviceA.updateTeamData7(serviceA.getTeams7());
        serviceA.updateTeamData8(serviceA.getTeams8());
        serviceA.updateTeamData9(serviceA.getTeams9());
        return "adminDashboard";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError(Exception e) {
        LOGGER.severe("jebatanja bracala");
        e.printStackTrace();
    }

}
