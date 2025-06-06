package dev.kernelkaput.ai;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * REST Resource for managing configuration items.
 */
@Path("/config")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Configuration", description = "Operationen zur Verwaltung von Konfigurationseinstellungen")
public class ConfigurationResource {

    @Inject
    Configuration configuration;

    /**
     * Retrieves all configuration items.
     *
     * @return a list of all configuration items
     */
    @GET
    @Operation(summary = "Alle Konfigurationseinstellungen abrufen", 
               description = "Liefert eine Liste aller verfügbaren Konfigurationseinstellungen")
    @APIResponses({
        @APIResponse(responseCode = "200", 
                     description = "Erfolgreiche Abfrage aller Konfigurationseinstellungen",
                     content = @Content(mediaType = MediaType.APPLICATION_JSON,
                                       schema = @Schema(type = SchemaType.ARRAY, 
                                                      implementation = ConfigurationItem.class)))
    })
    public List<ConfigurationItem> getAllConfigItems() {
        Map<String, String> allItems = configuration.getAllConfigItems();
        return allItems.entrySet().stream()
                .map(entry -> new ConfigurationItem(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a specific configuration item.
     *
     * @param key the configuration key
     * @return the requested configuration item or 404 if not found
     */
    @GET
    @Path("/{key}")
    @Operation(summary = "Konfigurationseinstellung abrufen", 
               description = "Liefert eine spezifische Konfigurationseinstellung anhand des Schlüssels")
    @APIResponses({
        @APIResponse(responseCode = "200", 
                     description = "Konfigurationseinstellung erfolgreich abgerufen",
                     content = @Content(mediaType = MediaType.APPLICATION_JSON,
                                       schema = @Schema(implementation = ConfigurationItem.class))),
        @APIResponse(responseCode = "404", 
                     description = "Konfigurationseinstellung wurde nicht gefunden")
    })
    public Response getConfigItem(@PathParam("key") @NotBlank String key) {
        return configuration.getConfigValue(key)
                .map(value -> Response.ok(new ConfigurationItem(key, value)).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     * Updates a configuration item.
     *
     * @param key the configuration key
     * @param item the configuration item with the new value
     * @return the updated configuration item
     */
    @PUT
    @Path("/{key}")
    @Operation(summary = "Konfigurationseinstellung aktualisieren", 
               description = "Aktualisiert eine bestehende Konfigurationseinstellung")
    @APIResponses({
        @APIResponse(responseCode = "200", 
                     description = "Konfigurationseinstellung erfolgreich aktualisiert",
                     content = @Content(mediaType = MediaType.APPLICATION_JSON,
                                       schema = @Schema(implementation = ConfigurationItem.class))),
        @APIResponse(responseCode = "400", 
                     description = "Ungültige Anfrage - der Schlüssel im Pfad stimmt nicht mit dem Schlüssel im Anfragekörper überein")
    })
    public Response updateConfigItem(
            @PathParam("key") @NotBlank String key, 
            @Valid ConfigurationItem item) {
        
        // Ensure the path parameter and request body key match
        if (!key.equals(item.getKey())) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Path parameter key must match request body key")
                    .build();
        }

        String previousValue = configuration.updateConfigItem(key, item.getValue());
        return Response.ok(new ConfigurationItem(key, item.getValue())).build();
    }
}
