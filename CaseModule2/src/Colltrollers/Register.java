package Colltrollers;

import Models.Guest;
import io.WriteAndReadGuest;

import java.util.List;
import java.util.Scanner;

public class Register {
    static Scanner sc=new Scanner(System.in);
    public static void register(List<Guest> guests){
            String id;
            String phoneNumber;
            String passWord;
            String name;
            while (true) {
                System.out.println("Nhập tên tài khoản:");
                id = sc.nextLine();
                if (ValidateLogin.valiDateAccount(id)) {
                    if (checkedid(id,guests)) {
                        break;
                    } else
                        System.out.println("Tên đăng nhập đã tồn tại, vui lòng nhập lại!");
                }
                System.out.println("Vui lòng nhập tên tài khoản ít nhất 6 ký tự và không có ký tự đặc biệt");
            }

            while (true) {
                System.out.println("Nhập mật khẩu:");
                passWord = sc.nextLine();
                System.out.println("Xác nhận lại mật khẩu:");
                String passWordConfim = sc.nextLine();
                if (passWord.equals(passWordConfim)) {
                    if (ValidateLogin.valiDatePassword(passWord)) {
                        break;
                    } else
                        System.out.println("Vui lòng nhập mật khẩu ít nhất 6 ký tự và không có ký tự đặc biệt");
                } else
                    System.out.println("Mật khẩu không trùng khớp");
            }

            while (true) {
                System.out.println("Vui lòng nhập tên của bạn:");
                name = sc.nextLine();
                if (ValidateLogin.valiDateName(name)) {
                    break;
                }
            }
            while (true) {
                System.out.println("Vui lòng nhập số điện thoại của bạn:");
                System.out.println("Số điện thoại bắt đầu từ 0 và có 10 chữ số");
                phoneNumber = sc.nextLine();
                if (ValidateLogin.valiDatePhoneNumber(String.valueOf(phoneNumber))) {
                    break;
                } else System.out.println("Nhập sai số điện thoại, vui lòng nhập lại");
            }
            System.out.println("Nhập địa chỉ giao hàng:");
            String anddress = sc.nextLine();
            guests.add(new Guest(id, passWord, name, phoneNumber, anddress));
            WriteAndReadGuest.write(guests);
        }
    public static boolean checkedid(String id, List<Guest> guests){
        boolean check=true;
        for (int i = 0; i < guests.size(); i++) {
            if (id.equals(guests.get(i).getId())){
                check=false;
                break;
            }
        }
        return check;
    }
}
