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
import dp.futsal.service.FutsalService;
import dp.futsal.service.MatchDayForm;
import dp.futsal.service.MatchResult;
import dp.futsal.service.Team;
import java.util.List;
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

    @GetMapping("/")
    public String index(Model model) {
        LOGGER.info("inside index");
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("results", service.getResults5());
        model.addAttribute("leagueTable", service.getTeamListSorted5());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        return "index";
    }

    @GetMapping("/team")
    public String team(Model model, int index) {
        model.addAttribute("team5", service.getTeamListIDindexed5().get(index));
        model.addAttribute("team6", service.getTeamListIDindexed6().get(index));
        model.addAttribute("team7", service.getTeamListIDindexed7().get(index));
        model.addAttribute("team8", service.getTeamListIDindexed8().get(index));
        model.addAttribute("team9", service.getTeamListIDindexed9().get(index));
        model.addAttribute("results5", service.getTeamListIDindexed5().get(index).getResults());
        model.addAttribute("results6", service.getTeamListIDindexed6().get(index).getResults());
        model.addAttribute("results7", service.getTeamListIDindexed7().get(index).getResults());
        model.addAttribute("results8", service.getTeamListIDindexed8().get(index).getResults());
        model.addAttribute("results9", service.getTeamListIDindexed9().get(index).getResults());
        model.addAttribute("leagueTable", service.getTeamListSorted5());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        return "teamInfo";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("leagueTable", service.getTeamListSorted5());
        model.addAttribute("results", service.getResults5());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        return "adminDashboard";
    }

    
    
    @GetMapping("/editTeam5")
    public String editTeam5(Model model, int index) {
        model.addAttribute("team", service.getTeamListIDindexed5().get(index));
        model.addAttribute("results", service.getTeamListIDindexed5().get(index).getResults());
        model.addAttribute("leagueTable", service.getTeamListSorted5());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        return "editTeam5";
    }
    @GetMapping("/editTeam6")
    public String editTeam6(Model model, int index) {
        model.addAttribute("team", service.getTeamListIDindexed6().get(index));
        model.addAttribute("results", service.getTeamListIDindexed6().get(index).getResults());
        model.addAttribute("leagueTable", service.getTeamListSorted6());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        return "editTeam6";
    }
    @GetMapping("/editTeam7")
    public String editTeam7(Model model, int index) {
        model.addAttribute("team", service.getTeamListIDindexed7().get(index));
        model.addAttribute("results", service.getTeamListIDindexed7().get(index).getResults());
        model.addAttribute("leagueTable", service.getTeamListSorted7());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        return "editTeam7";
    }
    @GetMapping("/editTeam8")
    public String editTeam8(Model model, int index) {
        model.addAttribute("team", service.getTeamListIDindexed8().get(index));
        model.addAttribute("results", service.getTeamListIDindexed8().get(index).getResults());
        model.addAttribute("leagueTable", service.getTeamListSorted8());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        return "editTeam8";
    }
    @GetMapping("/editTeam9")
    public String editTeam9(Model model, int index) {
        model.addAttribute("team", service.getTeamListIDindexed9().get(index));
        model.addAttribute("results", service.getTeamListIDindexed9().get(index).getResults());
        model.addAttribute("leagueTable", service.getTeamListSorted9());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        return "editTeam9";
    }
    

    @PostMapping("/updatedTeam5")
    public String updateTeam5(Model model, @ModelAttribute Team team) {
        LOGGER.info("" + team.getTeamName());

        Team teamTemp = service.getTeam5(team.getId());
        List<MatchResult> matchResultList = teamTemp.getResults();
        team.setResults(matchResultList);

        service.getTeamMap5().put(team.getId(), team);
        service.updateTeamData5(service.getTeamMap5());
        model.addAttribute("updatedTeam", team);
        model.addAttribute("leagueTable", service.getTeamListSorted5());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        LOGGER.info(service.getTeamMap5().toString());
        return "updatedTeam";
    }

    @PostMapping("/updatedTeam6")
    public String updateTeam6(Model model, @ModelAttribute Team team) {
        LOGGER.info("" + team.getTeamName());

        Team teamTemp = service.getTeam6(team.getId());
        List<MatchResult> matchResultList = teamTemp.getResults();
        team.setResults(matchResultList);

        service.getTeamMap6().put(team.getId(), team);
        service.updateTeamData6(service.getTeamMap6());
        model.addAttribute("updatedTeam", team);
        model.addAttribute("leagueTable", service.getTeamListSorted6());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        LOGGER.info(service.getTeamMap6().toString());
        return "updatedTeam";
    }
    @PostMapping("/updatedTeam7")
    public String updateTeam7(Model model, @ModelAttribute Team team) {
        LOGGER.info("" + team.getTeamName());

        Team teamTemp = service.getTeam7(team.getId());
        List<MatchResult> matchResultList = teamTemp.getResults();
        team.setResults(matchResultList);

        service.getTeamMap7().put(team.getId(), team);
        service.updateTeamData7(service.getTeamMap7());
        model.addAttribute("updatedTeam", team);
        model.addAttribute("leagueTable", service.getTeamListSorted7());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        LOGGER.info(service.getTeamMap7().toString());
        return "updatedTeam";
    }
    @PostMapping("/updatedTeam8")
    public String updateTeam8(Model model, @ModelAttribute Team team) {
        LOGGER.info("" + team.getTeamName());

        Team teamTemp = service.getTeam8(team.getId());
        List<MatchResult> matchResultList = teamTemp.getResults();
        team.setResults(matchResultList);

        service.getTeamMap8().put(team.getId(), team);
        service.updateTeamData8(service.getTeamMap8());
        model.addAttribute("updatedTeam", team);
        model.addAttribute("leagueTable", service.getTeamListSorted8());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        LOGGER.info(service.getTeamMap8().toString());
        return "updatedTeam";
    }
    @PostMapping("/updatedTeam9")
    public String updateTeam9(Model model, @ModelAttribute Team team) {
        LOGGER.info("" + team.getTeamName());

        Team teamTemp = service.getTeam9(team.getId());
        List<MatchResult> matchResultList = teamTemp.getResults();
        team.setResults(matchResultList);

        service.getTeamMap9().put(team.getId(), team);
        service.updateTeamData9(service.getTeamMap9());
        model.addAttribute("updatedTeam", team);
        model.addAttribute("leagueTable", service.getTeamListSorted9());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        LOGGER.info(service.getTeamMap9().toString());
        return "updatedTeam";
    }
    
    
    @GetMapping("/enterMatchDayResults5")
    public String enterResults5(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, service.getTeamListIDindexed5(), service.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("leagueTable", service.getTeamListSorted5());
        model.addAttribute("results", service.getResults5().get(index));
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        return "enterMatchDayResults5";
    }
    @GetMapping("/enterMatchDayResults6")
    public String enterResults6(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, service.getTeamListIDindexed6(), service.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("leagueTable", service.getTeamListSorted6());
        model.addAttribute("results", service.getResults6().get(index));
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        return "enterMatchDayResults6";
    }
    @GetMapping("/enterMatchDayResults7")
    public String enterResults7(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, service.getTeamListIDindexed7(), service.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("leagueTable", service.getTeamListSorted7());
        model.addAttribute("results", service.getResults7().get(index));
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        return "enterMatchDayResults7";
    }
    @GetMapping("/enterMatchDayResults8")
    public String enterResults8(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, service.getTeamListIDindexed8(), service.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("leagueTable", service.getTeamListSorted8());
        model.addAttribute("results", service.getResults8().get(index));
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        return "enterMatchDayResults8";
    }
    @GetMapping("/enterMatchDayResults9")
    public String enterResults9(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, service.getTeamListIDindexed9(), service.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("leagueTable", service.getTeamListSorted9());
        model.addAttribute("results", service.getResults9().get(index));
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        return "enterMatchDayResults9";
    }

    @PostMapping("/addedMatchDayResults5")
    public String addedResults5(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(service.getTeamMap5());

        for (int i = 1; i < 11; i++) {
            service.getTeam5(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(service.getResults5(), service.getGamePostponed5(), service.getNotPlaying5());
        service.setTeamMap5(form.getTeamMap());
        service.updateTeamData5(service.getTeamMap5());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("leagueTable", service.getTeamListSorted5());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        LOGGER.info(service.getGamePostponed5().toString());
        LOGGER.info(service.getNotPlaying5().toString());
        return "addedResults";
    }

    @PostMapping("/addedMatchDayResults6")
    public String addedResults6(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(service.getTeamMap6());

        for (int i = 1; i < 11; i++) {
            service.getTeam6(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(service.getResults6(), service.getGamePostponed6(), service.getNotPlaying6());
        service.setTeamMap6(form.getTeamMap());
        service.updateTeamData6(service.getTeamMap6());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("leagueTable", service.getTeamListSorted6());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        LOGGER.info(service.getGamePostponed6().toString());
        LOGGER.info(service.getNotPlaying6().toString());
        return "addedResults";
    }
    @PostMapping("/addedMatchDayResults7")
    public String addedResults7(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(service.getTeamMap7());

        for (int i = 1; i < 11; i++) {
            service.getTeam7(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(service.getResults7(), service.getGamePostponed7(), service.getNotPlaying7());
        service.setTeamMap7(form.getTeamMap());
        service.updateTeamData7(service.getTeamMap7());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("leagueTable", service.getTeamListSorted7());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        LOGGER.info(service.getGamePostponed7().toString());
        LOGGER.info(service.getNotPlaying7().toString());
        return "addedResults";
    }
    @PostMapping("/addedMatchDayResults8")
    public String addedResults8(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(service.getTeamMap8());

        for (int i = 1; i < 11; i++) {
            service.getTeam8(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(service.getResults8(), service.getGamePostponed8(), service.getNotPlaying8());
        service.setTeamMap8(form.getTeamMap());
        service.updateTeamData8(service.getTeamMap8());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("leagueTable", service.getTeamListSorted8());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        LOGGER.info(service.getGamePostponed8().toString());
        LOGGER.info(service.getNotPlaying8().toString());
        return "addedResults";
    }
    @PostMapping("/addedMatchDayResults9")
    public String addedResults9(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(service.getTeamMap9());

        for (int i = 1; i < 11; i++) {
            service.getTeam9(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(service.getResults9(), service.getGamePostponed9(), service.getNotPlaying9());
        service.setTeamMap9(form.getTeamMap());
        service.updateTeamData5(service.getTeamMap9());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("leagueTable", service.getTeamListSorted9());
        model.addAttribute("teamListID", service.getTeamListIDindexed5());
        LOGGER.info(service.getGamePostponed9().toString());
        LOGGER.info(service.getNotPlaying9().toString());
        return "addedResults";
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError(Exception e) {
        LOGGER.severe("jebatanja bracala");
        e.printStackTrace();
    }

}
