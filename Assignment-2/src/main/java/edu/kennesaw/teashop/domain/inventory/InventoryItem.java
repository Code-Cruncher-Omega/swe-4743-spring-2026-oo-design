package edu.kennesaw.teashop.domain.inventory;

import java.util.UUID;

public class InventoryItem {
    private final UUID ID;
    private final String NAME;
    private final double PRICE;
    private int quantity;
    private final StarRating STAR_RATING;

    public InventoryItem(UUID id, String name, double price, int quantity, StarRating rating) {
        ID = id;
        NAME = name;
        PRICE = price;
        this.quantity = quantity;
        STAR_RATING = rating;
    }

    public UUID getID() {
        return ID;
    }

    public String getName() {
        return NAME;
    }

    public double getPrice() {
        return PRICE;
    }

    public int getQuantity() {
        return quantity;
    }

    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public int getRating() {
        return STAR_RATING.getCount();
    }
}
