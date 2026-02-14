package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.ArrayList;

public interface InventoryQuery {
    ArrayList<InventoryItem> run();
}
