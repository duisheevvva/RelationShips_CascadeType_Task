package org.example.repository;

import org.example.entity.Publisher;

import java.util.List;

public interface PublisherRepository {
//    3) Publisher :
//
//   3.1) Publisher кошуу учун SavePublisher() деген метод тузуп, сакталган Publisher ди кайтаруу керек.
//
//   3.2) Издательстводо getPublisherById(), getAllPublishers()(аты боюнча сорттоп чыгаруу), updatePublisher(),
//   deletePublisherByName() (издательствону очургондо, ага тиешелуу китептер жана авторлор  очпошу керек), методдорун тузуп, ишке ашыруу.

    Publisher savePublisher(Publisher publisher);

    Publisher getPublisherById(Long id);
    List<Publisher> getAllPublishers(String ascOrDesc);

    String updatePublisher(Long id,Publisher publisher);
    void deletePublisherByName(String name);
}
