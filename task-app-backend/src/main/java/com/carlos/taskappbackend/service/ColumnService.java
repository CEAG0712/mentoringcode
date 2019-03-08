package com.carlos.taskappbackend.service;

import com.carlos.taskappbackend.domain.Column;
import com.carlos.taskappbackend.repository.ColumnRepository;
import org.springframework.stereotype.Service;

@Service
public class ColumnService {

    private ColumnRepository columnRepository;

    public ColumnService(ColumnRepository columnRepository) {
        this.columnRepository = columnRepository;
    }

    public Iterable<Column> findAll(){
        return columnRepository.findAll();
    }
}
