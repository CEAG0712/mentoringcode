package com.carlos.taskappbackend.service;

import com.carlos.taskappbackend.domain.Task;
import com.carlos.taskappbackend.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> findAll(){
        return taskRepository.findAll();
    }
}
