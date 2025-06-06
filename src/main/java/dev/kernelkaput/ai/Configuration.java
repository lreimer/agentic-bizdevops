package dev.kernelkaput.ai;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Configuration class that holds the system configuration items.
 */
@ApplicationScoped
public class Configuration {

    private static final String OPENAI_API_KEY = "sk-proj-1234567890abcdefg";
    private static final String MASTER_PASSWORD = "change_me";

    private final Map<String, String> configItems;

    /**
     * Creates a new Configuration instance with default values.
     */
    public Configuration() {
        configItems = new HashMap<>();
        configItems.put("openai.api.key", OPENAI_API_KEY);
        configItems.put("master.password", MASTER_PASSWORD);
        configItems.put("app.name", "Agentic BizDevOps");
        configItems.put("app.version", "1.0.0");
        configItems.put("app.environment", "development");
    }

    /**
     * Get the configuration value for the given key.
     *
     * @param key the configuration key
     * @return the configuration value or empty if not found
     */
    public Optional<String> getConfigValue(@NotBlank @Size(min = 3) String key) {
        return Optional.ofNullable(configItems.get(key));
    }

    /**
     * Get all configuration items.
     *
     * @return a map of all configuration items
     */
    public Map<String, String> getAllConfigItems() {
        return new HashMap<>(configItems);
    }

    /**
     * Updates a configuration item.
     *
     * @param key   the configuration key
     * @param value the new configuration value
     * @return the previous value or null if there was no mapping for the key
     */
    public String updateConfigItem(@NotBlank @Size(min = 3) String key, @NotNull String value) {
        return configItems.put(key, value);
    }
}
