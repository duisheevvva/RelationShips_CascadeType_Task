package org.example;

import org.example.config.HibernateConfig;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.entity.Reader;
import org.example.enums.Genre;
import org.example.repository.AuthorRepository;

import org.example.entity.Author;
import org.example.enums.Gender;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.example.service.PublisherService;
import org.example.service.ReaderService;
import org.example.service.serviceImpl.AuthorServiceImpl;
import org.example.service.serviceImpl.BookServiceImpl;
import org.example.service.serviceImpl.PublisherServiceImpl;
import org.example.service.serviceImpl.ReaderServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
//   1) Диаграмма боюнча бардык Entity класстарды тузуп, полелерин жазуу.
//
//   2) Тузулгон Entity класстардын байланыштарын(relationship) , Cascade Type тарын, Fetch Type тарын туура коюп жазуу.
//
//   3) Publisher :
//
//   3.1) Publisher кошуу учун SavePublisher() деген метод тузуп, сакталган Publisher ди кайтаруу керек.
//
//   3.2) Издательстводо getPublisherById(), getAllPublishers()(аты боюнча сорттоп чыгаруу), updatePublisher(),
//   deletePublisherByName() (издательствону очургондо, ага тиешелуу китептер жана авторлор  очпошу керек), методдорун тузуп, ишке ашыруу.
//
//    4) Author:
//
//   4.1) Автордо saveAuthor(), updateAuthor(), getAuthorById(), getAuthorsByPublisherId()(тиешелуу издательствонун авторлорун чыгарып беруу),
//   deleteAuthorById()(автор очкондо, авторго тиешелуу издательство очпошу керек, китептер очуш керек),
//   assignAuthorToPublisher()(авторду издательствого кошуп коюу(назначить)).

//    5) Book:

//    5.1) Book да saveBook()(Book сакталып жатканда кандайдыр бир авторго тиешелуу болуп сакталуусу керек), updateBookAuthor(),
//    getBookAndPublisherByBookId()(Бир Id ге тиешелуу book тун маалыматтары жана ага тиешелуу издательствосу чыксын), deleteBookByAuthorId();

//    6) Reader:
//    6.1) saveReader(), updateReader(), getReaderByBookId(), deleteReaderById(),getReadersByAuthorId();

//    7) Бардык маанилер консольго так жана ирети менен чыгуусу керек .

        HibernateConfig.getEntityManager();

        AuthorService authorService = new AuthorServiceImpl();
        BookService bookService = new BookServiceImpl();
        PublisherService publisherService = new PublisherServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();
        List<Book> books = new ArrayList<>();
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        Publisher publisher = new Publisher("Aizat", "Vostoc-5", books);
        Publisher publisher1 = new Publisher("Khafiz", "Grajdanskai-119", books1);
        Publisher publisher2 = new Publisher("Nurseyit", "Alamedin-1", books2);
        List<Publisher> publishers = new ArrayList<>(List.of(publisher));
        List<Publisher> publishers1 = new ArrayList<>(List.of(publisher1));
        List<Publisher> publishers2 = new ArrayList<>(List.of(publisher2));
        Author author = new Author("Kanykei", "Akjoltoi kyzy", "akjoltoikyzykanykei@gmail.com", LocalDate.of(2006, 3, 19), "America", Gender.FEMALE, publishers, books);
        Author author1 = new Author("Gulmira", "Osmonova", "gulmira@gmail.com", LocalDate.of(1987, 8, 3), "Kazakstan", Gender.FEMALE, publishers1, books2);
        Author author2 = new Author("Sanzhar", "Abdumomunov", "sanzhar@gmail.com", LocalDate.of(2003, 9, 15), "Kyrgyzstan", Gender.MALE, publishers2, books1);
        Book book = new Book("John Adams", "America", LocalDate.of(2002, 9, 3), 1225, Genre.History, publisher, author);
        Book book1 = new Book("1776", "America", LocalDate.of(2005, 5, 24), 1662, Genre.History, publisher, author);
        Book book2 = new Book("The Six Wives of Henry VIII", "America", LocalDate.of(1991, 1, 10), 1225, Genre.History, publisher, author);
        Book book3 = new Book("To Kill a Mockingbird", "Kyzgyzstan", LocalDate.of(2002, 1, 1), 787, Genre.Classics, publisher2, author2);
        Book book4 = new Book("Little Women", "Kyrgyzstan", LocalDate.of(2018, 9, 25), 1225, Genre.Classics, publisher2, author2);
        Book book5 = new Book("Beloved", "Kyrgyzstan", LocalDate.of(2004, 6, 8), 787, Genre.Classics, publisher2, author2);
        Book book6 = new Book("The Water Dancer", "Kazakstan", LocalDate.of(2019, 9, 24), 1312, Genre.Fantasy, publisher1, author1);
        Book book7 = new Book("CIRCE", "Kazakstan", LocalDate.of(2023, 4, 27), 1050, Genre.Fantasy, publisher1, author1);
        Book book8 = new Book("Ninth House", "Kazakstan", LocalDate.of(2019, 10, 8), 2187, Genre.Fantasy, publisher1, author1);
        books.add(book);
        books.add(book1);
        books.add(book2);
        books1.add(book3);
        books1.add(book4);
        books1.add(book5);
        books2.add(book6);
        books2.add(book7);
        books2.add(book8);
        Reader reader = new Reader("Madina", 16, "madina@gmail.com", book3);
        Reader reader1 = new Reader("Adilet", 22, "adilet@gmail.com", book);
        Reader reader2 = new Reader("Ainazik", 19, "ainazik@gmail.com", book6);
//Author methods
//1
        System.out.println(authorService.saveAuthor(author));
        System.out.println(authorService.saveAuthor(author1));
        System.out.println(authorService.saveAuthor(author2));
//2
        System.out.println(authorService.updateAuthor(2L, new Author("Torogeldi", "Niazbekov", "torogeldi@gmail.com",
                LocalDate.of(2006, 8, 12), "Rassia", Gender.MALE, publishers2, books)));
//3
        System.out.println(authorService.getAuthorsByPublisherId(1L));
//4
        System.out.println(authorService.getAuthorsByPublisherId(3L));
//5
        authorService.deleteAuthorById(2L);
//6
        authorService.assignAuthorToPublisher(3L, 3L);
//Book methods
//1
        System.out.println(bookService.saveBook(book));
        System.out.println(bookService.saveBook(book1));
        System.out.println(bookService.saveBook(book2));
        System.out.println(bookService.saveBook(book3));
        System.out.println(bookService.saveBook(book4));
        System.out.println(bookService.saveBook(book5));
        System.out.println(bookService.saveBook(book6));
        System.out.println(bookService.saveBook(book7));
        System.out.println(bookService.saveBook(book8));
//2
        bookService.updateBookAuthor(3L, new Author("Kanykei", "Akjoltoi kyzy", "akjoltoikyzykanykei@gmail.com", LocalDate.of(2006, 3, 19), "America", Gender.FEMALE, publishers, books));

//3
        System.out.println(bookService.getBookAndPublisherByBookId(1L));
//4
        bookService.deleteBookByAuthorId(1L);
//Publisher methods
//1
        System.out.println(publisherService.savePublisher(publisher));
        System.out.println(publisherService.savePublisher(publisher1));
        System.out.println(publisherService.savePublisher(publisher2));
//2
        System.out.println(publisherService.getPublisherById(2L));
//3
        System.out.println(publisherService.getAllPublishers("asc"));
//4
        System.out.println(publisherService.updatePublisher(3L, new Publisher("Gulira", "Panfilova-153", books)));
//5
        publisherService.deletePublisherByName("Khafiz");
//Reader methods
//1
        System.out.println(readerService.saveReader(reader));
        System.out.println(readerService.saveReader(reader1));
        System.out.println(readerService.saveReader(reader2));
//2
        System.out.println(readerService.updateReader(2L, new Reader("Abdumalik", 19, "malik@gmail.com", book8)));
//3
        System.out.println(readerService.getReaderByBookId(1L));
//4
        readerService.deleteReaderById(2L);
//5
        System.out.println(readerService.getReadersByAuthorId(1L));
    }
}