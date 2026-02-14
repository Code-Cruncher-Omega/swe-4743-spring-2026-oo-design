package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.ArrayList;

public class AvailabilityFilterDecorator extends InventoryQueryDecoratorBase {
    public AvailabilityFilterDecorator(InventoryQuery inner) {
        super(inner);
    }

    public ArrayList<InventoryItem> run() {
        query = INNER.run();
        query = new ArrayList<>(query.stream().filter(t -> t.getQuantity() > 0).toList());
        return query;
    }
}
