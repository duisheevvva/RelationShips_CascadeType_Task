package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Genre;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(generator = "books_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "books_gen",sequenceName = "books_seq",
                      allocationSize = 1)
    private String name;
    private String country;
    @Column(name = "published_year")
    private LocalDate publishedYear;
    private int price;
    private Genre genre;

    @ManyToOne
    private Publisher publisher;
    @ManyToOne
    private Author author;

    public Book(String name, String country, LocalDate publishedYear, int price, Genre genre, Publisher publisher, Author author) {
        this.name = name;
        this.country = country;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
        this.publisher = publisher;
        this.author = author;
    }
}
