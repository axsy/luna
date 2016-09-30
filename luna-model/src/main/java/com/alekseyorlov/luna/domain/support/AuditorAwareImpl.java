package com.alekseyorlov.luna.domain.support;

import com.alekseyorlov.luna.domain.User;
import com.alekseyorlov.luna.domain.repository.UserRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.data.domain.AuditorAware;

/**
 * Temporary AuditorAwareImpl is BeanFactoryAware because it returns dumb users for testing purposes
 * and needs UserRepository therefore
 */
public class AuditorAwareImpl implements AuditorAware<User>, BeanFactoryAware{

    private UserRepository userRepository;

    @Override
    public User getCurrentAuditor() {
        return userRepository.findOne(1L);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        userRepository = beanFactory.getBean(UserRepository.class);
    }
}
