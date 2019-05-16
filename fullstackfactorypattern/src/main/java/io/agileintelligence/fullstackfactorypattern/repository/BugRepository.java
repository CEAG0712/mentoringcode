package io.agileintelligence.fullstackfactorypattern.repository;

import io.agileintelligence.fullstackfactorypattern.domain.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepository extends JpaRepository<Bug, Long> {
}
