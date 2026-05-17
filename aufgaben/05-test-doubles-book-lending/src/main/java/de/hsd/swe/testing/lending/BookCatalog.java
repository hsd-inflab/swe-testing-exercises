package de.hsd.swe.testing.lending;

import de.hsd.swe.testing.lending.model.Lending;

/**
 * Manages books and lendings of the library. Part of our own system and may be
 * adapted if needed for testability.
 */
public interface BookCatalog {

    boolean isAvailable(String bookId);

    void saveLending(Lending lending);
}
