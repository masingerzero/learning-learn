package org.masingerzero.modernjava;

import org.masingerzero.modernjava.model.Invoice;

public class FilterByItemNameOrange implements InvoiceFilter {

    @Override
    public boolean test(Invoice invoice) {
        return invoice.getItemName().equals("orange");
    }
}
