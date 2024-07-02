package web.codecademy.takeout;

import java.util.ArrayList;
import java.util.List;

public class FoodMenu{
    private List<Food> menu;

    public FoodMenu(){

        menu = new ArrayList<>();

        Food fries = new Food("French Fries", "Crispy french fries", 4);
        Food masalaChicken = new Food("Masala Chicken", "Exquisite masala chicken", 12);
        Food tiramisu = new Food("Tiramisu", "Italian dessert", 4);
        menu.add(fries);
        menu.add(masalaChicken);
        menu.add(tiramisu);
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < menu.size(); i++) {

            sb.append(i + 1).append(". ").append(menu.get(i)).append("\n");
        }
        return sb.toString();
    }

    public Food getLowestCostFood(){
        if(menu.isEmpty()){
            return null;
        }
        Food lowerPriceFood = menu.get(0);
        for(Food food : menu){
            if(food.getPrice() < lowerPriceFood.getPrice()) {
                lowerPriceFood = food;

            }

        }
        return lowerPriceFood;


    }

    public List<Food> getMenu() {
        return menu;
    }
}
