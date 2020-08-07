package com.tmsolution.settingsapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test(){
        return "test";
    }
}
