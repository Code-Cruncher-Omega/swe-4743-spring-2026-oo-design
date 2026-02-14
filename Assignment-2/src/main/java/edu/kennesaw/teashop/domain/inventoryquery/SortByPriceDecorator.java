package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.ArrayList;

public class SortByPriceDecorator extends InventoryQueryDecoratorBase {
    private final boolean DESCENDING;

    public SortByPriceDecorator(InventoryQuery inner, boolean descending) {
        super(inner);
        DESCENDING = descending;
    }

    public ArrayList<InventoryItem> run() {
        query = INNER.run();
        insertionSort(query, query.size());
        if(DESCENDING) {
            query = new ArrayList<>(query.reversed());
        }
        return query;
    }

    private static void insertionSort(ArrayList<InventoryItem> query, int n)
    {
        if (n <= 1) {
            return;
        }

        insertionSort(query, n - 1);

        InventoryItem last = query.get(n - 1);
        int j = n-2;

        while(j >= 0 && query.get(j).getPRICE() > last.getPRICE()) {
            query.set(j + 1, query.get(j));
            j--;
        }
        query.set(j + 1, last);
    }
}
