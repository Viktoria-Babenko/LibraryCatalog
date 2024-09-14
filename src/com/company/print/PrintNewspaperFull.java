package com.company.print;

import java.util.Arrays;

import com.company.interfase.ItemPrintable;
import com.company.model.Newspaper;
import com.company.interfase.LibruaryItem;

public class PrintNewspaperFull implements ItemPrintable {
    @Override
    public void print(LibruaryItem item) {
        Newspaper newspaper = (Newspaper) item;
        System.out.println("Название газеты: " + newspaper.getName());
        System.out.println("Дата выхода: " + newspaper.getDate());
        System.out.println( Arrays.toString(newspaper.getTitles()) );
        System.out.println();
    }
}
