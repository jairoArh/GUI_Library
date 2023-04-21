package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlingEvents implements ActionListener {
    public final static String ADD = "Agegar";
    public final static String CLEAN = "Limpiar";

    private MainWindow mainWindow;

    public HandlingEvents(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch ( e.getActionCommand()){
            case ADD : mainWindow.add();
        }
    }
}
