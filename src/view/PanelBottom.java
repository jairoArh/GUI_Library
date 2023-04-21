package view;

import logic.HandlingBooks;

import javax.swing.*;
import java.awt.*;

public class PanelBottom extends JPanel {
    private JButton save;
    private JButton clean;

    private MainWindow mainWindow;

    public PanelBottom(MainWindow mainWindow) {
         this.mainWindow = mainWindow;

         setLayout( new GridLayout(1,2));

         save = new JButton("Agregar");
         save.setActionCommand(HandlingEvents.ADD);
         save.addActionListener( new HandlingEvents( mainWindow ) );

         clean = new JButton("Limpiar");
         clean.setActionCommand( HandlingEvents.CLEAN );
         clean.addActionListener( new HandlingEvents( mainWindow ) );

         add( save );
         add(clean);
    }
}
