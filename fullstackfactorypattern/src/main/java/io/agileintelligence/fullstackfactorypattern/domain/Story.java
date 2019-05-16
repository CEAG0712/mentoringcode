package io.agileintelligence.fullstackfactorypattern.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@NoArgsConstructor
@Entity
public class Story extends BacklogItem {



    private int storyPoints;

    public Story(String issueType, String summary, String description, String status, int storyPoints) {
        super(issueType, summary, description, status);
        this.storyPoints = storyPoints;
    }
}
