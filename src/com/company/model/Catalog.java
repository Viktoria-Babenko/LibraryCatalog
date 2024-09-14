package com.company.model;

import java.util.Arrays;
import java.util.Objects;
import com.company.interfase.*;
import com.company.print.*;
import com.company.factory.RandomLabruaryItem;

public class Catalog implements LibraryCatalog {
    private  LibruaryItem[] libruaryItems;

    public Catalog() {}

    public Catalog(LibruaryItem[] libruaryItems) {
        this.libruaryItems = libruaryItems;
    }

    @Override
    public void initCatalog(int count){
        libruaryItems = new LibruaryItem[count];
        for(int i=0; i<count; i++) {
            libruaryItems[i] = RandomLabruaryItem.createRandomItem();
        }
    }

    @Override
    public void printCatalogFull(){
        for (LibruaryItem libruaryItem : libruaryItems) {
            if (libruaryItem instanceof Book) {
                libruaryItem.print(new PrintBookFull());
            } else if (libruaryItem instanceof Newspaper) {
                libruaryItem.print(new PrintNewspaperFull());
            } else if (libruaryItem instanceof Almanac) {
                libruaryItem.print(new PrintAlmanacFull());
            }
        }
    }

    @Override
    public void printCatalogShortInfo(){
        for (LibruaryItem libruaryItem : libruaryItems) {
            if (libruaryItem instanceof Book) {
                libruaryItem.print(new PrintBookShortInfo());
            } else if (libruaryItem instanceof Newspaper) {
                libruaryItem.print(new PrintNewspeperShortInfo());
            } else if (libruaryItem instanceof Almanac) {
                libruaryItem.print(new PrintAlmanacShortInfo());
            }
        }
    }

    @Override
    public void addItem(LibruaryItem libruaryItem){
        if(libruaryItems != null) {
            LibruaryItem[] itemsNew = new LibruaryItem[libruaryItems.length + 1];
            System.arraycopy(libruaryItems, 0, itemsNew, 0, libruaryItems.length);
            itemsNew[libruaryItems.length] = libruaryItem;
            libruaryItems = itemsNew;
        }
        else{
            libruaryItems = new LibruaryItem[1];
            libruaryItems[0] = libruaryItem;
        }

    }

    @Override
    public LibruaryItem searchForName(String name){

        if(!Objects.equals(name, "")){
            for (LibruaryItem item : libruaryItems) {
                if(item instanceof Book book){
                    if(book.getTitle().equals(name)){
                        return item;
                    }
                }
                else if(item instanceof Newspaper newspaper){
                    if(newspaper.getName().equals(name)){
                        return item;
                    }
                }
                else if(item instanceof Almanac almanac){
                    if(almanac.getName().equals(name)){
                        return item;
                    }
                    else{
                        for(Book book: almanac.getBooks()){
                            if(book.getTitle().equals(name)){
                                return book;
                            }
                        }
                    }
                }
            }
        }
        return null;

    }

    @Override
    public LibruaryItem searchForAuthor(String name){

        if(!Objects.equals(name, "")){
            for (LibruaryItem item : libruaryItems) {
                if(item instanceof Book book){
                    if(Objects.equals(book.getTitle(), name)){
                        return item;
                    }
                }
                else if(item instanceof Newspaper newspaper){
                    if(Objects.equals(newspaper.getName(),name)){
                        return item;
                    }
                }
                else if(item instanceof Almanac almanac){
                    if(Objects.equals(almanac.getName(), name)){
                        return item;
                    }
                }
            }
        }
        return null;

    }

    @Override
    public boolean deleteForName(String name){
        LibruaryItem item = searchForName(name);
        if(item != null){
            int index = Arrays.asList(libruaryItems).indexOf(item);
            if(index >= 0){
                libruaryItems[index] = null;
                LibruaryItem[] itemsNew = new LibruaryItem[libruaryItems.length-1];
                int j = 0;
                for(int i = 0; i < libruaryItems.length; i++){
                    if(libruaryItems[i] != null ){
                        itemsNew[i-j] = libruaryItems[i];
                    }
                    else{
                        j = 1;
                    }
                }
                libruaryItems = itemsNew;
                return true;
            }
        }
        return false;

    }

    public LibruaryItem[] getEditions() {

        return libruaryItems;
    }
    public void setEditions(LibruaryItem[] items) {

        this.libruaryItems = items;
    }

}
