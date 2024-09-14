package com.company.initialization;

import java.util.Random;
import com.company.interfase.NewspaperInitialiser;
import com.company.model.Newspaper;

public class NewspaperArrayInit implements NewspaperInitialiser {
    private final String[][] arrays = {{"Николаев Инфо", "Заголовок1", "Заголовок2", "Заголовок3", "Заголовок4"},{"Факты Неделя", "Заголовок1", "Заголовок2", "Заголовок3", "Заголовок4"},
            {"Вести", "Заголовок1", "Заголовок2", "Заголовок3", "Заголовок4"},{"Взгляд", "Заголовок1", "Заголовок2", "Заголовок3", "Заголовок4"},
            {"Власть денег", "Заголовок1", "Заголовок2", "Заголовок3", "Заголовок4"}};
    private static final Random random = new Random();

    @Override
    public void initialise(Newspaper newspaper) {
        int choice = random.nextInt(arrays.length);
        newspaper.setName(arrays[choice][0]);
        setTitles(newspaper, choice);
        setDate(newspaper);
    }

    private void setTitles(Newspaper newspaper, int choice){
        int titleCount = random.nextInt(1,5);
        newspaper.setTitles(new String[titleCount]);
        for (int i = 0; i < titleCount; i++) {
            newspaper.getTitles()[i] = arrays[choice][i+1];
        }
    }
    private void setDate(Newspaper newspaper) {
        StringBuilder date = new StringBuilder();
        date.append(random.nextInt(28));
        date.append("/");
        date.append(random.nextInt(12));
        date.append("/");
        date.append(random.nextInt(1990, 2025));
        newspaper.setDate(date.toString());
    }
}
