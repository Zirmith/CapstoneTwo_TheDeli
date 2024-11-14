package org.ps;

import java.util.Scanner;

public class Chips {
    private String type;
    private double price;

    // ANSI escape codes for colors and styles
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String BOLD = "\u001B[1m";

    public Chips(Scanner scanner) {
        setType(scanner);
        price = 1.50; // fixed price for chips
    }

    private void setType(Scanner scanner) {
        System.out.print(CYAN + BOLD + "Choose chip type (e.g., plain, BBQ, sour cream): " + RESET);
        this.type = scanner.nextLine();
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return GREEN + "Chips [" + RESET + 
               YELLOW + "Type: " + RESET + type + 
               CYAN + ", Price: $" + RESET + String.format("%.2f", price) + 
               GREEN + "]";
    }
}
