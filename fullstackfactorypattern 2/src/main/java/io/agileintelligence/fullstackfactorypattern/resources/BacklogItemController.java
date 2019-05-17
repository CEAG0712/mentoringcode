package io.agileintelligence.fullstackfactorypattern.resources;


import io.agileintelligence.fullstackfactorypattern.domain.BacklogItem;
import io.agileintelligence.fullstackfactorypattern.dtos.BacklogItemCreateDTO;
import io.agileintelligence.fullstackfactorypattern.dtos.BacklogItemResponseDTO;
import io.agileintelligence.fullstackfactorypattern.service.BacklogItemService;
import io.agileintelligence.fullstackfactorypattern.service.impl.BacklogItemServiceImpl;
import io.agileintelligence.fullstackfactorypattern.utils.BacklogResponseDTOFactory;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/board")
@CrossOrigin
public class BacklogItemController {

    private BacklogItemService backlogItemService;

    public BacklogItemController(BacklogItemService backlogItemService) {
        this.backlogItemService = backlogItemService;
    }

    @PostMapping
    public ResponseEntity createNewBI(@RequestBody BacklogItemCreateDTO dto){
        BacklogItem createdBacklogItem = backlogItemService.create(dto.to());
        return ResponseEntity.ok().body(new Resource(BacklogResponseDTOFactory.build(createdBacklogItem),
                new Link("http://localhost:8080/board").withRel("createBacklogItem")
                ));
    }

    @GetMapping
    public ResponseEntity getAll(){
        List<BacklogItemResponseDTO> backlogItemDtos = backlogItemService.getAll().stream()
                .map(BacklogResponseDTOFactory::build)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(backlogItemDtos);
    }

}
