package com.alekseyorlov.luna.config;

import com.alekseyorlov.luna.domain.User;
import com.alekseyorlov.luna.domain.support.AuditorAwareImpl;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.support.Repositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.alekseyorlov.luna.domain.repository"})
@EnableTransactionManagement
@EnableJpaAuditing
public class OrmConfiguration {

    @Autowired
    private ListableBeanFactory listableBeanFactory;

    @Bean
    public Repositories repositories() {
        return new Repositories(listableBeanFactory);
    }

    @Bean
    public AuditorAware<User> auditorProvider() {
        return new AuditorAwareImpl();
    }

}
