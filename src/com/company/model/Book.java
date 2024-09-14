package com.company.model;

import java.util.Objects;
import com.company.interfase.*;

public class Book implements LibruaryItem {
    private String title;
    private String author;
    private String genre;
    private int pages;
    private BookInitialiser bookInitialiser;

    public Book() {}
    public Book(BookInitialiser bookInitialiser) {
        this.bookInitialiser = bookInitialiser;
    }
    public Book(String title, String author, String genre, int pages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }
    @Override
    public void init() { bookInitialiser.initialise(this);}

    @Override
    public void print(ItemPrintable itemPrintable) {
        itemPrintable.print((LibruaryItem) this);
    }

    @Override
    public String toString() {
        return "Название: " + this.getTitle() + "\n" + "Автор: " + this.getAuthor() + "\n" +
                "Жанр: " + this.getGenre() + "\n" + "Количество страниц: " + this.getPages() + "\n------------" ;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(genre, book.genre);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, author, genre);
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public BookInitialiser getBookInitialiser() {
        return bookInitialiser;
    }

    public void setBookInitialiser(BookInitialiser bookInitialiser) {
        this.bookInitialiser = bookInitialiser;
    }
}
