package org.masingerzero.modernjava;

import org.masingerzero.modernjava.model.Invoice;

public class FilterByQuantityLessThanFive implements InvoiceFilter {

    @Override
    public boolean test(Invoice invoice) {
        return invoice.getQuantity() < 5;
    }
}
