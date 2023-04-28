package org.example.service.serviceImpl;

import org.example.entity.Publisher;
import org.example.repository.PublisherRepository;
import org.example.repository.repositoryImpl.PublisherRepositoryImpl;
import org.example.service.PublisherService;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {
    PublisherRepository publisherRepository = new PublisherRepositoryImpl();
    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.savePublisher(publisher);
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepository.getPublisherById(id);
    }

    @Override
    public List<Publisher> getAllPublishers(String ascOrDesc) {
        return publisherRepository.getAllPublishers("asc");
    }

    @Override
    public String updatePublisher(Long id, Publisher publisher) {
        return publisherRepository.updatePublisher(id,publisher);
    }

    @Override
    public void deletePublisherByName(String name) {
        publisherRepository.deletePublisherByName(name);
    }
}
