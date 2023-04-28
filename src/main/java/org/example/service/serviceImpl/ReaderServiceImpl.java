package org.example.service.serviceImpl;

import org.example.entity.Reader;
import org.example.repository.ReaderRepository;
import org.example.repository.repositoryImpl.ReaderRepositoryImpl;
import org.example.service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    ReaderRepository readerRepository =new ReaderRepositoryImpl();

    @Override
    public String saveReader(Reader reader) {
        return readerRepository.saveReader(reader);
    }

    @Override
    public String updateReader(Long id, Reader reader) {
        return readerRepository.updateReader(id,reader);
    }

    @Override
    public Reader getReaderByBookId(Long bookId) {
        return readerRepository.getReaderByBookId(bookId);
    }

    @Override
    public void deleteReaderById(Long id) {
        readerRepository.deleteReaderById(id);
    }

    @Override
    public List<Reader> getReadersByAuthorId(Long authorId) {
        return readerRepository.getReadersByAuthorId(authorId);
    }
}
