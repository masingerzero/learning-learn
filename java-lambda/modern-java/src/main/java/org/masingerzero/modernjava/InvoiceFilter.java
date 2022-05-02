package org.masingerzero.modernjava;

import org.masingerzero.modernjava.model.Invoice;

public interface InvoiceFilter {
    public boolean test(Invoice invoice);
}
