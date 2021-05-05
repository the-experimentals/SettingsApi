package com.tmsolution.settingsapi.dataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FirstCollection")
public class Settings {

    @Id
    private String _id;
    private boolean _2fA;
    private String _theme;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public boolean is_2fA() {
        return _2fA;
    }

    public void set_2fA(boolean _2fA) {
        this._2fA = _2fA;
    }

    public String get_theme() {
        return _theme;
    }

    public void set_theme(String _theme) {
        this._theme = _theme;
    }
}
