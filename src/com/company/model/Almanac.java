package com.company.model;

import com.company.interfase.*;

public class Almanac implements LibruaryItem {
    private String name;
    private Book[] books;
    private AlmanacInitialiser almanacInitialiser;

    public Almanac() {};
    public Almanac(AlmanacInitialiser almanacInitialiser) {
        this.almanacInitialiser = almanacInitialiser;
    }
    public Almanac(String name, Book[] books) {
        this.name = name;
        this.books = books;
    }

    @Override
    public void init() {
        almanacInitialiser.initialise(this);
    }

    @Override
    public void print(ItemPrintable itemPrintablePrintable) {
        itemPrintablePrintable.print((LibruaryItem) this);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Book[] getBooks() {
        return books;
    }
    public void setBooks(Book[] books) {
        this.books = books;
    }


}
