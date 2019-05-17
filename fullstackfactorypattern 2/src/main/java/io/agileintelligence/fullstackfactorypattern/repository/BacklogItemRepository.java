package io.agileintelligence.fullstackfactorypattern.repository;

import io.agileintelligence.fullstackfactorypattern.domain.BacklogItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BacklogItemRepository extends JpaRepository<BacklogItem, Long> {
}
