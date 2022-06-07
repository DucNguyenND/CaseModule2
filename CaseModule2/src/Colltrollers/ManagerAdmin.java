package Colltrollers;

import Models.Staff;
import io.WriteAndReadAccountStaff;

import java.util.List;
import java.util.Scanner;

public class ManagerAdmin {
    static Scanner scannerAdmin =new Scanner(System.in);
    public static void menuAdmin(List<Staff> staff,String nameLogin){
        WriteAndReadAccountStaff.read(staff);
        System.out.println(nameLogin);
        System.out.println("1. Thêm nhân viên");
        System.out.println("2. Sửa thông tin nhân viên");
        System.out.println("3. Đuổi việc nhân viên");
        System.out.println("4. Xem thông tin khách hàng");
        System.out.println("5. Xem doanh thu cửa hàng");
        switch (Integer.parseInt(scannerAdmin.nextLine())){
            case 1:
                addStaff(staff);
                break;
            case 2:
            case 3:

        }
    }
    public static Staff creatStaff(){
        String id="";
        while (true){
        System.out.println("Nhập id nhân viên");
        id= scannerAdmin.nextLine();
        if (ValidateLogin.valiDateAccount(id)){
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
        creatStaff();
        staff.add(creatStaff());
        WriteAndReadAccountStaff.write(staff);
    }
    public static void editnv(List<Staff> staff){
        for (int i = 0; i < staff.size(); i++) {
            System.out.println((i+1)+staff.get(i).shownv());
        }
        int choiceAdmin;
        System.out.println("Nhập số thứ tự nhân viên cần sửa");
        choiceAdmin=Integer.parseInt(scannerAdmin.nextLine());
    }
}
