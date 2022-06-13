package hu.hansa.test.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("hu.hansa.test")
@EntityScan("hu.hansa.test")
@EnableJpaAuditing
@Configuration
public class JpaConfiguration {

}
