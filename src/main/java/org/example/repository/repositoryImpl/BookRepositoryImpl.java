package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.entity.Author;
import org.example.entity.Publisher;
import org.example.repository.BookRepository;
import org.example.entity.Book;

import java.util.List;
//    5) Book:

//    5.1) Book да saveBook()(Book сакталып жатканда кандайдыр бир авторго тиешелуу болуп сакталуусу керек), updateBookAuthor(),
//    getBookAndPublisherByBookId()(Бир Id ге тиешелуу book тун маалыматтары жана ага тиешелуу издательствосу чыксын), deleteBookByAuthorId();

public class BookRepositoryImpl implements BookRepository {
    private  final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String saveBook(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

    @Override
    public Book updateBookAuthor(Long id, Author author) {
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, id);
        book.setAuthor(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

    @Override
    public Book getBookAndPublisherByBookId(Long bookId) {
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, bookId);
        Publisher publisher = book.getPublisher();
        book.setPublisher(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return book;
    }
    @Override
    public void deleteBookByAuthorId(Long id) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, id);
        List<Book> books = author.getBooks();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            entityManager.remove(book);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
