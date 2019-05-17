package io.agileintelligence.fullstackfactorypattern.service;

import io.agileintelligence.fullstackfactorypattern.domain.BacklogItem;

import java.util.List;

/**
 * @author Uttpal
 */
public interface BacklogItemService {
    BacklogItem create(BacklogItem backlogItem);

    List<BacklogItem> getAll();
}
