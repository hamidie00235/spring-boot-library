package com.luv2code.springbootlibrary.entity;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="review")
@Data
public class Review {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_email")
    private String userEmail;
    @Column(name="date")
    @CreationTimestamp
    private Date date;
    @Column(name="rating")
    private double rating;
    @Column(name="book_id")
    private long bookId;
    @Column(name="review_description")
    private String reviewDescription;


    }

