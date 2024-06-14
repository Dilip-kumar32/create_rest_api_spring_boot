package com.api.book.bootrestbook.services;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.Dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // get all books details
    public List<Book> getAllBooks(){
         List<Book> list=(List<Book>)this.bookRepository.findAll();
         return list;
    
    }

    //get single book details
    public Book getBookById(int id){
        Book book=null;
        try{

           book=this.bookRepository.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }

    //adding new book
    public Book saveBook(Book book){
        // list.add(book);
        Book result=this.bookRepository.save(book);
        return result;
    }

    //deleting new book
    public void deleteBook(int id){

        this.bookRepository.deleteById(id);
    }

    //update the book
    public void updateBook(Book book,int id){

         book.setId(id);
         this.bookRepository.save(book);


    }
    
}
