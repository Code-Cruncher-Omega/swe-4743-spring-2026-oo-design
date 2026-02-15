package edu.kennesaw.teashop.userinterface.querybuilder;

public class InventoryQueryOutput {
    private InventoryQueryBuilder inventoryQueryBuilder;

    public InventoryQueryOutput(InventoryQueryBuilder invBuilder) {
        inventoryQueryBuilder = invBuilder;
    }

    public String filterAndSort() {


        /*
        FILTERS
         */

        String contains = inventoryQueryBuilder.containsTextFilter();
        String availability = inventoryQueryBuilder.availabilityFilter();
        String minimum = inventoryQueryBuilder.minimumPriceFilter();
        String maximum = inventoryQueryBuilder.maximumPriceFilter();
        String minimumStars = inventoryQueryBuilder.minimumStarsFilter();
        String maximumStars = inventoryQueryBuilder.maximumStarsFilter();
        /*
        SORTS
         */

        String priceSort = inventoryQueryBuilder.priceSort();
        String starsSort = inventoryQueryBuilder.starsSort();

        String settingsApplied = "\nApplied Filters and Sorts:\n";
        if(!contains.isEmpty()) {
            settingsApplied += "- Filter: Contains \"" + contains + "\"\n";
        }
        settingsApplied += "- Filter: Availability = " + ((availability.charAt(0) == 'y') ? "In Stock (Quantity > 0)" : "Ignored (Quantity >= 0)") + "\n";
        settingsApplied += "- Filter: Price between $" + minimum + " and $" + maximum + "\n";
        settingsApplied += "- Filter: Star rating between " + minimumStars + " and " + maximumStars + "\n";
        if(priceSort.charAt(0) != 'n') {
            settingsApplied += "- Sort: Price (" + ((priceSort.charAt(0) == 'a') ? "Ascending" : "Descending") + ")\n";
        }
        if(priceSort.charAt(0) != 'n') {
            settingsApplied += "- Sort: Star rating (" + ((starsSort.charAt(0) == 'a') ? "Ascending" : "Descending") + ")\n";
        }

        return settingsApplied;
    }
}
