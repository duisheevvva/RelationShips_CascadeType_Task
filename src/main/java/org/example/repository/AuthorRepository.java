package org.example.repository;

import org.example.entity.Author;

import java.util.List;

public interface AuthorRepository {
//     4) Author:
//
//   4.1) Автордо saveAuthor(), updateAuthor(), getAuthorById(), getAuthorsByPublisherId()(тиешелуу издательствонун авторлорун чыгарып беруу),
//   deleteAuthorById()(автор очкондо, авторго тиешелуу издательство очпошу керек, китептер очуш керек),
//   assignAuthorToPublisher()(авторду издательствого кошуп коюу(назначить)).

    String saveAuthor(Author author);
    Author updateAuthor(Long id ,Author author);
    List<Author> getAuthorsByPublisherId(Long publisherId);
    void deleteAuthorById(Long id);
    String assignAuthorToPublisher(Long authorId,Long publisherId);

}
