package com.carlos.taskappbackend.repository;

import com.carlos.taskappbackend.domain.Column;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColumnRepository extends JpaRepository<Column, Long> {
    Column findByColId(String id);
}
