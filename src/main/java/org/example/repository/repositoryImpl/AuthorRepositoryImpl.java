package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.config.HibernateConfig;
import org.example.entity.Publisher;
import org.example.repository.AuthorRepository;
import org.example.entity.Author;

import java.util.List;

//     4) Author:
//
//   4.1) Автордо saveAuthor(), updateAuthor(), getAuthorById(), getAuthorsByPublisherId()(тиешелуу издательствонун авторлорун чыгарып беруу),
//   deleteAuthorById()(автор очкондо, авторго тиешелуу издательство очпошу керек, китептер очуш керек),
//   assignAuthorToPublisher()(авторду издательствого кошуп коюу(назначить)).

public class AuthorRepositoryImpl implements AuthorRepository {
    private  final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String saveAuthor(Author author) {
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author.getFirstName() + "is saved";
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        entityManager.getTransaction().begin();
        Author author1 = entityManager.find(Author.class, id);
        author1.setFirstName(author.getFirstName());
        author1.setLastName(author.getLastName());
        author1.setEmail(author.getEmail());
        author1.setDateOfBirth(author.getDateOfBirth());
        author1.setCountry(author.getCountry());
        author1.setGender(author.getGender());
        entityManager.merge(author1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author;
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long publisherId) {
        Query query = entityManager.createQuery(
                "select a from Author a join a.publishers p where p.id = :publisherId");
        query.setParameter("publisherId", publisherId);
        List<Author> authors = query.getResultList();
        return authors;
    }

    @Override
    public void deleteAuthorById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Author.class,id));
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("author with id:" + id + "deleted");
    }

    @Override
    public String assignAuthorToPublisher(Long authorId, Long publisherId) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class, publisherId);
        Author author = entityManager.find(Author.class, authorId);
        publisher.getAuthors().add(author);
        author.getPublishers().add(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

}
