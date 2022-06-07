package io;

import Models.Computer;
import Models.Staff;

import java.io.*;
import java.util.List;

public class WriteAndReadAccountStaff {
   static File file=new File("C:\\Users\\DucNguyen\\Desktop\\CaseModule2\\Data\\StaffID.txt");


    public static void write(List<Staff> staff){
        try {
            FileWriter fileWriter=new FileWriter(file);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (Staff e:staff
            ) {
                bufferedWriter.write(e.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void read(List<Staff> staff){
        try {

            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String str=bufferedReader.readLine();
            while (str!=null){
                String[] arr=str.split(",");
                String id=arr[0];
                String password=arr[1];
                String name=arr[2];
                String phoneNumber= arr[3];
                String address=arr[4];
                String idcard= arr[5];
                staff.add(new Staff(id,password,name,phoneNumber,address,idcard));
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
