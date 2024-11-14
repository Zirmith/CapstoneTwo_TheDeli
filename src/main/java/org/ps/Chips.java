package org.ps;

import java.util.Scanner;

public class Chips {
    private String type;
    private double price;

    public Chips(Scanner scanner) {
        setType(scanner);
        price = 1.50; // fixed price for chips
    }

    private void setType(Scanner scanner) {
        System.out.print("Choose chip type (e.g., plain, BBQ, sour cream): ");
        this.type = scanner.nextLine();
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Chips [Type: " + type + ", Price: $" + String.format("%.2f", price) + "]";
    }
}
