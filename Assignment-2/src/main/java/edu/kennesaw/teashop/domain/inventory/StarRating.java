package edu.kennesaw.teashop.domain.inventory;

public class StarRating {
    private final int RATING;

    public StarRating(int stars) {
        if(stars < 1) {
            RATING = 1;
        } else if (stars > 5) {
            RATING = 5;
        } else {
            RATING = stars;
        }
    }

    public int getRATING() {
        return RATING;
    }
}
