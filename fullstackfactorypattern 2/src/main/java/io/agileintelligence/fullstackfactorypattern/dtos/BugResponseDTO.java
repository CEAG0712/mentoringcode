package io.agileintelligence.fullstackfactorypattern.dtos;

import io.agileintelligence.fullstackfactorypattern.domain.Bug;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class BugResponseDTO extends BacklogItemResponseDTO {

    private Integer timeEstimateMinutes;

    private BugResponseDTO(@NonNull Long id, @NonNull String issueType, String summary, String description, @NonNull String status, Integer timeEstimateMinutes) {
        super(id, issueType, summary, description, status);
        this.timeEstimateMinutes = timeEstimateMinutes;
    }

    public static BugResponseDTO from(Bug bugBacklogItem) {
        return new BugResponseDTO(bugBacklogItem.getId(), bugBacklogItem.getIssueType(), bugBacklogItem.getSummary(), bugBacklogItem.getDescription(), bugBacklogItem.getStatus(), bugBacklogItem.getTimeEstimateMinutes());
    }
}
