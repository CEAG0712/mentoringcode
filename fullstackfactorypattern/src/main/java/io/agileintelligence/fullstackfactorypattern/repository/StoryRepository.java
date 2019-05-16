package io.agileintelligence.fullstackfactorypattern.repository;

import io.agileintelligence.fullstackfactorypattern.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
}
