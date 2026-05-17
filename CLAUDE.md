# Hinweise für Claude Code

Dieses Repository ist eine Sammlung von Java-Übungsaufgaben für Studierende im Software-Engineering-Kontext, Schwerpunkt **Test Doubles (Stubs/Mocks)**. Die Aufgaben werden auf GitHub veröffentlicht und in der Lehre eingesetzt.

## Kommunikation und Sprache

Klare Trennung:

- **Englisch (Industriestandard):** alles, was Code ist — Java-Bezeichner (Klassen, Methoden, Felder, Records), Package-Namen, Javadoc, In-Code-Kommentare. Auch Aufgaben-**Ordnernamen** in Englisch (z. B. `05-test-doubles-library-lending`), damit Ordner und Package-Slug zusammenpassen.
- **Deutsch:** Aufgaben-READMEs, Top-Level-`README.md`, `docs/allgemeine-hinweise.md`, Commit-Messages, Antworten in der Konversation.

Zielgruppe der Aufgabentexte sind Studierende — fachlich präzise, aber ohne Insider-Jargon.

## Technischer Stack (verbindlich für alle Aufgaben)

- Java 21
- Maven (jede Aufgabe ist ein **eigenständiges** Maven-Projekt mit eigener `pom.xml` — **kein Parent-POM**)
- JUnit 5 (`junit-jupiter`)
- AssertJ (`assertj-core`) für Assertions, nicht `org.junit.jupiter.api.Assertions`
- Mockito (`mockito-core`, `mockito-junit-jupiter`), wenn Stubs/Mocks sinnvoll sind

Versionen und Plugins: siehe [`docs/pom-template.xml`](docs/pom-template.xml). Beim Anlegen einer neuen Aufgabe **dieses Template kopieren**, nicht ad hoc einen neuen POM schreiben.

## Repository-Layout

```
swe-testing-exercises/
├── README.md                       # Übersicht + Aufgabentabelle
├── CLAUDE.md                       # diese Datei
├── aufgaben/<NN>-<kurzname>/       # je Aufgabe: README.md, pom.xml, src/, optional images/
└── docs/
    ├── allgemeine-hinweise.md      # für Studierende: Stub vs. Mock, AAA, AssertJ, Mockito-Kurzref
    └── pom-template.xml            # Vorlage für jede Aufgaben-pom.xml
```

Maven-Konvention: Produktivcode unter `src/main/java`, Tests unter `src/test/java`. Basis-Package: `de.hsd.swe.testing.<aufgabenkurzname>`.

## Aufgabentypen und Namensschema

Es gibt **zwei** didaktisch unterschiedliche Aufgabentypen — beide gehören in `aufgaben/`, aber sie folgen unterschiedlichen Namensregeln:

| Typ              | Ordnername                  | Idee                                                                 |
| ---------------- | --------------------------- | -------------------------------------------------------------------- |
| **Geführt**      | `NN-stub-…` / `NN-mock-…`   | Der Test Double ist im Ordnernamen explizit benannt.                 |
| **Entscheidung** | `NN-test-doubles-…`         | Ordnername lässt offen, ob Stub oder Mock passt — Studierende wählen. |

**Wichtig bei Entscheidungsaufgaben:** Weder Ordnername, README-Überschriften noch Klassennamen dürfen die Lösung verraten. Das Szenario soll so formuliert sein, dass *beide* Optionen zunächst denkbar wirken, aber eine fachlich klar besser passt. Wenn du beim Schreiben einer Entscheidungsaufgabe-README "Stub" oder "Mock" tippen willst, ist das ein Signal, dass du den didaktischen Aufhänger gerade auflöst.

## Didaktische Trennlinie (Stub vs. Mock)

- **Stub** → SUT *liest* etwas von der Abhängigkeit, Test prüft **Zustand/Rückgabewert** (state verification).
- **Mock** → SUT *teilt* der Abhängigkeit etwas mit (Command), Test prüft die **Interaktion** (interaction verification).

In Mockito ist technisch jedes `mock(...)`-Objekt ein "Mock"; die Unterscheidung Stub/Mock in dieser Sammlung bezieht sich auf die **Test-Intention**, nicht auf die API.

## Pflichtbestandteile einer Aufgaben-README

Jede `aufgaben/<NN-…>/README.md` enthält in dieser Reihenfolge:

1. Titel
2. Fachliche Ausgangssituation
3. Lernziel
4. Technische Ausgangssituation (vorhandene Klassen/Schnittstellen)
5. Konkrete Arbeitsaufträge
6. Akzeptanzkriterien (prüfbar formuliert, nicht "verify(...) verwenden")
7. Hinweise zum Ausführen der Tests (`mvn test`)
8. *Optional:* Reflexionsfragen
9. *Optional:* Hinweise, die nicht direkt die Lösung verraten

Akzeptanzkriterien beschreiben **fachliches Verhalten** ("Test prüft, dass die E-Mail an die richtige Adresse verschickt wurde"), nicht die Mockito-Syntax.

## Vorgehen beim Anlegen einer neuen Aufgabe

1. Klären, ob die Aufgabe geführt oder Entscheidung ist, und entsprechend benennen.
2. Ordner anlegen, `docs/pom-template.xml` als `pom.xml` kopieren, `artifactId` + `name` setzen.
3. Klassengerüst unter `src/main/java/...` anlegen (SUT + Abhängigkeits-Interface; bei geführten Aufgaben darf das Interface schon "naheliegend" sein, bei Entscheidungsaufgaben bewusst neutral).
4. Testklasse unter `src/test/java/...` — bei geführten Aufgaben optional ein Beispieltest, bei Entscheidungsaufgaben ggf. nur eine leere Klasse mit TODO.
5. README mit den Pflichtbestandteilen 1–7 schreiben.
6. Eintrag in der Aufgabentabelle im Top-Level-`README.md` aus *kursiv* in regulär ändern (= "Aufgabe ist verfügbar").

## Was nicht ins öffentliche Repo gehört

- Musterlösungen (laufen in einem separaten, privaten Branch/Repository).
- Persönliche Daten, Bewertungsschemata, Klausurfragen.

## Verifikation nach Aufgaben-Anlage

Nach dem Anlegen einer neuen Aufgabe `mvn -q -f aufgaben/<NN-…>/pom.xml test` aus dem Repo-Root ausführen und das Ergebnis nennen (auch wenn Tests bewusst fehlschlagen, weil die SUT noch nicht implementiert ist — das gehört in den Bericht).
