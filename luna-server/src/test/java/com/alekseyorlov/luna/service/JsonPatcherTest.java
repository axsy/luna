package com.alekseyorlov.luna.service;

import com.alekseyorlov.luna.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
public class JsonPatcherTest {

    @Autowired
    private JsonPatcher patcher;

    @Test
    public void shouldAddPropertyValue() throws IOException {

        // given
        TestDTO testDTO = new TestDTO();
        testDTO.setA("a");

        // when
        TestDTO patchedTestDTO = patcher.patch(
                "[ {\"op\": \"replace\", \"path\": \"/a\", \"value\": \"b\"} ]",
                testDTO,
                TestDTO.class);

        // then
        assertEquals("b", patchedTestDTO.getA());
    }

}

class TestDTO {

    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}