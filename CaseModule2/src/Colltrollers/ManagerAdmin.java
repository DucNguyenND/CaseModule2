package Colltrollers;

import Models.Computer;
import Models.ComputerGuest;
import Models.Guest;
import Models.Staff;
import Validate.ValidateChoice;
import io.WriteAndReadAccountStaff;
import io.WriteAndReadCartGuest;
import io.WriteAndReadGuest;

import java.util.List;
import java.util.Scanner;

public class ManagerAdmin {
    static Scanner scannerAdmin =new Scanner(System.in);
    public static void menuAdmin(List<Staff> staff, String nameLogin, List<Guest> guests, List<Computer> computers,List<ComputerGuest> cartGuest){
            while (true){
                while (true){
        WriteAndReadAccountStaff.read(staff);
        System.out.println(nameLogin);
        System.out.println("1. Thêm nhân viên");
        System.out.println("2. Xem danh sách nhân viên");
        System.out.println("3. Sửa thông tin nhân viên");
        System.out.println("4. Xóa nhân viên");
        System.out.println("5. Xem thông tin khách hàng");
        System.out.println("6. Xem doanh thu cửa hàng");
        System.out.println("7. Đăng xuất");
            try {

                    int choice=Integer.parseInt(scannerAdmin.nextLine());
                if (ValidateChoice.validateChoiceAdmin(String.valueOf(choice))){
                    if (choice==1){
                            addStaff(staff);
                        }else if (choice==2){
                        showNV(staff);
                    }else if (choice==3){
                            editStaff(staff);
                        }else if (choice==4){
                            remoteStaff(staff);
                        }else if (choice==5){
                            showGuest(guests);
                        }else if (choice==6){
                            showTurnover(cartGuest);
                        }else if (choice==7){
                        break;}
                }else {
                    System.out.println("Vui lòng chọn từ 1-7");
                }
                    }catch (Exception e){
                System.out.println("Vui lòng chọn lại");
            }
        }
            break;
            }
        }
    public static Staff creatStaff(List<Staff> staff){
        String id="";
        boolean checkID=false;
        while (true){
        System.out.println("Nhập id nhân viên");
        id= scannerAdmin.nextLine();
        if (Colltrollers.ValidateLogin.valiDateAccount(id)){
            break;
        } else System.out.println("Nhập sai vui lòng nhập lại");
        }
        System.out.println("Nhập Password của nhân viên");
        String passWord= scannerAdmin.nextLine();
        System.out.println("Nhập tên nhân viên");
        String name= scannerAdmin.nextLine();
        System.out.println("Nhập số điện thoại nhân viên");
        String phoneNumber= scannerAdmin.nextLine();
        System.out.println("Nhập địa chỉ của nhân viên");
        String address= scannerAdmin.nextLine();
        System.out.println("Nhập số CMND/CCCD của nhân viên");
        String idCard= scannerAdmin.nextLine();
        return new Staff(id,passWord,name,phoneNumber,address,idCard);
    }
    public static void addStaff(List<Staff> staff){
        creatStaff(staff);
        staff.add(creatStaff(staff));
        WriteAndReadAccountStaff.write(staff);
    }
    public static void editStaff(List<Staff> staff) {
        int indexStaff=-1;
        boolean check=false;
        System.out.println("Vui lòng nhập ID nhân viên cần sửa");
        String idStaff= scannerAdmin.nextLine();
        for (int i = 0; i <staff.size(); i++) {
            if (staff.get(i).getId().equals(idStaff)){
                indexStaff=i;
                check=true;
                break;
            }
        }
        if (check){
            staff.set(indexStaff,creatStaff(staff));
            WriteAndReadAccountStaff.write(staff);
            System.out.println("Done!");
        }else {
            System.out.println("Sai ID nhân viên");
        }
    }
    public static void remoteStaff(List<Staff> staff){
        int indexStaff=-1;
        while (true){
            System.out.println("Vui lòng nhập ID nhân viên cần xóa");
            String idStaff= scannerAdmin.nextLine();
            for (int i = 0; i <staff.size(); i++) {
                if (staff.get(i).getId().equals(idStaff)){
                    indexStaff=i;

                    break;
                }
            }
            if (indexStaff!=-1){
            staff.remove(indexStaff);
            System.out.println("Xóa thành công");
            break;
            }else {
                System.out.println("ID nhập vào không trùng khớp");
                break;
            }
        }
    }
    public static void showGuest(List<Guest> guests){
        for (int i = 0; i < guests.size(); i++) {
            System.out.println(guests.get(i).toString());
        }
    }
    public static void showTurnover(List<ComputerGuest> computerGuests){
        WriteAndReadCartGuest cartGuest=new WriteAndReadCartGuest();
        cartGuest.read(computerGuests);
        int turnover=0;
        for (ComputerGuest computerGuest:computerGuests
             ) {
            if (computerGuest.getStatus().equals("Đã mua")){
            System.out.println(computerGuest.showCartGuest());
            turnover+=computerGuest.getPrice();
        }
        }
        System.out.println("Tổng doanh thu hiện tại là: " + turnover);
    }
    public static void showNV(List<Staff> staff){
        for (int i = 0; i < staff.size(); i++) {
            System.out.println((i+1)+". "+staff.get(i).shownv());
        }
    }
}
