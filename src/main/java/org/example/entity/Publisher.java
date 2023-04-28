package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "publishers")
@Getter
@Setter
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(generator = "publisher_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "publisher_gen", sequenceName = "publisher_seq",
                       allocationSize = 1)
    private Long id;
    private String name;
    private String address;
//    1 relation (Publisher-Book)Target class
    @OneToMany(cascade = {CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE},mappedBy = "publisher")
    private List<Book>books;
//    2 relation
    @ManyToMany
    private List<Author>authors;
    public Publisher(String name, String address, List<Book> books) {
        this.name = name;
        this.address = address;
        this.books = books;
}
}
