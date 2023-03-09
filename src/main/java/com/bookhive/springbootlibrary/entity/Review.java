package com.bookhive.springbootlibrary.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "review")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "date")
    @CreationTimestamp
    private LocalDateTime date;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "book_id")
    private Long BookId;

    @Column(name = "review_description")
    private String reviewDescription;
}