package com.company.menu;

import com.company.interfase.MenuPrintable;

public class Menu implements MenuPrintable {
    public  void printMenu() {
        System.out.println("МЕНЮ");
        System.out.println("1.Создать каталог нажмите;");
        System.out.println("2.Печать каталога полная инфо нажмите;");
        System.out.println("3.Печать каталога краткая инфо нажмите;");
        System.out.println("4.Добавить издание;");
        System.out.println("5.Найти по названию;");
        System.out.println("6.Найти по автору;");
        System.out.println("7.Удалить издание;");
        System.out.println("8.Выход;");
    }
    public void printMenuAddEdition() {
        System.out.println("1.Добавить книгу;");
        System.out.println("2.Добавить газету;");
        System.out.println("3.Добавить альманах;");
    }
}
