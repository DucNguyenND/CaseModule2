package io;

import Models.Computer;
import Models.Guest;

import java.io.*;
import java.util.List;

public class WriteAndReadGuest {
    static File file=new File("C:\\Users\\DucNguyen\\Desktop\\CaseModule2\\Data\\idGuest.txt");
    public static void write(List<Guest> guests){
        try {
            FileWriter fileWriter=new FileWriter(file);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (Guest guest:guests
            ) {
                bufferedWriter.write(guest.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readFileGuest(List<Guest> guests){
        try{
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String str=bufferedReader.readLine();
            while (str!=null){
                String[] arr=str.split(",");
                String id=arr[0];
                String password=arr[1];
                String name=arr[2];
                String phoneNumber=arr[3];
                String address=arr[4];
                guests.add(new Guest(id,password,name,phoneNumber,address));
                str=bufferedReader.readLine();
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
