package com.company;

import java.util.Scanner;
import com.company.menu.*;

public class Main {
    public static void main(String[] args) {
        Servise servise = new Servise();
        Scanner scanner = new Scanner(System.in);
        do{
            servise.getMenu().printMenu();
            int choice = scanner.nextInt();
            if(choice == 1){
                servise.init();
            }
            else if(choice == 2){
                servise.printCatalogFull();
            }
            else if(choice == 3){
                servise.printCatalogShort();
            }
            else if(choice == 4){
                servise.addItem();
            }
            else if (choice == 5) {
                servise.searchForName();
            }
            else if(choice == 6){
                servise.searchForAuthor();
            }
            else if(choice == 7){
                servise.deleteForName();
            }
            else if (choice == 8) {
                break;
            }
        }while (true);

        System.exit(0);
    }
}