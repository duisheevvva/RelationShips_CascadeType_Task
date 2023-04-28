package org.example.repository;

import org.example.entity.Author;
import org.example.entity.Book;

import java.util.List;

public interface BookRepository {
//    5) Book:

//    5.1) Book да saveBook()(Book сакталып жатканда кандайдыр бир авторго тиешелуу болуп сакталуусу керек), updateBookAuthor(),
//    getBookAndPublisherByBookId()(Бир Id ге тиешелуу book тун маалыматтары жана ага тиешелуу издательствосу чыксын), deleteBookByAuthorId();

    String saveBook(Book book);
    Book updateBookAuthor(Long id, Author author);
    Book getBookAndPublisherByBookId(Long bookId);
    void deleteBookByAuthorId(Long id);
}
