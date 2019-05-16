package io.agileintelligence.fullstackfactorypattern.resources;

import io.agileintelligence.fullstackfactorypattern.domain.Bug;
import io.agileintelligence.fullstackfactorypattern.domain.Story;
import io.agileintelligence.fullstackfactorypattern.dtos.BacklogItemDTO;
import io.agileintelligence.fullstackfactorypattern.dtos.GetAllBacklogItemsResponseDTO;
import io.agileintelligence.fullstackfactorypattern.repository.BugRepository;
import io.agileintelligence.fullstackfactorypattern.service.BacklogItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(BacklogItemController.class)
public class BacklogItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BacklogItemService backlogItemService;







    @Test
    public void getStoryAndBugListsObject_Test() throws Exception{

        List<Bug> bugList = new ArrayList<>();
        Bug b1=  new Bug("BUG","Test Bug 1", "Test Bug 1 description","TO_DO",70 );
        b1.setId(1L);
        Bug b2 =new Bug("BUG","Test Bug 2", "Test Bug 2 description","TO_DO",50 );
        b2.setId(2L);

        bugList.addAll(Arrays.asList(b1,b2));

        Story s1 = new Story("STORY", "Test Story 1", "Test Story 1 description", "TO_DO", 8);
        s1.setId(1L);
        Story s2 = new Story("STORY", "Test Story 2", "Test Story 2 description", "TO_DO", 8);
        s2.setId(2L);

        List<Story> storyList = new ArrayList<>();
        storyList.addAll(Arrays.asList(s1,s2));

        GetAllBacklogItemsResponseDTO allBI = new GetAllBacklogItemsResponseDTO();

        allBI.setStoryList(storyList);
        allBI.setBugList(bugList);

        when(backlogItemService.getAllBI()).thenReturn(allBI);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/board")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{storyList: " +
                        "[ {id: 1," +
                        "issueType: STORY, " +
                        "summary: \"Test Story 1\"," +
                        "description: \"Test Story 1 description\", " +
                        "status: TO_DO," +
                        "storyPoints: 8 }," +
                        "{id: 2," +
                        "issueType: \"STORY\"," +
                        "summary: \"Test Story 2\"," +
                        "description: \"Test Story 2 description\"," +
                        "status: TO_DO," +
                        "storyPoints: 8}]" +
                        ",bugList: " +
                        "[{id: 1," +
                        "issueType: BUG," +
                        "summary: \"Test Bug 1\"," +
                        "description: \"Test Bug 1 description\"," +
                        "status: TO_DO, " +
                        "timeEstimateMinutes: 70}, " +
                        "{id: 2," +
                        "issueType: BUG," +
                        "summary: \"Test Bug 2\"," +
                        "description: \"Test Bug 2 description\"," +
                        "status: TO_DO," +
                        "timeEstimateMinutes: 50}]}"))
                .andReturn();

    }

//    @Test
//    public void createNewBug() throws Exception{
//        BacklogItemDTO dto = new BacklogItemDTO();
//
//
//    }


}
