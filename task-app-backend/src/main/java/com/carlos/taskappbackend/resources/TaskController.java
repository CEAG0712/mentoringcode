package com.carlos.taskappbackend.resources;


import com.carlos.taskappbackend.domain.Column;
import com.carlos.taskappbackend.domain.Task;
import com.carlos.taskappbackend.dto.DragNDropDTO;
import com.carlos.taskappbackend.service.DragNDropService;
import com.carlos.taskappbackend.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@CrossOrigin
public class TaskController {

    private TaskService taskService;
    private DragNDropService dragNDropService;

    public TaskController(TaskService taskService, DragNDropService dragNDropService) {
        this.taskService = taskService;
        this.dragNDropService = dragNDropService;
    }

    @GetMapping
    public Iterable<Task> findAll(){
        return taskService.findAll();
    }

    @PutMapping
    public ResponseEntity dragAndDrop(@RequestBody Column column ){

        return ResponseEntity.ok(dragNDropService.updateColumn(column));

    }



}
