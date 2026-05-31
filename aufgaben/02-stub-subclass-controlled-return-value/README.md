# Aufgabe 02 - Stub: Unterklasse mit kontrolliertem Rückgabewert

## Fachliche Ausgangssituation

Die Klasse `WelcomeMessageCreator` erstellt wie in Aufgabe 01 eine Begrüßungsnachricht für eine Kundin oder einen Kunden. Dafür braucht sie eine passende Begrüßung von einer Abhängigkeit. Im echten Programm kommt diese Begrüßung aus der Klasse `TimeBasedGreetingProvider`, die je nach Tageszeit einen anderen Text liefern kann.

Anders als in Aufgabe 01 gibt es in dieser Aufgabe kein Interface `GreetingProvider`. `WelcomeMessageCreator` hängt direkt von der konkreten Klasse `TimeBasedGreetingProvider` ab.

Wir nehmen außerdem an, dass `TimeBasedGreetingProvider` nicht geändert werden kann. Deshalb kann für diese Abhängigkeit nicht einfach ein neues Interface eingeführt werden, zum Beispiel weil es sich um Legacy-Code handelt oder die Klasse von einem externen Team erstellt wurde.

Für den Unit-Test von `WelcomeMessageCreator` soll `TimeBasedGreetingProvider` trotzdem nicht mit seiner echten Logik verwendet werden. Stattdessen soll der Test einen sehr einfachen, handgeschriebenen Stub verwenden. Weil es kein Interface gibt, muss dieser Stub eine Unterklasse von `TimeBasedGreetingProvider` sein und die Methode `currentGreeting()` überschreiben.

## Lernziel

- Existierenden Code in Klassen- und Sequenzdiagrammen erfassen.
- Eine Abhängigkeit ersetzen, obwohl kein Interface vorhanden ist.
- Einen handgeschriebenen Stub als Unterklasse einer konkreten Klasse erstellen.
- Einen kontrollierten Rückgabewert im Test verwenden.
- Die Testbarkeit einer konkreten Klassenabhängigkeit mit der Testbarkeit einer Interface-Abhängigkeit vergleichen.

## Technische Ausgangssituation

| Klasse / Interface                               | Rolle                                  | Veränderbar? |
| ------------------------------------------------ | -------------------------------------- | ------------ |
| `ex02.welcomeapp.WelcomeMessageCreator`          | Unit under Test                        | ja           |
| `ex02.greetingservice.TimeBasedGreetingProvider` | echte Implementierung der Abhängigkeit | nein         |
| `ex02.welcomeapp.WelcomeMessageCreatorTest`      | Testklasse                             | ja           |

**Constraint:** Du darfst für die Lösung ausschließlich Code unter `src/test/java` ändern. Der Produktivcode bleibt unverändert.

**Hinweis zu `System.out`:** Die `System.out.println(...)`-Ausgaben im Produktivcode dienen nur dazu, die Demo auf der Konsole echter wirken zu lassen. Sie sind für die Lösung nicht relevant und sollen in den Tests nicht als eigener Exit Point betrachtet werden.

## Arbeitsaufträge

1. Lies den Produktivcode von `WelcomeMessageCreator` und `TimeBasedGreetingProvider`.

2. **Klassendiagramm:** Erstelle ein UML-Klassendiagramm für alle Klassen in diesem Projekt.

3. **Sequenzdiagramm:** Erstelle ein Sequenzdiagramm für den Fall, dass `WelcomeMessageCreator` eine Begrüßungsnachricht erstellt.

4. Vergleiche den Ist-Stand mit Aufgabe 01: `WelcomeMessageCreator` verwendet hier nicht das Interface `GreetingProvider`, sondern direkt die konkrete Klasse `TimeBasedGreetingProvider`. Über Konstruktor-Injection, also eine Form von Dependency Injection, erhält `WelcomeMessageCreator` die Abhängigkeit injiziert. Das bedeutet: Beim Erzeugen von `WelcomeMessageCreator` wird ein passendes Objekt übergeben. In der Klasse `App` siehst du, dass `WelcomeMessageCreator` dort ein Objekt von `TimeBasedGreetingProvider` erhält.

5. Schreibe in `ex02.welcomeapp.WelcomeMessageCreatorTest` einen Unit-Test für `WelcomeMessageCreator`. Verwende für die `TimeBasedGreetingProvider`-Abhängigkeit ein Test Double. Dazu eignet sich ein Stub, der einen geeigneten Wert zurückgibt, zum Beispiel `"Hallo"`. Weil es kein Interface gibt, muss der Stub von `TimeBasedGreetingProvider` erben und `currentGreeting()` überschreiben, damit er in `WelcomeMessageCreator` injiziert werden kann. Schreibe den Test im AAA-Stil (Arrange, Act, Assert), wie in der Vorlesung besprochen.

6. Reflexion: Welchen Vorteil und welchen Nachteil hat ein Stub als Unterklasse von `TimeBasedGreetingProvider` im Vergleich zu einem Stub, der wie in Aufgabe 01 nur das Interface `GreetingProvider` implementiert?

## Tests ausführen

```bash
mvn test
```

Aus dem Repository-Root:

```bash
mvn -f aufgaben/02-stub-subclass-controlled-return-value/pom.xml test
```
