package ex21.billingplatform;

import ex21.maildelivery.Mailer;
import ex21.renderingservice.Renderer;

/**
 * Orchestrates the invoice processing: tax -> discount -> document -> PDF -> mail.
 * Owned by our team (BillingPlatform) and may be modified.
 */
public class InvoiceProcessor {

    private final TaxCalculator taxCalculator;
    private final DiscountApplier discountApplier;
    private final InvoiceBuilder invoiceBuilder;
    private final Renderer renderer;
    private final Mailer mailer;

    public InvoiceProcessor(TaxCalculator taxCalculator,
                            DiscountApplier discountApplier,
                            InvoiceBuilder invoiceBuilder,
                            Renderer renderer,
                            Mailer mailer) {
        this.taxCalculator = taxCalculator;
        this.discountApplier = discountApplier;
        this.invoiceBuilder = invoiceBuilder;
        this.renderer = renderer;
        this.mailer = mailer;
    }

    public InvoiceResult process(InvoiceRequest req) {
        Tax tax = taxCalculator.calculate(req);
        Discount discount = discountApplier.apply(req, tax);
        InvoiceDocument doc = invoiceBuilder.build(req, tax, discount);
        byte[] pdf = renderer.render(doc.toRenderableContent());

        if (isEmpty(pdf)) {
            throw new IllegalStateException("rendered invoice PDF must not be empty");
        }
        
        mailer.send(req.getCustomerEmail(), pdf);
        return new InvoiceResult(req.getInvoiceId(), doc.getTotal());
    }

    private boolean isEmpty(byte[] pdf) {
        return pdf == null || pdf.length == 0;
    }
}
