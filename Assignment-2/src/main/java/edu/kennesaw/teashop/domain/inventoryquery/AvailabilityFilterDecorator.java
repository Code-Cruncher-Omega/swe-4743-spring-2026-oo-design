package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.ArrayList;

public class AvailabilityFilterDecorator extends InventoryQueryDecoratorBase {
    public AvailabilityFilterDecorator(InventoryQuery inner) {
        super(inner);
    }

    public ArrayList<InventoryItem> run() {
        query = INNER.run();
        for(int i = 0 ; i < query.size() ; i++) {
            while(query.get(i).getQuantity() < 1) {
                query.remove(i);
            }
        }
        return query;
    }
}
