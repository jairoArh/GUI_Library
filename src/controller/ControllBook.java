package controller;

import logic.Author;
import logic.Book;
import logic.HandlingBooks;

import java.time.LocalDate;
import java.util.Arrays;

public class ControllBook {
    private HandlingBooks handlingBooks;


    public ControllBook() {
        handlingBooks = new HandlingBooks();
    }

    public boolean addBook(int id, String title, short pages, String dateRelease, String idAuthor) {
        Author author = handlingBooks.findAuthor(Integer.parseInt(idAuthor));
        if (author != null) {
            String[] date = dateRelease.split("[/-]");
            int day = Integer.parseInt(date[2]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[0]);
            LocalDate dateBook = LocalDate.of(year, month, day);

            Book book = new Book(id, title, author, (short) pages, dateBook);

            return handlingBooks.addBook(book);
        }

        return false;
    }

    public String[] findBookById(int id) {
        Book book = handlingBooks.findByIdBook(id);
        if (book != null) {
            String idAux = Integer.toString(book.getId());
            String title = book.getTitle();
            String pages = Short.toString(book.getPages());
            String dateRelease = book.getDateRelease().toString();
            String author = book.getAuthor().getName();
            String[] out = new String[]{idAux, title, pages, dateRelease, author};

            return out;
        }

        return null;
    }

    public String[][] getAuthors() {
        Author[] authors = handlingBooks.getAuthors();

        String[][] out = new String[6][4];

        for (int i = 0; i < out.length; i++) {
            out[i][0] = Integer.toString(authors[i].getId());
            out[i][1] = authors[i].getName();
            out[i][2] = authors[i].getCountry();
            out[i][3] = authors[i].getBirthday().toString();
        }

        return out;
    }
}
