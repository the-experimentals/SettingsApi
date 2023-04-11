package com.tmsolution.settingsapi.repositories;

import com.tmsolution.settingsapi.dataModels.UserPreferences;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bibeksaini
 * 14/05/21
 * @project settingsapi
 */
@Repository
public interface UserPreferencesRepository extends MongoRepository<UserPreferences, String> {
}
