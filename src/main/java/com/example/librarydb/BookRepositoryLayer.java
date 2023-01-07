package com.example.librarydb;


import com.example.librarydb.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryLayer {


    @Autowired
    BookRespository bookRespository;

    public void createBook(Book book) throws Exception {

        //Validation part of duplicate part
        if(bookRespository.findById(book.getId()).get()!=null){

            throw new Exception("Book is already present");
        }

        bookRespository.save(book);
    }

}
