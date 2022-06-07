package io;

import Models.Computer;

import java.io.*;
import java.util.List;

public class WriteAndReadStaff {
    File file=new File("C:\\Users\\DucNguyen\\Desktop\\CaseModule2\\Data\\Computer.txt");


    public void write(List<Computer> computer){
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
    public void read(List<Computer> computers){
        try {

            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String str=bufferedReader.readLine();
            while (str!=null){
                String[] arr=str.split(",");
                String brand=arr[0];
                String name=arr[1];
                String chip=arr[2];
                String display=arr[3];
                String ram=arr[4];
                String battery=arr[5];
                int price= Integer.parseInt(arr[6]);
                int amount= Integer.parseInt(arr[7]);
                computers.add(new Computer(brand,name,chip,display,ram,battery,amount,price));
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
