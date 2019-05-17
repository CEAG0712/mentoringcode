package io.agileintelligence.fullstackfactorypattern.dtos;

import io.agileintelligence.fullstackfactorypattern.domain.BacklogItem;
import io.agileintelligence.fullstackfactorypattern.domain.Bug;
import io.agileintelligence.fullstackfactorypattern.domain.Story;
import lombok.*;

@Data
@NoArgsConstructor
public class BacklogItemCreateDTO {

    @NonNull
    private String issueType;
    private String summary;
    private String description;

    @NonNull
    private String status;
    //Story Only
    private Integer storyPoints;

    //Bug Only
    private Integer timeEstimateMinutes;

    private BacklogItemCreateDTO(@NonNull String issueType, String summary, String description, @NonNull String status, Integer storyPoints, Integer timeEstimateMinutes) {
        this.issueType = issueType;
        this.summary = summary;
        this.description = description;
        this.status = status;
        this.storyPoints = storyPoints;
        this.timeEstimateMinutes = timeEstimateMinutes;
    }

    public static BacklogItemCreateDTO createBug(@NonNull String issueType, String summary, String description, @NonNull String status, Integer timeEstimateMinutes) {
        return new BacklogItemCreateDTO(issueType, summary, description, status, null, timeEstimateMinutes);
    }

    public static BacklogItemCreateDTO createStory(@NonNull String issueType, String summary, String description, @NonNull String status, Integer storyPoints) {
        return new BacklogItemCreateDTO(issueType, summary, description, status, storyPoints, null);
    }

    public BacklogItem to() {
        if(getIssueType().equals(Bug.bugType)) {
            return new Bug(issueType, summary, description, status, timeEstimateMinutes);
        } else if(getIssueType().equals(Story.storyType)) {
            return new Story(issueType, summary, description, status, storyPoints);
        }
        //TODO implement
        throw new RuntimeException("Invalid issueType");
    }

}
