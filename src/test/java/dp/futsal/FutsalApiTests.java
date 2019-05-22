package dp.futsal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
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

    @BeforeClass
    public static void setUp() {
	teamRepo = new ArrayList<>();
	teamRepo.add(new Teams(1, "man utd", "manchester", "red", "old trafford", "saturday"));
	teamRepo.add(new Teams(2, "man city", "manchester", "blue", "etihad", "saturday"));
	teamRepo.add(new Teams(3, "tottenham", "london", "white", "hart lane", "saturday"));
	teamRepo.add(new Teams(4, "liverpool", "liverpool", "red", "anfield", "saturday"));
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
	List<Teams> teams = mapper.readValue(response, new TypeReference<List<Teams>>() {
	});

	assertThat(teams.size()).isEqualTo(4);
    }

    @Test
    public void saveTeam() {

    }

    @Test
    public void updateTeam() {

    }

    @Test
    public void saveGame() {

    }

    @Test
    public void deleteGame() {

    }

    @Test
    public void returnHome() throws Exception {
	mockMvc.perform(get("/")).andExpect(status().isOk())
		.andExpect(content().string(containsString("Fair Play Liga Buducih Sampiona")));
    }

}
