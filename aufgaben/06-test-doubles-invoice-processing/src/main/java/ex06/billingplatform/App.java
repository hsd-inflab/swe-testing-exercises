package ex06.billingplatform;

import ex06.maildelivery.Mailer;
import ex06.renderingservice.PdfRenderer;

public class App {

    public static void main(String[] args) {
        InvoiceProcessor processor = new InvoiceProcessor(
                new TaxCalculator(),
                new DiscountApplier(),
                new InvoiceBuilder(),
                new PdfRenderer(),
                new Mailer()
        );

        InvoiceRequest req = new InvoiceRequest(
                "INV-2026-001",
                "kundin@example.com",
                25000
        );

        System.out.println(">>> Processing invoice " + req.getInvoiceId() + " ...");
        InvoiceResult result = processor.process(req);
        System.out.println(">>> Result: " + result);
    }
}
