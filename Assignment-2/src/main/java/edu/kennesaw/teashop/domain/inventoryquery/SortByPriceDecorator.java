package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.ArrayList;
import java.util.Comparator;

public class SortByPriceDecorator extends InventoryQueryDecoratorBase {
    private final boolean DESCENDING;

    public SortByPriceDecorator(InventoryQuery inner, boolean descending) {
        super(inner);
        DESCENDING = descending;
    }

    public ArrayList<InventoryItem> run() {
        query = INNER.run();
        query = new ArrayList<>(query.stream().sorted(Comparator.comparing(InventoryItem::getPRICE)).toList());
        if(DESCENDING) {
            query = new ArrayList<>(query.reversed());
        }
        return query;
    }
}
