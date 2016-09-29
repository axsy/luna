package com.alekseyorlov.luna.service;

import com.alekseyorlov.luna.Application;
import com.alekseyorlov.luna.dto.Entry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles({"test", "integration"})
@Transactional
public class EntriesTest {

    @Autowired
    private Entries entries;

    @Test
    public void shouldFindEntry() throws Exception {

        // given
        Long entryId = 1L;

        // when
        Entry entryDto = entries.find(1L);

        // then
        assertEquals(entryId, entryDto.getId());
    }

    @Test
    public void shouldFindAll() throws Exception {

        // given
        Long entryId = 1L;
        Integer pageSize = 1;
        Integer pageNumber = 1;
        PageRequest pageRequest = new PageRequest(pageNumber, pageSize);

        // when
        Page<Entry> entryDto = entries.findAll(pageRequest);

        // then
        assertNotNull(entryDto);
        assertEquals(1, entryDto.getTotalElements());
    }

    @Test
    public void shouldFindAllBySpecification() throws Exception {

        // TODO: Implement test
    }

    @Test
    public void shouldSave() throws Exception {

        // TODO: Implement test
    }

    @Test
    public void shouldPatch() throws Exception {

        // TODO: Implement test
    }

    @Test
    public void shouldUpdate() throws Exception {

        // TODO: Implement test
    }

    @Test
    public void shouldDelete() throws Exception {

        // TODO: Implement test
    }

    @Test
    public void shouldDeleteAll() throws Exception {

        // TODO: Implement test
    }
}