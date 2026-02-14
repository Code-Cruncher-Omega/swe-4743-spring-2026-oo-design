package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;
import edu.kennesaw.teashop.domain.inventory.InventoryRepository;

import java.util.ArrayList;

public class AllInventoryQuery implements InventoryQuery {
    private ArrayList<InventoryItem> query;


    public AllInventoryQuery(InventoryRepository inventory) {
        query = inventory.getItems();
    }

    public ArrayList<InventoryItem> run() {
        return query;
    }
}
