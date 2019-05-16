package io.agileintelligence.fullstackfactorypattern.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoryResponseDTO extends BacklogItemAbstractResponseDTO {

    private int storyPoints;

}
