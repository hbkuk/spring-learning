package cholog;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "publisher")
    //@OneToMany(fetch = FetchType.EAGER)
    private Set<Book> book;

    public Publisher(String name) {
        this.name = name;
        this.book = new HashSet<>();
    }

    public Publisher() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        this.book.add(book);
    }

    public Set<Book> getBooks() {
        return this.book;
    }
}
