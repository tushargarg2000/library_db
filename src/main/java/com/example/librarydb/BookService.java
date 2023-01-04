package com.example.librarydb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {


    @Autowired
    BookRespository bookRespository;

    public void createBook(Book book)throws Exception{

        //Logic is written here

        //Validation part of duplicate part
        if(bookRespository.findById(book.getId()).get()!=null){

            throw new Exception("Book is already present");
        }

        bookRespository.save(book);

    }


    public Book getBookById(Integer id) throws Exception{

        Book book = bookRespository.findById(id).get();

        System.out.println(book.getName());

        return book;
    }

    public void updateBookPages(UpdateBookPage updateBookPage){

        //We need to convert our object (Entry dto) into Entity Object.

        int id = updateBookPage.getId();

        Book bookToBeUpdated = bookRespository.findById(id).get();

        bookToBeUpdated.setPages(updateBookPage.getPages());

        bookRespository.save(bookToBeUpdated);
    }


}
