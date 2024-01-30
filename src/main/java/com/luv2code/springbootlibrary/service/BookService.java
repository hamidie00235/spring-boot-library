package com.luv2code.springbootlibrary.service;

import com.luv2code.springbootlibrary.dao.BookRepository;
import com.luv2code.springbootlibrary.dao.CheckoutRepository;
import com.luv2code.springbootlibrary.entity.Book;
import com.luv2code.springbootlibrary.entity.Checkout;
import jakarta.persistence.Table;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Table
@Transactional
public class BookService {
    private BookRepository bookRepository;
    private CheckoutRepository checkoutRepository;
    public BookService(BookRepository bookRepository,CheckoutRepository checkoutRepository){
        this.bookRepository=bookRepository;
        this.checkoutRepository=checkoutRepository;
    }
    public Book checkoutBook(String userEmail, Long bookId) throws Exception {
        Optional<Book> book=bookRepository.findById(bookId);
        Checkout validateCheckout =checkoutRepository.findByUserEmailAndBookId(userEmail, bookId);
        if(!book.isPresent() || validateCheckout !=null || book.get().getCopiesAvailable()<=0 ){
            throw new Exception("Book doesn't exist or already checked out by user");
        }
        book.get().setCopiesAvailable(book.get().getCopiesAvailable()-1);
        bookRepository.save(book.get());
        Checkout checkout=new Checkout(
                userEmail,
                LocalDate.now().toString(),
                LocalDate.now().plusDays(7).toString(),
                book.get().getId()
        );
        checkoutRepository.save(checkout);
return book.get();
    }




}
