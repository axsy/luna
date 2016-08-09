package com.alekseyorlov.luna;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Application.class})
public class ApplicationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void shouldInstantiateApplicationContext() {

        assertThat(context).isNotNull();
    }
}