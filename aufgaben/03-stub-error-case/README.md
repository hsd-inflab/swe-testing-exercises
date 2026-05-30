# Aufgabe 03 - Stub: Fehlerfall erzwingen

## Fachliche Ausgangssituation

Die Klasse `ParcelStatusMessageCreator` erstellt eine kurze Statusnachricht für ein Paket. Dafür braucht sie den aktuellen Lieferstatus von einer Abhängigkeit. Im echten Programm kommt dieser Status aus der Klasse `ParcelTrackingClient`.

`ParcelTrackingClient` steht hier stellvertretend für einen externen Tracking-Dienst. Meist liefert dieser Dienst sinnvolle Statuswerte wie `"IN_DELIVERY"` oder `"DELIVERED"`. In seltenen Fällen schlägt aber die Verbindung fehl. In dieser Aufgabe ist das im Produktivcode absichtlich so modelliert, dass `ParcelTrackingClient` ungefähr bei jedem zwanzigsten Aufruf eine `IllegalStateException` wirft.

Beim Testen von `ParcelStatusMessageCreator` spielt diese seltene Exception eine wichtige Rolle. Die Aufgabe besteht darin, diesen Ausnahmepfad genauer zu betrachten und im Unit-Test prüfbar zu machen.

## Lernziel

- Einen seltenen Fehlerfall deterministisch testbar machen.
- Einen handgeschriebenen Stub erstellen, der eine Exception wirft.
- Mit `assertThrows` prüfen, dass ein erwarteter Ausnahmepfad eintritt.
- Begründen, warum ein Test nicht auf Zufall oder echte Verbindungsfehler warten sollte.

## Technische Ausgangssituation

| Klasse / Interface                              | Rolle                                  | Veränderbar? |
| ----------------------------------------------- | -------------------------------------- | ------------ |
| `ex03.parcelapp.ParcelStatusMessageCreator`     | Unit under Test                        | ja           |
| `ex03.trackingservice.ParcelTrackingClient`     | echte Implementierung der Abhängigkeit | nein         |
| `ex03.parcelapp.ParcelStatusMessageCreatorTest` | Testklasse                             | ja           |

**Constraint:** Du darfst für die Lösung ausschließlich Code unter `src/test/java` ändern. Der Produktivcode bleibt unverändert.

**Hinweis zu `System.out`:** Die `System.out.println(...)`-Ausgaben im Produktivcode dienen nur dazu, die Demo auf der Konsole echter wirken zu lassen. Sie sind für die Lösung nicht relevant und sollen in den Tests nicht als eigener Exit Point betrachtet werden.

## Arbeitsaufträge

1. Lies den Produktivcode von `ParcelStatusMessageCreator` und `ParcelTrackingClient`.

2. Verstehe den Ist-Stand: `ParcelStatusMessageCreator` hängt direkt von `ParcelTrackingClient` ab. Über Konstruktor-Injection, also eine Form von Dependency Injection, erhält `ParcelStatusMessageCreator` die Abhängigkeit injiziert. Das bedeutet: Beim Erzeugen von `ParcelStatusMessageCreator` wird ein passendes Objekt übergeben. In der Klasse `App` siehst du, dass `ParcelStatusMessageCreator` dort ein echtes Objekt von `ParcelTrackingClient` erhält.

3. Schau dir besonders `ParcelTrackingClient#currentStatusFor(String)` an. Die Methode liefert normalerweise einen Paketstatus zurück. Selten wirft sie aber eine `IllegalStateException`, weil die Verbindung zum Tracking-Dienst fehlgeschlagen ist. Überlege, warum ein Unit-Test schlecht wäre, der den echten `ParcelTrackingClient` zwanzigmal oder öfter aufruft und darauf hofft, dass irgendwann die Exception auftritt.

4. Schreibe in `ex03.parcelapp.ParcelStatusMessageCreatorTest` einen Unit-Test für den Fehlerfall. Verwende für die `ParcelTrackingClient`-Abhängigkeit ein Test Double. Dazu eignet sich ein Stub, der von `ParcelTrackingClient` erbt und `currentStatusFor(String)` überschreibt. Diese überschreibende Methode soll immer eine `IllegalStateException` werfen, zum Beispiel mit der Nachricht `"connection to tracking service failed"`.

5. Verwende im Test `assertThrows`, um zu prüfen, dass `ParcelStatusMessageCreator#createStatusMessage(String)` die erwartete Exception auslöst. Der Test soll im AAA-Stil (Arrange, Act, Assert) geschrieben sein, wie in der Vorlesung besprochen.

6. Schreibe einen zweiten Test für denselben Fehlerfall, diesmal aber ohne eine spezielle JUnit-Methode für Exceptions wie `assertThrows` zu verwenden. Der Test soll grün sein, wenn die Exception geworfen wird. Der Test soll rot sein, wenn keine Exception geworfen wird. Überlege, wie du das mit passenden Assertions ausdrücken kannst.

7. Reflexion: Warum ist der Stub in diesem Test geeigneter als der echte `ParcelTrackingClient`? Warum ist es hier sinnvoll, dass der Stub die Exception immer wirft, obwohl der echte Fehler nur selten auftritt?

## Tests ausführen

```bash
mvn test
```

Aus dem Repository-Root:

```bash
mvn -f aufgaben/03-stub-error-case/pom.xml test
```
