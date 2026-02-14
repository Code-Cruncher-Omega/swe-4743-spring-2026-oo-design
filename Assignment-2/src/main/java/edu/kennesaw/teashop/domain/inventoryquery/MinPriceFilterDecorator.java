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
        for(int i = 0 ; i < query.size() ; i++) {
            while(query.get(i).getPRICE() < MIN) {
                query.remove(i);
            }
        }
        return query;
    }
}
