package dp.futsal.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import net.bytebuddy.description.method.MethodDescription.TypeToken;
import org.springframework.stereotype.Service;


@Service
public class TeamCollection {

    private static final Logger LOGGER = Logger.getLogger(TeamCollection.class.getName());
    private Map<Integer, Team> teamMap = new HashMap<>();

    public TeamCollection() {

    }

    @Override
    public String toString() {
        List<Team> teamList = new ArrayList<>(teamMap.values());
        return teamList.toString();
    }

    public Map<Integer, Team> loadTeamsFromJson(String file) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(file);
            InputStream inputStream = url.openStream();
            Reader reader = new InputStreamReader(inputStream, Charset.forName("utf-8").newDecoder());
            BufferedReader buffReader = new BufferedReader(reader);
            String line;
            while ((line = buffReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            LOGGER.severe("nisam ucitao teams json");
        }
        return teamMap;

    }

    public void saveTeamsToJson(String fileString, Map<Integer, Team> teams) {

        File file = new File(fileString);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            Writer writer = new OutputStreamWriter(outputStream, Charset.forName("utf-8").newEncoder());
            try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                String json;

            }
        } catch (IOException e) {
        }
    }

    public String saveTeamsToJson(Map<Integer, Team> teams) {

        String json = "";
        return json;
    }

    public Team getTeam(int index) {
        return teamMap.get(index);
    }

    public void addTeam(int index, Team team) {
        teamMap.put(index, team);
    }

    public Map<Integer, Team> getTeamCollection() {
        return teamMap;
    }

    public void setTeamCollection(Map<Integer, Team> teamCollection) {
        this.teamMap = teamCollection;
    }

}
