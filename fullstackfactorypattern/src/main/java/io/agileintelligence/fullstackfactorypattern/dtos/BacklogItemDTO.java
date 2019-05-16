package io.agileintelligence.fullstackfactorypattern.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BacklogItemDTO {

    private String issueType;
    private String summary;
    private String description;
    private String status;
    //Story Only
    private int storyPoints;

    //Bug Only
    private int timeEstimateMinutes;


}
