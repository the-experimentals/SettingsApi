package com.tmsolution.settingsapi.controllers;

import com.tmsolution.settingsapi.constants.EndpointMappings;
import com.tmsolution.settingsapi.repositories.SettingsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bibeksaini
 * 08/05/21
 * @project settingsapi
 */
public class SettingsControllerTest {

    SettingsController controller;

    @Mock
    SettingsRepository repository;

    public SettingsControllerTest() {
        MockitoAnnotations.openMocks(this);

        this.controller = new SettingsController(repository, new ModelMapper());
    }

    @Test
    @DisplayName("Testing settings not found")
    void testSettingsNotFound() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get(EndpointMappings.CONTROLLER_PATH.concat(EndpointMappings.GET_SETTINGS))).andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
