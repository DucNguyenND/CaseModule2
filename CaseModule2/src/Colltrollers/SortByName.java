package Colltrollers;

import Models.Computer;

import java.util.Comparator;

public class SortByName implements Comparator<Computer> {
    @Override
    public int compare(Computer o1, Computer o2) {
        if (o1.getName().equals(o2.getName())){
            return 1;
        }
        else
            return -1;
    }
}
