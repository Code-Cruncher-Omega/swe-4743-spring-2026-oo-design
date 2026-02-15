package edu.kennesaw.teashop.userinterface.querybuilder;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;
import edu.kennesaw.teashop.domain.inventory.InventoryRepository;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class InventoryQueryOutputWriter {
    private InventoryQueryBuilder queryBuilder;
    private InventoryQueryOutput queryOut;
    private PrintStream console;

    public InventoryQueryOutputWriter(InventoryRepository invRepo, InputStream input, PrintStream output) {
        queryBuilder = new InventoryQueryBuilder(invRepo, input, output);
        queryOut = new InventoryQueryOutput(queryBuilder);
        console = output;
    }

    public ArrayList<InventoryItem> write() {
        console.println("Complete the prompts to search our selection of fine teas.");
        console.println();
        console.println("Applied Filters and Sorts:");
        console.println(queryOut.filterAndSort());
        ArrayList<InventoryItem> query = queryBuilder.getQuery().run();
        console.println(query.size() + " items matches your query:");
        for (int i = 0; i < query.size(); i++) {
            InventoryItem item = query.get(i);
            console.print(i + ". " + item.getName());
            console.print("\t\t$" + item.getPrice());
            console.print("\t" + ((item.getQuantity() > 1) ? "Qty: " + item.getQuantity() : "(OUT OF STOCK)"));
            console.print("\t" + item.getRating() + " stars");
            console.println();
        }
        return query;
    }
}
