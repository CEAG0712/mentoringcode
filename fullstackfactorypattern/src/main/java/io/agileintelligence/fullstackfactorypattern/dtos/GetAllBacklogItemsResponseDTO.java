package io.agileintelligence.fullstackfactorypattern.dtos;

import io.agileintelligence.fullstackfactorypattern.domain.Bug;
import io.agileintelligence.fullstackfactorypattern.domain.Story;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Data
public class GetAllBacklogItemsResponseDTO {
    List<Story> storyList = new ArrayList<>();
    List<Bug> bugList = new ArrayList<>();

}
