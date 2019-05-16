package io.agileintelligence.fullstackfactorypattern.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BugResponseDTO extends BacklogItemAbstractResponseDTO {

    private int timeEstimateMinutes;

}
