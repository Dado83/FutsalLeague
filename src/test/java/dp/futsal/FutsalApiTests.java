package dp.futsal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.Any;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dp.futsal.database.DatabaseService;
import dp.futsal.database.Teams;
import dp.futsal.form.MatchResultForm;
import dp.futsal.form.TeamForm;
import junit.extensions.TestSetup;


@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class FutsalApiTests {

    @Autowired
    private FutsalController controller;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DatabaseService dbService;

    private static List<Teams> teamRepo;
    private static Teams teams;

    @BeforeClass
    public static void setUp() {
	teamRepo = new ArrayList<>();
	teamRepo.add(new Teams(1, "man utd", "manchester", "red", "old trafford", "saturday", 1));
	teamRepo.add(new Teams(2, "man city", "manchester", "blue", "etihad", "saturday", 2));
	teamRepo.add(new Teams(3, "tottenham", "london", "white", "hart lane", "saturday", 3));
	teamRepo.add(new Teams(4, "liverpool", "liverpool", "red", "anfield", "saturday", 4));
	teams = new Teams("zeljo", "doboj", "plava", "lipa", "nedjelja", 5);
    }

    @Test
    public void contextLoads() {
	assertThat(controller).isNotNull();
    }

    @Test
    public void getTeams() throws Exception {
	Mockito.when(dbService.getTeams()).thenReturn(teamRepo);

	RequestBuilder rb = MockMvcRequestBuilders.get("/teams");
	MvcResult mr = mockMvc.perform(rb).andReturn();

	String response = mr.getResponse().getContentAsString();
	ObjectMapper mapper = new ObjectMapper();
	List<Teams> teams = mapper.readValue(response, new TypeReference<List<Teams>>() {});

	assertThat(teams.size()).isEqualTo(4);
    }

    @Test
    public void saveTeam() throws Exception {
	Mockito.when(dbService.saveTeam(Mockito.any(TeamForm.class))).thenReturn(teams);

	RequestBuilder rb = MockMvcRequestBuilders.get("/teams/input");
	MvcResult mr = mockMvc.perform(rb).andReturn();

	String response = mr.getResponse().getContentAsString();
	ObjectMapper mapper = new ObjectMapper();
	Teams team = mapper.readValue(response, new TypeReference<Teams>() {});

	assertThat(teams.getTeamName()).isEqualTo(team.getTeamName());
    }

    @Test
    public void saveGame() throws Exception {
	Mockito.when(dbService.saveGame(Mockito.any(MatchResultForm.class))).thenReturn("utakmica snimljena");

	RequestBuilder rb = MockMvcRequestBuilders.post("/result/input");
	MvcResult mr = mockMvc.perform(rb).andReturn();

	String response = mr.getResponse().getContentAsString();

	assertThat(response).isEqualTo("utakmica snimljena");
    }

    @Test
    public void deleteGame() throws Exception {
	Mockito.when(dbService.deleteGame(Mockito.anyInt())).thenReturn("utakmica izbrisana");

	RequestBuilder rb = MockMvcRequestBuilders.get("/result/delete/1");
	MvcResult mr = mockMvc.perform(rb).andReturn();

	String response = mr.getResponse().getContentAsString();

	assertThat(response).isEqualTo("utakmica izbrisana");
    }

    @Test
    public void returnHome() throws Exception {
	mockMvc.perform(get("/")).andExpect(status().isOk())
		.andExpect(content().string(containsString("Fair Play Liga Buducih Sampiona")));
    }

}
