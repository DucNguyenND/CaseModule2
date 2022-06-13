package io;

import Models.ComputerGuest;

import java.io.*;
import java.util.List;

public class ReadFileGuest {
    public static void read(List<ComputerGuest> computer){
        File file=new File("C:\\Users\\DucNguyen\\Desktop\\CaseModule2\\Data\\cartguest.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String str=bufferedReader.readLine();
            while (str!=null){
                String[] arr=str.split(",");
                String brand=arr[1];
                String name=arr[2];
                String chip=arr[3];
                String display=arr[4];
                String ram=arr[5];
                String battery=arr[6];
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
