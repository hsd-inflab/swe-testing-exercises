# Aufgabe 06 - Test Doubles: Invoice Processing

**Aufgabentyp:** Entscheidungsaufgabe.

## Fachliche Ausgangssituation

Unsere Firma **BillingPlatform** rechnet im Auftrag von Onlineshops Bestellungen ab und versendet die fertigen Rechnungen an die Kundinnen. Für jede Rechnung wird intern die Mehrwertsteuer berechnet, ab einem Bruttobetrag wird ein Rabatt angewendet und das fertige Rechnungsdokument zusammengestellt. Anschließend rendert der externe Dienstleister **RenderingService** den Rechnungsinhalt zu einer PDF-Datei. Die PDF wird vom externen Versandanbieter **MailDelivery** als E-Mail-Anhang an die Empfängerin verschickt. Der RenderingService läuft auf einer entfernten Render-Farm und braucht spürbar Zeit für die Antwort. Der Versand bei MailDelivery löst reale Nebenwirkungen aus (SMTP-Versand, echte E-Mails an Kundinnen) und darf in Tests nicht versehentlich ausgelöst werden. Unser Team ist für die Orchestrierung des Ablaufs sowie für die Steuer-, Rabatt- und Dokumentenlogik zuständig.

> *Hinweis:* Der Versand-Schritt ist fachlich kritisch, da er die fertige Rechnung an die Kundin schickt. In einem produktiven System müsste sein Erfolg explizit geprüft und im Fehlerfall behandelt werden (z. B. ausgelöste Exception, Retry, Outbox). Diese Fehlerbehandlung ist bewusst **nicht** Teil dieser Aufgabe.

## Lernziel

- Existierenden Code in Klassen- und Sequenzdiagrammen erfassen.
- Eine größere Unit of Work mit internen Kollaboratoren und externen Abhängigkeiten analysieren (Entry- und Exit-Points).
- Pro Aufruf begründet entscheiden, ob ein Stub, ein Mock oder die echte Instanz angemessen ist; insbesondere für die Frage, ob *interne* Kollaboratoren überhaupt durch Test Doubles ersetzt werden sollten.
- Den praktischen Unterschied zwischen Unit-, Integrations- und End-to-End-Test erleben.

## Technische Ausgangssituation

| Paket                      | Wofür                                                         | Veränderbar? |
| -------------------------- | ------------------------------------------------------------- | ------------ |
| `ex06.billingplatform.*`   | Unser Team (BillingPlatform): Verarbeitung der Rechnungen     | ja           |
| `ex06.renderingservice.*`  | Externer Dienst RenderingService: PDF-Rendering               | **nein**     |
| `ex06.maildelivery.*`      | Externer Dienst MailDelivery: Mail-Versand                    | **nein**     |

Die Klassen der beiden externen Unternehmen **dürfen nicht verändert werden**.

> *Hinweis:* Die Datentypen in unserem Package sind als klassische Klassen mit Gettern und Settern umgesetzt. In modernem Java würden sie als Java Records geschrieben (klassische Form hier bewusst zur Demonstration).

## Arbeitsaufträge

> Reflektiere nach jeder Teilaufgabe kurz: Was hast du dabei neu erkannt? Welche Annahme musstest du anpassen?

1. **Klassendiagramm:** Erstelle ein UML-Klassendiagramm für alle Klassen in diesem Projekt. Mache die Eigentumsverhältnisse sichtbar (z. B. Farben oder Notizen pro Owner).

2. **Sequenzdiagramme:** Erstelle ein Sequenzdiagramm für den Fall *mit* Rabatt (Brutto ≥ 100). Erstelle ein zweites Sequenzdiagramm für den Fall *ohne* Rabatt (Brutto < 100).

3. **Unit of Work:** Bestimme zuerst, welche Klassen zum Unit of Work gehören (Tipp: nicht jede Klasse unter `ex06.billingplatform.*` ist UoW-Code, z. B. ist die Demo-`App` keiner und reine Datentypen sind es auch nicht). Erstelle dann in der Notation aus der Vorlesung die **Entry Points** und **Exit Points** des UoW.

4. **Welche Klassen testen?** Schaue dir die Klassen unseres Teams unter `ex06.billingplatform.*` an. Welche sollten wir definitiv mit Unit-Tests abdecken, welche sind nicht notwendig? **Begründe deine Antwort** jeweils kurz.

5. **Unit-Tests:** Schreibe zu jedem identifizierten Exit Point aus 3. mindestens einen Unit-Test für `InvoiceProcessor` in `ex06.billingplatform.InvoiceProcessorTest`. Verwende Test Doubles für die Abhängigkeiten und entscheide selbst, welcher Typ je Abhängigkeit passt (z. B. Mock oder Stub). Entscheide außerdem bewusst, ob die **internen Kollaboratoren** `TaxCalculator`, `DiscountApplier` und `InvoiceBuilder` als Test Doubles oder als echte Instanzen eingesetzt werden. **Begründe deine Wahl** kurz im Test (Kommentar) oder schriftlich.

6. **Integrations-Tests:** Schreibe **zwei** Integrations-Tests, in denen `InvoiceProcessor` zusammen mit dem **echten** `PdfRenderer` läuft. Überlege bewusst, wie du mit `Mailer` umgehst.

7. **E2E-Test:** Schreibe **einen** End-to-End-Test, der den gesamten Pfad mit allen echten Komponenten durchläuft.

## Tests ausführen

```bash
mvn test
```

Demo zur Anschauung der echten Abhängigkeiten:

```bash
mvn -q compile
java -cp target/classes ex06.billingplatform.App
```
