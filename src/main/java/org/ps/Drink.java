package org.ps;

import java.util.Scanner;

public class Drink {
    private String size;
    private String flavor;
    private double price;

    // ANSI escape codes for colors and styles
    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String BOLD = "\u001B[1m";

    public Drink(Scanner scanner) {
        setSize(scanner);
        setFlavor(scanner);
        calculatePrice();
    }

    private void setSize(Scanner scanner) {
        System.out.print(CYAN + BOLD + "Choose drink size (small, medium, large): " + RESET);
        this.size = scanner.nextLine().toLowerCase();
    }

    private void setFlavor(Scanner scanner) {
        System.out.print(CYAN + BOLD + "Choose drink flavor (e.g., cola, lemonade, orange): " + RESET);
        this.flavor = scanner.nextLine();
    }

    private void calculatePrice() {
        switch (size) {
            case "small":
                price = 2.00;
                break;
            case "medium":
                price = 2.50;
                break;
            case "large":
                price = 3.00;
                break;
            default:
                price = 0.0;
        }
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return GREEN + "Drink [" + RESET + 
               YELLOW + "Size: " + RESET + size + 
               CYAN + ", Flavor: " + RESET + flavor + 
               GREEN + ", Price: $" + RESET + String.format("%.2f", price) + 
               GREEN + "]";
    }
}
