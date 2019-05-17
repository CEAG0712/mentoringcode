package io.agileintelligence.fullstackfactorypattern.dtos;

import io.agileintelligence.fullstackfactorypattern.domain.BacklogItem;
import io.agileintelligence.fullstackfactorypattern.domain.Bug;
import io.agileintelligence.fullstackfactorypattern.domain.Story;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Data
public class GetAllBacklogItemsResponseDTO {
    @NonNull
    private final List<BacklogItem> backlogItems;
}
