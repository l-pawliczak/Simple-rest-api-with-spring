package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.List;

@Service
public interface BookService {
    public List<Book> getList();

    public void addBook(Book book);

    public Book getById(long id);

    public void updateBook(long id, Book book);

    public void deleteBook(Book book);
}
