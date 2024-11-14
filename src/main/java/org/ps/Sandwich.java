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

    // ANSI escape codes for colors and styles
    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String BOLD = "\u001B[1m";
    private static final String RED = "\u001B[31m";
    
    public Sandwich(Scanner scanner) {
        meats = new ArrayList<>();
        cheeses = new ArrayList<>();
        regularToppings = new ArrayList<>();
        sauces = new ArrayList<>();

        System.out.println("\n" + CYAN + BOLD + "Customize Sandwich:" + RESET);

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
        System.out.print(CYAN + BOLD + "Choose size (4\", 8\", 12\"): " + RESET);
        this.size = scanner.nextLine().trim();
    }

    private void setBread(Scanner scanner) {
        System.out.print(CYAN + BOLD + "Choose bread (white, wheat, rye, wrap): " + RESET);
        this.bread = scanner.nextLine().trim();
    }

    private void setToasted(Scanner scanner) {
        System.out.print(CYAN + BOLD + "Would you like the sandwich toasted? (yes/no): " + RESET);
        String toastOption = scanner.nextLine().trim();
        this.toasted = toastOption.equalsIgnoreCase("yes");
    }

    private void addMeats(Scanner scanner) {
        String meatOption;
        do {
            System.out.print(CYAN + BOLD + "Add meat (steak, ham, salami, roast beef, chicken, bacon or 'done' to finish): " + RESET);
            meatOption = scanner.nextLine().trim().toLowerCase();

            if (meatOption.equals("done")) {
                break;
            } else if (meatOption.isEmpty()) {
                System.out.println(RED + "Invalid input. Please enter a valid meat option." + RESET);
            } else if (isValidMeat(meatOption)) {
                meats.add(meatOption);
            } else {
                System.out.println(RED + "Invalid choice. Please choose a valid meat option or type 'done' to finish." + RESET);
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
            System.out.print(CYAN + BOLD + "Add cheese (american, provolone, cheddar, swiss or 'done' to finish): " + RESET);
            cheeseOption = scanner.nextLine().trim().toLowerCase();

            if (cheeseOption.equals("done")) {
                break;
            } else if (cheeseOption.isEmpty()) {
                System.out.println(RED + "Invalid input. Please enter a valid cheese option." + RESET);
            } else if (isValidCheese(cheeseOption)) {
                cheeses.add(cheeseOption);
            } else {
                System.out.println(RED + "Invalid choice. Please choose a valid cheese option or type 'done' to finish." + RESET);
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
            System.out.print(CYAN + BOLD + "Add regular topping (lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms or 'done' to finish): " + RESET);
            toppingOption = scanner.nextLine().trim().toLowerCase();

            if (toppingOption.equals("done")) {
                break;
            } else if (toppingOption.isEmpty()) {
                System.out.println(RED + "Invalid input. Please enter a valid topping option." + RESET);
            } else if (isValidTopping(toppingOption)) {
                regularToppings.add(toppingOption);
            } else {
                System.out.println(RED + "Invalid choice. Please choose a valid topping option or type 'done' to finish." + RESET);
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
            System.out.print(CYAN + BOLD + "Add sauce (mayo, mustard, ketchup, ranch, thousand islands, vinaigrette or 'done' to finish): " + RESET);
            sauceOption = scanner.nextLine().trim().toLowerCase();

            if (sauceOption.equals("done")) {
                break;
            } else if (sauceOption.isEmpty()) {
                System.out.println(RED + "Invalid input. Please enter a valid sauce option." + RESET);
            } else if (isValidSauce(sauceOption)) {
                sauces.add(sauceOption);
            } else {
                System.out.println(RED + "Invalid choice. Please choose a valid sauce option or type 'done' to finish." + RESET);
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
        return GREEN + "Sandwich [" + RESET + 
               YELLOW + "Size: " + RESET + size + "\"" + 
               CYAN + ", Bread: " + RESET + bread + 
               GREEN + ", Toasted: " + RESET + (toasted ? "Yes" : "No") + 
               CYAN + ", Meats: " + RESET + meats + 
               GREEN + ", Cheeses: " + RESET + cheeses + 
               CYAN + ", Regular Toppings: " + RESET + regularToppings + 
               GREEN + ", Sauces: " + RESET + sauces + 
               GREEN + ", Price: $" + RESET + String.format("%.2f", price) + 
               GREEN + "]";
    }

    public double getPrice() {
        return price;
    }
}
