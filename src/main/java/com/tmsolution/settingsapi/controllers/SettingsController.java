package com.tmsolution.settingsapi.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    @GetMapping(path = "/test")
    public String test(){
        return "test";
    }

    @PutMapping(path = "/toggle2fa")
    public void toggle2FA(){

    }

    @PutMapping(path = "toggleTheme")
    public void toggleTheme(){

    }
}
