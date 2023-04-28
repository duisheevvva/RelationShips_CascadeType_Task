package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.config.HibernateConfig;
import org.example.entity.Author;
import org.example.repository.ReaderRepository;
import org.example.entity.Reader;

import java.util.List;

//    6) Reader:
//    6.1) saveReader(), updateReader(), getReaderByBookId(), deleteReaderById(),getReadersByAuthorId();

public class ReaderRepositoryImpl implements ReaderRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public String saveReader(Reader reader) {
        entityManager.getTransaction().begin();
        entityManager.persist(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
        return reader.getName() + "is saved";
    }

    @Override
    public String updateReader(Long id, Reader reader) {
        entityManager.getTransaction().begin();
        Reader reader1 = entityManager.find(Reader.class, id);
        reader1.setName(reader.getName());
        reader1.setEmail(reader.getEmail());
        reader1.setAge(reader.getAge());
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

    @Override
    public Reader getReaderByBookId(Long bookId) {
        entityManager.getTransaction().begin();
        Reader reader = entityManager.find(Reader.class, bookId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return reader;
    }

    @Override
    public void deleteReaderById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Reader.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Reader> getReadersByAuthorId(Long authorId) {
        Query query = entityManager.createQuery(
                "select r from Reader r join r.authors at where at.id = :authorId");
        query.setParameter("authorId", authorId);
        List<Reader> readers = query.getResultList();
        return readers;
    }
}

