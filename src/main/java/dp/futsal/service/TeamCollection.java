/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp.futsal.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class TeamCollection {

    private static final Logger LOGGER = Logger.getLogger(TeamCollection.class.getName());
    private Map<Integer, Team> teamMap = new HashMap<>();

    @Override
    public String toString() {
        List<Team> teamList = new ArrayList<>(teamMap.values());
        return teamList.toString();
    }

    public void loadTeamCollectionFromJson(String fileString) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<Integer, Team>>() {
        }.getType();
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileString);
        try {
            InputStream fileInputStream = new FileInputStream(file);
            Reader inputStream = new InputStreamReader(fileInputStream, Charset.forName("utf-8").newDecoder());
            BufferedReader reader = new BufferedReader(inputStream);
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            LOGGER.severe("nisam ucitao json");
        }
        this.teamMap = (Map<Integer, Team>) gson.fromJson(stringBuilder.toString(), type);

    }

    public void saveTeamMapToJson(String fileString) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<Integer, Team>>() {
        }.getType();
        File file = new File(fileString);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            Writer writer = new OutputStreamWriter(outputStream, Charset.forName("utf-8").newEncoder());
            try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                String json = gson.toJson(teamMap, type);
                bufferedWriter.write(json);
            }
        } catch (IOException e) {
        }
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
