package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;
import edu.kennesaw.teashop.domain.inventory.StarRating;

import java.util.ArrayList;

public class MinStarRatingFilterDecorator extends InventoryQueryDecoratorBase {
    private final StarRating MIN_STAR_RATING;

    public MinStarRatingFilterDecorator(InventoryQuery inner, int min) {
        super(inner);
        MIN_STAR_RATING = new StarRating(min);
    }

    public ArrayList<InventoryItem> run() {
        query = INNER.run();
        query = new ArrayList<>(query.stream().filter(t -> t.getRating() > MIN_STAR_RATING.getRATING()).toList());
        return query;
    }
}
