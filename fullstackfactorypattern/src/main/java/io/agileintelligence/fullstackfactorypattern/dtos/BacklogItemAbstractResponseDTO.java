package io.agileintelligence.fullstackfactorypattern.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BacklogItemAbstractResponseDTO {

    //EXPLICIT MAPPING TO SKIP
    private Long id;
    private String issueType;
    private String summary;
    private String description;

}
