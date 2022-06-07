package Colltrollers;

import Models.Computer;
import Models.ComputerGuest;
import io.WriteAndReadCartGuest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerGuest {

   static WriteAndReadCartGuest writeAndReadCartGuest=new WriteAndReadCartGuest();

   static Scanner scanner=new Scanner(System.in);
    public static void MenuGuest(List<Computer> computers, List<ComputerGuest> cartguest, String nameLogin,String nameID){
        while (true){
            System.out.println(nameLogin);
        System.out.println("========= Menu =========");
        System.out.println("1. Xem laptop theo hãng ");
        System.out.println("2. Xem theo giá tiền");
        System.out.println("3. Mua hàng");
        System.out.println("4. Xem giỏ hàng");
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
                pay(computers,cartguest,nameID);
                break;
            case 4:
                showCart(cartguest);
                break;
        }
    }
    }
    public static void sortByPrice(List<Computer> computers){
        System.out.println("1. Sắp xếp theo giá giảm dần");
        System.out.println("2. Sắp xếp theo giá tăng dần");
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
    public static void buyLaptop(List<Computer> computers, List<ComputerGuest> cartguest,String nameID){
        while (true){
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
                cartguest.add(new ComputerGuest(nameID,brand,name,chip,display,ram,battery,amount,price));
            }
            writeAndReadCartGuest.write(cartguest);
            System.out.println("Bạn có muốn xem thêm sản phẩm không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            if (Integer.parseInt(scanner.nextLine())==1){
            }else if (Integer.parseInt(scanner.nextLine())==2){
                break;
            }
        }
        }
    }
    public static void showCart(List<ComputerGuest> cartguest){
        int sumPrice=0;
        for (ComputerGuest cart:cartguest
             ) {
            System.out.println(cart.showLaptop());
            sumPrice+=cart.getPrice();
        }
        System.out.println("Tổng số tiền bạn phải thanh toán là: " + sumPrice);
    }
    public static void pay(List<Computer> computers, List<ComputerGuest> cartguest,String nameID){
        buyLaptop(computers,cartguest,nameID);
        showCart(cartguest);

    }
}
