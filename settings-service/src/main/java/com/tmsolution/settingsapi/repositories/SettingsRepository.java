package com.tmsolution.settingsapi.repositories;

import com.tmsolution.settingsapi.dataModels.Settings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository extends MongoRepository<Settings, String> {
}
