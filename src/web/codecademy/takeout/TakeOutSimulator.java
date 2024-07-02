package web.codecademy.takeout;

import java.util.List;
import java.util.Scanner;

public class TakeOutSimulator{
    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    public TakeOutSimulator(Customer customer, FoodMenu menu, Scanner input){
        this.customer = customer;
        this.menu = menu;
        this.input = input;

    }

    private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever<T> intUserInputRetriever) {
        while (true) {
            System.out.println(userInputPrompt);
            String userInput = input.nextLine();
            try {
                int intInput = Integer.parseInt(userInput);
                return intUserInputRetriever.produceOutputOnIntUserInput(intInput);
            } catch (NumberFormatException e) {
                System.out.println("Input needs to be an integer. Try again!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Try Again!");
            }
        }
    }

    public boolean shouldSimulate(){
        Food lowestCostFood = menu.getLowestCostFood();

        String userPrompt = "Enter 1 to proceed with the simulation or 0 to stop the simulation: ";
        IntUserInputRetriever<Boolean> retriever = selection -> {
            if (selection!=0 && selection !=1){
                throw new IllegalArgumentException(selection + "is not a valid input");
            }
            if(selection == 1 ){
                if(lowestCostFood.getPrice() > customer.getMoney()){
                    return true;
                }else{
                    System.out.println("You do not have enough money");
                    return false;
                }


            }
            return false;
        };

        return getOutputOnIntInput(userPrompt, retriever);

    }

    public Food getMenuSelection(){
        String userPrompt = "Please choose a food item from the menu by entering the corresponding number:";
        IntUserInputRetriever<Food> retriever = selection -> {
            List<Food> foodMenu = menu.getMenu();
            if(selection < 1 || selection > foodMenu.size()){
                throw new IllegalArgumentException(selection + "is not a valid input");

            }

            return foodMenu.get(selection - 1);
        };

        return getOutputOnIntInput(userPrompt, retriever);


    }

    public boolean isStillOrderingFood(){
        String userPrompt = "Would you like to continue? 1 = yes, 0 = no";
        IntUserInputRetriever<Boolean> retriever = selection -> {
            if(selection != 0 && selection != 1){
                throw new IllegalArgumentException(selection + "is not valid");
            }

            return selection == 1;
        };
        return getOutputOnIntInput(userPrompt, retriever);
    }

    public  void checkOutCustomer(ShoppingBag<Food> shoppingBag){
        System.out.println("Processing payment...");
        int totalCost = shoppingBag.getTotalPrice();
        int customerMoney = customer.getMoney();
        int remainingMoney = totalCost - customerMoney;

        if (remainingMoney < 0) {
            System.out.println("You do not have enough money to complete the purchase.");
            return;
        }
        customer.setMoney(remainingMoney);

        System.out.printf("You have %d money left%n", remainingMoney);
        System.out.println("Enjoy your meal!");
    }

    public void takeOutPrompt(){
        ShoppingBag<Food> shoppingBag = new ShoppingBag<Food>();
        int customerMoneyLeft = customer.getMoney();
        while(true){
            System.out.printf("You have %d money left%n", customerMoneyLeft);
            Food selectedFood = getMenuSelection();

            if(customerMoneyLeft >= selectedFood.getPrice()){
                customerMoneyLeft -= selectedFood.getPrice();
                shoppingBag.addItem(selectedFood);
                System.out.printf("Added %s to your shopping bag %n");
            }
        }
    }



}

