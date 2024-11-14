package org.ps;

import java.util.Scanner;

public class Drink {
    private String size;
    private String flavor;
    private double price;

    public Drink(Scanner scanner) {
        setSize(scanner);
        setFlavor(scanner);
        calculatePrice();
    }

    private void setSize(Scanner scanner) {
        System.out.print("Choose drink size (small, medium, large): ");
        this.size = scanner.nextLine().toLowerCase();
    }

    private void setFlavor(Scanner scanner) {
        System.out.print("Choose drink flavor (e.g., cola, lemonade, orange): ");
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
        return "Drink [Size: " + size + ", Flavor: " + flavor + ", Price: $" + String.format("%.2f", price) + "]";
    }
}
