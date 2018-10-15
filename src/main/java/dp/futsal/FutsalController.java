/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp.futsal;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
import dp.futsal.service.MatchPair;
import dp.futsal.service.MatchResult;
import dp.futsal.service.Team;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 * @author Wade
 */
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
        model.addAttribute("results", service.getResults());
        model.addAttribute("leagueTable", service.getTeamListSorted());
        model.addAttribute("teamListID", service.getTeamListIDindexed());
        return "index";
    }

    @GetMapping("/team")
    public String team(Model model, int index) {
        model.addAttribute("team", service.getTeamListIDindexed().get(index));
        model.addAttribute("results", service.getTeamListIDindexed().get(index).getResults());
        model.addAttribute("leagueTable", service.getTeamListSorted());
        return "teamInfo";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("leagueTable", service.getTeamListSorted());
        model.addAttribute("results", service.getResults());
        model.addAttribute("pairs", service.getPairs());
        return "adminDashboard";
    }

    @GetMapping("/editTeam")
    public String editTeam(Model model, int index) {
        model.addAttribute("team", service.getTeamListIDindexed().get(index));
        model.addAttribute("results", service.getTeamListIDindexed().get(index).getResults());
        model.addAttribute("leagueTable", service.getTeamListSorted());
        model.addAttribute("pairs", service.getPairs());
        return "editTeam";
    }

    @PostMapping("/updatedTeam")
    public String updateTeam(Model model, @ModelAttribute Team team) {
        LOGGER.info("" + team.getTeamName());

        Team teamTemp = service.getTeam(team.getId());
        List<MatchResult> matchResultList = teamTemp.getResults();
        team.setResults(matchResultList);

        service.getTeamMap().put(team.getId(), team);
        service.updateTeamData(service.getTeamMap());
        model.addAttribute("updatedTeam", team);
        model.addAttribute("leagueTable", service.getTeamListSorted());
        model.addAttribute("pairs", service.getPairs());
        LOGGER.info(service.getTeamMap().toString());
        return "updatedTeam";
    }

    @GetMapping("/enterMatchDayResults")
    public String enterResults(Model model, int index) {
        MatchDayForm mDayForm = new MatchDayForm();
        mDayForm.loadForm(index, service.getTeamListIDindexed(), service.getPairs());
        model.addAttribute("gameForm", mDayForm);
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("leagueTable", service.getTeamListSorted());
        
        
//        service.getResults();
//        Map<Integer, List<MatchResult>> tempRez = null;
//        if (service.getResults() != null) {
//            tempRez = new HashMap<>();
//        } else {
//            tempRez = new HashMap<>(service.getResults());
//        }
        
        model.addAttribute("results", service.getResults().get(index));
        
        return "enterMatchDayResults";
    }

    @PostMapping("/addedMatchDayResults")
    public String addedResults(Model model, @ModelAttribute MatchDayForm form) {
        LOGGER.info("pocetak addedmatch");

        form.setTeamMap(service.getTeamMap());

        for (int i = 1; i < 11; i++) {
            service.getTeam(i).delMatchDay(form.getmDay() + "");
        }

        form.saveResults(service.getResults(), service.getGamePostponed(), service.getNotPlaying());
        service.setTeamMap(form.getTeamMap());
        service.updateTeamData(service.getTeamMap());
        model.addAttribute("result", form.getResults());
        model.addAttribute("pairs", service.getPairs());
        model.addAttribute("leagueTable", service.getTeamListSorted());
        LOGGER.info(service.getGamePostponed().toString());
        LOGGER.info(service.getNotPlaying().toString());
        return "addedResults";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError(Exception e) {
        LOGGER.severe("jebatanja bracala");
        e.printStackTrace();
    }

}
