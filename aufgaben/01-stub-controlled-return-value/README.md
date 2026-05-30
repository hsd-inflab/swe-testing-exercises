# Aufgabe 01 - Stub: Kontrollierter Rückgabewert

## Fachliche Ausgangssituation

Die Klasse `WelcomeMessageCreator` erstellt eine Begrüßungsnachricht für eine Kundin oder einen Kunden. Dafür braucht sie eine passende Begrüßung von einer Abhängigkeit. Im echten Programm kommt diese Begrüßung aus der Klasse `TimeBasedGreetingProvider`, die je nach Tageszeit einen anderen Text liefern kann. `TimeBasedGreetingProvider` implementiert das Interface `GreetingProvider`.

Für den Unit-Test von `WelcomeMessageCreator` soll `TimeBasedGreetingProvider` nicht verwendet werden. Stattdessen soll der Test einen sehr einfachen, handgeschriebenen Stub verwenden. Dieser Stub implementiert ebenfalls `GreetingProvider` und liefert einen festen Rückgabewert.

## Lernziel

- Eine Abhängigkeit über ein Interface ersetzen.
- Einen handgeschriebenen Stub erstellen, der ein Interface implementiert.
- Einen kontrollierten Rückgabewert im Test verwenden.
- Das Ergebnis der getesteten Klasse prüfen, statt eine Interaktion zu verifizieren.

## Technische Ausgangssituation

| Klasse / Interface                              | Rolle                                  | Veränderbar? |
| ----------------------------------------------- | -------------------------------------- | ------------ |
| `ex01.welcomeapp.WelcomeMessageCreator`         | Unit under Test                        | ja           |
| `ex01.greetingservice.GreetingProvider`         | Interface der Abhängigkeit             | nein         |
| `ex01.greetingservice.TimeBasedGreetingProvider` | echte Implementierung der Abhängigkeit | nein         |
| `ex01.welcomeapp.WelcomeMessageCreatorTest`     | Testklasse                             | ja           |

**Constraint:** Du darfst für die Lösung ausschließlich Code unter `src/test/java` ändern. Der Produktivcode bleibt unverändert.

**Hinweis zu `System.out`:** Die `System.out.println(...)`-Ausgaben im Produktivcode dienen nur dazu, die Demo auf der Konsole echter wirken zu lassen. Sie sind für die Lösung nicht relevant und sollen in den Tests nicht als eigener Exit Point betrachtet werden.

## Arbeitsaufträge

1. Lies den Produktivcode von `WelcomeMessageCreator`, `GreetingProvider` und `TimeBasedGreetingProvider`.

2. Verstehe den Ist-Stand: `WelcomeMessageCreator` verwendet das Interface `GreetingProvider`. Über Konstruktor-Injection, also eine Form von Dependency Injection, erhält `WelcomeMessageCreator` die Abhängigkeit injiziert. Das bedeutet: Beim Erzeugen von `WelcomeMessageCreator` wird ein passendes Objekt übergeben. In der Klasse `App` siehst du, dass `WelcomeMessageCreator` dort ein Objekt von `TimeBasedGreetingProvider` erhält. Überlege, welchen Nachteil es hat, beim Unit-Test von `WelcomeMessageCreator` ebenfalls ein Objekt der Klasse `TimeBasedGreetingProvider` zu verwenden.

3. Schreibe in `ex01.welcomeapp.WelcomeMessageCreatorTest` einen Unit-Test für `WelcomeMessageCreator`. Verwende für die `GreetingProvider`-Abhängigkeit ein Test Double. Dazu eignet sich ein Stub, der einen geeigneten Wert zurückgibt, zum Beispiel `"Hallo"`. Der Stub muss das Interface `GreetingProvider` implementieren, damit er in `WelcomeMessageCreator` injiziert werden kann. Schreibe den Test im AAA-Stil (Arrange, Act, Assert), wie in der Vorlesung besprochen.

4. Reflexion: Warum ist der Stub in diesem Test geeigneter als ein Mock?

## Tests ausführen

```bash
mvn test
```

Aus dem Repository-Root:

```bash
mvn -f aufgaben/01-stub-controlled-return-value/pom.xml test
```
