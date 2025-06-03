package dev.kernelkaput.ai;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Configuration {

    public static final String OPENAI_API_KEY = "sk-proj-1234567890abcdefg";

    public static final String MASTER_PASSWORD = "change_me";

    private Configuration() {
        // Private constructor to hide the implicit public one
    }
}
