package org.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;
    private double totalPrice;

    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
        totalPrice = 0.0;
    }

    public void addSandwich(Scanner scanner) {
        Sandwich sandwich = new Sandwich(scanner);
        sandwiches.add(sandwich);
        totalPrice += sandwich.getPrice();
    }

    public void addDrink(Scanner scanner) {
        Drink drink = new Drink(scanner);
        drinks.add(drink);
        totalPrice += drink.getPrice();
    }

    public void addChips(Scanner scanner) {
        Chips chip = new Chips(scanner);
        chips.add(chip);
        totalPrice += chip.getPrice();
    }

    public void displayOrderSummary() {
        System.out.println("\nOrder Summary:");
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich);
        }
        for (Drink drink : drinks) {
            System.out.println(drink);
        }
        for (Chips chip : chips) {
            System.out.println(chip);
        }
        System.out.println("Total Price: $" + String.format("%.2f", totalPrice));
    }

    public void saveReceipt() {
        String directoryPath = "receipts";
        File directory = new File(directoryPath);

        // Create the directory if it does not exist
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created: " + directoryPath);
            } else {
                System.out.println("Failed to create directory: " + directoryPath);
                return; // Exit if directory creation fails
            }
        }

        String fileName = directoryPath + "/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Order Receipt\n\n");
            for (Sandwich sandwich : sandwiches) {
                writer.write(sandwich.toString() + "\n");
            }
            for (Drink drink : drinks) {
                writer.write(drink.toString() + "\n");
            }
            for (Chips chip : chips) {
                writer.write(chip.toString() + "\n");
            }
            writer.write("Total Price: $" + String.format("%.2f", totalPrice) + "\n");
            System.out.println("Receipt saved as " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the receipt.");
            e.printStackTrace();
        }
    }
    public void checkout() {
        System.out.println("\nChecking out...");
        displayOrderSummary(); // Show the order summary
        saveReceipt(); // Save the receipt to a file
        System.out.println("Thank you for your order!");
    }
}

