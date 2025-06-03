---
status: "proposed"
date: 2025-06-03
decision-makers: Mario-Leander Reimer
consulted: Development Team, Database Administrators
informed: Project Management, Operations Team
---

# Verwendung von PostgreSQL als Datenbank statt MongoDB

## Context and Problem Statement

Das agentic-bizdevops Projekt benötigt eine Datenbanklösung für die Persistenz von Daten. Es muss entschieden werden, welche Datenbanktechnologie für das Projekt am besten geeignet ist. Bisher wurde MongoDB als mögliche Option in Betracht gezogen, aber es bedarf einer fundierten Entscheidung unter Berücksichtigung der Projektanforderungen, der langfristigen Wartbarkeit und der Teamkompetenzen.

## Decision Drivers

* Langfristige Skalierbarkeit und Performance
* Datenkonsistenz und Transaktionsgarantien
* Kompatibilität mit Quarkus und dem JVM-Ökosystem
* Teamexpertise und vorhandenes Know-how
* Operationelle Komplexität und Betriebskosten
* Datenmodellierung und Flexibilität des Schemas

## Considered Options

* MongoDB - dokumentenbasierte NoSQL-Datenbank
* PostgreSQL - relationale SQL-Datenbank
* MySQL - relationale SQL-Datenbank
* H2 (für Entwicklung und Tests) kombiniert mit PostgreSQL oder MySQL für Produktion

## Decision Outcome

Chosen option: "PostgreSQL", because es die beste Kombination aus Zuverlässigkeit, Funktionsumfang und Kompatibilität mit unseren Anforderungen bietet. PostgreSQL unterstützt sowohl relationale als auch dokumentenorientierte Datenmodelle (durch JSONB), bietet robuste Transaktionsgarantien und hat eine exzellente Integration mit dem Quarkus-Framework.

### Consequences

* Good, because PostgreSQL bietet ACID-Eigenschaften und starke Konsistenzgarantien.
* Good, because es unterstützt sowohl relationale als auch JSON-Datenstrukturen (JSONB).
* Good, because es hat eine hervorragende Integration mit Quarkus über Hibernate und Panache.
* Good, because das Team hat bereits Erfahrung mit PostgreSQL, was die Entwicklung beschleunigt.
* Good, because PostgreSQL ist Open Source und hat eine große Community-Unterstützung.
* Neutral, because für einfache Anwendungsfälle könnte PostgreSQL als überdimensioniert angesehen werden.
* Bad, because es könnte bei sehr hohen Schreiblasten mehr Tuning erfordern als schemalose Datenbanken.

### Confirmation

Die Einhaltung dieser Entscheidung wird durch folgende Maßnahmen überprüft:

1. Integration der PostgreSQL-Abhängigkeiten im Projekt-Build-System (Gradle)
2. Einrichtung von automatisierten Tests mit TestContainers für PostgreSQL
3. Code-Reviews, die sicherstellen, dass keine anderen Datenbanktypen verwendet werden
4. Architektur-Reviews im Rahmen der regulären Sprint-Reviews

## Pros and Cons of the Options

### PostgreSQL

Eine ausgereifte, robuste relationale Datenbank mit JSON-Unterstützung.

* Good, because bietet ACID-Transaktionen und referentielle Integrität.
* Good, because unterstützt JSONB für schemalose Daten, was Flexibilität bietet.
* Good, because hat gute Integration mit JVM-basierten Frameworks, insbesondere Quarkus.
* Good, because bietet eine umfangreiche SQL-Unterstützung und mächtige Abfragemöglichkeiten.
* Good, because verfügt über zahlreiche Erweiterungen für spezielle Anwendungsfälle.
* Neutral, because benötigt etwas mehr Ressourcen als leichtgewichtige Datenbanklösungen.
* Bad, because horizontale Skalierung ist nicht so einfach wie bei einigen NoSQL-Datenbanken.

### MongoDB

Eine dokumentenorientierte NoSQL-Datenbank.

* Good, because bietet flexible Schemagestaltung ohne Migration bei Änderungen.
* Good, because einfache horizontale Skalierung durch Sharding.
* Good, because gute Performance bei Lese-intensiven Workloads.
* Neutral, because bietet inzwischen auch Transaktionen, aber mit gewissen Einschränkungen.
* Bad, because weniger starke ACID-Garantien als relationale Datenbanken.
* Bad, because die Integration mit Quarkus ist weniger ausgereift als für relationale Datenbanken.
* Bad, because das Team hat weniger Erfahrung mit MongoDB, was zu längeren Entwicklungszeiten führen kann.

### MySQL

Eine weitverbreitete relationale Datenbank.

* Good, because breite Unterstützung und gute Integration mit Java-Ökosystem.
* Good, because stabile Performance und gut dokumentiert.
* Neutral, because ähnliche Funktionalität wie PostgreSQL.
* Bad, because weniger fortschrittliche Features im Vergleich zu PostgreSQL (z.B. weniger mächtige JSONB-Unterstützung).
* Bad, because lizenzrechtliche Bedenken seit der Oracle-Übernahme.

### H2 + PostgreSQL/MySQL

H2 für Entwicklung/Tests und PostgreSQL oder MySQL für Produktion.

* Good, because vereinfacht die lokale Entwicklung und automatisierte Tests.
* Good, because reduziert die Abhängigkeit von externen Diensten während der Entwicklung.
* Neutral, because übliche Praxis in vielen Java-Projekten.
* Bad, because Unterschiede zwischen Entwicklungs- und Produktionsumgebung können zu schwer zu findenden Bugs führen.
* Bad, because erfordert zusätzliche Konfiguration für unterschiedliche Umgebungen.

## More Information

* Die Implementierung der PostgreSQL-Integration soll im nächsten Sprint beginnen.
* Die Entscheidung sollte in einem Jahr oder bei signifikanten Änderungen der Anwendungsanforderungen überprüft werden.
* Als nächster Schritt sollte ein Datenbankmigrationskonzept mit Liquibase oder Flyway entwickelt werden.
* Wichtige Ressourcen:
  * [Quarkus - PostgreSQL Guide](https://quarkus.io/guides/datasource)
  * [PostgreSQL Documentation](https://www.postgresql.org/docs/)
