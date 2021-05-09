package com.tmsolution.settingsapi.responsemodels;

import com.tmsolution.settingsapi.constants.Themes;

public class SettingsResponse {

    private boolean twofa;
    private String theme;

    public boolean isTwofa() {
        return twofa;
    }

    public void setTwofa(boolean twofa) {
        this.twofa = twofa;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
