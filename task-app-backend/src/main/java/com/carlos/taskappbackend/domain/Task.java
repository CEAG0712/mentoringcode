package com.carlos.taskappbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskId;
    private String content;
    @ManyToOne
    @JsonIgnore
    private Column column;
    private String status; // todo, inProgress, Done, Test
    private int colIndex;

    public Task(String taskId, String content) {
        this.taskId = taskId;
        this.content = content;
    }
}
