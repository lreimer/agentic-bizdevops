# Agentic BizDevOps

Demo repository to try out different agentic AI development use cases.

## Features

- **Configuration API**: REST-Endpoint zum Abrufen und Aktualisieren von Konfigurationseinstellungen
  - GET /config - Alle Konfigurationseinstellungen abrufen
  - GET /config/{key} - Spezifische Konfigurationseinstellung abrufen
  - PUT /config/{key} - Konfigurationseinstellung aktualisieren

## Dokumentation

Die API-Dokumentation finden Sie im Ordner `docs/api/`. Der Swagger UI-Endpunkt ist verfügbar unter `/q/swagger-ui`.

## Entwicklung

### Voraussetzungen

- Java 21
- Gradle

### Anwendung starten

```shell
./gradlew quarkusDev
```

### Tests ausführen

```shell
./gradlew test
```

### Anwendung bauen

```shell
./gradlew build
```

## Maintainer

M.-Leander Reimer (@lreimer), <mario-leander.reimer@qaware.de>

## License

This software is provided under the MIT open source license, read the `LICENSE` file for details.
