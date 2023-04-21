package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame  {
    private PanelTop panelTop;
    private PanelBottom panelBottom;
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
    }

    private void initComponents() {
        panelTop = new PanelTop("Agregar Libro");

        panelBottom = new PanelBottom( this );
    }

    public void add() {
        System.out.println(HandlingEvents.ADD);
    }
}
