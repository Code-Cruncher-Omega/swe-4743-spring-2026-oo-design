package edu.kennesaw.teashop.domain.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InventoryRepository {
    private final List<InventoryItem> ITEMS = List.of(
            new InventoryItem(UUID.randomUUID(), "Green Tea", 15.99, 50, new StarRating(4)),
            new InventoryItem(UUID.randomUUID(), "Black Tea", 12.49, 75, new StarRating(5)),
            new InventoryItem(UUID.randomUUID(), "Herbal Tea", 14.29, 30, new StarRating(3)),
            new InventoryItem(UUID.randomUUID(), "Oolong Tea", 18.00, 10, new StarRating(5)),
            new InventoryItem(UUID.randomUUID(), "Matcha", 29.99, 0, new StarRating(4)),
            new InventoryItem(UUID.randomUUID(), "White Tea", 22.50, 25, new StarRating(4)),
            new InventoryItem(UUID.randomUUID(), "Chai Tea", 10.99, 60, new StarRating(3)),
            new InventoryItem(UUID.randomUUID(), "Earl Grey", 13.99, 45, new StarRating(5)),
            new InventoryItem(UUID.randomUUID(), "Rooibos", 17.10, 0, new StarRating(5)),
            new InventoryItem(UUID.randomUUID(), "Mint Tea", 11.89, 80, new StarRating(1)),
            new InventoryItem(UUID.randomUUID(), "Jasmine Green", 16.75, 35, new StarRating(4)),
            new InventoryItem(UUID.randomUUID(), "Darjeeling", 21.60, 18, new StarRating(5))
    );

    public boolean purchase(UUID id, int quantity) {
        for(InventoryItem item : ITEMS) {
            if(item.getID().equals(id)) {
                item.removeQuantity(quantity);
                return true;    // Successful
            }
        }
        return false;   // Failed - Item not found
    }

    public InventoryItem getItem(int index) {
        return ITEMS.get(index);
    }

    public ArrayList<InventoryItem> getItems() {
        return new ArrayList<>(ITEMS);
    }
}
