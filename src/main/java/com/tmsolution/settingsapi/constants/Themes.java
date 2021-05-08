package com.tmsolution.settingsapi.constants;

/**
 * @author bibeksaini
 * 08/05/21
 * @project settingsapi
 */
public enum Themes {
    LIGHT("light-theme"),
    DARK( "dark-theme");

    private String value;

    private Themes(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
