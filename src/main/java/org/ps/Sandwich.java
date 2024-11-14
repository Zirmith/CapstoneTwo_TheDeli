package org.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich {
    private String size;
    private String bread;
    private List<String> meats;
    private List<String> cheeses;
    private List<String> regularToppings;
    private List<String> sauces;
    private boolean toasted;
    private double price;

    public Sandwich(Scanner scanner) {
        meats = new ArrayList<>();
        cheeses = new ArrayList<>();
        regularToppings = new ArrayList<>();
        sauces = new ArrayList<>();

        System.out.println("\nCustomize Sandwich:");

        setSize(scanner);
        setBread(scanner);
        setToasted(scanner);
        addMeats(scanner);
        addCheeses(scanner);
        addRegularToppings(scanner);
        addSauces(scanner);

        price = calculatePrice();
    }

    private void setSize(Scanner scanner) {
        System.out.print("Choose size (4\", 8\", 12\"): ");
        this.size = scanner.nextLine().trim();
    }

    private void setBread(Scanner scanner) {
        System.out.print("Choose bread (white, wheat, rye, wrap): ");
        this.bread = scanner.nextLine().trim();
    }

    private void setToasted(Scanner scanner) {
        System.out.print("Would you like the sandwich toasted? (yes/no): ");
        String toastOption = scanner.nextLine().trim();
        this.toasted = toastOption.equalsIgnoreCase("yes");
    }

    private void addMeats(Scanner scanner) {
        String meatOption;
        do {
            System.out.print("Add meat (steak, ham, salami, roast beef, chicken, bacon or 'done' to finish): ");
            meatOption = scanner.nextLine().trim().toLowerCase();

            if (meatOption.equals("done")) {
                break;
            } else if (meatOption.isEmpty()) {
                System.out.println("Invalid input. Please enter a valid meat option.");
            } else if (isValidMeat(meatOption)) {
                meats.add(meatOption);
            } else {
                System.out.println("Invalid choice. Please choose a valid meat option or type 'done' to finish.");
            }
        } while (true);
    }

    private boolean isValidMeat(String meatOption) {
        return meatOption.equals("steak") || meatOption.equals("ham") || meatOption.equals("salami") ||
                meatOption.equals("roast beef") || meatOption.equals("chicken") || meatOption.equals("bacon");
    }

    private void addCheeses(Scanner scanner) {
        String cheeseOption;
        do {
            System.out.print("Add cheese (american, provolone, cheddar, swiss or 'done' to finish): ");
            cheeseOption = scanner.nextLine().trim().toLowerCase();

            if (cheeseOption.equals("done")) {
                break;
            } else if (cheeseOption.isEmpty()) {
                System.out.println("Invalid input. Please enter a valid cheese option.");
            } else if (isValidCheese(cheeseOption)) {
                cheeses.add(cheeseOption);
            } else {
                System.out.println("Invalid choice. Please choose a valid cheese option or type 'done' to finish.");
            }
        } while (true);
    }

    private boolean isValidCheese(String cheeseOption) {
        return cheeseOption.equals("american") || cheeseOption.equals("provolone") ||
                cheeseOption.equals("cheddar") || cheeseOption.equals("swiss");
    }

    private void addRegularToppings(Scanner scanner) {
        String toppingOption;
        do {
            System.out.print("Add regular topping (lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms or 'done' to finish): ");
            toppingOption = scanner.nextLine().trim().toLowerCase();

            if (toppingOption.equals("done")) {
                break;
            } else if (toppingOption.isEmpty()) {
                System.out.println("Invalid input. Please enter a valid topping option.");
            } else if (isValidTopping(toppingOption)) {
                regularToppings.add(toppingOption);
            } else {
                System.out.println("Invalid choice. Please choose a valid topping option or type 'done' to finish.");
            }
        } while (true);
    }

    private boolean isValidTopping(String toppingOption) {
        return toppingOption.equals("lettuce") || toppingOption.equals("peppers") || toppingOption.equals("onions") ||
                toppingOption.equals("tomatoes") || toppingOption.equals("jalapenos") || toppingOption.equals("cucumbers") ||
                toppingOption.equals("pickles") || toppingOption.equals("guacamole") || toppingOption.equals("mushrooms");
    }

    private void addSauces(Scanner scanner) {
        String sauceOption;
        do {
            System.out.print("Add sauce (mayo, mustard, ketchup, ranch, thousand islands, vinaigrette or 'done' to finish): ");
            sauceOption = scanner.nextLine().trim().toLowerCase();

            if (sauceOption.equals("done")) {
                break;
            } else if (sauceOption.isEmpty()) {
                System.out.println("Invalid input. Please enter a valid sauce option.");
            } else if (isValidSauce(sauceOption)) {
                sauces.add(sauceOption);
            } else {
                System.out.println("Invalid choice. Please choose a valid sauce option or type 'done' to finish.");
            }
        } while (true);
    }

    private boolean isValidSauce(String sauceOption) {
        return sauceOption.equals("mayo") || sauceOption.equals("mustard") || sauceOption.equals("ketchup") ||
                sauceOption.equals("ranch") || sauceOption.equals("thousand islands") || sauceOption.equals("vinaigrette");
    }

    private double calculatePrice() {
        double basePrice;
        switch (size) {
            case "4":
                basePrice = 5.50;
                break;
            case "8":
                basePrice = 7.00;
                break;
            case "12":
                basePrice = 8.50;
                break;
            default:
                basePrice = 0.0;
        }

        double meatCost = meats.size() * getMeatPrice();
        double cheeseCost = cheeses.size() * getCheesePrice();

        return basePrice + meatCost + cheeseCost;
    }

    private double getMeatPrice() {
        switch (size) {
            case "4": return 1.00;
            case "8": return 2.00;
            case "12": return 3.00;
            default: return 0.0;
        }
    }

    private double getCheesePrice() {
        switch (size) {
            case "4": return 0.75;
            case "8": return 1.50;
            case "12": return 2.25;
            default: return 0.0;
        }
    }

    @Override
    public String toString() {
        return "Sandwich [Size: " + size + "\", Bread: " + bread + ", Toasted: " + (toasted ? "Yes" : "No") +
                ", Meats: " + meats + ", Cheeses: " + cheeses + ", Regular Toppings: " + regularToppings +
                ", Sauces: " + sauces + ", Price: $" + String.format("%.2f", price) + "]";
    }

    public double getPrice() {
        return price;
    }
}
