//package io.agileintelligence.fullstackfactorypattern.service;
//
//import io.agileintelligence.fullstackfactorypattern.domain.BacklogItem;
//import io.agileintelligence.fullstackfactorypattern.domain.Bug;
//import io.agileintelligence.fullstackfactorypattern.domain.Story;
//import io.agileintelligence.fullstackfactorypattern.dtos.BacklogItemDTO;
//import io.agileintelligence.fullstackfactorypattern.dtos.BugResponseDTO;
//import io.agileintelligence.fullstackfactorypattern.dtos.GetAllBacklogItemsResponseDTO;
//import io.agileintelligence.fullstackfactorypattern.repository.BugRepository;
//import io.agileintelligence.fullstackfactorypattern.repository.StoryRepository;
//import io.agileintelligence.fullstackfactorypattern.resources.BacklogItemController;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//import static org.junit.Assert.assertEquals;
//
//
////@RunWith(SpringRunner.class)
////@WebMvcTest(BacklogItemService.class)
//public class BacklogItemServiceTest {
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    @InjectMocks
//    private BacklogItemService backlogItemService;
//
//    @Mock
//    private BugRepository bugRepository;
//
//    @Mock
//    private StoryRepository storyRepository;
//
//    @Mock
//    private BacklogItemFactoryComponent backlogItemFactoryComponent;
//
//
//    @Before
//    public void beforeStartTesting(){
//        MockitoAnnotations.initMocks(this);
//        backlogItemService = new BacklogItemService(bugRepository,storyRepository, backlogItemFactoryComponent);
//    }
//
//    @Test
//    public void getAll() throws Exception {
//
//        List<Bug> bugList = new ArrayList<>();
//        Bug b1=  new Bug("BUG","Test Bug 1", "Test Bug 1 description","TO_DO",70 );
//        b1.setId(1L);
//        Bug b2 =new Bug("BUG","Test Bug 2", "Test Bug 2 description","TO_DO",50 );
//        b2.setId(2L);
//
//        bugList.addAll(Arrays.asList(b1,b2));
//
//        when(bugRepository.findAll()).thenReturn(bugList);
//
//        Story s1 = new Story("STORY", "Test Story 1", "Test Story 1 description", "TO_DO", 8);
//        s1.setId(1L);
//        Story s2 = new Story("STORY", "Test Story 2", "Test Story 2 description", "TO_DO", 8);
//        s2.setId(2L);
//
//        List<Story> storyList = new ArrayList<>();
//        storyList.addAll(Arrays.asList(s1,s2));
//
//        when(storyRepository.findAll()).thenReturn(storyList);
//
//        GetAllBacklogItemsResponseDTO responseService = new GetAllBacklogItemsResponseDTO();
//        responseService.setBugList(bugList);
//        responseService.setStoryList(storyList);
//
//
//        GetAllBacklogItemsResponseDTO controllerData = backlogItemService.getAllBI();
//
//
//        assertEquals(storyList, controllerData.getStoryList());
//        assertEquals(bugList, controllerData.getBugList());
//        assertEquals(responseService,controllerData);
//
//    }
//
//    @Test
//    public void createBI() throws Exception{
//        BacklogItemDTO dto = new BacklogItemDTO();
//
//        dto.setIssueType("bug");
//        dto.setDescription("Test Description");
//        dto.setSummary("Test Summary");
//        dto.setTimeEstimateMinutes(60);
//
//
//        BugResponseDTO bugResponseDTO = new BugResponseDTO();
//        bugResponseDTO.setIssueType("bug");
//        bugResponseDTO.setDescription("Test Description");
//        bugResponseDTO.setSummary("Test Summary");
//        bugResponseDTO.setTimeEstimateMinutes(60);
//
//        bugResponseDTO.setId(1L);
//
//        when(backlogItemFactoryComponent.createBI(dto)).thenReturn(bugResponseDTO);
//
//        assertEquals(dto.getSummary(), bugResponseDTO.getSummary());
//
//        //public Bug(String issueType, String summary, String description, String status, int timeEstimateMinutes
//    }
//}
