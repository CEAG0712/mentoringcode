package io.agileintelligence.fullstackfactorypattern.utils;

import io.agileintelligence.fullstackfactorypattern.domain.BacklogItem;
import io.agileintelligence.fullstackfactorypattern.domain.Bug;
import io.agileintelligence.fullstackfactorypattern.domain.Story;
import io.agileintelligence.fullstackfactorypattern.dtos.BacklogItemResponseDTO;
import io.agileintelligence.fullstackfactorypattern.dtos.BugResponseDTO;
import io.agileintelligence.fullstackfactorypattern.dtos.StoryResponseDTO;

/**
 * @author Uttpal
 */
public interface BacklogResponseDTOFactory {

    static BacklogItemResponseDTO build(BacklogItem backlogItem) {
        if(backlogItem.getIssueType().equals(Bug.bugType)) {
            return BugResponseDTO.from((Bug) backlogItem);
        } else if(backlogItem.getIssueType().equals(Story.storyType)) {
            return StoryResponseDTO.from((Story) backlogItem);
        }

        throw new RuntimeException("Invalid IssueType");
    }

}
