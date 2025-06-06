package dev.kernelkaput.ai;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Data transfer object for configuration items.
 */
@Schema(name = "ConfigurationItem", description = "Repräsentiert eine Konfigurationseinstellung")
public class ConfigurationItem {

    @NotBlank
    @Size(min = 3)
    @Schema(description = "Der Schlüssel der Konfigurationseinstellung", required = true, example = "app.name")
    private String key;

    @Schema(description = "Der Wert der Konfigurationseinstellung", example = "Agentic BizDevOps")
    private String value;

    /**
     * Default constructor required for JSON serialization.
     */
    public ConfigurationItem() {
    }

    /**
     * Creates a new configuration item.
     *
     * @param key the configuration key
     * @param value the configuration value
     */
    public ConfigurationItem(String key, String value) {
        this.key = key;
        this.value = value;
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
}
