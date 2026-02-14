package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.ArrayList;

public abstract class InventoryQueryDecoratorBase implements InventoryQuery {
    protected final InventoryQuery INNER;
    protected ArrayList<InventoryItem> query;

    public InventoryQueryDecoratorBase(InventoryQuery inner) {
        INNER = inner;
    }

    public abstract ArrayList<InventoryItem> run();
}
