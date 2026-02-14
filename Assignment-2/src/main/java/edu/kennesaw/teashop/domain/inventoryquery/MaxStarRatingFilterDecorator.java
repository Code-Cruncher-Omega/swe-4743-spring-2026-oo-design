package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;
import edu.kennesaw.teashop.domain.inventory.StarRating;

import java.util.ArrayList;

public class MaxStarRatingFilterDecorator extends InventoryQueryDecoratorBase {
    private final StarRating STAR_RATING;

    public MaxStarRatingFilterDecorator(InventoryQuery inner, int max) {
        super(inner);
        STAR_RATING = new StarRating(max);
    }

    public ArrayList<InventoryItem> run() {
        query = INNER.run();
        for(int i = 0 ; i < query.size() ; i++) {
            while(query.get(i).getRating() > STAR_RATING.getRATING()) {
                query.remove(i);
            }
        }
        return query;
    }
}
