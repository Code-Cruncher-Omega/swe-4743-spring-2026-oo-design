package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;
import edu.kennesaw.teashop.domain.inventory.StarRating;

import java.util.ArrayList;

public class MaxStarRatingFilterDecorator extends InventoryQueryDecoratorBase {
    private final StarRating MAX_STAR_RATING;

    public MaxStarRatingFilterDecorator(InventoryQuery inner, int max) {
        super(inner);
        MAX_STAR_RATING = new StarRating(max);
    }

    public ArrayList<InventoryItem> run() {
        query = INNER.run();
        query = new ArrayList<>(query.stream().filter(t -> t.getRating() < MAX_STAR_RATING.getCount()).toList());
        return query;
    }
}
