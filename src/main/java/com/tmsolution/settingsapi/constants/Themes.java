package com.tmsolution.settingsapi.constants;

import java.util.Arrays;

/**
 * @author bibeksaini
 * 08/05/21
 * @project settingsapi
 */
public enum Themes {
    NOT_VALID(""),
    LIGHT("light-theme"),
    DARK( "dark-theme");

    private String value;

    private Themes(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public static Themes getTheme(String theme){

        var filteredTheme = Arrays.stream(Themes.values()).filter(x -> x.getValue().equals(theme)).findFirst();

        if(filteredTheme.isPresent())
            return filteredTheme.get();
        else
            return NOT_VALID;
    }
}
