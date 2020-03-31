package pl.skaler12.spring_mvc_jpa_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.skaler12.spring_mvc_jpa_security.domain.repository.DbRepository;
import pl.skaler12.spring_mvc_jpa_security.domain.repository.InMemoryRepository;
import pl.skaler12.spring_mvc_jpa_security.domain.repository.StudentRepository;

@Configuration
public class MainConfig {

    @Bean(name="InMemoryRepository")
    @Profile("dev")
    public StudentRepository createInMemoryRepo() {
        StudentRepository repo = new InMemoryRepository();
        return repo;
    }

    @Bean(name="DbRepository")
    @Profile("prod")
    public StudentRepository createDBRepo() {
        StudentRepository repo = new DbRepository();
        return repo;
    }

}