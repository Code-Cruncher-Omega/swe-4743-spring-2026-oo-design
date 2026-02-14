package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.ArrayList;

public class NameContainsFilterDecorator extends InventoryQueryDecoratorBase {
    private final String TEXT;

    public NameContainsFilterDecorator(InventoryQuery inner, String text) {
        super(inner);
        TEXT = text;
    }

    public ArrayList<InventoryItem> run() {
        query = INNER.run();
        for(int i = 0 ; i < query.size() ; i++) {
            while(!query.get(i).getNAME().contains(TEXT)) {
                query.remove(i);
            }
        }
        return query;
    }
}
