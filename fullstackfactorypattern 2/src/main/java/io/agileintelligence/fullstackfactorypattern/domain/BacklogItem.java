package io.agileintelligence.fullstackfactorypattern.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
public abstract class BacklogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String issueType;
    private String summary;
    private String description;
    private String status;



    public BacklogItem(String issueType, String summary, String description, String status) {
        this.issueType = issueType;
        this.summary = summary;
        this.description = description;
        this.status = status;
    }


    //User Stories will have story points

    //Bugs have will have timeEstimateInMinutes - no story points
}
