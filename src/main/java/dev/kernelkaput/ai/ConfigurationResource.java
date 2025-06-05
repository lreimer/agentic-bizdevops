package dev.kernelkaput.ai;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Collection;

/**
 * REST-Endpunkt für die Verwaltung von Konfigurationselementen.
 */
@Path("/api/configurations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConfigurationResource {

    @Inject
    ConfigurationService configurationService;

    /**
     * Gibt alle Konfigurationen zurück.
     *
     * @return HTTP Response mit allen Konfigurationen
     */
    @GET
    public Collection<Configuration> getAllConfigurations() {
        return configurationService.getAllConfigurations();
    }

    /**
     * Gibt eine bestimmte Konfiguration zurück.
     *
     * @param key der Schlüssel der gesuchten Konfiguration
     * @return HTTP Response mit der gesuchten Konfiguration oder 404 Not Found
     */
    @GET
    @Path("/{key}")
    public Response getConfigurationByKey(@PathParam("key") String key) {
        return configurationService.getConfigurationByKey(key)
                .map(config -> Response.ok(config).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}
