package com.tmsolution.settingsapi.bootstrap;

import com.tmsolution.settingsapi.constants.Themes;
import com.tmsolution.settingsapi.dataModels.Settings;
import com.tmsolution.settingsapi.repositories.SettingsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final SettingsRepository settingsRepository;

    public BootstrapData(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        if(settingsRepository.findAll().isEmpty()){
            Settings defaultSettings = new Settings();
            defaultSettings.setTwofa(true);
            defaultSettings.setTheme(Themes.LIGHT.getValue());

            settingsRepository.save(defaultSettings);
        }

    }
}
