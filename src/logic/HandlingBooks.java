package logic;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HandlingBooks {
    private Author[] authors;

    private Book[] books;

    int position;

    public HandlingBooks() {
        authors = new Author[6];
        getAuthors();
        position = 0;
        books = new Book[10];
    }

    public Book findByIdBook(int id){
        for( int index = 0 ; index < position ; index++ ){
            if( books[index].getId() == id ){
                return books[index];
            }
        }

        return null;
    }

    public boolean addBook( Book book ){
        if( findByIdBook( book.getId()) == null  ){
            books[position++] = book;

            return true;
        }

        return false;
    }

    public Author findAuthor( int id ){
        for( Author author : authors ){
            if( author.getId() == id ){

                return author;
            }
        }

        return null;
    }

    private void getAuthors() {
        int cont = 0;
        try (FileReader file = new FileReader(new File("resources/files/auth.csv"))) {
            BufferedReader input = new BufferedReader( file );
            String line = null;

            while( (line = input.readLine()) !=  null ){
                StringTokenizer tokens = new StringTokenizer(line,";");
                while( tokens.hasMoreTokens()){
                    String aux = tokens.nextToken();
                    int id = Integer.parseInt( aux );
                    String name = tokens.nextToken();
                    String country = tokens.nextToken();
                    StringTokenizer date = new StringTokenizer(tokens.nextToken(),"/");
                    int day = Integer.parseInt( date.nextToken());
                    int month = Integer.parseInt( date.nextToken());
                    int year = Integer.parseInt( date.nextToken());
                    LocalDate birthday = LocalDate.of(year,month,day);

                    Author author = new Author(id,name,country,birthday);

                    authors[cont++] = author;
                }
            }
            System.out.println(Arrays.toString( authors));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
