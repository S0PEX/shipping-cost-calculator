package ak.softwarequality;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the shipping cost calculator");

        double orderAmount = promptInputDouble("Please enter the cost of the order:");
        String shippingOption = promptInputShippingMethod();

        double totalCost = calculateOrderCost(orderAmount, shippingOption);
        System.out.println("Total Cost of the Order: $" + totalCost);
    }

    /**
     * Prompts the user to input a double number
     * WARNING: This method will only exit once a valid number is input!
     *
     * @param promptMessage Prompt that should be displayed before the input
     * @return Number input by the user as double
     */
    private static double promptInputDouble(String promptMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(promptMessage);
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("The input must be a decimal number, e.g., 12.0");
            return promptInputDouble(promptMessage);
        }
    }

    /**
     * Prompts the user to select a shipping method (either standard or express)
     * WARNING: This method will only exit once a valid shipping method is input!
     *
     * @return Shipping method
     */
    private static String promptInputShippingMethod() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please select the shipping method (standard or express):");
            String shippingMethod = scanner.nextLine();
            if (!shippingMethod.equals("standard") && !shippingMethod.equals("express")) {
                System.out.println(shippingMethod + " is not a valid shipping method!");
            } else {
                return shippingMethod;
            }
        }
    }

    /**
     * Calculates the total order cost (including shipping and given discount) based on an order amount and
     * selected shipping method
     *
     * @param orderAmount    Cost of order without applied discounts and shipping
     * @param shippingOption Shipping method, either "standard" or "express
     * @return Total order cost
     */
    public static double calculateOrderCost(double orderAmount, String shippingOption) {
        double shippingCost = 0;
        double discount = 0;

        // Determine shipping cost based on the chosen shipping option
        if (shippingOption.equals("standard")) {
            shippingCost = 10;
        } else if (shippingOption.equals("express")) {
            shippingCost = 20;
        } else {
            throw new IllegalArgumentException("Invalid shipping option.");
        }

        // Apply a discount based on the order amount
        if (orderAmount >= 100) {
            discount = 10;
        }

        // Calculate the total cost
        double totalCost = orderAmount + shippingCost - discount;

        // Ensure the total cost is non-negative
        double finalOrderCost = Math.max(0, totalCost);

        return finalOrderCost;
    }
}