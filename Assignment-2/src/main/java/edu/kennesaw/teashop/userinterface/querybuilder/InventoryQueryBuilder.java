package edu.kennesaw.teashop.userinterface.querybuilder;

import edu.kennesaw.teashop.domain.inventory.InventoryRepository;
import edu.kennesaw.teashop.domain.inventoryquery.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InventoryQueryBuilder {
    private final String AVAILABILITY = "Y";
    private final double MINIMUM = 0.0;
    private final double MAXIMUM = 1000.0;
    private final int MINIMUM_STARS = 3;
    private final int MAXIMUM_STARS = 5;
    private final String PRICE_SORT = "A";
    private final String STARS_SORT = "D";

    private InventoryQuery query;
    private InventoryRepository repo;
    private PrintStream console;
    private Scanner scan;

    public InventoryQueryBuilder(InventoryRepository invRepo, InputStream input, PrintStream output) {
        repo = invRepo;
        reset();
        scan = new Scanner(input);
        console = output;
    }

    public InventoryQuery getQuery() {
        return query;
    }

    public String containsTextFilter() {
        String contains;
        console.print("* Tea name contains (leave blank for all names: ");
        contains = scan.nextLine();
        if(!contains.isEmpty()) {
            query = new NameContainsFilterDecorator(query, contains);
        }
        return contains;
    }

    public String availabilityFilter() {
        String availability;
        while(true) {
            console.print("* Is available? (Y/N, default " + AVAILABILITY + "): ");
            availability = scan.nextLine();
            if(availability.length() > 1) {
                console.println("Error - Enter only one character");
                console.println();
                continue;
            }
            if(availability.isEmpty()) {
                availability = AVAILABILITY;
            }
            if(availability.toLowerCase().charAt(0) == 'n') {
                return availability;
            }
            if(availability.toLowerCase().charAt(0) == 'y') {
                query = new AvailabilityFilterDecorator(query);
                return availability;
            }
            console.println("Error - Enter a valid character");
        }
    }

    public String minimumPriceFilter() {
        String minimum;
        while(true) {
            console.print("* Price minimum (default $" + MINIMUM + "): ");
            minimum = scan.nextLine();
            double temp;
            if(minimum.isEmpty()) {
                query = new MinPriceFilterDecorator(query, MINIMUM);
                return minimum;
            }
            try {
                temp = Double.parseDouble(minimum);
            } catch(NumberFormatException e) {
                console.println("Error - Enter only numbers");
                console.println();
                continue;
            }
            query = new MinPriceFilterDecorator(query, temp);
            return minimum;
        }
    }

    public String maximumPriceFilter() {
        String maximum;
        while(true) {
            console.print("* Price maximum (default $" + MAXIMUM + "): ");
            maximum = scan.nextLine();
            double temp;
            if(maximum.isEmpty()) {
                query = new MaxPriceFilterDecorator(query, MAXIMUM);
                return maximum;
            }
            try {
                temp = Double.parseDouble(maximum);
            } catch (NumberFormatException e) {
                console.println("Error - Enter only numbers");
                console.println();
                continue;
            }
            query = new MaxPriceFilterDecorator(query, temp);
            return maximum;
        }
    }

    public String minimumStarsFilter() {
        String minimumStars;
        while(true) {
            console.print("* Star rating maximum (1-5, default " + MINIMUM_STARS + "): ");
            minimumStars = scan.nextLine();
            int temp;
            if(minimumStars.isEmpty()) {
                query = new MinStarRatingFilterDecorator(query, MINIMUM_STARS);
                return minimumStars;
            }
            try {
                temp = Integer.parseInt(minimumStars);
            } catch (NumberFormatException e) {
                console.println("Error - Enter only numbers");
                console.println();
                continue;
            }
            query = new MinStarRatingFilterDecorator(query, temp);
            return minimumStars;
        }
    }

    public String maximumStarsFilter() {
        String maximumStars;
        while(true) {
            console.print("* Star rating maximum (1-5, default " + MAXIMUM_STARS + "): ");
            maximumStars = scan.nextLine();
            int temp;
            if(maximumStars.isEmpty()) {
                query = new MaxStarRatingFilterDecorator(query, MAXIMUM_STARS);
                return maximumStars;
            }
            try {
                temp = Integer.parseInt(maximumStars);
            } catch (NumberFormatException e) {
                console.println("Error - Enter only numbers");
                console.println();
                continue;
            }
            query = new MaxStarRatingFilterDecorator(query, temp);
            return maximumStars;
        }
    }

    public String priceSort() {
        String priceAscending;
        while(true) {
            console.print("* Sort by Price (A/D, default " + PRICE_SORT + "): ");
            priceAscending = scan.nextLine();
            if(priceAscending.length() > 1) {
                console.println("Error - Enter only one character");
                console.println();
                continue;
            }
            if(priceAscending.isEmpty()) {
                priceAscending = PRICE_SORT;
            }
            if(priceAscending.toLowerCase().charAt(0) == 'a') {
                query = new SortByPriceDecorator(query, false);
                return priceAscending;
            }
            if(priceAscending.toLowerCase().charAt(0) == 'd') {
                query = new SortByPriceDecorator(query, true);
                return priceAscending;
            }
            console.println("Error - Enter a valid character");
        }
    }

    public String starsSort() {
        String starsAscending;
        while(true) {
            console.print("* Sort by Star rating (A/D, default " + STARS_SORT + "): ");
            starsAscending = scan.nextLine();
            if(starsAscending.length() > 1) {
                console.println("Error - Enter only one character");
                console.println();
                continue;
            }
            if(starsAscending.isEmpty()) {
                starsAscending = STARS_SORT;
            }
            if(starsAscending.toLowerCase().charAt(0) == 'a') {
                query = new SortByStarRatingDecorator(query, false);
                return starsAscending;
            }
            if(starsAscending.toLowerCase().charAt(0) == 'd') {
                query = new SortByStarRatingDecorator(query, true);
                return starsAscending;
            }
            console.println("Error - Enter a valid character");
        }
    }

    public void reset() {
        query = new AllInventoryQuery(repo);
    }

}
