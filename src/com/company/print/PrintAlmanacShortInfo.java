package com.company.print;

import com.company.interfase.*;
import com.company.model.Almanac;

public class PrintAlmanacShortInfo implements ItemPrintable {
    @Override
    public void print(LibruaryItem libruaryItem) {
        Almanac almanac = (Almanac) libruaryItem;
        System.out.println("Название альманаха: " + almanac.getName());
        System.out.println("Количество книг: " + (almanac.getBooks().length));
        System.out.println(" ");
    }

}
