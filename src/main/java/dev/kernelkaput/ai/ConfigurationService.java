package dev.kernelkaput.ai;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service zur Verwaltung von Konfigurationselementen.
 */
@ApplicationScoped
public class ConfigurationService {

    private final Map<String, Configuration> configurations = new ConcurrentHashMap<>();

    public ConfigurationService() {
        // Initialisiere mit einigen Standard-Konfigurationen
        addConfiguration(new Configuration("openai.api.key", "sk-proj-1234567890abcdefg", "OpenAI API Schlüssel"));
        addConfiguration(new Configuration("master.password", "change_me", "Master-Passwort für administrative Funktionen"));
        addConfiguration(new Configuration("app.version", "1.0.0", "Aktuelle Anwendungsversion"));
    }

    /**
     * Fügt eine neue Konfiguration hinzu oder aktualisiert eine bestehende.
     *
     * @param configuration die hinzuzufügende oder zu aktualisierende Konfiguration
     * @return die hinzugefügte oder aktualisierte Konfiguration
     */
    public Configuration addConfiguration(Configuration configuration) {
        configurations.put(configuration.getKey(), configuration);
        return configuration;
    }

    /**
     * Gibt alle Konfigurationen zurück.
     *
     * @return alle Konfigurationen
     */
    public Collection<Configuration> getAllConfigurations() {
        return configurations.values();
    }

    /**
     * Sucht nach einer Konfiguration mit dem angegebenen Schlüssel.
     *
     * @param key der Schlüssel der gesuchten Konfiguration
     * @return die gefundene Konfiguration oder ein leeres Optional
     */
    public Optional<Configuration> getConfigurationByKey(String key) {
        return Optional.ofNullable(configurations.get(key));
    }

    /**
     * Entfernt eine Konfiguration mit dem angegebenen Schlüssel.
     *
     * @param key der Schlüssel der zu entfernenden Konfiguration
     * @return true, wenn die Konfiguration entfernt wurde, false wenn sie nicht existierte
     */
    public boolean removeConfiguration(String key) {
        return configurations.remove(key) != null;
    }
}
