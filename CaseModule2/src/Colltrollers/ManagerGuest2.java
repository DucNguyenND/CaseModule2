package Colltrollers;

import Models.Computer;
import Models.ComputerGuest;
import Models.Guest;
import io.*;
import Validate.ValidateChoice;

import java.util.List;
import java.util.Scanner;

public class ManagerGuest2 {
    static WriteAndReadCartGuest writeAndReadCartGuest=new WriteAndReadCartGuest();
    static WriteAndReadStaff writeAndReadStaff=new WriteAndReadStaff();
    static Scanner scannerGuest=new Scanner(System.in);
    public static void managerGuest2(List<Computer> computers, List<ComputerGuest> cartguest, String nameLogin, String nameID, List<Computer> computerscartguest,List<Guest> guests){
        computers.clear();
        writeAndReadStaff.read(computers);
        try {
        writeAndReadCartGuest.read(cartguest);}
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("");
        }
        readCartGuest(cartguest,nameID,computerscartguest);
        while (true){
            while (true){
            try {
        System.out.println("===Menu===");
        System.out.println("1. Xem laptop theo hãng");
        System.out.println("2. Sắp xếp laptop theo giá");
        System.out.println("3. Xem giỏ hàng");
        System.out.println("4. Thanh toán");
        System.out.println("5. Xem laptop đã mua");
        System.out.println("6. Đổi mật khẩu");
        System.out.println("7. Đăng xuất");
        int choiceguest=Integer.parseInt(scannerGuest.nextLine());
        if (ValidateChoice.validateChoiceGuest(String.valueOf(choiceguest))){
        switch (choiceguest){
            case 1:
                computers.sort(new SortByName());
                buy(computers,cartguest,nameLogin,nameID,computerscartguest);
                break;
            case 2:
                computers.sort(new PriceMinToMax());
                buy(computers,cartguest,nameLogin,nameID,computerscartguest);
                break;
            case 3:
                showCart(cartguest,nameID,computerscartguest);
                break;
            case 4:
                pay(computerscartguest,computers,cartguest);
                break;
            case 5:
                showBought(cartguest);
                break;
            case 6:
                changePassword(guests,nameID);
                break;
            case 7:
                return;
        }
        break;
        }else System.out.println("Vui lòng chọn từ 1-7");
    }catch (Exception e) {
                System.out.println("Vui lòng nhập lại");
            }
        }}
    }
    public static void buy(List<Computer> computers, List<ComputerGuest> cartguest,String nameLogin,String nameID,List<Computer> computerscartguest){
        while (true){
            for (int i = 0; i < computers.size(); i++) {
                System.out.println((i+1)+". Tên mặt hàng: " + computers.get(i).getName());
                System.out.println("   Giá Tiền:     "+ computers.get(i).getPrice());
                System.out.println("");
            }


            try {
                int index=-1;
                System.out.println("Chọn sản phẩm bạn muốn mua");
                index=Integer.parseInt(scannerGuest.nextLine());
            if (index>computers.size()){
                System.out.println("Vui lòng chọn lại");
            }else {
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
                        System.out.println("Đã thêm mặt hàng vào giỏ hàng");
                    }
                }
                writeAndReadCartGuest.write(cartguest);
            }
            computerscartguest.clear();
            readCartGuest(cartguest,nameID,computerscartguest);
            break;
    }catch (Exception e){
                System.out.println("Vui lòng chọn lại");
            }
        }
    }
    public static void showCart(List<ComputerGuest> cartguest,String nameID,List<Computer> computerscartguest){

        int sumPrice=0;
        for (int i = 0; i <cartguest.size() ; i++) {
            if(cartguest.get(i).getStatus().equals("Chưa thanh toán")){
            System.out.println("Tên hàng hóa: "+cartguest.get(i).getName());
            System.out.println("Giá tiền :" + cartguest.get(i).getPrice());
            System.out.println("");
            sumPrice+=cartguest.get(i).getPrice();
        }}
        System.out.println("Tổng số tiền  " + sumPrice);
    }
    public static void readCartGuest(List<ComputerGuest> cartguest,String nameID,List<Computer> computerscartguest){
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
    public static void pay(List<Computer> computerscartguest,List<Computer> computers,List<ComputerGuest> cartguest){
        int sumPrice=0;
        for (int i = 0; i <computerscartguest.size() ; i++) {
            System.out.println("Tên hàng hóa: "+computerscartguest.get(i).getName());
            System.out.println("Giá tiền :" + computerscartguest.get(i).getPrice());
            System.out.println("");
            sumPrice+=computerscartguest.get(i).getPrice();
            for (int j = 0; j <computers.size() ; j++) {
                if (computerscartguest.get(i).getName().equals(computers.get(j).getName())){
                    computers.get(j).setAmount(computers.get(j).getAmount()-1);
                }
            }
        }
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).getAmount()==0){
                computers.remove(i);
            }
        }
        System.out.println("Đã lên đơn thành công. Số tiền bạn cần thanh toán là : " + sumPrice);
        for (int i = 0; i < computerscartguest.size(); i++) {
            for (int j = 0; j < cartguest.size(); j++) {
            if (computerscartguest.get(i).getName().equals(cartguest.get(j).getName())){
                cartguest.get(j).setStatus("Đã mua");
            }
        }}
        writeAndReadCartGuest.write(cartguest);

    }
    public static void changePassword(List<Guest> guests,String nameID){
        while (true){
            boolean check=false;
        System.out.print("Nhập mật khẩu cũ: ");
        String passwordold=scannerGuest.nextLine();
        System.out.println("");
        System.out.print("Nhập mật khẩu mới:");
        String newpassword=scannerGuest.nextLine();
        System.out.println("");
        System.out.print("Xác nhận mật khẩu:");
        String confimnewpassword=scannerGuest.nextLine();
        for (int i = 0; i < guests.size(); i++) {
            if (guests.get(i).getId().equals(nameID)&& guests.get(i).getPassword().equals(passwordold)&&newpassword.equals(confimnewpassword)){
                guests.get(i).setPassword(newpassword);
                check=true;
                break;
            }

    }
        if (check){
            System.out.println("Đổi mật khẩu thành công!");
            WriteAndReadGuest.write(guests);
        }else System.out.println("Sai mật khẩu hoặc mật khẩu mới không trùng khớp");
        break;
        }
    }
    public static void showBought(List<ComputerGuest> cartguest){
        for (int i = 0; i < cartguest.size(); i++) {
            if (cartguest.get(i).getStatus().equals("Đã mua")){
                System.out.println(cartguest.get(i).showCartGuest());
            }
        }
    }
}
