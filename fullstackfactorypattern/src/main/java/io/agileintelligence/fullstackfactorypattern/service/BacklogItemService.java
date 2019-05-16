package io.agileintelligence.fullstackfactorypattern.service;

import io.agileintelligence.fullstackfactorypattern.domain.Bug;
import io.agileintelligence.fullstackfactorypattern.domain.Story;
import io.agileintelligence.fullstackfactorypattern.dtos.BacklogItemAbstractResponseDTO;
import io.agileintelligence.fullstackfactorypattern.dtos.BacklogItemDTO;
import io.agileintelligence.fullstackfactorypattern.dtos.GetAllBacklogItemsResponseDTO;
import io.agileintelligence.fullstackfactorypattern.repository.BugRepository;
import io.agileintelligence.fullstackfactorypattern.repository.StoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacklogItemService {

    private BugRepository bugRepository;
    private StoryRepository storyRepository;
    private BacklogItemFactoryComponent backlogItemFactoryComponent;

    public BacklogItemService(BugRepository bugRepository, StoryRepository storyRepository, BacklogItemFactoryComponent backlogItemFactoryComponent) {
        this.bugRepository = bugRepository;
        this.storyRepository = storyRepository;
        this.backlogItemFactoryComponent = backlogItemFactoryComponent;
    }



    public BacklogItemAbstractResponseDTO createBI(BacklogItemDTO dto){
        return backlogItemFactoryComponent.createBI(dto);
    }

    public GetAllBacklogItemsResponseDTO getAllBI(){

        List<Bug> bugList = bugRepository.findAll();
        List<Story>storyList = storyRepository.findAll();

        GetAllBacklogItemsResponseDTO dto = new GetAllBacklogItemsResponseDTO();
        dto.setStoryList(storyList);
        dto.setBugList(bugList);

        return dto;
    }
}
