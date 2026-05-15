# swe-testing-exercises

Eine Sammlung kleiner Java-Übungsaufgaben für Studierende im Software-Engineering-Kontext. Schwerpunkt der ersten Aufgaben sind **Test Doubles**, insbesondere **Stubs** und **Mocks**.

## Zielgruppe

Studierende, die bereits Grundkenntnisse in Java und automatisiertem Testen mit JUnit haben und nun lernen sollen, Abhängigkeiten in Tests bewusst durch Test Doubles zu ersetzen.

## Lernziele der Sammlung

Nach der Bearbeitung der Aufgaben können Studierende

- erkennen, welche Abhängigkeit in einem Test ersetzt werden sollte,
- ein Test Double sinnvoll als **Stub** oder als **Mock** auswählen,
- begründen, ob im Test ein **Zustand** oder eine **Interaktion** geprüft wird,
- Tests lesbar und wartbar strukturieren (Arrange-Act-Assert, sprechende Namen, fokussierte Assertions),
- die Mockito-API anwenden, ohne sie als Selbstzweck zu verstehen.

## Voraussetzungen

- **JDK 21** (z. B. Temurin, GraalVM)
- **Maven 3.9+**
- Eine IDE deiner Wahl (IntelliJ IDEA, Eclipse, VS Code mit Java-Extension)

Prüfen mit:

```bash
java -version
mvn -version
```

## Aufbau einer Aufgabe

Jede Aufgabe liegt unter `aufgaben/<nummer>-<kurzname>/` und ist ein **eigenständiges Maven-Projekt**. Du kannst also einen einzelnen Aufgabenordner herauslösen und unabhängig bauen:

```bash
cd aufgaben/01-stub-controlled-return-value
mvn test
```

Die Aufgabenstellung steht jeweils in der `README.md` des Aufgabenordners. Bilder oder Diagramme liegen optional unter `images/`.

## Aufgabentypen

Die Sammlung enthält zwei didaktisch unterschiedliche Aufgabentypen:

| Typ                  | Ordnername                  | Idee                                                                                    |
| -------------------- | --------------------------- | --------------------------------------------------------------------------------------- |
| **Geführt**          | `NN-stub-…` / `NN-mock-…`   | Der zu verwendende Test Double ist im Ordnernamen genannt. Fokus: Konzept einüben.      |
| **Entscheidung**     | `NN-test-doubles-…`         | Der Ordnername lässt offen, ob Stub oder Mock passt. Fokus: anwenden und begründen.     |

## Aufgabenübersicht

> Diese Tabelle wächst mit der Sammlung. Aufgaben, die noch nicht angelegt sind, erscheinen kursiv.

| Nr.  | Aufgabe                                  | Typ           | Thema (Stichwort)                       |
| ---- | ---------------------------------------- | ------------- | --------------------------------------- |
| 01   | *stub-controlled-return-value*           | Geführt       | Kontrollierte Rückgabewerte             |
| 02   | *mock-notification-sender*               | Geführt       | Interaktion verifizieren                |
| 03   | *stub-error-case*                        | Geführt       | Fehler-/Ausnahmepfad testen             |
| 04   | *mock-interaction-verification*          | Geführt       | Aufrufparameter prüfen                  |
| 05   | *test-doubles-order-discount*            | Entscheidung  | Rabattberechnung                        |
| 06   | *test-doubles-registration*              | Entscheidung  | Benutzerregistrierung                   |
| 07   | *test-doubles-payment*                   | Entscheidung  | Zahlungsabwicklung                      |
| 08   | *test-doubles-inventory*                 | Entscheidung  | Lagerbestand                            |

## Hinweise für Lehrende

- Jede Aufgabe ist einzeln klonbar / verteilbar.
- Es gibt **keinen Parent-POM** — Versionen sind in jedem Aufgaben-POM eigenständig deklariert. Vorlage siehe [`docs/pom-template.xml`](docs/pom-template.xml).
- Lösungen werden in einem separaten, privaten Branch oder Repository gepflegt (nicht Teil dieser öffentlichen Sammlung).
