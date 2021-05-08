package com.tmsolution.settingsapi.dataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Settings")
public class Settings {

    @Id
    private String id;
    private boolean twofa;
    private String theme;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isTwofa() {
        return twofa;
    }

    public void setTwofa(boolean twofa) {
        this.twofa = twofa;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
