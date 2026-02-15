package edu.kennesaw.teashop.userinterface;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;
import edu.kennesaw.teashop.domain.inventory.InventoryRepository;
import edu.kennesaw.teashop.domain.payment.PaymentStrategy;
import edu.kennesaw.teashop.userinterface.querybuilder.InventoryQueryOutputWriter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private InventoryRepository invRepo;
    private InventoryQueryOutputWriter outputWriter;
    private InputStream input;
    private PrintStream console;
    private PaymentStrategy payStrategy;

    public Application(InputStream input, PrintStream output) {
        invRepo = new InventoryRepository();
        outputWriter = new InventoryQueryOutputWriter(invRepo, input, output);
        this.input = input;
        console = output;
    }

    public void run() {
        Scanner scan = new Scanner(input);
        String text;
        while(true) {
            console.println("WELCOME TO EDUARDO'S TEA SHOP");
            console.println();
            ArrayList<InventoryItem> query = outputWriter.write();
            int querySize = query.size();
            InventoryItem purchasing = query.getFirst();
            while(true) {
                console.print("Purchase an item? Enter item number 1-" + querySize + " or 0 to continue (default): ");
                text = scan.nextLine();
                int itemNumber;
                try {
                    itemNumber = Integer.parseInt(text);
                    if(itemNumber == 0) {
                        break;
                    }
                    if(itemNumber < 1) {
                        console.println("Error - Enter a number greater than 0");
                        console.println();
                        continue;
                    }
                    if(itemNumber > querySize) {
                        console.println("Error - Enter a number smaller than " + (1 + querySize));
                        console.println();
                        continue;
                    }
                } catch(NumberFormatException e) {
                    console.println("Error - Invalid characters entered");
                    console.println();
                    continue;
                }
                purchasing = query.get(itemNumber - 1);
            }
            int bought = -1;
            while(true) {
                console.print("Quantity for \"" + purchasing.getName() + "\" (1-" + purchasing.getQuantity() + "): ");

            }
        }
    }
}
