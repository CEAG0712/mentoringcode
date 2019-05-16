package io.agileintelligence.fullstackfactorypattern.service;

import io.agileintelligence.fullstackfactorypattern.domain.Bug;
import io.agileintelligence.fullstackfactorypattern.domain.Story;
import io.agileintelligence.fullstackfactorypattern.dtos.BacklogItemAbstractResponseDTO;
import io.agileintelligence.fullstackfactorypattern.dtos.BacklogItemDTO;
import io.agileintelligence.fullstackfactorypattern.dtos.BugResponseDTO;
import io.agileintelligence.fullstackfactorypattern.dtos.StoryResponseDTO;
import io.agileintelligence.fullstackfactorypattern.repository.BugRepository;
import io.agileintelligence.fullstackfactorypattern.repository.StoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BacklogItemFactoryComponent {

    private BugRepository bugRepository;
    private StoryRepository storyRepository;
    private ModelMapper mapper;

    public BacklogItemFactoryComponent(BugRepository bugRepository, StoryRepository storyRepository, ModelMapper mapper) {
        this.bugRepository = bugRepository;
        this.storyRepository = storyRepository;
        this.mapper = mapper;
    }

    public  BacklogItemAbstractResponseDTO createBI(BacklogItemDTO dto){

        if(dto.getStatus()==null){
            dto.setStatus("TO_DO");
        }

        if(dto.getIssueType().equalsIgnoreCase("BUG")){
            Bug bug = bugRepository.save(mapper.map(dto, Bug.class));
            return mapper.map(bug, BugResponseDTO.class);
        }
        else if(dto.getIssueType().equalsIgnoreCase("STORY")){
            Story story = storyRepository.save(mapper.map(dto, Story.class));
            return mapper.map(story, StoryResponseDTO.class);
        }
        return null;
    }
}
