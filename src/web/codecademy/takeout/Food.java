package web.codecademy.takeout;

public class Food implements PricedItem<Integer>{
    private String name;
    private String description;
    private int price;

    public Food(String name, String description, int price){
        this.name = name;
        this.description = description;
        this.price = price;
    }


    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return String.format("Enjoy %s, %s, cost: %d", this.getName(), this.getDescription(), this.getPrice());
    }
}

