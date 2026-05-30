# Aufgabe 06 - Mock: Fehlerfall ohne externen Aufruf prüfen

## Fachliche Ausgangssituation

Die Klasse `PasswordResetRequester` startet den Passwort-Zurücksetzen-Prozess für ein Kundenkonto. Dafür prüft sie zuerst die übergebene E-Mail-Adresse. Nur wenn die Adresse gültig aussieht, erstellt sie eine Nachricht und übergibt diese an eine Abhängigkeit, die eine Passwort-Reset-Mail verschicken kann.

Im echten Programm übernimmt das die Klasse `RemotePasswordResetMailSender`. Sie steht hier stellvertretend für einen externen Mail-Dienst. `RemotePasswordResetMailSender` implementiert das Interface `PasswordResetMailSender`.

Für den Unit-Test von `PasswordResetRequester` soll keine echte Mail an einen externen Dienst übergeben werden. Stattdessen soll der Test einen handgeschriebenen Mock für `PasswordResetMailSender` verwenden. Dieser Mock liefert keinen kontrollierten Rückgabewert. Er wird verwendet, um zu speichern, ob `PasswordResetRequester` die Abhängigkeit aufgerufen hat und welche Argumente übergeben wurden.

Der besondere Fokus dieser Aufgabe liegt auf dem Fehlerfall: Wenn die E-Mail-Adresse ungültig ist, soll `PasswordResetRequester` eine `IllegalArgumentException` werfen und die Mail-Abhängigkeit gerade nicht aufrufen. Anders als in Aufgabe 03 wird der Fehlerfall hier also nicht durch einen Stub der Abhängigkeit erzeugt. Der Fehler entsteht in der System under Test selbst, und der Mock hilft dabei, die Interaktion mit der Abhängigkeit zu prüfen.

## Lernziel

- Einen Fehlerfall testen, bei dem eine externe Abhängigkeit nicht aufgerufen werden darf.
- Einen handgeschriebenen Mock erstellen, der ein Interface implementiert.
- Eine erfolgte Interaktion mit erwarteten Argumenten verifizieren.
- Eine ausbleibende Interaktion im Fehlerfall verifizieren.
- Begründen, warum in diesem Beispiel ein Mock und kein Stub im Mittelpunkt steht.

## Technische Ausgangssituation

| Klasse / Interface                                      | Rolle                                  | Veränderbar? |
| ------------------------------------------------------- | -------------------------------------- | ------------ |
| `ex06.accountapp.PasswordResetRequester`                | Unit under Test                        | ja           |
| `ex06.notificationservice.PasswordResetMailSender`      | Interface der Abhängigkeit             | nein         |
| `ex06.notificationservice.RemotePasswordResetMailSender`| echte Implementierung der Abhängigkeit | nein         |
| `ex06.accountapp.PasswordResetRequesterTest`            | Testklasse                             | ja           |

**Constraint:** Du darfst für die Lösung ausschließlich Code unter `src/test/java` ändern. Der Produktivcode bleibt unverändert.

**Hinweis zu `System.out`:** Die `System.out.println(...)`-Ausgaben im Produktivcode dienen nur dazu, die Demo auf der Konsole echter wirken zu lassen. Sie sind für die Lösung nicht relevant und sollen in den Tests nicht als eigener Exit Point betrachtet werden.

## Arbeitsaufträge

1. Lies den Produktivcode von `PasswordResetRequester`, `PasswordResetMailSender` und `RemotePasswordResetMailSender`.

2. Verstehe den Ist-Stand: `PasswordResetRequester` verwendet das Interface `PasswordResetMailSender`. Über Konstruktor-Injection, also eine Form von Dependency Injection, erhält `PasswordResetRequester` die Abhängigkeit injiziert. Das bedeutet: Beim Erzeugen von `PasswordResetRequester` wird ein passendes Objekt übergeben. In der Klasse `App` siehst du, dass `PasswordResetRequester` dort ein Objekt von `RemotePasswordResetMailSender` erhält.

3. Schreibe in `ex06.accountapp.PasswordResetRequesterTest` einen Unit-Test für den Erfolgsfall von `PasswordResetRequester#requestPasswordReset(String, String)`. Verwende für die `PasswordResetMailSender`-Abhängigkeit ein handgeschriebenes Test Double. Dazu eignet sich ein Mock, der `PasswordResetMailSender` implementiert, den Aufruf von `sendPasswordResetMail(String, String, String)` speichert und später im Test auslesbar macht. Schreibe den Test im AAA-Stil (Arrange, Act, Assert), wie in der Vorlesung besprochen.

4. Prüfe im Assert-Teil, dass `PasswordResetRequester` genau die erwartete Mail an die Abhängigkeit übergibt. Für den Aufruf

   ```java
   requester.requestPasswordReset("CUST-123", "ada@example.test");
   ```

   soll die Abhängigkeit mit folgenden Argumenten aufgerufen werden:

   - Empfängeradresse: `"ada@example.test"`
   - Betreff: `"Reset your password"`
   - Nachrichtentext: `"Use this link to reset the password for account CUST-123: https://account.example/reset?customerId=CUST-123"`

5. Schreibe einen zweiten Unit-Test für den Fehlerfall. Rufe `requester.requestPasswordReset("CUST-123", "not-an-email")` auf und prüfe mit `assertThrows`, dass eine `IllegalArgumentException` geworfen wird.

6. Prüfe im selben Fehlerfall zusätzlich mit deinem Mock, dass `sendPasswordResetMail(String, String, String)` nicht aufgerufen wurde. Der Test soll also nicht nur die Exception prüfen, sondern auch die ausbleibende Interaktion mit der externen Abhängigkeit.

7. Reflexion: Warum ist der Mock in diesem Test geeigneter als der echte `RemotePasswordResetMailSender`? Woran erkennst du, dass hier nicht ein Rückgabewert kontrolliert wird, sondern eine Interaktion beziehungsweise eine ausbleibende Interaktion geprüft wird? Was ist das Risiko beim Verwenden eines Mocks für diesen Fall?

## Tests ausführen

```bash
mvn test
```

Aus dem Repository-Root:

```bash
mvn -f aufgaben/06-mock-error-case/pom.xml test
```
