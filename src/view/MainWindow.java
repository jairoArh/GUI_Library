package view;

import controller.ControllBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainWindow extends JFrame  {
    private PanelTop panelTop;
    private PanelBottom panelBottom;

    private String[][] authors;

    private ControllBook controllBook;

    private PanelCenter panelCenter;
    public MainWindow( String title )  {
        super( title );
        setSize( 640, 480 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setResizable( false );
        setLayout( new BorderLayout( ));
    }
    
    public void begin(){
        initComponents();
        addComponents();
    }

    private void addComponents() {
        add( panelTop, BorderLayout.NORTH);
        add( panelBottom, BorderLayout.SOUTH);
        add( panelCenter, BorderLayout.CENTER );
    }

    private void initComponents() {
        controllBook = new ControllBook();

        authors = controllBook.getAuthors();

        panelTop = new PanelTop("Agregar Libro");

        panelBottom = new PanelBottom( this );

        panelCenter = new PanelCenter( this, authors );
    }

    public void add() {
        String id = panelCenter.getId();

        String title = panelCenter.getTitle();

        StringTokenizer token = new StringTokenizer( panelCenter.getAuthor(),"|");

        String author = token.nextToken();

        String pages = panelCenter.getPages();

        String release = panelCenter.getRelease();

        System.out.println( controllBook.addBook( Integer.parseInt( id),title,Short.parseShort(pages),release,author));

    }
}
