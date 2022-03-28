package com.ohme.controller;

import com.ohme.domain.universe.glider.GliderUniverse;
import com.ohme.service.executor.UniverseExecutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebAppConfiguration
public class GameOfLifeControllerTest {

    @MockBean
    @Qualifier("glider")
    private UniverseExecutor executor;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        Mockito.when(executor.getCurrentState()).thenReturn(new GliderUniverse(5));
        Mockito.when(executor.tick()).thenReturn(new GliderUniverse(5));
        Mockito.when(executor.reset()).thenReturn(new GliderUniverse(5));
    }

    @ParameterizedTest
    @ValueSource(strings = {"/state", "/tick", "/reset"})
    void endpointsActiveTest(String endpoint) throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(get(endpoint)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @ParameterizedTest
    @ValueSource(strings = {"/state", "/tick", "/reset"})
    void getEndpointResponseTest(String endpoint) throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MvcResult result = mockMvc.perform(get(endpoint)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(new GliderUniverse(5).toHtmlString(), result.getResponse().getContentAsString());
    }
}
