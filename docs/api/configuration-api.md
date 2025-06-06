# Configuration API

Diese API ermöglicht den Zugriff auf Konfigurationseinstellungen der Anwendung.

## API-Endpunkt

Der Basis-Endpunkt für die Configuration API ist `/config`.

## Authentifizierung

Diese API erfordert derzeit keine Authentifizierung.

## Ressourcen

### Alle Konfigurationseinstellungen abrufen

Ruft alle verfügbaren Konfigurationseinstellungen ab.

**Methode**: `GET`

**Endpunkt**: `/config`

**Antwortformat**:

```json
[
  {
    "key": "string",
    "value": "string"
  }
]
```

**Antwortcodes**:

- `200 OK`: Die Anfrage war erfolgreich.

### Spezifischen Konfigurationswert abrufen

Ruft einen bestimmten Konfigurationswert anhand des Schlüssels ab.

**Methode**: `GET`

**Endpunkt**: `/config/{key}`

**Parameter**:

- `{key}`: Der Schlüssel der Konfigurationseinstellung (Pfadparameter)

**Antwortformat**:

```json
{
  "key": "string",
  "value": "string"
}
```

**Antwortcodes**:

- `200 OK`: Die Anfrage war erfolgreich.
- `404 Not Found`: Die angegebene Konfigurationseinstellung wurde nicht gefunden.

### Konfigurationswert aktualisieren

Aktualisiert einen bestimmten Konfigurationswert.

**Methode**: `PUT`

**Endpunkt**: `/config/{key}`

**Parameter**:

- `{key}`: Der Schlüssel der Konfigurationseinstellung (Pfadparameter)

**Anfragekörper**:

```json
{
  "key": "string",
  "value": "string"
}
```

**Antwortformat**:

```json
{
  "key": "string",
  "value": "string"
}
```

**Antwortcodes**:

- `200 OK`: Die Anfrage war erfolgreich.
- `400 Bad Request`: Der Schlüssel im Pfad stimmt nicht mit dem Schlüssel im Anfragekörper überein.

## Datenmodelle

### ConfigurationItem

| Feld  | Typ    | Beschreibung                     |
|-------|--------|---------------------------------|
| key   | string | Der Schlüssel der Konfigurationseinstellung |
| value | string | Der Wert der Konfigurationseinstellung      |

## Beispiele

### Alle Konfigurationseinstellungen abrufen

**Anfrage**:

```
GET /config
```

**Antwort**:

```json
[
  {
    "key": "app.name",
    "value": "Agentic BizDevOps"
  },
  {
    "key": "app.version",
    "value": "1.0.0"
  },
  {
    "key": "app.environment",
    "value": "development"
  }
]
```

### Spezifischen Konfigurationswert abrufen

**Anfrage**:

```
GET /config/app.name
```

**Antwort**:

```json
{
  "key": "app.name",
  "value": "Agentic BizDevOps"
}
```

### Konfigurationswert aktualisieren

**Anfrage**:

```
PUT /config/app.environment
```

```json
{
  "key": "app.environment",
  "value": "production"
}
```

**Antwort**:

```json
{
  "key": "app.environment",
  "value": "production"
}
```
