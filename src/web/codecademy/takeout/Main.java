package web.codecademy.takeout;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please insert your name: ");
        String customerName = input.next();
        System.out.println("Enter the amount of money you have: ");
        int money = getCustomerMoney(input);
        Customer customer = new Customer(customerName, money);
        FoodMenu menu = new FoodMenu();
        TakeOutSimulator simulator = new TakeOutSimulator(customer, menu, input);
        simulator.startTakeOutSimulator();



    }

    public static int getCustomerMoney(Scanner input){
        int customerMoney = 0;
        while (true) {
            try {
                customerMoney = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer:");
                input.nextLine();
            }
        }
        return customerMoney;
    }
}

