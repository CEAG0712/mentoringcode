package io.agileintelligence.fullstackfactorypattern.dtos;

import io.agileintelligence.fullstackfactorypattern.domain.BacklogItem;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
@EqualsAndHashCode
public abstract class BacklogItemResponseDTO {

    private final @NonNull Long id;

    @NonNull
    private final String issueType;
    private final String summary;
    private final String description;

    @NonNull
    private final String status;

    public BacklogItemResponseDTO(@NonNull Long id, @NonNull String issueType, String summary, String description, @NonNull String status) {
        this.id = id;
        this.issueType = issueType;
        this.summary = summary;
        this.description = description;
        this.status = status;
    }
}
