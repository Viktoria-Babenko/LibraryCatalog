package com.company.print;

import com.company.interfase.ItemPrintable;
import com.company.interfase.LibruaryItem;
import com.company.model.Book;

public class PrintBookShortInfo implements ItemPrintable {

    @Override
    public void print(LibruaryItem itemLibruary) {
        Book book = (Book) itemLibruary;
        System.out.println("Название книги: " + book.getTitle());
        System.out.println("Автор: " + book.getAuthor());
        System.out.println();
    }
}
