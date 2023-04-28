package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.config.HibernateConfig;
import org.example.repository.PublisherRepository;
import org.example.entity.Publisher;

import java.util.List;

//    3) Publisher :
//
//   3.1) Publisher кошуу учун SavePublisher() деген метод тузуп, сакталган Publisher ди кайтаруу керек.
//
//   3.2) Издательстводо getPublisherById(), getAllPublishers()(аты боюнча сорттоп чыгаруу), updatePublisher(),
//   deletePublisherByName() (издательствону очургондо, ага тиешелуу китептер жана авторлор  очпошу керек), методдорун тузуп, ишке ашыруу.


public class PublisherRepositoryImpl implements PublisherRepository {
    private  final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public Publisher savePublisher(Publisher publisher) {
        entityManager.getTransaction().begin();
        entityManager.persist(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;

    }

    @Override
    public Publisher getPublisherById(Long id) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }



    @Override
    public List<Publisher> getAllPublishers(String ascOrDesc) {
        entityManager.getTransaction().begin();
        String orderBy = "ASC".equals(ascOrDesc) ? "name ASC" : "name DESC";
        String queryStr = "SELECT p FROM Publisher p ORDER BY " + orderBy;
        TypedQuery<Publisher> query = entityManager.createQuery(queryStr, Publisher.class);
        List<Publisher> publishers = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return publishers;
    }

    @Override
    public String updatePublisher(Long id, Publisher publisher) {
        entityManager.getTransaction().begin();
        Publisher publisher1 = entityManager.find(Publisher.class, id);
        publisher1.setName(publisher.getName());
        publisher1.setAddress(publisher.getAddress());
        entityManager.merge(publisher1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher.getName() + "is update";
    }

    @Override
    public void deletePublisherByName(String name) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class,name);
        entityManager.remove(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
