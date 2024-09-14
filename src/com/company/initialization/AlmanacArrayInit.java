package com.company.initialization;

import java.util.Random;
import com.company.factory.RandomLabruaryItem;
import com.company.model.*;

public class AlmanacArrayInit extends RandomLabruaryItem {
    private static final String[] almanacNames = {"Альманах1","Альманах2","Альманах3","Альманах4","Альманах5"};
    private static final Random random = new Random();

    @Override
    public void initialise(Almanac almanac) {
        String title = almanacNames[random.nextInt(almanacNames.length)];
        int year = 1950 + random.nextInt(23);
        Book[] books = new Book[3]; // например, каждый альманах имеет по 3 книги

        for (int i = 0; i < books.length; i++) {
            books[i] = new Book();
            new BookArrayInit().initialise(books[i]);
        }
        almanac.setName(title);
        almanac.setBooks(books);
    }
}
