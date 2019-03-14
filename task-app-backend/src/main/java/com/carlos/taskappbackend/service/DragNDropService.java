package com.carlos.taskappbackend.service;

import com.carlos.taskappbackend.domain.Column;
import com.carlos.taskappbackend.domain.Task;
import com.carlos.taskappbackend.dto.DragNDropDTO;
import com.carlos.taskappbackend.repository.ColumnRepository;
import com.carlos.taskappbackend.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DragNDropService {

    private TaskRepository taskRepository;
    private ColumnRepository columnRepository;

    public DragNDropService(TaskRepository taskRepository, ColumnRepository columnRepository) {
        this.taskRepository = taskRepository;
        this.columnRepository = columnRepository;
    }


    public Iterable<Column> updateColumn(DragNDropDTO dragNDropDTO){
        Column column = columnRepository.findByColId("column-1");

        List<Task> updateTasks = column.getTaskList();
      dragNDropDTO.getDragNDropDTOS().stream().map(dndObject ->
                {
                    Task task1 = taskRepository.findByTaskId(dndObject.getTaskId());
                    task1.setColIndex(dndObject.getIndex());

                    updateTasks.set(task1.getColIndex(),task1);
                    return task1;

                }).collect(Collectors.toList());


//
        //column.getTaskList().clear();
//
        column.getTaskList().addAll(updateTasks);

       // column.setTaskList(updateTasks);

        columnRepository.save(column);

        return columnRepository.findAll();
    }

    public Column updateColumn (Column column) {
        for (Task task : column.getTaskList()) {
            task.setColumn(column);
        }
        taskRepository.saveAll(column.getTaskList());

        return columnRepository.save(column);
    }

}
