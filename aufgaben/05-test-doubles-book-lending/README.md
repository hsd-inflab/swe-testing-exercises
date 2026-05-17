# Aufgabe 05 — Test Doubles: Bibliotheksausleihe

**Aufgabentyp:** Entscheidungsaufgabe. Du entscheidest selbst, welche Abhängigkeiten du als Stub und welche als Mock behandelst.

## Ausgangssituation

Eine Klasse verarbeitet die Ausleihe eines Buches. Sie fragt zuerst beim `BookCatalog` nach, ob das Buch verfügbar ist.

- Ist es **verfügbar**, wird die Ausleihe im `BookCatalog` gespeichert und über den `ConfirmationSender` eine Bestätigung an die Nutzerin gesendet.
- Ist es **nicht verfügbar**, finden weder Speicherung noch Versand statt.

`BookCatalog` gehört zum eigenen System und ist anpassbar. `ConfirmationSender` ist eine Legacy-Klasse und darf **nicht** verändert werden.

## Lernziel

- SUT und Abhängigkeiten identifizieren.
- Pro Aufruf begründet entscheiden: Stub (Rückgabewert) oder Mock (Interaktion).
- Legacy-Klassen in Tests aus dem Spiel nehmen, ohne sie zu ändern.

## Technische Ausgangssituation

Package `de.hsd.swe.testing.lending`:

- `LendingService` (SUT): `boolean lend(String bookId, User user)` — Konstruktor-Injection bereits vorhanden.
- `BookCatalog` (Interface): `isAvailable(String)`, `saveLending(Lending)`.
- `ConfirmationSender` (konkrete Legacy-Klasse, nicht-`final`): `sendConfirmation(String email, String message)`.
- Records `Lending(bookId, userId)` und `User(id, email)`.

## Arbeitsauftrag

Implementiere Tests in `LendingServiceTest` für die zwei fachlichen Fälle:

1. **Buch verfügbar:** Ausleihe wird mit korrekter `bookId` und `userId` gespeichert; Bestätigung wird an die E-Mail-Adresse gesendet und enthält die `bookId`; Rückgabewert `true`.
2. **Buch nicht verfügbar:** Keine Speicherung, kein Versand; Rückgabewert `false`.

Verwende Mockito + AssertJ. Halte Arrange-Act-Assert sichtbar.

## Akzeptanzkriterien

- `mvn test` läuft grün.
- Beide Fälle (verfügbar / nicht verfügbar) sind je in mindestens einem Test abgedeckt.
- Der `ConfirmationSender` wird in den Tests nicht real aufgerufen.

## Ausführen

```bash
mvn test
```

## Reflexion (optional)

- Welcher Methodenaufruf brauchte einen Stub, welcher einen Mock — und warum?
- Wie würdest du mit dem `ConfirmationSender` umgehen, wenn er `final` wäre?

Stilkonventionen (AAA, AssertJ, Mockito): siehe [`docs/allgemeine-hinweise.md`](../../docs/allgemeine-hinweise.md).
