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

    // ANSI escape codes for colors and styles
    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String BOLD = "\u001B[1m";

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
        printBorder();
        System.out.println(CYAN + BOLD + "            Order Summary            " + RESET);
        printBorder();
        
        if (sandwiches.isEmpty() && drinks.isEmpty() && chips.isEmpty()) {
            System.out.println(RED + "No items in the order!" + RESET);
        } else {
            if (!sandwiches.isEmpty()) {
                System.out.println(GREEN + "| Sandwiches: " + RESET);
                for (Sandwich sandwich : sandwiches) {
                    System.out.println(GREEN + "|  - " + sandwich + RESET);
                }
            }
            if (!drinks.isEmpty()) {
                System.out.println(YELLOW + "| Drinks: " + RESET);
                for (Drink drink : drinks) {
                    System.out.println(YELLOW + "|  - " + drink + RESET);
                }
            }
            if (!chips.isEmpty()) {
                System.out.println(BLUE + "| Chips: " + RESET);
                for (Chips chip : chips) {
                    System.out.println(BLUE + "|  - " + chip + RESET);
                }
            }
            System.out.println(CYAN + "| Total Price: $" + String.format("%.2f", totalPrice) + RESET);
        }

        printBorder();
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
        printBorder();
        System.out.println(CYAN + BOLD + "         Checking Out...         " + RESET);
        printBorder();
        displayOrderSummary(); // Show the order summary
        saveReceipt(); // Save the receipt to a file
        System.out.println(RED + "| Thank you for your order!" + RESET);
        printBorder();
    }

    private static void printBorder() {
        System.out.println(BOLD + BLUE + "|====================================================|" + RESET);
    }
}
