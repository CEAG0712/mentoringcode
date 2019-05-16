package io.agileintelligence.fullstackfactorypattern.data;

import io.agileintelligence.fullstackfactorypattern.domain.Bug;
import io.agileintelligence.fullstackfactorypattern.domain.Story;
import io.agileintelligence.fullstackfactorypattern.repository.BugRepository;
import io.agileintelligence.fullstackfactorypattern.repository.StoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class InitialDataLoad {

    @Bean
    CommandLineRunner loadDB(BugRepository bugRepository, StoryRepository storyRepository){

        return args -> {
            bugRepository.save(new Bug("BUG","Test Bug 1", "Test Bug 2 description","TO_DO",50 ));
            bugRepository.save(new Bug("BUG","Test Bug 2", "Test Bug 2 description","TO_DO",70 ));
            storyRepository.save(new Story("STORY", "Test Story 1", "Test Story 1 description", "TO_DO", 8));
            storyRepository.save(new Story("STORY", "Test Story 2", "Test Story 2 description", "TO_DO", 5));

        };

    }
}
