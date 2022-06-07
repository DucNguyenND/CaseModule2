package Models;

public class Computer {
    private String brand;
    private String name;
    private String chip;
    private String display;
    private String ram;
    private String battery;
    private int amount;
    private int price;

    public Computer() {
    }

    public Computer(String brand, String name, String chip, String display, String ram, String battery, int amount, int price) {
        this.brand = brand;
        this.name = name;
        this.chip = chip;
        this.display = display;
        this.ram = ram;
        this.battery = battery;
        this.amount=amount;
        this.price=price;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  brand + "," +
                 name + "," + chip + "," + display + "," + ram +
                "," + battery + "," + amount + "," + price;
    }
    public String showLaptop(){
        return name + " Giá: " + price;
    }
}
