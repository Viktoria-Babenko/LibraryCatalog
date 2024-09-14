package com.company.model;

import com.company.interfase.ItemPrintable;
import com.company.interfase.LibruaryItem;
import com.company.interfase.NewspaperInitialiser;
import java.util.Arrays;

public class Newspaper implements LibruaryItem {
    private String name;
    private String date;
    private String [] titles;
    private NewspaperInitialiser newspaperInitialiser;

    public Newspaper (){}
    public Newspaper(NewspaperInitialiser newspaperInitialiser){
        this.newspaperInitialiser = newspaperInitialiser;
    }
    public Newspaper(String name, String date, String[] titles) {
        this.name = name;
        this.date = date;
        this.titles = titles;
    }

    @Override
    public void init() {
        newspaperInitialiser.initialise(this);
    }

    @Override
    public void print(ItemPrintable itemPrintable) {
        itemPrintable.print((LibruaryItem) this);
    }

    @Override
    public String toString() {
        return "Название: " + this.getName() + "\n" + "Дата выхода: " + this.getDate() + "\n" +
                Arrays.toString(this.getTitles()) + "\n------------";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }
}
