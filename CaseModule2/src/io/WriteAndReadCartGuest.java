package io;

import Models.Computer;
import Models.ComputerGuest;

import java.io.*;
import java.util.List;

public class WriteAndReadCartGuest {
    File file=new File("C:\\Users\\DucNguyen\\Desktop\\CaseModule2\\Data\\cartguest.txt");

    public void write(List<ComputerGuest> computer){
        try {
            FileWriter fileWriter=new FileWriter(file);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (Computer e:computer
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
    public void read(List<ComputerGuest> computers){
        try {

            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String str=bufferedReader.readLine();
            while (str!=null){
                String[] arr=str.split(",");
                String nameID=arr[0];
                String brand=arr[1];
                String name=arr[2];
                String chip=arr[3];
                String display=arr[4];
                String ram=arr[5];
                String battery=arr[6];
                int price= Integer.parseInt(arr[7]);
                int amount= Integer.parseInt(arr[8]);
                computers.add(new ComputerGuest(nameID,brand,name,chip,display,ram,battery,amount,price));
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
