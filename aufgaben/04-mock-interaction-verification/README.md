# Aufgabe 04 - Mock: Interaktion verifizieren

## Fachliche Ausgangssituation

Die Klasse `AccountCreationReporter` erstellt einen Audit-Eintrag, wenn ein neues Kundenkonto angelegt wurde. Dafür braucht sie eine Abhängigkeit, die Audit-Einträge speichern kann. Im echten Programm übernimmt das die Klasse `RemoteAuditLog`, die den Eintrag an ein externes Audit-System übertragen würde. `RemoteAuditLog` implementiert das Interface `AuditLog`.

Für den Unit-Test von `AccountCreationReporter` soll kein echter Audit-Eintrag an ein externes System übertragen werden. Stattdessen soll der Test einen sehr einfachen, handgeschriebenen Mock für `AuditLog` verwenden. Dieser Mock liefert keinen kontrollierten Rückgabewert. Er wird verwendet, um zu speichern, ob `AccountCreationReporter` die Abhängigkeit aufgerufen hat und welche Argumente übergeben wurden.

## Lernziel

- Existierenden Code in Klassen- und Sequenzdiagrammen erfassen.
- Eine Abhängigkeit über ein Interface ersetzen.
- Einen handgeschriebenen Mock erstellen, der ein Interface implementiert.
- Eine Interaktion mit einer Abhängigkeit verifizieren.
- Aufrufparameter prüfen, statt einen Rückgabewert zu kontrollieren.
- Den Unterschied zwischen Stub und Mock an einem kleinen Beispiel begründen.

## Technische Ausgangssituation

| Klasse / Interface                                  | Rolle                                  | Veränderbar? |
| --------------------------------------------------- | -------------------------------------- | ------------ |
| `ex04.accountapp.AccountCreationReporter`           | Unit under Test                        | ja           |
| `ex04.auditservice.AuditLog`                        | Interface der Abhängigkeit             | nein         |
| `ex04.auditservice.RemoteAuditLog`                  | echte Implementierung der Abhängigkeit | nein         |
| `ex04.accountapp.AccountCreationReporterTest`       | Testklasse                             | ja           |

**Constraint:** Du darfst für die Lösung ausschließlich Code unter `src/test/java` ändern. Der Produktivcode bleibt unverändert.

**Hinweis zu `System.out`:** Die `System.out.println(...)`-Ausgaben im Produktivcode dienen nur dazu, die Demo auf der Konsole echter wirken zu lassen. Sie sind für die Lösung nicht relevant und sollen in den Tests nicht als eigener Exit Point betrachtet werden.

## Arbeitsaufträge

1. Lies den Produktivcode von `AccountCreationReporter`, `AuditLog` und `RemoteAuditLog`.

2. **Klassendiagramm:** Erstelle ein UML-Klassendiagramm für alle Klassen in diesem Projekt.

3. **Sequenzdiagramm:** Erstelle ein Sequenzdiagramm für den Fall, dass `AccountCreationReporter` einen Audit-Eintrag für ein neu angelegtes Kundenkonto erstellt.

4. Verstehe den Ist-Stand: `AccountCreationReporter` verwendet das Interface `AuditLog`. Über Konstruktor-Injection, also eine Form von Dependency Injection, erhält `AccountCreationReporter` die Abhängigkeit injiziert. Das bedeutet: Beim Erzeugen von `AccountCreationReporter` wird ein passendes Objekt übergeben. In der Klasse `App` siehst du, dass `AccountCreationReporter` dort ein Objekt von `RemoteAuditLog` erhält. Überlege, welchen Nachteil es hätte, beim Unit-Test von `AccountCreationReporter` ebenfalls ein Objekt der Klasse `RemoteAuditLog` zu verwenden.

5. Schreibe in `ex04.accountapp.AccountCreationReporterTest` einen Unit-Test für `AccountCreationReporter#reportAccountCreated(String, String)`. Verwende für die `AuditLog`-Abhängigkeit ein handgeschriebenes Test Double. Dazu eignet sich ein Mock, der `AuditLog` implementiert, den Aufruf von `record(String, String, String)` speichert und später im Test auslesbar macht. Der Mock soll in `AccountCreationReporter` injiziert werden. Schreibe den Test im AAA-Stil (Arrange, Act, Assert), wie in der Vorlesung besprochen.

6. Prüfe im Assert-Teil, dass `AccountCreationReporter` genau den erwarteten Audit-Eintrag an die Abhängigkeit übergibt. Für den Aufruf

   ```java
   reporter.reportAccountCreated("ACC-123", "Ada");
   ```

   soll die Abhängigkeit mit folgenden Argumenten aufgerufen werden:

   - Ereignistyp: `"ACCOUNT_CREATED"`
   - ID der betroffenen Entität: `"ACC-123"`
   - Details: `"Account for Ada was created."`

7. Reflexion: Warum ist hier ein Mock geeigneter als ein Stub? Woran erkennst du in diesem Beispiel, dass nicht ein Rückgabewert, sondern eine Interaktion im Mittelpunkt steht?

## Tests ausführen

```bash
mvn test
```

Aus dem Repository-Root:

```bash
mvn -f aufgaben/04-mock-interaction-verification/pom.xml test
```
