package com.tmsolution.settingsapi.responsemodels;

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
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
