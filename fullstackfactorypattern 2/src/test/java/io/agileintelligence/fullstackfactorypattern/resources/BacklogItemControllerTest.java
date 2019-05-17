package io.agileintelligence.fullstackfactorypattern.resources;

import com.google.gson.Gson;
import io.agileintelligence.fullstackfactorypattern.domain.BacklogItem;
import io.agileintelligence.fullstackfactorypattern.domain.Bug;
import io.agileintelligence.fullstackfactorypattern.domain.Story;
import io.agileintelligence.fullstackfactorypattern.dtos.BacklogItemCreateDTO;
import io.agileintelligence.fullstackfactorypattern.service.BacklogItemService;
import io.agileintelligence.fullstackfactorypattern.utils.BacklogResponseDTOFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BacklogItemControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplate restTemplate;

    private Gson gson = new Gson();

    private String boardRestUrl;

    @Before
    public void init() {
        boardRestUrl = String.format("http://localhost:%s/board", port);
    }


    @Test
    public void getStoryAndBugListsObject_Test() throws Exception{

        Bug b1 =  new Bug("BUG","Test Bug 1", "Test Bug 1 description","TO_DO",70 );
        Story s1 = new Story("STORY", "Test Story 1", "Test Story 1 description", "TO_DO", 8);


        List<BacklogItem> backlogItems = Arrays.asList(b1, s1);

        BacklogItemCreateDTO createBugDto = BacklogItemCreateDTO.createBug(Bug.bugType, b1.getSummary(), b1.getDescription(), b1.getStatus(), b1.getTimeEstimateMinutes());
        BacklogItemCreateDTO createStoryDto = BacklogItemCreateDTO.createStory(Story.storyType, s1.getSummary(), s1.getDescription(), s1.getStatus(), s1.getStoryPoints());

        ResponseEntity<String> response = restTemplate.postForEntity(boardRestUrl, createBugDto, String.class);
        Bug createdb1 = new Bug(b1.getIssueType(), b1.getSummary(), b1.getDescription(), b1.getStatus(),b1.getTimeEstimateMinutes());

        createdb1.setId(Long.valueOf("5"));
        Resource expectedResponseResource = new Resource(BacklogResponseDTOFactory.build(createdb1),
                new Link("http://localhost:8080/board").withRel("createBacklogItem"));
        String expectedStringResponse = "{\"id\":5,\"issueType\":\"BUG\",\"summary\":\"Test Bug 1\",\"description\":\"Test Bug 1 description\",\"status\":\"TO_DO\",\"timeEstimateMinutes\":70,\"_links\":{\"createBacklogItem\":{\"href\":\"http://localhost:8080/board\"}}}";

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), expectedStringResponse);

    }

//    @Test
//    public void createNewBug() throws Exception{
//        BacklogItemDTO dto = new BacklogItemDTO();
//
//
//    }


}
