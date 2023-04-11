package com.tmsolution.settingsapi.dataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author bibeksaini
 * 14/05/21
 * @project settingsapi
 */
@Document(collection = "GlobalSettings")
public class GlobalSettings {

    @Id
    private String Id;
    private boolean twofa;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public boolean isTwofa() {
        return twofa;
    }

    public void setTwofa(boolean twofa) {
        this.twofa = twofa;
    }
}
