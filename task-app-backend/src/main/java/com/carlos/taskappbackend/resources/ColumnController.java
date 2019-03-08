package com.carlos.taskappbackend.resources;

import com.carlos.taskappbackend.domain.Column;
import com.carlos.taskappbackend.service.ColumnService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projectboard")
@CrossOrigin
public class ColumnController {

    private ColumnService columnService;

    public ColumnController(ColumnService columnService) {
        this.columnService = columnService;
    }

    @GetMapping
    public Iterable<Column> findAllColumns(){
        return columnService.findAll();
    }
}
 //Handle Change
// Handle index when delete
