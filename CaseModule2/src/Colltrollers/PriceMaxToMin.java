package Colltrollers;

import Models.Computer;

import java.util.Comparator;

public class PriceMaxToMin implements Comparator<Computer> {
    @Override
    public int compare(Computer o1, Computer o2) {
        if (o1.getPrice()> o2.getPrice()){
            return 1;
        }
        else
            return -1;
    }
}
