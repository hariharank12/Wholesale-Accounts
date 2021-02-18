package org.anz.wholesale.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages="org.anz.wholesale.entity")
@EnableJpaRepositories(basePackages = "org.anz.wholesale.repository")
public class AccountConfiguration {
}
