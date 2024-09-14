package com.company.print;

import com.company.interfase.ItemPrintable;
import com.company.interfase.LibruaryItem;
import com.company.model.Newspaper;

public class PrintNewspeperShortInfo implements ItemPrintable {
    @Override
    public void print(LibruaryItem itemLibruary) {
        Newspaper newspaper = (Newspaper) itemLibruary;
        System.out.println("Название газеты: " + newspaper.getName());
        System.out.println("Дата выхода: " + newspaper.getDate());
        System.out.println();
    }
}
