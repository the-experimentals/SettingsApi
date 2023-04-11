package com.tmsolution.settingsapi.dataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author bibeksaini
 * 14/05/21
 * @project settingsapi
 */
@Document(collection = "UserPreferences")
public class UserPreferences {

    @Id
    private String Id;
    private String profileID;
    private String theme;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProfileID() {
        return profileID;
    }

    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
