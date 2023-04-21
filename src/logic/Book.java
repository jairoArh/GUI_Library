package logic;

import java.time.LocalDate;

public class Book {
    private int id;
    private String title;

    private Author author;

    private short pages;

    private LocalDate dateRelease;

    public Book(int id, String title, Author author, short pages, LocalDate dateRelease) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.dateRelease = dateRelease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public short getPages() {
        return pages;
    }

    public void setPages(short pages) {
        this.pages = pages;
    }

    public LocalDate getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(LocalDate dateRelease) {
        this.dateRelease = dateRelease;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", pages=" + pages +
                ", dateRelease=" + dateRelease +
                '}';
    }
}
