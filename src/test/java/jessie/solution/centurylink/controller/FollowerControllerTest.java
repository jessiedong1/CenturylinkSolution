package jessie.solution.centurylink.controller;

import jessie.solution.centurylink.service.FollowerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//Testing
@WebMvcTest(FollowerController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class FollowerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    FollowerService fService;


    @Test
    void getAllFollowersShouldWork() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/octocat");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }
}
