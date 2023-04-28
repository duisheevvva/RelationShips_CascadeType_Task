package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "readers")
@Getter
@Setter
@NoArgsConstructor
public class Reader {
    @Id
    @GeneratedValue(generator = "reader_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "reader_gen",sequenceName = "reader_seq",allocationSize = 1)
    private String name;
    private int age;
    private String email;
    @OneToOne
    private Book book;

    public Reader(String name, int age, String email, Book book) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.book = book;
    }
}
