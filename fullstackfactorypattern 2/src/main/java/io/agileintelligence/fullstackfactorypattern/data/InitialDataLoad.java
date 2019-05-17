package io.agileintelligence.fullstackfactorypattern.data;

import io.agileintelligence.fullstackfactorypattern.domain.Bug;
import io.agileintelligence.fullstackfactorypattern.domain.Story;
import io.agileintelligence.fullstackfactorypattern.repository.BacklogItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class InitialDataLoad {

    @Bean
    CommandLineRunner loadDB(BacklogItemRepository backlogItemRepository){

        return args -> {
            backlogItemRepository.save(new Bug("BUG","Test Bug 1", "Test Bug 2 description","TO_DO",50 ));
            backlogItemRepository.save(new Bug("BUG","Test Bug 2", "Test Bug 2 description","TO_DO",70 ));
            backlogItemRepository.save(new Story("STORY", "Test Story 1", "Test Story 1 description", "TO_DO", 8));
            backlogItemRepository.save(new Story("STORY", "Test Story 2", "Test Story 2 description", "TO_DO", 5));

        };

    }
}
