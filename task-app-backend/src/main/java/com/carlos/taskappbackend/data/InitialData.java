package com.carlos.taskappbackend.data;

import com.carlos.taskappbackend.domain.Column;
import com.carlos.taskappbackend.domain.Task;
import com.carlos.taskappbackend.repository.ColumnRepository;
import com.carlos.taskappbackend.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StreamUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class InitialData {

    @Bean
    CommandLineRunner loadDB(TaskRepository repository, ColumnRepository columnRepository){

        return args -> {
            Column column = columnRepository.save(new Column("column-1", "To Do"));

            repository.save(new Task("task-1", "create spring boot project"));
            repository.save(new Task("task-2", "create domain object"));
            repository.save(new Task("task-3", "create repo and service"));
            repository.save(new Task("task-4", "create controller"));
            repository.save(new Task("task-5", "Initial Data Load"));
            List<Task> tasks = new ArrayList<>();


            List<Task> finalTasks = tasks;
            tasks = repository.findAll().stream().map(task -> {
                task.setColumn(column);
                finalTasks.add(task);

               task.setIndex(finalTasks.indexOf(task));
                return repository.save(task);
            }).collect(Collectors.toList());

        //Sorting algorithm

            //System.out.println(column.getTaskList());
        };
    }
}
