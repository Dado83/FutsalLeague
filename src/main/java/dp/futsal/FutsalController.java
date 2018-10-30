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
import dp.futsal.service.notUsed.FutsalServiceA;
import dp.futsal.service.notUsed.FutsalServiceB;
import dp.futsal.service.notUsed.MatchDayFormA;
import dp.futsal.service.notUsed.MatchDayFormB;
import dp.futsal.service.TeamForm;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FutsalController {

    private static final Logger LOGGER = Logger.getLogger(FutsalController.class.getName());
    @Autowired
    private FutsalServiceA serviceA;
    @Autowired
    private FutsalServiceB serviceB;

    @PostConstruct
    public void init() {
        LOGGER.info("inside controller postconstruct");
        serviceA.init();
        serviceB.init();
    }

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        model.addAttribute("pairsA", serviceA.getPairs());
        model.addAttribute("results5A", serviceA.getResults5());
        model.addAttribute("results6A", serviceA.getResults6());
        model.addAttribute("results7A", serviceA.getResults7());
        model.addAttribute("results8A", serviceA.getResults8());
        model.addAttribute("results9A", serviceA.getResults9());
        model.addAttribute("leagueTable5A", serviceA.getLeagueTable5());
        model.addAttribute("leagueTable6A", serviceA.getLeagueTable6());
        model.addAttribute("leagueTable7A", serviceA.getLeagueTable7());
        model.addAttribute("leagueTable8A", serviceA.getLeagueTable8());
        model.addAttribute("leagueTable9A", serviceA.getLeagueTable9());
        model.addAttribute("teamLinksA", serviceA.getTeamLinks5());
        model.addAttribute("teamLogosA", serviceA.getTeamLogos());

        model.addAttribute("pairsB", serviceB.getPairs());
        model.addAttribute("results5B", serviceB.getResults5());
        model.addAttribute("results6B", serviceB.getResults6());
        model.addAttribute("results7B", serviceB.getResults7());
        model.addAttribute("results8B", serviceB.getResults8());
        model.addAttribute("results9B", serviceB.getResults9());
        model.addAttribute("leagueTable5B", serviceB.getLeagueTable5());
        model.addAttribute("leagueTable6B", serviceB.getLeagueTable6());
        model.addAttribute("leagueTable7B", serviceB.getLeagueTable7());
        model.addAttribute("leagueTable8B", serviceB.getLeagueTable8());
        model.addAttribute("leagueTable9B", serviceB.getLeagueTable9());
        model.addAttribute("teamLinksB", serviceB.getTeamLinks5());
        model.addAttribute("teamLogosB", serviceB.getTeamLogos());
    }

    @GetMapping("/")
    public String index(Model model) {
        LOGGER.info("inside index");

        int lastMDay = serviceA.getResults5().size();
        model.addAttribute("lastMDayA", lastMDay);
        serviceA.removeDummyTeam(serviceA.getLeagueTable5());
        serviceA.removeDummyTeam(serviceA.getLeagueTable6());
        serviceA.removeDummyTeam(serviceA.getLeagueTable7());
        serviceA.removeDummyTeam(serviceA.getLeagueTable8());
        serviceA.removeDummyTeam(serviceA.getLeagueTable9());

        int lastMDayB = serviceA.getResults5().size();
        model.addAttribute("lastMDayB", lastMDayB);
        serviceB.removeDummyTeam(serviceB.getLeagueTable5());
        serviceB.removeDummyTeam(serviceB.getLeagueTable6());
        serviceB.removeDummyTeam(serviceB.getLeagueTable7());
        serviceB.removeDummyTeam(serviceB.getLeagueTable8());
        serviceB.removeDummyTeam(serviceB.getLeagueTable9());

        return "index";
    }

    @GetMapping("/adminA")
    public String adminA(Model model) {

        return "adminDashboardA";
    }

    @GetMapping("/teamA")
    public String teamA(Model model, int index) {
        model.addAttribute("team5A", serviceA.getTeamLinks5().get(index));
        model.addAttribute("team6A", serviceA.getTeamLinks6().get(index));
        model.addAttribute("team7A", serviceA.getTeamLinks7().get(index));
        model.addAttribute("team8A", serviceA.getTeamLinks8().get(index));
        model.addAttribute("team9A", serviceA.getTeamLinks9().get(index));
        model.addAttribute("results5A", serviceA.getTeamLinks5().get(index).getResults());
        model.addAttribute("results6A", serviceA.getTeamLinks6().get(index).getResults());
        model.addAttribute("results7A", serviceA.getTeamLinks7().get(index).getResults());
        model.addAttribute("results8A", serviceA.getTeamLinks8().get(index).getResults());
        model.addAttribute("results9A", serviceA.getTeamLinks9().get(index).getResults());

        return "teamInfoA";
    }

    @GetMapping("/editTeamA")
    public String editTeam5A(Model model, int index) {
        model.addAttribute("teamA", serviceA.getTeamLinks5().get(index));

        return "editTeamA";
    }

    @PostMapping("/updatedTeamA")
    public String updateTeam5A(Model model, @ModelAttribute TeamForm team) {
        LOGGER.info("" + team.getTeamName());
        serviceA.updateTeam(team);
        model.addAttribute("updatedTeamA", team);
        LOGGER.info(serviceA.getTeams5().toString());

        return "updatedTeamA";
    }

    @GetMapping("/enterMatchDayResults5A")
    public String enterResults5A(Model model, int index) {
        MatchDayFormA mDayForm = new MatchDayFormA();
        mDayForm.loadForm(index, serviceA.getTeamLinks5(), serviceA.getPairs());
        model.addAttribute("gameFormA", mDayForm);
        model.addAttribute("resultsA", serviceA.getResults5().get(index));

        return "enterMatchDayResults5A";
    }

    @GetMapping("/enterMatchDayResults6A")
    public String enterResults6A(Model model, int index) {
        MatchDayFormA mDayForm = new MatchDayFormA();
        mDayForm.loadForm(index, serviceA.getTeamLinks6(), serviceA.getPairs());
        model.addAttribute("gameFormA", mDayForm);
        model.addAttribute("resultsA", serviceA.getResults6().get(index));

        return "enterMatchDayResults6A";
    }

    @GetMapping("/enterMatchDayResults7A")
    public String enterResults7A(Model model, int index) {
        MatchDayFormA mDayForm = new MatchDayFormA();
        mDayForm.loadForm(index, serviceA.getTeamLinks7(), serviceA.getPairs());
        model.addAttribute("gameFormA", mDayForm);
        model.addAttribute("resultsA", serviceA.getResults7().get(index));

        return "enterMatchDayResults7A";
    }

    @GetMapping("/enterMatchDayResults8A")
    public String enterResults8A(Model model, int index) {
        MatchDayFormA mDayForm = new MatchDayFormA();
        mDayForm.loadForm(index, serviceA.getTeamLinks8(), serviceA.getPairs());
        model.addAttribute("gameFormA", mDayForm);
        model.addAttribute("resultsA", serviceA.getResults8().get(index));

        return "enterMatchDayResults8A";
    }

    @GetMapping("/enterMatchDayResults9A")
    public String enterResults9A(Model model, int index) {
        MatchDayFormA mDayForm = new MatchDayFormA();
        mDayForm.loadForm(index, serviceA.getTeamLinks9(), serviceA.getPairs());
        model.addAttribute("gameFormA", mDayForm);
        model.addAttribute("resultsA", serviceA.getResults9().get(index));

        return "enterMatchDayResults9A";
    }

    @PostMapping("/addedMatchDayResults5A")
    public String addedResults5A(Model model, @ModelAttribute MatchDayFormA form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceA.getTeams5());

        for (int i = 1; i < 6; i++) {
            serviceA.getTeam5(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceA.getResults5(), serviceA.getGamePostponed(), serviceA.getNotPlaying());
        serviceA.setTeams5(form.getTeamMap());
        serviceA.updateTeamData5(serviceA.getTeams5());
        model.addAttribute("resultA", form.getResults());
        LOGGER.info(serviceA.getGamePostponed().toString());
        LOGGER.info(serviceA.getNotPlaying().toString());

        return "addedResultsA";
    }

    @PostMapping("/addedMatchDayResults6A")
    public String addedResults6A(Model model, @ModelAttribute MatchDayFormA form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceA.getTeams6());

        for (int i = 1; i < 6; i++) {
            serviceA.getTeam6(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceA.getResults6(), serviceA.getGamePostponed(), serviceA.getNotPlaying());
        serviceA.setTeams6(form.getTeamMap());
        serviceA.updateTeamData6(serviceA.getTeams6());
        model.addAttribute("resultA", form.getResults());

        return "addedResultsA";
    }

    @PostMapping("/addedMatchDayResults7A")
    public String addedResults7A(Model model, @ModelAttribute MatchDayFormA form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceA.getTeams7());

        for (int i = 1; i < 6; i++) {
            serviceA.getTeam7(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceA.getResults7(), serviceA.getGamePostponed(), serviceA.getNotPlaying());
        serviceA.setTeams7(form.getTeamMap());
        serviceA.updateTeamData7(serviceA.getTeams7());
        model.addAttribute("resultA", form.getResults());

        return "addedResultsA";
    }

    @PostMapping("/addedMatchDayResults8A")
    public String addedResults8A(Model model, @ModelAttribute MatchDayFormA form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceA.getTeams8());

        for (int i = 1; i < 6; i++) {
            serviceA.getTeam8(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceA.getResults8(), serviceA.getGamePostponed(), serviceA.getNotPlaying());
        serviceA.setTeams8(form.getTeamMap());
        serviceA.updateTeamData8(serviceA.getTeams8());
        model.addAttribute("resultA", form.getResults());

        return "addedResultsA";
    }

    @PostMapping("/addedMatchDayResults9A")
    public String addedResults9A(Model model, @ModelAttribute MatchDayFormA form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceA.getTeams9());

        for (int i = 1; i < 6; i++) {
            serviceA.getTeam9(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceA.getResults9(), serviceA.getGamePostponed(), serviceA.getNotPlaying());
        serviceA.setTeams9(form.getTeamMap());
        serviceA.updateTeamData9(serviceA.getTeams9());
        model.addAttribute("resultA", form.getResults());

        return "addedResultsA";
    }

    @GetMapping("/resultsA")
    public String resultsA(Model model) {

        return "resultsA";
    }

    @GetMapping("/fixturesA")
    public String fixturesA(Model model) {

        return "fixturesA";
    }

    @GetMapping("/saveA")
    public String saveA(Model model) {
        LOGGER.info("save");
        serviceA.saveFutsalData();

        return "adminDashboardA";
    }

    @GetMapping("/deleteMDayA")
    public String delMDayA(Model model) {
        LOGGER.info("save");

        serviceA.deleteLastMDay();
        serviceA.updateTeamData5(serviceA.getTeams5());
        serviceA.updateTeamData6(serviceA.getTeams6());
        serviceA.updateTeamData7(serviceA.getTeams7());
        serviceA.updateTeamData8(serviceA.getTeams8());
        serviceA.updateTeamData9(serviceA.getTeams9());

        return "adminDashboardA";
    }

    @GetMapping("/adminB")
    public String adminB(Model model) {

        return "adminDashboardB";
    }

    @GetMapping("/teamB")
    public String teamB(Model model, int index) {
        model.addAttribute("team5B", serviceB.getTeamLinks5().get(index));
        model.addAttribute("team6B", serviceB.getTeamLinks6().get(index));
        model.addAttribute("team7B", serviceB.getTeamLinks7().get(index));
        model.addAttribute("team8B", serviceB.getTeamLinks8().get(index));
        model.addAttribute("team9B", serviceB.getTeamLinks9().get(index));
        model.addAttribute("results5B", serviceB.getTeamLinks5().get(index).getResults());
        model.addAttribute("results6B", serviceB.getTeamLinks6().get(index).getResults());
        model.addAttribute("results7B", serviceB.getTeamLinks7().get(index).getResults());
        model.addAttribute("results8B", serviceB.getTeamLinks8().get(index).getResults());
        model.addAttribute("results9B", serviceB.getTeamLinks9().get(index).getResults());

        return "teamInfoB";
    }

    @GetMapping("/editTeamB")
    public String editTeam5B(Model model, int index) {
        model.addAttribute("teamB", serviceB.getTeamLinks5().get(index));

        return "editTeamB";
    }

    @PostMapping("/updatedTeamB")
    public String updateTeam5B(Model model, @ModelAttribute TeamForm team) {
        LOGGER.info("" + team.getTeamName());
        serviceB.updateTeam(team);
        model.addAttribute("updatedTeamB", team);
        LOGGER.info(serviceB.getTeams5().toString());

        return "updatedTeamB";
    }

    @GetMapping("/enterMatchDayResults5B")
    public String enterResults5B(Model model, int index) {
        MatchDayFormB mDayForm = new MatchDayFormB();
        mDayForm.loadForm(index, serviceB.getTeamLinks5(), serviceB.getPairs());
        model.addAttribute("gameFormB", mDayForm);
        model.addAttribute("resultsB", serviceB.getResults5().get(index));

        return "enterMatchDayResults5B";
    }

    @GetMapping("/enterMatchDayResults6B")
    public String enterResults6B(Model model, int index) {
        MatchDayFormB mDayForm = new MatchDayFormB();
        mDayForm.loadForm(index, serviceB.getTeamLinks6(), serviceB.getPairs());
        model.addAttribute("gameFormB", mDayForm);
        model.addAttribute("resultsB", serviceB.getResults6().get(index));

        return "enterMatchDayResults6B";
    }

    @GetMapping("/enterMatchDayResults7B")
    public String enterResults7B(Model model, int index) {
        MatchDayFormB mDayForm = new MatchDayFormB();
        mDayForm.loadForm(index, serviceB.getTeamLinks7(), serviceB.getPairs());
        model.addAttribute("gameFormB", mDayForm);
        model.addAttribute("resultsB", serviceB.getResults7().get(index));

        return "enterMatchDayResults7B";
    }

    @GetMapping("/enterMatchDayResults8B")
    public String enterResults8B(Model model, int index) {
        MatchDayFormB mDayForm = new MatchDayFormB();
        mDayForm.loadForm(index, serviceB.getTeamLinks8(), serviceB.getPairs());
        model.addAttribute("gameFormB", mDayForm);
        model.addAttribute("resultsB", serviceB.getResults8().get(index));

        return "enterMatchDayResults8B";
    }

    @GetMapping("/enterMatchDayResults9B")
    public String enterResults9B(Model model, int index) {
        MatchDayFormB mDayForm = new MatchDayFormB();
        mDayForm.loadForm(index, serviceB.getTeamLinks9(), serviceB.getPairs());
        model.addAttribute("gameFormB", mDayForm);
        model.addAttribute("resultsB", serviceB.getResults9().get(index));

        return "enterMatchDayResults9B";
    }

    @PostMapping("/addedMatchDayResults5B")
    public String addedResults5B(Model model, @ModelAttribute MatchDayFormB form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceB.getTeams5());

        for (int i = 1; i < 4; i++) {
            serviceB.getTeam5(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceB.getResults5(), serviceB.getGamePostponed(), serviceB.getNotPlaying());
        serviceB.setTeams5(form.getTeamMap());
        serviceB.updateTeamData5(serviceB.getTeams5());
        model.addAttribute("resultB", form.getResults());

        LOGGER.info(serviceB.getGamePostponed().toString());
        LOGGER.info(serviceB.getNotPlaying().toString());

        return "addedResultsB";
    }

    @PostMapping("/addedMatchDayResults6B")
    public String addedResults6B(Model model, @ModelAttribute MatchDayFormB form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceB.getTeams6());

        for (int i = 1; i < 4; i++) {
            serviceB.getTeam6(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceB.getResults6(), serviceB.getGamePostponed(), serviceB.getNotPlaying());
        serviceB.setTeams6(form.getTeamMap());
        serviceB.updateTeamData6(serviceB.getTeams6());
        model.addAttribute("resultB", form.getResults());

        return "addedResultsB";
    }

    @PostMapping("/addedMatchDayResults7B")
    public String addedResults7B(Model model, @ModelAttribute MatchDayFormB form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceB.getTeams7());

        for (int i = 1; i < 4; i++) {
            serviceB.getTeam7(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceB.getResults7(), serviceB.getGamePostponed(), serviceB.getNotPlaying());
        serviceB.setTeams7(form.getTeamMap());
        serviceB.updateTeamData7(serviceB.getTeams7());
        model.addAttribute("resultB", form.getResults());

        return "addedResultsB";
    }

    @PostMapping("/addedMatchDayResults8B")
    public String addedResults8B(Model model, @ModelAttribute MatchDayFormB form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceB.getTeams8());

        for (int i = 1; i < 4; i++) {
            serviceB.getTeam8(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceB.getResults8(), serviceB.getGamePostponed(), serviceB.getNotPlaying());
        serviceB.setTeams8(form.getTeamMap());
        serviceB.updateTeamData8(serviceB.getTeams8());
        model.addAttribute("resultB", form.getResults());

        return "addedResultsB";
    }

    @PostMapping("/addedMatchDayResults9B")
    public String addedResults9B(Model model, @ModelAttribute MatchDayFormB form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(serviceB.getTeams9());

        for (int i = 1; i < 4; i++) {
            serviceB.getTeam9(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(serviceB.getResults9(), serviceB.getGamePostponed(), serviceB.getNotPlaying());
        serviceB.setTeams9(form.getTeamMap());
        serviceB.updateTeamData9(serviceB.getTeams9());
        model.addAttribute("resultB", form.getResults());

        return "addedResultsB";
    }

    @GetMapping("/resultsB")
    public String resultsB(Model model) {

        return "resultsB";
    }

    @GetMapping("/fixturesB")
    public String fixturesB(Model model) {

        return "fixturesB";
    }

    @GetMapping("/saveB")
    public String saveB(Model model) {
        LOGGER.info("save");
        serviceB.saveFutsalData();

        return "adminDashboardB";
    }

    @GetMapping("/deleteMDayB")
    public String delMDayB(Model model) {
        LOGGER.info("save");

        serviceB.deleteLastMDay();
        serviceB.updateTeamData5(serviceB.getTeams5());
        serviceB.updateTeamData6(serviceB.getTeams6());
        serviceB.updateTeamData7(serviceB.getTeams7());
        serviceB.updateTeamData8(serviceB.getTeams8());
        serviceB.updateTeamData9(serviceB.getTeams9());

        return "adminDashboardB";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError(Exception e) {
        LOGGER.severe("jebatanja bracala");
        e.printStackTrace();
    }

}
