package com.company.menu;

import com.company.interfase.LibruaryItem;
import com.company.interfase.MenuPrintable;
import com.company.model.*;

import java.util.Objects;
import java.util.Scanner;

public class Servise {
    private Catalog catalog;
    private MenuPrintable menu;

    public Servise() {
        this.catalog = new Catalog();
        this.menu = new Menu();
    }
    public Servise(Catalog catalog) {
        this.catalog = catalog;
    }

    public void init(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Укажите количество изданий: ");
        int num = sc.nextInt();
        if(num > 0 ){
            catalog.initCatalog(num);
            System.out.println("Каталог проинициализирован: " + catalog.getEditions().length + " изданий.");
        }
    }

    public void  printCatalogFull(){
        if(catalog.getEditions() != null){
            catalog.printCatalogFull();
        }
        else{
            System.out.println("Каталог пуст!");
        }
    }

    public void  printCatalogShort(){
        if(catalog.getEditions() != null){
            catalog.printCatalogShortInfo();
        }
        else{
            System.out.println("Каталог пуст!");
        }
    }

    public void addItem(){
        menu.printMenuAddEdition();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 1 ){
            catalog.addItem(addBook());
            System.out.println("Книга добавлена!");
        }
        else if(num == 2 ){
            addNewspaper();
        } else if (num == 3 ) {
            addAlmanac();
        }

    }

    public void searchForName(){
        System.out.println("Введите название издания: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        LibruaryItem item = catalog.searchForName(name);
        if(item != null){
            System.out.println(item.toString());
        }
    }

    public void searchForAuthor(){
        System.out.println("Введите автора: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        LibruaryItem item = catalog.searchForAuthor(name);
        if(item != null){
            System.out.println(item.toString());
        }
    }

    public void deleteForName(){
        System.out.println("Введите название издания для удаления: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        if(catalog.deleteForName(name)){
            System.out.println("Издание удалено!");
        }
        else {
            System.out.println("Произошла ошибка, попробуйте снова!");
        }
    }

    private LibruaryItem addBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название книги: ");
        String title = sc.nextLine();
        System.out.println("Введите автора: ");
        String author = sc.nextLine();
        System.out.println("Введите жанр книги: ");
        String genre = sc.nextLine();
        System.out.println("Введите количество страниц: ");
        int pages = sc.nextInt();
        if(Objects.equals(title, "") || Objects.equals(author, "") || Objects.equals(genre, "") || pages == 0){
            System.out.println("Не все поля заполнены!");
        }
        else{
            return new Book(title, author, genre, pages);
        }
        return null;
    }

    private void addNewspaper(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название газеты: ");
        String name = sc.nextLine();
        System.out.println("Введите дату выпуска: ");
        String date = sc.nextLine();
        System.out.println("Введите количество заголовков: ");
        int count = sc.nextInt();
        String[] titles = null;
        if(count > 0){
            titles = new String[count];
            for(int i = 0; i < count; i++){
                System.out.println("Заголовок " + i + ": ");
                String title = sc.next();
                titles[i] = title;
            }
        }
        if(Objects.equals(name, "") || Objects.equals(date, "")){
            System.out.println("Не все поля заполнены!");
        }
        else {
            Newspaper newspaper = new Newspaper(name, date, titles);
            catalog.addItem(newspaper);
            System.out.println("Газета добавлена!");
        }

    }

    private void addAlmanac() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название: ");
        String name = sc.nextLine();
        System.out.println("Введите количество книг в альманахе: ");
        int count = sc.nextInt();
        Book [] books = null;
        if(count > 0) {
            books = new Book[count];
            for (int i = 0; i < count; i++) {
                books[i] = (Book) addBook();
            }
        }
        if(Objects.equals(name, "")){
            System.out.println("Не все поля заполнены!");
        }
        else {
            Almanac almanac = new Almanac(name, books);
            catalog.addItem(almanac);
            System.out.println("Альманах добавлен!");
        }
    }

    public Catalog getCatalog() {
        return catalog;
    }
    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public MenuPrintable getMenu() {
        return menu;
    }

}
