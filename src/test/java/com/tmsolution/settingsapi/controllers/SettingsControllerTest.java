package com.tmsolution.settingsapi.controllers;

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
        mockMvc.perform(MockMvcRequestBuilders.get("/api/settings/get-settings")).andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
