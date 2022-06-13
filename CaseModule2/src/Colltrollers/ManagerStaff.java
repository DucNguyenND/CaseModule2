package Colltrollers;

import Models.Computer;
import Models.ComputerGuest;
import Models.Guest;
import Models.Staff;
import io.ValidateChoice;
import io.ValidateComputer;
import io.WriteAndReadStaff;

import java.util.List;
import java.util.Scanner;

public class ManagerStaff {
    static Scanner scannerStaff =new Scanner(System.in);
    static WriteAndReadStaff writeAndRead=new WriteAndReadStaff();
    public static void menuStaff(List<Computer> computers, String nameLogin, List<Guest>guests,List<ComputerGuest> cartguest){
        writeAndRead.read(computers);
            while (true){
            System.out.println(nameLogin);
            System.out.println("====Menu====");
            System.out.println("1. Thêm Laptop");
            System.out.println("2. Xóa Laptop");
            System.out.println("3. Sửa thông tin Laptop");
            System.out.println("4. Hiển thị thông tin khách hàng");
            System.out.println("5. Đăng xuất");
        try {
        int choice=Integer.parseInt(scannerStaff.nextLine());
        if (ValidateChoice.validateChoiceStaff(String.valueOf(choice))){
            switch (choice){
                case 1:
                    addlaptop(computers);
                    break;
                case 2:
                    remoteLaptop(computers);
                    break;
                case 3:
                    editLaptop(computers);
                    break;
                case 4:
                    showGuest(guests,cartguest);
                case 5:
                    return;
            }
        }
        else System.out.println("Vui lòng chọn lại");
        }catch (NumberFormatException e){
            System.out.println("Vui lòng nhập lại");
        }
        }
    }
    public static Computer creatLaptop(){
        System.out.println("Nhập hãng máy tính");
        String brand= scannerStaff.nextLine();
        System.out.println("Nhập tên máy tính");
        String name= scannerStaff.nextLine();
        System.out.println("Nhập thông số chip");
        String chip= scannerStaff.nextLine();
        System.out.println("Nhập thông số màn hình");
        String display= scannerStaff.nextLine();
        System.out.println("Nhập thông tin Ram");
        String ram= scannerStaff.nextLine();
        System.out.println("Nhập thông số Pin");
        String battery= scannerStaff.nextLine();
       int ammount=0;
        while (true){
            System.out.println("Nhập số lượng tồn:");
            ammount=Integer.parseInt(scannerStaff.nextLine());
            if (ValidateComputer.validateAmount(String.valueOf(ammount))){
                break;
            }else System.out.println("Vui lòng nhập lại");
        }
      int price=0;
        while (true){
            System.out.println("Nhập giá tiền: ");
            price=Integer.parseInt(scannerStaff.nextLine());
            if (ValidateComputer.validatePrice(String.valueOf(price))){
                break;
            }else System.out.println("Vui lòng nhập lại");
        }
        return new Computer(brand,name,chip,display,ram,battery,ammount,price);
    }
    public static void addlaptop(List<Computer> computers){
        computers.add(creatLaptop());
        writeAndRead.write(computers);
        writeAndRead.read(computers);
    }
    public static void editLaptop(List<Computer> computers){
        int choicestaff=-1;
        for (int i = 0; i < computers.size(); i++) {
            System.out.println((i+1)+ computers.get(i).showLaptop());
        }

        while (true){
            System.out.println("Vui lòng chọn laptop muốn sửa:");
            choicestaff=Integer.parseInt(scannerStaff.nextLine());
            if (choicestaff>=1&&choicestaff<=computers.size()){
                break;
            }else System.out.println("Vui lòng chọn lại");
            creatLaptop();
            computers.set((choicestaff-1),creatLaptop());
        }
    }
    public static void remoteLaptop(List<Computer> computers){
        boolean checkremote=false;
            System.out.println("Vui lòng nhập tên laptop cần xóa");
            String nameLaptop=scannerStaff.nextLine();
            for (int i = 0; i <computers.size(); i++) {
                if (computers.get(i).getName().equals(nameLaptop)){
                    computers.remove(i);
                    checkremote=true;
                    break;
                }
                if (checkremote){
                    System.out.println("Đã xóa!");
                }else
                    System.out.println("Vui lòng nhập đúng tên laptop");
            }
        }
        public static void showGuest(List<Guest>guests,List<ComputerGuest> cartguest){
            for (int i = 0; i <cartguest.size()-1; i++) {
                if (cartguest.get(i).getNameID().equals(cartguest.get(i+1).getNameID())){
                    continue;
                }else {
                for (int j = 0; j < guests.size(); j++) {
                if (cartguest.get(i).getNameID().equals(guests.get(j).getId())){
                    System.out.println("Khách hàng: "+guests.get(j).getName());
                    System.out.println("Phone number:" + guests.get(j).getPhoneNumber());
                    System.out.println("Địa chỉ nhận hàng: " + guests.get(j).getAddress());
                }
                }
                }
                    cartguest.get(i).showCartGuest();
            }
    }
}
