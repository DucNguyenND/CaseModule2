package Colltrollers;

import Models.Computer;
import Models.ComputerGuest;
import io.ValidateChoice;
import io.WriteAndReadCartGuest;
import io.WriteAndReadStaff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerGuest {

   static WriteAndReadCartGuest writeAndReadCartGuest=new WriteAndReadCartGuest();
   static Scanner scanner=new Scanner(System.in);
    public static void MenuGuest(List<Computer> computers, List<ComputerGuest> cartguest, String nameLogin,String nameID,List<Computer> computerscartguest){
        (new WriteAndReadStaff()).read(computers);
        while (true){
            System.out.println(nameLogin);
            System.out.println("========= Menu =========");
            System.out.println("1. Xem laptop theo hãng ");
            System.out.println("2. Xem theo giá tiền");
            System.out.println("3. Mua hàng");
            System.out.println("4. Xem giỏ hàng");
            System.out.println("5. Thanh toán");
            System.out.println("6. Đăng xuất");
        switch (Integer.parseInt(scanner.nextLine())){
            case 1:
                computers.sort(new SortByName());
                for (Computer computer: computers
                ) {
                    System.out.println(computer.showLaptop());
                }
                break;
            case 2:
                sortByPrice(computers);
                break;
            case 3:
                pay(computers,cartguest,nameLogin,nameID,computerscartguest);
                break;
            case 4:
                showCart(cartguest,nameID,computerscartguest);
                break;
            case 5:
                showCart(cartguest,nameID,computerscartguest);
                System.out.println("Đơn hàng sẽ sớm gửi tới bạn");
                break;
            case 6:
                break;
        }
        }
    }
    public static void sortByPrice(List<Computer> computers){
        System.out.println("1. Sắp xếp theo giá tăng dần");
        System.out.println("2. Sắp xếp theo giá giảm dần");
        switch (Integer.parseInt(scanner.nextLine())){
            case 1:
                computers.sort(new PriceMaxToMin());
                for (int i = 0; i < computers.size(); i++) {
                    System.out.println((i+1)+ computers.get(i).showLaptop());
                }
                break;
            case 2:
                computers.sort(new PriceMinToMax());
                for (int i = 0; i < computers.size(); i++) {
                    System.out.println((i+1)+ computers.get(i).showLaptop());
                }
                break;
        }
    }
    public static void buyLaptop(List<Computer> computers, List<ComputerGuest> cartguest,String nameLogin,String nameID,List<Computer> computerscartguest){
        while (true){
            for (int i = 0; i < computers.size(); i++) {
                System.out.println((i+1)+". Tên mặt hàng: " + computers.get(i).getName());
                System.out.println("   Giá Tiền:     "+ computers.get(i).getPrice());
                System.out.println("");
            }
            int index=-1;
            System.out.println("Chọn sản phẩm bạn muốn mua");
            index=Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < computers.size(); i++) {
                if (index-1==i){
                String brand=computers.get(i).getBrand();
                String name=computers.get(i).getName();
                String chip=computers.get(i).getChip();
                String display=computers.get(i).getDisplay();
                String ram=computers.get(i).getRam();
                String battery=computers.get(i).getBattery();
                int amount=computers.get(i).getAmount();
                int price= computers.get(i).getPrice();
                String status="Chưa thanh toán";
                cartguest.add(new ComputerGuest(nameID,brand,name,chip,display,ram,battery,amount,price,status));

                }}
            writeAndReadCartGuest.write(cartguest);
            System.out.println("Bạn có muốn xem thêm sản phẩm không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            switch (Integer.parseInt(scanner.nextLine())){
                case 1:
                    computers.clear();
                    MenuGuest(computers,cartguest,nameLogin,nameID,computerscartguest);
                    break;
                case 2:
                    showCart(cartguest,nameID,computerscartguest);
                    System.out.println("Đơn hàng sẽ sớm được gửi đến bạn");
                    MenuGuest(computers,cartguest,nameLogin,nameID,computerscartguest);
                    break;
            }
            break;
        }
    }
    public static void showCart(List<ComputerGuest> cartguest,String nameID,List<Computer> computerscartguest){
        int sumPrice=0;
        writeAndReadCartGuest.read(cartguest);
        for (int i = 0; i < cartguest.size(); i++) {
            if (nameID.equals(cartguest.get(i).getNameID())){
                String brand=cartguest.get(i).getBrand();
                String name=cartguest.get(i).getName();
                String chip=cartguest.get(i).getChip();
                String display=cartguest.get(i).getDisplay();
                String ram=cartguest.get(i).getRam();
                String battery=cartguest.get(i).getBattery();
                int amount=cartguest.get(i).getAmount();
                int price= cartguest.get(i).getPrice();
                computerscartguest.add(new Computer(brand,name,chip,display,ram,battery,amount,price));
            }
        }
        for (Computer cart:computerscartguest
             ) {
            System.out.println("Tên hàng hóa: "+cart.getName());
            System.out.println("Giá tiền :" + cart.getPrice());
            System.out.println("");
            sumPrice+=cart.getPrice();
        }
        System.out.println("Tổng số tiền  " + sumPrice);
    }
    public static void pay(List<Computer> computers, List<ComputerGuest> cartguest,String nameLogin,String nameID,List<Computer> computerscartguest){
        buyLaptop(computers,cartguest,nameLogin,nameID,computerscartguest);
        showCart(cartguest,nameID,computerscartguest);

    }
    public static void addCart(List<ComputerGuest> cartguest,String nameID,List<Computer> computerscartguest){
        writeAndReadCartGuest.read(cartguest);
        for (int i = 0; i < cartguest.size(); i++) {
            if (nameID.equals(cartguest.get(i).getNameID())){
                String brand=cartguest.get(i).getBrand();
                String name=cartguest.get(i).getName();
                String chip=cartguest.get(i).getChip();
                String display=cartguest.get(i).getDisplay();
                String ram=cartguest.get(i).getRam();
                String battery=cartguest.get(i).getBattery();
                int amount=cartguest.get(i).getAmount();
                int price= cartguest.get(i).getPrice();
                computerscartguest.add(new Computer(brand,name,chip,display,ram,battery,amount,price));
            }
        }
    }
}
