package com.example.librarydb;



public class UpdateBookPage {

    private int id;

    private int pages;


    public UpdateBookPage(int id, int pages) {
        this.id = id;
        this.pages = pages;
    }

    public UpdateBookPage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
