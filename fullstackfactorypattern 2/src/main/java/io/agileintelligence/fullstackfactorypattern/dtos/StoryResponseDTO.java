package io.agileintelligence.fullstackfactorypattern.dtos;

import io.agileintelligence.fullstackfactorypattern.domain.Story;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class StoryResponseDTO extends BacklogItemResponseDTO {

    private Integer storyPoints;

    public StoryResponseDTO(@NonNull Long id, @NonNull String issueType, String summary, String description, @NonNull String status, Integer storyPoints) {
        super(id, issueType, summary, description, status);
        this.storyPoints = storyPoints;
    }

    public static StoryResponseDTO from(Story story) {
        return new StoryResponseDTO(story.getId(), story.getIssueType(), story.getSummary(), story.getDescription(), story.getStatus(), story.getStoryPoints());
    }
}
