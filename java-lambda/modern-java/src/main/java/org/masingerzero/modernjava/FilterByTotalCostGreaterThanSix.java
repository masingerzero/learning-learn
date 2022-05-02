package org.masingerzero.modernjava;

import org.masingerzero.modernjava.model.Invoice;

public class FilterByTotalCostGreaterThanSix implements InvoiceFilter {

    @Override
    public boolean test(Invoice invoice) {
        return invoice.getTotalCost() > 6;
    }
}
