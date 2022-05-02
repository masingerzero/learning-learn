package org.masingerzero.modernjava;

import org.masingerzero.modernjava.model.DataHelper;
import org.masingerzero.modernjava.model.Invoice;
import org.masingerzero.modernjava.model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class InvoiceFunctionalSandBox {

    public static void main(String[] args) {
        //order invoices by name
        List<Invoice> invoices = DataHelper.getInvoices();

        Function<Integer, String> function = InvoiceFunctionalSandBox::getStringFromInt;
       // Function<Object, String> function2 = InvoiceFunctionalSandBox::getString;
        comparing((Person p) -> p.getAge());
        Comparator.comparing(Person::getAge);
//        Function<?, String> function = Person::getAge;
        Function<Person, String> f1 = Person::getName;
        Function<Person, String> f2 = (Person p) -> p.getName();


    }

    public static List<Invoice> orderByName(List<Invoice> invoiceList) {
        //Collections.sort(invoiceList, );
        return null;
    }

    public static String getStringFromInt(Integer i) {
        return Integer.toString(i);
    }

    public static String getString() {
        return "hola";
    }

    //public<T,U> static void comparing (Function<? super T,? extends U> keyExtractor) {

    //}
    public static <T, U> Function<T,U>  comparing(
            Function<T, U> keyExtractor)
    {
        return keyExtractor;
    }
}
