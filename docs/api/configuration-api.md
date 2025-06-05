# Configuration API

Diese API ermöglicht das Verwalten von Konfigurationselementen.

## Endpoints

### GET /api/configurations

Gibt eine Liste aller Konfigurationselemente zurück.

**Response:**
```json
[
  {
    "key": "openai.api.key",
    "value": "sk-proj-1234567890abcdefg",
    "description": "OpenAI API Schlüssel"
  },
  {
    "key": "master.password",
    "value": "change_me",
    "description": "Master-Passwort für administrative Funktionen"
  },
  {
    "key": "app.version",
    "value": "1.0.0",
    "description": "Aktuelle Anwendungsversion"
  }
]
```

### GET /api/configurations/{key}

Gibt ein bestimmtes Konfigurationselement anhand des Schlüssels zurück.

**Parameter:**
- `key` (Pfadparameter): Der Schlüssel des gesuchten Konfigurationselements

**Response (200 OK):**
```json
{
  "key": "app.version",
  "value": "1.0.0",
  "description": "Aktuelle Anwendungsversion"
}
```

**Response (404 Not Found):**
Wird zurückgegeben, wenn kein Konfigurationselement mit dem angegebenen Schlüssel existiert.
