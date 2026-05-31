# Aufgabe 05 - Mock: Unterklasse zur Interaktionsprüfung

## Fachliche Ausgangssituation

Die Klasse `AccountActivationNotifier` erstellt eine Benachrichtigung, wenn ein Kundenkonto aktiviert wurde. Dafür braucht sie eine Abhängigkeit, die Nachrichten verschicken kann. Im echten Programm übernimmt das die Klasse `RemoteNotificationSender`, die die Nachricht an einen externen Benachrichtigungsdienst übertragen würde.

Anders als in Aufgabe 04 gibt es in dieser Aufgabe kein Interface für die Abhängigkeit. `AccountActivationNotifier` hängt direkt von der konkreten Klasse `RemoteNotificationSender` ab.

Wir nehmen außerdem an, dass `RemoteNotificationSender` nicht geändert werden kann. Deshalb kann für diese Abhängigkeit nicht einfach ein neues Interface eingeführt werden, zum Beispiel weil es sich um Legacy-Code handelt oder die Klasse von einem externen Team erstellt wurde.

Für den Unit-Test von `AccountActivationNotifier` soll `RemoteNotificationSender` trotzdem nicht mit seiner echten Logik verwendet werden. Stattdessen soll der Test einen sehr einfachen, handgeschriebenen Mock verwenden. Weil es kein Interface gibt, muss dieser Mock eine Unterklasse von `RemoteNotificationSender` sein und die Methode `send(String, String, String)` überschreiben.

Der Mock liefert keinen kontrollierten Rückgabewert. Er wird verwendet, um zu speichern, ob `AccountActivationNotifier` die Abhängigkeit aufgerufen hat und welche Argumente übergeben wurden.

## Lernziel

- Existierenden Code in Klassen- und Sequenzdiagrammen erfassen.
- Eine Abhängigkeit ersetzen, obwohl kein Interface vorhanden ist.
- Einen handgeschriebenen Mock als Unterklasse einer konkreten Klasse erstellen.
- Eine Interaktion mit einer Abhängigkeit verifizieren.
- Aufrufparameter prüfen, statt einen Rückgabewert zu kontrollieren.
- Die Testbarkeit einer konkreten Klassenabhängigkeit mit der Testbarkeit einer Interface-Abhängigkeit vergleichen.

## Technische Ausgangssituation

| Klasse / Interface                                      | Rolle                                  | Veränderbar? |
| ------------------------------------------------------- | -------------------------------------- | ------------ |
| `ex05.accountapp.AccountActivationNotifier`             | System under Test                        | ja           |
| `ex05.notificationservice.RemoteNotificationSender`     | echte Implementierung der Abhängigkeit | nein         |
| `ex05.accountapp.AccountActivationNotifierTest`         | Testklasse                             | ja           |

**Constraint:** Du darfst für die Lösung ausschließlich Code unter `src/test/java` ändern. Der Produktivcode bleibt unverändert.

**Hinweis zu `System.out`:** Die `System.out.println(...)`-Ausgaben im Produktivcode dienen nur dazu, die Demo auf der Konsole echter wirken zu lassen. Sie sind für die Lösung nicht relevant und sollen in den Tests nicht als eigener Exit Point betrachtet werden.

## Arbeitsaufträge

1. Lies den Produktivcode von `AccountActivationNotifier` und `RemoteNotificationSender`.

2. **Klassendiagramm:** Erstelle ein UML-Klassendiagramm für alle Klassen in diesem Projekt.

3. **Sequenzdiagramm:** Erstelle ein Sequenzdiagramm für den Fall, dass `AccountActivationNotifier` eine Benachrichtigung für ein aktiviertes Kundenkonto erstellt.

4. Vergleiche den Ist-Stand mit Aufgabe 04: `AccountActivationNotifier` verwendet hier kein Interface, sondern direkt die konkrete Klasse `RemoteNotificationSender`. Über Konstruktor-Injection, also eine Form von Dependency Injection, erhält `AccountActivationNotifier` die Abhängigkeit injiziert. Das bedeutet: Beim Erzeugen von `AccountActivationNotifier` wird ein passendes Objekt übergeben. In der Klasse `App` siehst du, dass `AccountActivationNotifier` dort ein Objekt von `RemoteNotificationSender` erhält.

5. Schreibe in `ex05.accountapp.AccountActivationNotifierTest` einen Unit-Test für `AccountActivationNotifier#notifyAccountActivated(String, String)`. Verwende für die `RemoteNotificationSender`-Abhängigkeit ein Test Double. Dazu eignet sich ein Mock, der den Aufruf von `send(String, String, String)` speichert und später im Test auslesbar macht. Weil es kein Interface gibt, muss der Mock von `RemoteNotificationSender` erben und `send(String, String, String)` überschreiben, damit er in `AccountActivationNotifier` injiziert werden kann. Schreibe den Test im AAA-Stil (Arrange, Act, Assert), wie in der Vorlesung besprochen.

6. Prüfe im Assert-Teil, dass `AccountActivationNotifier` genau die erwartete Benachrichtigung an die Abhängigkeit übergibt. Für den Aufruf

   ```java
   notifier.notifyAccountActivated("Ada", "ada@example.test");
   ```

   soll die Abhängigkeit mit folgenden Argumenten aufgerufen werden:

   - Empfängeradresse: `"ada@example.test"`
   - Betreff: `"Your account is active"`
   - Nachrichtentext: `"Hello Ada, your account has been activated."`

7. Reflexion: Welchen Vorteil und welchen Nachteil hat ein Mock als Unterklasse von `RemoteNotificationSender` im Vergleich zu einem Mock, der wie in Aufgabe 04 nur das Interface `AuditLog` implementiert? Woran erkennst du in diesem Beispiel, dass nicht ein Rückgabewert, sondern eine Interaktion im Mittelpunkt steht?

## Tests ausführen

```bash
mvn test
```

Aus dem Repository-Root:

```bash
mvn -f aufgaben/05-mock-subclass-interaction-verification/pom.xml test
```
