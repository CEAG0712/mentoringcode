package io.agileintelligence.fullstackfactorypattern.service.impl;

import io.agileintelligence.fullstackfactorypattern.domain.BacklogItem;
import io.agileintelligence.fullstackfactorypattern.repository.BacklogItemRepository;
import io.agileintelligence.fullstackfactorypattern.service.BacklogItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacklogItemServiceImpl implements BacklogItemService {

    private final BacklogItemRepository backlogItemRepository;

    public BacklogItemServiceImpl(BacklogItemRepository backlogItemRepository) {
        this.backlogItemRepository = backlogItemRepository;
    }


    @Override
    public BacklogItem create(BacklogItem backlogItem){
        return backlogItemRepository.save(backlogItem);
    }

    @Override
    public List<BacklogItem> getAll(){
        return backlogItemRepository.findAll();
    }
}
