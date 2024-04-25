package com.luv2code.springbootlibrary.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name="checkout")
@Data

public class Checkout {
    public Checkout(){}

    public Checkout(String userEmail,String checkoutDate,String returnDate,Long bookId){
        this.userEmail=userEmail;
        this.checkoutDate=checkoutDate;
        this.returnDate=returnDate;
        this.bookId=bookId;
    }

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
   private Long id;
    @Column(name="user_email")
   private String userEmail;
    @Column(name="checkout_date")
   private  String checkoutDate;
    @Column(name="return_date")
   private  String returnDate;
    @Column(name="book_id")
    private Long bookId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
