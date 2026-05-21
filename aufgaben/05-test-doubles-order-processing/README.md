# Aufgabe 05 - Test Doubles: Order Processing

**Aufgabentyp:** Entscheidungsaufgabe.

## Fachliche Ausgangssituation

Unsere Firma **OrderingPlatform** betreibt die Bestellplattform eines Onlineshops. Bevor eine Bestellung in den Versandprozess geht, muss der externe Dienstleister **RiskAssessment** sie freigeben. Geprüft werden Bonität, Bestellhistorie und Betrugssignale. Wird die Bestellung freigegeben, informiert unser System anschließend den externen Versandpartner **LogisticsProvider**, der den eigentlichen Versand inklusive Kundenbenachrichtigung anstößt. Wird sie abgelehnt, passiert nichts weiter. Die Kundin erfährt davon über einen separaten Kanal. Der Prüfdienst von RiskAssessment läuft über ein entferntes System und braucht spürbar Zeit für die Antwort. Der Versandstart bei LogisticsProvider löst reale Nebenwirkungen aus (CRM-Lookup, Templating, SMTP-Versand) und darf in Tests nicht versehentlich ausgelöst werden, sonst gehen z. B. echte E-Mails raus. Unser Team ist nur für die Orchestrierung der Verarbeitung zuständig.

> *Hinweis:* Der Notification-Schritt ist fachlich kritisch, da er den realen Versand anstößt. In einem produktiven System müsste sein Erfolg explizit geprüft und im Fehlerfall behandelt werden (z. B. ausgelöste Exception, Retry, Outbox). Diese Fehlerbehandlung ist bewusst **nicht** Teil dieser Aufgabe.

## Lernziel

- Existierenden Code in Klassen- und Sequenzdiagrammen erfassen.
- Eine Unit of Work mit Entry- und Exit-Points präzise beschreiben.
- Begründet entscheiden, welche Abhängigkeiten als Stub bzw. Mock ersetzt werden.
- Den praktischen Unterschied zwischen Unit-, Integrations- und End-to-End-Test erleben.

## Technische Ausgangssituation

| Klasse                                                  | Owner             | Veränderbar? |
| ------------------------------------------------------- | ----------------- | ------------ |
| `orderprocessing.orderingplatform.OrderProcessor`       | OrderingPlatform  | ja           |
| `orderprocessing.orderingplatform.App` (Demo-`main`)    | OrderingPlatform  | ja           |
| `orderprocessing.riskassessment.Approver` (Interface)   | RiskAssessment    | **nein**     |
| `orderprocessing.riskassessment.RemoteApprover`         | RiskAssessment    | **nein**     |
| `orderprocessing.logisticsprovider.NotificationSender`  | LogisticsProvider | **nein**     |

**Constraint:** Du darfst ausschließlich Code unter `orderprocessing.orderingplatform.*` ändern. Klassen unter `orderprocessing.riskassessment.*` und `orderprocessing.logisticsprovider.*` bleiben unverändert.

## Arbeitsaufträge

> Reflektiere nach jeder Teilaufgabe kurz: Was hast du dabei neu erkannt? Welche Annahme musstest du anpassen?

1. **Klassendiagramm:** Erstelle ein UML-Klassendiagramm für alle Klassen in diesem Projekt. Mache die Eigentumsverhältnisse sichtbar (z. B. Farben oder Notizen pro Owner).

2. **Sequenzdiagramm:** Erstelle ein Sequenzdiagramm für den Fall, dass die Anfrage *approved* wurde. Erstelle ein zweites Sequenzdiagramm für den Fall, dass die Anfrage nicht *approved* wurde.

3. **Unit of Work:** Bestimme in der Notation aus der Vorlesung die **Entry Points** und **Exit Points** des `OrderProcessor` (= Unit of Work).

4. **Unit-Tests:** Schreibe geeignete Unit-Tests für `OrderProcessor` in `orderprocessing.orderingplatform.OrderProcessorTest`. Verwende Test Doubles für die Abhängigkeiten und entscheide selbst, welcher Typ je Abhängigkeit passt (z. B. Mock oder Stub). **Begründe deine Wahl** kurz im Test (Kommentar) oder schriftlich.

5. **Integrations-Tests:** Schreibe **zwei** Integrations-Tests, in denen `OrderProcessor` zusammen mit dem **echten** `RemoteApprover` läuft. Überlege bewusst, wie du mit `NotificationSender` umgehst.

6. **E2E-Test:** Schreibe **einen** End-to-End-Test, der den gesamten Pfad mit allen echten Komponenten durchläuft.


## Tests ausführen

```bash
mvn test
```

Demo zur Anschauung der echten Abhängigkeiten:

```bash
mvn -q compile
java -cp target/classes orderprocessing.orderingplatform.App
```
