package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.ArrayList;

public class MaxPriceFilterDecorator extends InventoryQueryDecoratorBase {
    private final double MAX;

    public MaxPriceFilterDecorator(InventoryQuery inner, double max) {
        super(inner);
        MAX = max;
    }

    public ArrayList<InventoryItem> run() {
        query = INNER.run();
        for(int i = 0 ; i < query.size() ; i++) {
            while(MAX < query.get(i).getPRICE()) {
                query.remove(i);
            }
        }
        return query;
    }
}
