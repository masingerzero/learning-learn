package org.masingerzero.modernjava.chapter09;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FactoryPatternSandBox {
    public static void main(String[] args) {
        Product bond = ProductFactoryEnum.createProduct("bond");
        assert bond instanceof Bond;

    }

}

class ProductFactory {
    private final static Map<String, Supplier<Product>> productSupplier = new HashMap<>();
    static {
        productSupplier.put("loan", Loan::new);
        productSupplier.put("stock", Stock::new);
        productSupplier.put("bond", Bond::new);
    }

    public static Product createProduct(String name) {
        Product product = productSupplier.get(name).get();
        if (product == null) {
            throw new RuntimeException("No such product " + name);
        }
        return product;
    }
}

enum ProductFactoryEnum {
    LOAN(Loan::new),
    STOCK(Stock::new),
    BOND(Bond::new)
    ;
    private Supplier<Product> productSupplier;

    ProductFactoryEnum(Supplier<Product> productSupplier) {
        this.productSupplier = productSupplier;
    }

    public static Product createProduct(String name) {
        return ProductFactoryEnum
                .valueOf(name.toUpperCase())
                .productSupplier.get();
    }


}

class Product {

}

class Loan extends Product {

}

class Stock extends Product {

}

class Bond extends Product {

}