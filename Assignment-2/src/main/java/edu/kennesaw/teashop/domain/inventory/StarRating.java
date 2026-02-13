package edu.kennesaw.teashop.domain.inventory;

public class StarRating {
    private final int RATING;

    public StarRating(int rating) {
        if(rating < 1) {
            RATING = 0;
        } else if (rating > 4) {
            RATING = 5;
        } else {
            RATING = rating;
        }
    }

    public int getRATING() {
        return RATING;
    }
}
