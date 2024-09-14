package com.company.interfase;

public interface LibraryCatalog {
    void initCatalog(int count);
    void printCatalogFull();
    void printCatalogShortInfo();
    void addItem(LibruaryItem libruaryItem);
    LibruaryItem searchForName(String name);
    LibruaryItem searchForAuthor(String name);
    boolean deleteForName(String name);
}
