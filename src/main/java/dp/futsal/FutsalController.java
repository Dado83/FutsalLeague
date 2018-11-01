package dp.futsal;

import dp.futsal.service.FutsalService;
import dp.futsal.service.MatchDayForm;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import dp.futsal.service.TeamForm;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FutsalController {

    private static final Logger LOGGER = Logger.getLogger(FutsalController.class.getName());
    @Autowired
    private FutsalService service;

    @PostConstruct
    public void init() {
        LOGGER.info("inside controller postconstruct");
        service.init();
    }

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("results5", service.getResults5());
        model.addAttribute("results6", service.getResults6());
        model.addAttribute("results7", service.getResults7());
        model.addAttribute("results8", service.getResults8());
        model.addAttribute("results9", service.getResults9());
        model.addAttribute("leagueTable5", service.getLeagueTable5());
        model.addAttribute("leagueTable6", service.getLeagueTable6());
        model.addAttribute("leagueTable7", service.getLeagueTable7());
        model.addAttribute("leagueTable8", service.getLeagueTable8());
        model.addAttribute("leagueTable9", service.getLeagueTable9());
        model.addAttribute("teamLinks", service.getTeamLinks5());
        model.addAttribute("teamLogos", service.getTeamLogos());
    }

    @GetMapping("/")
    public String index(Model model) {
        LOGGER.info("inside index");

        int lastMDay = service.getResults5().size();
        model.addAttribute("lastMDay", lastMDay);
        service.removeDummyTeam(service.getLeagueTable5());
        service.removeDummyTeam(service.getLeagueTable6());
        service.removeDummyTeam(service.getLeagueTable7());
        service.removeDummyTeam(service.getLeagueTable8());
        service.removeDummyTeam(service.getLeagueTable9());

        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String admin(Model model) {

        return "adminDashboard";
    }

    @GetMapping("/team")
    public String team(Model model, int index) {
        model.addAttribute("team5", service.getTeamLinks5().get(index));
        model.addAttribute("team6", service.getTeamLinks6().get(index));
        model.addAttribute("team7", service.getTeamLinks7().get(index));
        model.addAttribute("team8", service.getTeamLinks8().get(index));
        model.addAttribute("team9", service.getTeamLinks9().get(index));
        model.addAttribute("results5", service.getTeamLinks5().get(index).getResults());
        model.addAttribute("results6", service.getTeamLinks6().get(index).getResults());
        model.addAttribute("results7", service.getTeamLinks7().get(index).getResults());
        model.addAttribute("results8", service.getTeamLinks8().get(index).getResults());
        model.addAttribute("results9", service.getTeamLinks9().get(index).getResults());

        return "teamInfo";
    }

    @GetMapping("/admin/editTeam")
    public String editTeam5(Model model, int index) {
        model.addAttribute("team", service.getTeamLinks5().get(index));

        return "editTeam";
    }

    @PostMapping("/updatedTeam")
    public String updateTeam5(Model model, @ModelAttribute TeamForm team) {
        LOGGER.info("" + team.getTeamName());
        service.updateTeam(team);
        model.addAttribute("updatedTeam", team);
        LOGGER.info(service.getTeams5().toString());

        return "updatedTeam";
    }

    @GetMapping("/admin/enterMatchDayResults5")
    public String enterResults5(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, service.getTeamLinks5(), service.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("results", service.getResults5().get(index));

        return "enterMatchDayResults5";
    }

    @GetMapping("/admin/enterMatchDayResults6")
    public String enterResults6(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, service.getTeamLinks6(), service.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("results", service.getResults6().get(index));

        return "enterMatchDayResults6";
    }

    @GetMapping("/admin/enterMatchDayResults7")
    public String enterResults7(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, service.getTeamLinks7(), service.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("results", service.getResults7().get(index));

        return "enterMatchDayResults7";
    }

    @GetMapping("/admin/enterMatchDayResults8")
    public String enterResults8(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, service.getTeamLinks8(), service.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("results", service.getResults8().get(index));

        return "enterMatchDayResults8";
    }

    @GetMapping("/admin/enterMatchDayResults9")
    public String enterResults9(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, service.getTeamLinks9(), service.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("results", service.getResults9().get(index));

        return "enterMatchDayResults9";
    }

    @PostMapping("/addedMatchDayResults5")
    public String addedResults5(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(service.getTeams5());

        for (int i = 1; i < 11; i++) {
            service.getTeam5(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(service.getResults5(), service.getGamePostponed(), service.getNotPlaying());
        service.setTeams5(form.getTeamMap());
        service.updateTeamData5(service.getTeams5());
        model.addAttribute("result", form.getResults());
        LOGGER.info(service.getGamePostponed().toString());
        LOGGER.info(service.getNotPlaying().toString());

        return "addedResults";
    }

    @PostMapping("/addedMatchDayResults6")
    public String addedResults6(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(service.getTeams6());

        for (int i = 1; i < 11; i++) {
            service.getTeam6(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(service.getResults6(), service.getGamePostponed(), service.getNotPlaying());
        service.setTeams6(form.getTeamMap());
        service.updateTeamData6(service.getTeams6());
        model.addAttribute("result", form.getResults());

        return "addedResults";
    }

    @PostMapping("/addedMatchDayResults7")
    public String addedResults7(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(service.getTeams7());

        for (int i = 1; i < 11; i++) {
            service.getTeam7(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(service.getResults7(), service.getGamePostponed(), service.getNotPlaying());
        service.setTeams7(form.getTeamMap());
        service.updateTeamData7(service.getTeams7());
        model.addAttribute("result", form.getResults());

        return "addedResults";
    }

    @PostMapping("/addedMatchDayResults8")
    public String addedResults8(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(service.getTeams8());

        for (int i = 1; i < 11; i++) {
            service.getTeam8(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(service.getResults8(), service.getGamePostponed(), service.getNotPlaying());
        service.setTeams8(form.getTeamMap());
        service.updateTeamData8(service.getTeams8());
        model.addAttribute("result", form.getResults());

        return "addedResults";
    }

    @PostMapping("/addedMatchDayResults9")
    public String addedResults9(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(service.getTeams9());

        for (int i = 1; i < 11; i++) {
            service.getTeam9(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(service.getResults9(), service.getGamePostponed(), service.getNotPlaying());
        service.setTeams9(form.getTeamMap());
        service.updateTeamData9(service.getTeams9());
        model.addAttribute("result", form.getResults());

        return "addedResults";
    }

    @GetMapping("/results")
    public String results(Model model) {

        return "results";
    }

    @GetMapping("/fixtures")
    public String fixtures(Model model) {

        return "fixtures";
    }

    @GetMapping("/admin/save")
    public String save(Model model) {
        LOGGER.info("save");
        service.saveFutsalData();

        return "adminDashboard";
    }

    @GetMapping("/admin/deleteMDay")
    public String delMDay(Model model) {
        LOGGER.info("save");

        service.deleteLastMDay();
        service.updateTeamData5(service.getTeams5());
        service.updateTeamData6(service.getTeams6());
        service.updateTeamData7(service.getTeams7());
        service.updateTeamData8(service.getTeams8());
        service.updateTeamData9(service.getTeams9());

        return "adminDashboard";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError(Exception e) {
        LOGGER.severe("jebatanja bracala");
        e.printStackTrace();
    }

}
