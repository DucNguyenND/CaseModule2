package Models;

public class CartGuest extends Computer{
    public CartGuest(String brand, String name, String chip, String display, String ram, String battery, int amount, int price) {
        super(brand, name, chip, display, ram, battery, amount, price);
    }

    @Override
    public String toString() {
        return super.getName()+" giá tiền: "+getPrice();
    }
}
