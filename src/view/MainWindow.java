package view;

import controller.ControllBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        if( controllBook.addBook( Integer.parseInt( id ),title,Short.parseShort(pages),release,author) ){
            JOptionPane.showMessageDialog( null, "Se agrego con exito");
            cleanFields();
        }else{
            JOptionPane.showMessageDialog( null, "ID ya Registrado");
        }

    }

    public void findByIdBook(){
        String id = panelCenter.getId();

        if( id.length() > 0 ){
            int numId = Integer.parseInt( id );

            String[ ] book = controllBook.findBookById( numId );

            if( book != null ){
                panelCenter.setTxtTitle( book[1] + "-" + book[4]);
                panelCenter.setPages( Integer.parseInt( book[2]));
            }else{
                JOptionPane.showMessageDialog(null,"El Libro no Existe");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Debe especificar el ID");
        }
    }

    public void cleanFields(){
        panelCenter.setId("");

        panelCenter.setTxtTitle("");

        panelCenter.setPages( 50 );

        System.out.println( LocalDate.now().toString());

        LocalDate dateNow = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");

        panelCenter.setDateRelease( formatter.format( dateNow).toString());

    }
}
