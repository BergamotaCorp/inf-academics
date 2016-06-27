package co.bergamota.business.objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "PUBLIC",name = "book")
public class Book{

    @Id
    private long id;
    private String book;
    private String autor;
    private String country;
    private String state;

    protected Book(){}

    public Book(String book, String autor, String country, String state) {
        this.book = book;
        this.autor = autor;
        this.country = country;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public String getBook() {
        return book;
    }

    public String getAutor() {
        return autor;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[id=%d, book='%s', autor='%s', country='%s', state='%s']",
                id, book, autor, country, state);
    }
}
