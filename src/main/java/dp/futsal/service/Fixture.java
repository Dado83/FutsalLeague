package dp.futsal.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class Fixture {

    private static final Logger LOGGER = Logger.getLogger(Fixture.class.getName());

    private Map<Integer, List<MatchResult>> resultsMap = new HashMap<>();
    private Map<Integer, List<MatchPair>> pairsMap = new HashMap<>();

    public void saveResultsToJson(String fileString, Map<Integer, List<MatchResult>> results) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<Integer, List<MatchResult>>>() {
        }.getType();
        String json = gson.toJson(results, type);
        File file = new File(fileString);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            Writer writer = new OutputStreamWriter(outputStream, Charset.forName("utf-8").newEncoder());
            try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                bufferedWriter.write(json);
            }
        } catch (IOException e) {

        }
    }

    private void putfixturePairs(int matchDay, MatchPair... match) {
        List<MatchPair> pairs = new ArrayList<>();
        pairs.addAll(Arrays.asList(match));
        pairsMap.put(matchDay, pairs);
    }

    public void loadFixturesFromJson(String file) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<Integer, List<MatchPair>>>() {
        }.getType();
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
            LOGGER.severe("nisam ucitao fixtures json");
        }
        pairsMap = (Map<Integer, List<MatchPair>>) gson.fromJson(stringBuilder.toString(), type);
    }

    public Map<Integer, List<MatchResult>> loadResultsFromJson(String file) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<Integer, List<MatchResult>>>() {
        }.getType();
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
            LOGGER.severe("nisam ucitao results json");
        }
        return resultsMap = (Map<Integer, List<MatchResult>>) gson.fromJson(stringBuilder.toString(), type);
    }

    public Map<Integer, List<MatchResult>> getResults() {
        return resultsMap;
    }

    public Map<Integer, List<MatchPair>> getPairs() {
        return pairsMap;
    }

}
