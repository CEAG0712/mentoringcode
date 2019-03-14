package com.carlos.taskappbackend.repository;

import com.carlos.taskappbackend.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTaskId(String taskId);
//List<Task> getAllAndOrderByColIndex();
//    List<Task> fi;
}
