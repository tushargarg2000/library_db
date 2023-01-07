package com.example.librarydb;


import com.example.librarydb.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRespository bookRespository;




    @Autowired
    BookRepositoryLayer bookRepositoryLayer;

    public void createBook(Book book)throws Exception{

        //Logic is written here

        bookRepositoryLayer.createBook(book);

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

    public List<ResponseObj> getBookNameAndAuthor(){

        //From the repository class --> what will I get

        List<Book> bookList = bookRespository.findAll(); //Select * from book_table;


        //Convert this entity into responseObject
        List<ResponseObj> ansList = new ArrayList<>();
        for(Book book:bookList){

            ResponseObj obj = new ResponseObj();
            obj.author = book.getAuthor();
            obj.name = book.getName();

            ansList.add(obj);

        }
        return ansList;

    }

}
