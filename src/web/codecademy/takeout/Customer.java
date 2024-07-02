package web.codecademy.takeout;

public class Customer{
    private String name;
    private int money;

    public Customer(String name, int money) {
        this.name = name;
        this.money = money;
    }


    public String getName(){
        return this.name;
    }

    public int getMoney(){
        return this.money;
    }

    public void setName(String name){
        this.name = name;

    }
    public void setMoney(int money){
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format("Hello %s! You have %d money.", name, money);
    }
}
