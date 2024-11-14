package org.ps;

import java.util.Scanner;

public class Main {
    // ANSI escape codes for colors and styles
    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String BOLD = "\u001B[1m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager orderManager = new OrderManager(scanner);

        boolean running = true;
        while (running) {
            printMenuBorder();
            System.out.println(CYAN + BOLD + "          Welcome to the Sandwich Order System          " + RESET);
            printMenuBorder();
            System.out.println(BLUE + "| Home Screen" + RESET);
            System.out.println(GREEN + "| 1) New Order" + RESET);
            System.out.println(RED + "| 0) Exit" + RESET);
            printMenuBorder();
            System.out.print(YELLOW + "| Choose an option: " + RESET);
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    orderManager.startOrder();
                    break;
                case 0:
                    running = false;
                    System.out.println(RED + "| Exiting the application..." + RESET);
                    break;
                default:
                    System.out.println(RED + "| Invalid choice, please try again." + RESET);
            }
        }

        scanner.close();
    }

    private static void printMenuBorder() {
        System.out.println(BOLD + BLUE + "|====================================================|" + RESET);
    }
}
