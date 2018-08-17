package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.*;

@Service
public class MemoryBookService implements BookService {
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public Book getById(long id) {
        return this.list.stream().filter(book -> book.getId() == id).findFirst().get();
    }

    public void addBook(Book book) {
        Book lastBook = Collections.max(this.list, Comparator.comparing(Book::getId));
        book.setId(lastBook.getId() + 1);

        this.list.add(book);
    }

    @Override
    public void updateBook(long id, Book book) {
        Book bookToUpdate = getList().stream().filter(b -> b.getId() == id).findFirst().get();

        bookToUpdate.setIsbn(book.getIsbn());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setPublisher(book.getPublisher());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setType(book.getType());
    }

    public void deleteBook(Book book) {
        this.list.remove(book);
    }
}