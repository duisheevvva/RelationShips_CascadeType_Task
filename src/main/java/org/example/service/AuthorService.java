package org.example.service;

import org.example.entity.Author;

import java.util.List;

public interface AuthorService {
    String saveAuthor(Author author);
    Author updateAuthor(Long id ,Author author);
    List<Author> getAuthorsByPublisherId(Long publisherId);
    void deleteAuthorById(Long id);
    String assignAuthorToPublisher(Long authorId,Long publisherId);
}
