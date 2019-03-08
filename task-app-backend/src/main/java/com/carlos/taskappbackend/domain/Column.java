package com.carlos.taskappbackend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Column {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String colId;
    private String title;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "column", orphanRemoval = true)
    private List<Task> taskList = new ArrayList<>();

    public Column(String colId, String title) {
        this.colId = colId;
        this.title = title;

    }
}
