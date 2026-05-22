package ex06.renderingservice;

/**
 * Renderer API published by RenderingService alongside their concrete
 * implementation. Owned by RenderingService.
 *
 * <p>Accepts a content string (e.g., HTML or a plain-text representation of
 * the document) and returns the rendered PDF bytes. The renderer does not
 * know about any specific customer domain model.
 */
public interface Renderer {

    byte[] render(String content);
}
