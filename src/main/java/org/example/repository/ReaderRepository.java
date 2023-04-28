package org.example.repository;

import org.example.entity.Reader;


import java.util.List;

public interface ReaderRepository {
//    6) Reader:
//    6.1) saveReader(), updateReader(), getReaderByBookId(), deleteReaderById(),getReadersByAuthorId();

    String saveReader(Reader reader);
    String updateReader(Long id,Reader reader);
    Reader getReaderByBookId(Long bookId);
    void deleteReaderById(Long id);
    List<Reader> getReadersByAuthorId(Long authorId);
}
