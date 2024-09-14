package com.company.factory;

import com.company.model.Almanac;
import com.company.model.Book;
import com.company.model.Newspaper;
import com.company.initialization.*;
import com.company.interfase.LibruaryItem;
import java.util.Random;

public abstract class RandomLabruaryItem {
    private static final Random random = new Random();

    public static LibruaryItem createRandomItem() {
        int itemType = random.nextInt(3);
        switch (itemType) {
            case 0:
                Book book = new Book();
                new BookArrayInit().initialise(book);
                return book;
            case 1:
                Newspaper newspaper = new Newspaper();
                new NewspaperArrayInit().initialise(newspaper);
                return newspaper;
            case 2:
                Almanac almanac = new Almanac();
                new AlmanacArrayInit().initialise(almanac);
                return almanac;
            default:
                throw new IllegalStateException("Неожиданное значение: " + itemType);
        }
    }

    public abstract void initialise(Almanac almanac);
}
