package org.example.service;

import org.example.entity.Author;
import org.example.entity.Book;

public interface BookService {

    String saveBook(Book book);
    Book updateBookAuthor(Long id, Author author);
    Book getBookAndPublisherByBookId(Long bookId);
    void deleteBookByAuthorId(Long id);
}
