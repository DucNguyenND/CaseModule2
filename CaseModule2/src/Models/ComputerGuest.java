package Models;

public class ComputerGuest extends Computer{
   private String nameID;
   private String status;

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getNameID() {
      return nameID;
   }

   public void setNameID(String nameID) {
      this.nameID = nameID;
   }

   public ComputerGuest(String nameID, String brand, String name, String chip, String display, String ram, String battery, int amount, int price,String status) {
      super(brand, name, chip, display, ram, battery, amount, price);
      this.nameID = nameID;
      this.status=status;
   }

   @Override
   public String toString() {
      return nameID + "," +super.toString()+","+ status;
   }
   public String showCartGuest(){
      return super.showLaptop();
   }
}
