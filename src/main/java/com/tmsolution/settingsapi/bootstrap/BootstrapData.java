package com.tmsolution.settingsapi.bootstrap;

import com.tmsolution.settingsapi.constants.Themes;
import com.tmsolution.settingsapi.dataModels.Settings;
import com.tmsolution.settingsapi.repositories.SettingsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements ApplicationListener<ApplicationReadyEvent> {

    private final SettingsRepository settingsRepository;

    public BootstrapData(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (settingsRepository.findAll().isEmpty()) {
            Settings defaultSettings = new Settings();
            defaultSettings.setTwofa(true);
            defaultSettings.setTheme(Themes.LIGHT.getValue());

            settingsRepository.save(defaultSettings);
        }
    }
}
