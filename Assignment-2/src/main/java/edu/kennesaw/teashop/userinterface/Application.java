package edu.kennesaw.teashop.userinterface;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;
import edu.kennesaw.teashop.domain.inventory.InventoryRepository;
import edu.kennesaw.teashop.domain.payment.PaymentStrategy;
import edu.kennesaw.teashop.userinterface.paymentbuilder.*;
import edu.kennesaw.teashop.userinterface.querybuilder.InventoryQueryOutputWriter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private InventoryRepository invRepo;
    private InventoryQueryOutputWriter outputWriter;
    private InputStream input;
    private PrintStream console;
    private PaymentStrategy payStrategy;
    private PaymentBuilderListFactory builderFactory;

    public Application(InputStream input, PrintStream output) {
        invRepo = new InventoryRepository();
        outputWriter = new InventoryQueryOutputWriter(invRepo, input, output);
        this.input = input;
        console = output;
        builderFactory = new PaymentBuilderListFactory();
    }

    public void run() {
        Scanner scan = new Scanner(input);
        String text;
        while(true) {
            console.println("WELCOME TO EDUARDO'S TEA SHOP");
            console.println();
            ArrayList<InventoryItem> query = outputWriter.write();
            console.println();
            int querySize = query.size();
            InventoryItem purchasing = null;
            int itemNumber;
            while(true) {
                console.print("Purchase an item? Enter item number 1-" + querySize + " or 0 to continue (default): ");
                text = scan.nextLine();
                try {
                    if(text.isEmpty()) {
                        itemNumber = 0;
                    } else {
                        itemNumber = Integer.parseInt(text);
                    }
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
                if(purchasing.getQuantity() < 1) {
                    console.println("Error - Pick an item that is in stock");
                }
                break;
            }
            int quantityBought = 0;
            while(itemNumber != 0) {
                console.print("Quantity for \"" + purchasing.getName() + "\" " + ((purchasing.getQuantity() > 1) ? "(1-" + purchasing.getQuantity() : "(1") + "): ");
                text = scan.nextLine();
                try {
                    quantityBought = Integer.parseInt(text);
                    if(quantityBought < 1) {
                        console.println("Error - Buy at least 1 item");
                        console.println();
                        continue;
                    }
                    if(quantityBought > purchasing.getQuantity()) {
                        console.println("Error - Buy what is available");
                        console.println();
                        continue;
                    }
                } catch(NumberFormatException e) {
                    console.println("Error - Invalid characters entered");
                    console.println();
                    continue;
                }
                break;
            }
            int paymentChoice;
            while(itemNumber != 0) {
                double totalPrice = quantityBought * purchasing.getPrice();
                console.println("*** Total Price: $" + totalPrice);
                console.println("*** Choose a payment method:");
                List<BasePaymentBuilder> builders = builderFactory.getBuilders();
                int builderCount = builders.size();
                for(int i = 0 ; i < builderCount ; i++) {
                    console.println((i + 1) + ". " + builders.get(i).getName());
                }
                console.print("Selection: ");
                text = scan.nextLine();
                try {
                    paymentChoice = Integer.parseInt(text);
                    if(paymentChoice < 1 || builderCount < paymentChoice) {
                        console.println("Error - Select a number between 1 and " + builderCount);
                        console.println();
                        continue;
                    }
                    BasePaymentBuilder builder = builders.get(paymentChoice - 1);
                    builder.setScan(input);
                    builder.setConsole(console);
                    builder.setAmount(totalPrice);
                    payStrategy = builder.process();
                } catch(NumberFormatException e) {
                    console.println("Error - Invalid characters entered");
                    console.println();
                    continue;
                }
                break;
            }
            if(itemNumber != 0) {
                payStrategy.pay();
                invRepo.purchase(purchasing.getID(), quantityBought);
                console.println("*** Purchase complete. Your " + quantityBought + ((quantityBought > 1) ? " packages " : " package ") + "of " + purchasing.getName() + " is on the way ***");
                console.println();
                while(true) {
                    console.println("Search for more tea? (Y/N, default Y): ");
                    text = scan.nextLine().toLowerCase();
                    if(text.length() > 1) {
                        console.println("Error - Enter either Y or N");
                        console.println();
                        continue;
                    }
                    if(text.isEmpty()) {
                        text = "y";
                    }
                    if(text.charAt(0) == 'y') {
                        break;  // Start over with updated inventory
                    }
                    if(text.charAt(0) == 'n') {
                        console.println("Thanks for visiting!");
                        return; // End
                    }
                }
            }
        }
    }
}
