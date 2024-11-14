package org.ps;

import java.util.Scanner;

public class OrderManager {
    private Scanner scanner;
    private Order currentOrder;

    public OrderManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startOrder() {
        currentOrder = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\nOrder Screen");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
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
                    System.out.println("Order canceled. Returning to Home Screen.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
