package io.agileintelligence.fullstackfactorypattern.resources;


import io.agileintelligence.fullstackfactorypattern.domain.BacklogItem;
import io.agileintelligence.fullstackfactorypattern.domain.Bug;
import io.agileintelligence.fullstackfactorypattern.domain.Story;
import io.agileintelligence.fullstackfactorypattern.dtos.BacklogItemAbstractResponseDTO;
import io.agileintelligence.fullstackfactorypattern.dtos.BacklogItemDTO;
import io.agileintelligence.fullstackfactorypattern.dtos.GetAllBacklogItemsResponseDTO;
import io.agileintelligence.fullstackfactorypattern.repository.BugRepository;
import io.agileintelligence.fullstackfactorypattern.repository.StoryRepository;
import io.agileintelligence.fullstackfactorypattern.service.BacklogItemService;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


@RestController
@RequestMapping("/board")
@CrossOrigin
public class BacklogItemController {

    private BacklogItemService backlogItemService;

    public BacklogItemController(BacklogItemService backlogItemService) {
        this.backlogItemService = backlogItemService;
    }

    @PostMapping
    public ResponseEntity createNewBI(@RequestBody BacklogItemDTO dto){
        return ResponseEntity.ok().body(new Resource(backlogItemService.createBI(dto),
                new Link("http://localhost:8080/board").withRel("createBacklogItem")
                ));
    }

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok().body(backlogItemService.getAllBI());
    }

}
