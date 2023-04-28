package org.example.service.serviceImpl;

import org.example.entity.Author;
import org.example.repository.AuthorRepository;
import org.example.repository.repositoryImpl.AuthorRepositoryImpl;
import org.example.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

AuthorRepository authorRepository=new AuthorRepositoryImpl();
    @Override
    public String saveAuthor(Author author) {
        return authorRepository.saveAuthor(author);
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        return authorRepository.updateAuthor(id,author);
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long publisherId) {
        return authorRepository.getAuthorsByPublisherId(publisherId);
    }

    @Override
    public void deleteAuthorById(Long id) {
        authorRepository.deleteAuthorById(id);

    }

    @Override
    public String assignAuthorToPublisher(Long authorId, Long publisherId) {
        return authorRepository.assignAuthorToPublisher(authorId,publisherId);
    }
}
