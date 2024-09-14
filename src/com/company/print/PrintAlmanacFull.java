package com.company.print;

import com.company.interfase.*;
import com.company.model.*;

public class PrintAlmanacFull implements ItemPrintable{
    @Override
    public void print(LibruaryItem libruaryItem) {
        Almanac almanac = (Almanac) libruaryItem;
        System.out.println("Название альманаха: " + almanac.getName());
        for(int i = 0; i < almanac.getBooks().length; i++){
            Book book = almanac.getBooks()[i];
            if(book != null){
                book.print(new PrintBookFull());
            }
        }
        System.out.println(" ");
        System.out.println(" ");
    }
}
