package com.company.initialization;

import java.util.Random;
import com.company.interfase.BookInitialiser;
import com.company.model.Book;

public class BookArrayInit implements BookInitialiser{
    private final String[][] arrays = {{"Николас Спаркс ", "Дневник памяти", "роман"},
            {"Тарас Шевченко","Кобзарь","поэзия"},{"Оскар Уайльд","Портрет Дориана Грея","роман"},
            {"Джон Рональд Руел Толктн","Властелин Колец.Часть первая","художественная литература"},
            {"Дин Кунц","Дом на краю света","художественная литература"}};

    private static final Random random = new Random();

    @Override
    public void initialise(Book book) {
        int choice = random.nextInt(arrays.length);
        book.setAuthor(arrays[choice][0]);
        book.setTitle(arrays[choice][1]);
        book.setGenre(arrays[choice][2]);
        book.setPages(random.nextInt(100, 1000));
    }
    public String[][] getArrays() {
        return arrays;
    }
}
