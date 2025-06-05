package dev.kernelkaput.ai;

import jakarta.validation.constraints.NotBlank;

/**
 * Repräsentiert ein Konfigurationselement mit Schlüssel und Wert.
 */
public class Configuration {

    @NotBlank
    private String key;
    
    @NotBlank
    private String value;

    private String description;

    // Standardkonstruktor für CDI und Jackson
    public Configuration() {
    }

    public Configuration(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Configuration(String key, String value, String description) {
        this.key = key;
        this.value = value;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
