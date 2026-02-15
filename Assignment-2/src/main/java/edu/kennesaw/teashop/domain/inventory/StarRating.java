package edu.kennesaw.teashop.domain.inventory;

public class StarRating {
    private final int COUNT;

    public StarRating(int count) {
        if(count < 1) {
            COUNT = 1;
        } else if (count > 5) {
            COUNT = 5;
        } else {
            COUNT = count;
        }
    }

    public int getCount() {
        return COUNT;
    }
}
