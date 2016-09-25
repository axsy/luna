package com.alekseyorlov.luna.config;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.support.Repositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.alekseyorlov.luna.model.repository"})
public class OrmConfiguration {

    @Autowired
    private ListableBeanFactory listableBeanFactory;

    @Bean
    public Repositories repositories() {
        return new Repositories(listableBeanFactory);
    }

}
