package Models;

public class ComputerGuest extends Computer{
   private String nameID;

   public ComputerGuest(String nameID,String brand, String name, String chip, String display, String ram, String battery, int amount, int price) {
      super(brand, name, chip, display, ram, battery, amount, price);
      this.nameID = nameID;
   }

   @Override
   public String toString() {
      return nameID+","+super.toString();
   }
   public String showCartGuest(){
      return super.showLaptop();
   }
}
