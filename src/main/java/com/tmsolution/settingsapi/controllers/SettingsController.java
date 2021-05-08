package com.tmsolution.settingsapi.controllers;

import com.tmsolution.settingsapi.repositories.SettingsRepository;
import com.tmsolution.settingsapi.responsemodels.SettingsResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    private SettingsRepository settingsRepository;

    private ModelMapper modelMapper;

    public SettingsController(SettingsRepository settingsRepository, ModelMapper modelMapper) {
        this.settingsRepository = settingsRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/test")
    public String test(){
        return "test";
    }

    @GetMapping()
    public ResponseEntity<SettingsResponse> get(){
        var settings = settingsRepository.findAll().get(0);
        if(Objects.nonNull(settings)){
            SettingsResponse settingsResponse = modelMapper.map(settings, SettingsResponse.class);
            return new ResponseEntity<SettingsResponse>(settingsResponse, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping(path = "/toggle2fa")
    public void toggle2FA(){
        var test = settingsRepository.findAll();
    }

    @PutMapping(path = "toggleTheme")
    public void toggleTheme(){

    }
}
