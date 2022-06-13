package Colltrollers;

import Models.Computer;
import Models.ComputerGuest;
import Models.Guest;
import Models.Staff;
import io.WriteAndReadAccountStaff;

import java.util.List;
import java.util.Scanner;

public class LoginAccount {
    static Scanner input=new Scanner(System.in);
    public static void loginaccount(List<Guest> guests, List<Staff> staff, List<Computer> computers, List<ComputerGuest> cartguest,List<Computer> computerscartguest){
        WriteAndReadAccountStaff.read(staff);
        while (true){
        System.out.println("Vui lòng nhập tên tài khoản:");
        String id=input.nextLine();
        System.out.println("Nhập Password:");
        String password=input.nextLine();
        int checkguest=0;
        int checkstaff=0;
        int checkadmin=0;
        String nameID=null;
        String nameLogin = null;
        for (int i = 0; i < guests.size(); i++) {
            if (guests.get(i).getId().equals(id)&&guests.get(i).getPassword().equals(password)){
                checkguest=1;
                nameLogin= "Xin chào "+ guests.get(i).getName();
                nameID=guests.get(i).getId();
                break;
            }
        }
        for (int i = 0; i < staff.size(); i++) {
            if (staff.get(i).getId().equals(id)&&staff.get(i).getPassword().equals(password)){
                checkstaff=1;
                nameLogin="Xin chào "+ staff.get(i).getName();
                nameID=staff.get(i).getId();
                break;
            }
        }
        if (id.equals("Admin") && password.equals("Admin")){
           checkadmin=1;
           nameLogin="===Xin chào admin===";

        }
        if (checkguest==1){
            ManagerGuest2.managerGuest2(computers,cartguest,nameLogin,nameID,computerscartguest,guests);
            break;
        }else if (checkstaff==1){
            ManagerStaff.menuStaff(computers,nameLogin,guests,cartguest);
            break;
             }else if (checkadmin==1){
            ManagerAdmin.menuAdmin(staff,nameLogin,guests,computers,cartguest);
            break;
                 } else {
                        System.out.println("Sai thông tin đăng nhập");

    }
    }
    }
}
