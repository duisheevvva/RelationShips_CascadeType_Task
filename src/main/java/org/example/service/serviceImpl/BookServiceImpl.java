package org.example.service.serviceImpl;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.example.repository.repositoryImpl.BookRepositoryImpl;
import org.example.service.BookService;

public class BookServiceImpl implements BookService {
    BookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public String saveBook(Book book) {
        return bookRepository.saveBook(book);
    }

    @Override
    public Book updateBookAuthor(Long id, Author author) {
        return bookRepository.updateBookAuthor(id,author);
    }

    @Override
    public Book getBookAndPublisherByBookId(Long bookId) {
        return bookRepository.getBookAndPublisherByBookId(bookId);
    }

    @Override
    public void deleteBookByAuthorId(Long id) {
        bookRepository.deleteBookByAuthorId(id);
    }
}
