package UI;

import enums.Option;
import services.imp.*;

import java.util.List;
import java.util.Scanner;

public class DisplayMenu {
    public static void displayMenu() {
        System.out.println("");
        System.out.println("----- Main Menu -----");
        System.out.println("[1]. Find the 3 highest revenue products");
        System.out.println("[2]. Calculate total revenue by customer");
        System.out.println("[3]. Find the highest value order of each customer");
        System.out.println("[4]. Categorize orders by month");
        System.out.println("[5]. Calculate total revenue each month");
        System.out.println("[6]. Find the customer who spent the most in a period of time");
        System.out.println("[0]. Exit");
        System.out.print("Please select an option: ");
    }
    public static Option OptionMenu(int numberOption) {
        Option option = Option.fromCode(numberOption);

        if (option == null) {
            System.out.println("Invalid option");
            return option;
        }

        switch (option) {
            case HIGHESTGROSSING: //1
//                System.out.println("Highest Revenue Product");
                HighestRevenueImp.main();
                break;
            case HIGHESTVALUE: //2
//                System.out.println("Total Revenue Customer");
                TotalRevenueCustomerImp.main();
                break;
            case SEGMENTORDER: //3
//                System.out.println("Segment Order");
                HighestOrderCustomerImp.main();
                break;
            case TOPSPENDER: //4
//                System.out.println("Top Spender");
                CategorizeOrdersMonthImp.main();
                break;
            case TOTALREVENUECUSTOMER: //5
//                System.out.println("Total Revenue Customer");
                TotalRevenueMonthImp.main();
                break;
            case TOTALREVENUEMONTH: //6
//                System.out.println("Total Revenue Month");
                BestCustomerOfTimeImp.main();
                break;
            case EXIT: //0
//                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        return option;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Option chosenOption;
        do {
            displayMenu();
            System.out.print("Enter your option (0-6): ");
            int input = -1;
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and 6.");
                scanner.next();
                System.out.print("Enter your option (0-6): ");
            }
            input = scanner.nextInt();
            scanner.nextLine();
            chosenOption = OptionMenu(input);
        } while (chosenOption != Option.EXIT);
        scanner.close();
        System.out.println("Application finished.");
    }
}
