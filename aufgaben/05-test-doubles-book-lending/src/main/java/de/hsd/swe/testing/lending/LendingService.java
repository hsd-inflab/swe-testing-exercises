package de.hsd.swe.testing.lending;

import de.hsd.swe.testing.lending.model.Lending;
import de.hsd.swe.testing.lending.model.User;

/**
 * Processes a book lending requested by a user.
 *
 * <p>The service first asks the {@link BookCatalog} whether the requested book
 * is available. If it is, the lending is saved in the catalog and a
 * confirmation is sent through the {@link ConfirmationSender}. If the book is
 * not available, neither saving nor sending takes place.
 */
public class LendingService {

    private final BookCatalog bookCatalog;
    private final ConfirmationSender confirmationSender;

    public LendingService(BookCatalog bookCatalog, ConfirmationSender confirmationSender) {
        this.bookCatalog = bookCatalog;
        this.confirmationSender = confirmationSender;
    }

    public boolean lend(String bookId, User user) {
        if (!bookCatalog.isAvailable(bookId)) {
            return false;
        }

        bookCatalog.saveLending(new Lending(bookId, user.id()));
        confirmationSender.sendConfirmation(
                user.email(),
                "Loan confirmed: book " + bookId
        );
        return true;
    }
}
