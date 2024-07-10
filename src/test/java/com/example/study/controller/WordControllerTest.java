package com.example.study.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.study.service.ExampleService;
@WebMvcTest(WordController.class)
public class WordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExampleService exampleService;

    @InjectMocks
    private WordController wordController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(wordController).build();
    }

    @Test
    public void testReceiveWord() throws Exception {
        mockMvc.perform(get("/receiveWord").param("word", "testWord"))
                .andExpect(status().isOk())
                .andExpect(content().string("Received word: testWord"));
    }
    /*
    @Test
    public void testExecuteWithValidParams() throws Exception {
        when(ExampleService.executeMethod("espanol", "hola")).thenReturn("Processed: idioma=espanol, word=hola");

        mockMvc.perform(get("/execute").param("idioma", "espanol").param("word", "hola"))
                .andExpect(status().isOk())
                .andExpect(content().string("Processed: idioma=espanol, word=hola"));

        verify(exampleService).executeMethod("espanol", "hola");
    }
    */
    @Test
    public void testExecuteWithMissingParams() throws Exception {
        mockMvc.perform(get("/execute").param("idioma", "espanol"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Both 'idioma' and 'word' parameters are required and must not be empty."));
    }
}