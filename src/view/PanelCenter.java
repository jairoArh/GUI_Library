package view;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PanelCenter extends JPanel {
    private JTextField txtId;
    private JTextField txtTitle;

    private JComboBox<String> author;

    private JSpinner pages;

    private JDateChooser dateRelease;

    private MainWindow mainWindow;

    private String[][] authors;

    public PanelCenter(MainWindow mainWindow, String[][] authors) {
        this.mainWindow = mainWindow;
        this.authors = authors;
        setLayout( new GridLayout( 5, 2));
        initComponents();
        addComponents();
    }

    private void addComponents() {
        add( new JLabel("Id Libro ") );
        add( txtId );

        add( new JLabel( "Titulo" ) );
        add( txtTitle );

        add( new JLabel( "Autor" ) );
        add( author );

        add( new JLabel( "Paginas" ) );
        add( pages );

        add( new JLabel( "Lanzamiento") );
        add( dateRelease );
    }

    private void initComponents() {
        txtId = new JTextField();

        txtTitle = new JTextField();

        String[] names = new String[6];

        for( var i = 0 ; i < authors.length ; i++ ){
            names[i] = authors[i][0] + "|" + authors[i][1];
        }

        author = new JComboBox<>( names );

        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(50,10,2000,1);
        pages = new JSpinner( spinnerNumberModel );

        dateRelease = new JDateChooser( );
    }

    public String getId(){
        return txtId.getText();
    }

    public String getTitle(){
        return txtTitle.getText();
    }

    public String getPages(){
        return pages.getValue().toString();
    }

    public String getAuthor(){

        return author.getSelectedItem().toString();
    }

    public String getRelease(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String aux = sdf.format(dateRelease.getDate());

        return aux;
    }
}
