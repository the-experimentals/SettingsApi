package com.tmsolution.settingsapi.controllers;

import com.tmsolution.settingsapi.repositories.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    private SettingsRepository settingsRepository;

    public SettingsController(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    @GetMapping(path = "/test")
    public String test(){
        return "test";
    }

    @PutMapping(path = "/toggle2fa")
    public void toggle2FA(){
        var test = settingsRepository.findAll();
    }

    @PutMapping(path = "toggleTheme")
    public void toggleTheme(){

    }
}
