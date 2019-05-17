package io.agileintelligence.fullstackfactorypattern.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@NoArgsConstructor
@Entity
public class Story extends BacklogItem {

    private Integer storyPoints;

    public static String storyType = "STORY";

    public Story(String issueType, String summary, String description, String status, Integer storyPoints) {
        super(issueType, summary, description, status);
        this.storyPoints = storyPoints;
    }
}
