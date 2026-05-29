package ex06.renderingservice;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Concrete renderer maintained by RenderingService. Implements {@link Renderer}.
 * Owned by RenderingService and MUST NOT be modified by us.
 *
 * <p>Talks to a remote render farm, so calls take noticeable time.
 */
public class PdfRenderer implements Renderer {

    @Override
    public byte[] render(String content) {
        System.out.println("[PdfRenderer] Connecting to render farm at pdf.renderingservice.example...");
        System.out.println("[PdfRenderer] Uploading document (" + content.length() + " chars)...");
        System.out.println("[PdfRenderer] Compositing pages and applying template...");
        System.out.println("[PdfRenderer] Awaiting render worker (this can take a moment)...");

        int latencyMs = ThreadLocalRandom.current().nextInt(10000, 20001);
        try {
            Thread.sleep(latencyMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("interrupted while rendering invoice", e);
        }

        byte[] pdf = ("%PDF-FAKE-" + content.hashCode()).getBytes(StandardCharsets.UTF_8);
        System.out.println("[PdfRenderer] Render complete after " + latencyMs + " ms (" + pdf.length + " bytes).");
        System.out.println("[PdfRenderer] Downloading PDF blob.");
        return pdf;
    }
}
