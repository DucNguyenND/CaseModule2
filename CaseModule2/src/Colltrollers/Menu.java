package Colltrollers;

import Models.Computer;
import Models.ComputerGuest;
import Models.Guest;
import Models.Staff;
import io.ValidateChoice;
import io.WriteAndReadGuest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

   static Scanner sc=new Scanner(System.in);
   static List<Guest> guests=new ArrayList<>();
   static List<ComputerGuest> cartguest=new ArrayList<>();
   static List<Computer> computers=new ArrayList<>();
    static List<Staff> staff=new ArrayList<>();

    public static void login() {
        WriteAndReadGuest.readFileGuest(guests);
        while (true) {
            while (true) {
                try {
                    while (true) {
                        System.out.println("====Menu====");
                        System.out.println("1. Đăng Nhập");
                        System.out.println("2. Đăng Ký");

                        int choice = Integer.parseInt(sc.nextLine());
                        if (ValidateChoice.validatechoice(String.valueOf(choice))) {
                            if (choice == 1) {
                                LoginAccount.loginaccount(guests, staff, computers, cartguest);
                            } else {
                                Register.register(guests);
                            }
                            break;
                        } else System.out.println("Vui lòng chọn lại");
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng chọn lại");
                }
            }
        }
    }
}
