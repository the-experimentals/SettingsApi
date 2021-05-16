package com.tmsolution.settingsapi.controllers;

import com.tmsolution.settingsapi.constants.EndpointMappings;
import com.tmsolution.settingsapi.dataModels.Settings;
import com.tmsolution.settingsapi.repositories.SettingsRepository;
import com.tmsolution.settingsapi.responsemodels.SettingsResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(EndpointMappings.CONTROLLER_PATH)
public class SettingsController {

    private SettingsRepository settingsRepository;

    private ModelMapper modelMapper;

    public SettingsController(SettingsRepository settingsRepository, ModelMapper modelMapper) {
        this.settingsRepository = settingsRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = EndpointMappings.TEST_ACTION)
    public String test(){
        return "test";
    }

    @GetMapping(EndpointMappings.GET_SETTINGS)
    public ResponseEntity<SettingsResponse> getSettings(){

        var settings = settingsRepository.findAll();
        if(!settings.isEmpty()){
            SettingsResponse settingsResponse = modelMapper.map(settings.get(0), SettingsResponse.class);
            return new ResponseEntity<SettingsResponse>(settingsResponse, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping(path = EndpointMappings.TOGGLE_2FA_ACTION)
    public void toggle2FA(){
        var test = settingsRepository.findAll();
    }

    @PutMapping(path = EndpointMappings.TOGGLE_THEME_ACTION)
    public void toggleTheme(){

    }
}
