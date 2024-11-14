package org.ps;

import java.util.Scanner;

public class OrderManager {
    private Scanner scanner;
    private Order currentOrder;

    // ANSI escape codes for colors and styles
    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String BOLD = "\u001B[1m";

    public OrderManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startOrder() {
        currentOrder = new Order();
        boolean ordering = true;

        while (ordering) {
            printMenuBorder();
            System.out.println(CYAN + BOLD + "            Order Screen            " + RESET);
            printMenuBorder();
            System.out.println(GREEN + "1) Add Sandwich" + RESET);
            System.out.println(YELLOW + "2) Add Drink" + RESET);
            System.out.println(BLUE + "3) Add Chips" + RESET);
            System.out.println(CYAN + "4) Checkout" + RESET);
            System.out.println(RED + "0) Cancel Order" + RESET);
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    currentOrder.addSandwich(scanner);
                    break;
                case 2:
                    currentOrder.addDrink(scanner);
                    break;
                case 3:
                    currentOrder.addChips(scanner);
                    break;
                case 4:
                    currentOrder.checkout();
                    ordering = false;
                    break;
                case 0:
                    System.out.println(RED + "Order canceled. Returning to Home Screen." + RESET);
                    ordering = false;
                    break;
                default:
                    System.out.println(RED + "Invalid choice, please try again." + RESET);
            }
        }
    }

    private static void printMenuBorder() {
        System.out.println(BOLD + BLUE + "===============================================" + RESET);
    }
}
