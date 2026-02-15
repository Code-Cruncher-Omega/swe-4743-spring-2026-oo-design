package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.ArrayList;

public class MinPriceFilterDecorator extends InventoryQueryDecoratorBase {
    private final double MIN;

    public MinPriceFilterDecorator(InventoryQuery inner, double min) {
        super(inner);
        MIN = min;
    }

    public ArrayList<InventoryItem> run() {
        query = INNER.run();
        query = new ArrayList<>(query.stream().filter(t -> t.getPrice() > MIN).toList());
        return query;
    }
}
