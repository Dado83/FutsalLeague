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
        model.addAttribute("team", service.getTeamListIDindexed5().get(index));
        model.addAttribute("results", service.getTeamListIDindexed5().get(index).getResults());
        model.addAttribute("leagueTable", service.getTeamListSorted5());
        return "teamInfo";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("leagueTable", service.getTeamListSorted5());
        model.addAttribute("results", service.getResults5());
        model.addAttribute("pairs", service.getPairs());
        return "adminDashboard";
    }

    @GetMapping("/editTeam")
    public String editTeam(Model model, int index) {
        model.addAttribute("team", service.getTeamListIDindexed5().get(index));
        model.addAttribute("results", service.getTeamListIDindexed5().get(index).getResults());
        model.addAttribute("leagueTable", service.getTeamListSorted5());
        model.addAttribute("pairs", service.getPairs());
        return "editTeam";
    }

    @PostMapping("/updatedTeam")
    public String updateTeam(Model model, @ModelAttribute Team team) {
        LOGGER.info("" + team.getTeamName());

        Team teamTemp = service.getTeam5(team.getId());
        List<MatchResult> matchResultList = teamTemp.getResults();
        team.setResults(matchResultList);

        service.getTeamMap5().put(team.getId(), team);
        service.updateTeamData5(service.getTeamMap5());
        model.addAttribute("updatedTeam", team);
        model.addAttribute("leagueTable", service.getTeamListSorted5());
        model.addAttribute("pairs", service.getPairs());
        LOGGER.info(service.getTeamMap5().toString());
        return "updatedTeam";
    }

    @GetMapping("/enterMatchDayResults")
    public String enterResults(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, service.getTeamListIDindexed5(), service.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("leagueTable", service.getTeamListSorted5());
        model.addAttribute("results", service.getResults5().get(index));
        return "enterMatchDayResults";
    }

    @PostMapping("/addedMatchDayResults")
    public String addedResults(Model model, @ModelAttribute MatchDayForm form) {
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
        LOGGER.info(service.getGamePostponed5().toString());
        LOGGER.info(service.getNotPlaying5().toString());
        return "addedResults";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError(Exception e) {
        LOGGER.severe("jebatanja bracala");
        e.printStackTrace();
    }

}
