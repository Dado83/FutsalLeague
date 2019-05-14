package dp.futsal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FutsalApiTests {

    @Autowired
    private FutsalController controller;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
	assertThat(controller).isNotNull();
    }

    @Test
    public void returnHome() {
	mockMvc.perform(get("/"))
    }
}
