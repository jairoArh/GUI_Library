package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlingEvents implements ActionListener {
    public final static String ADD = "Agegar";
    public final static String CLEAN = "Limpiar";

    public final static String FIND_BOOK_BY_ID = "Buscar por Id";

    private MainWindow mainWindow;

    public HandlingEvents(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch ( e.getActionCommand()){
            case ADD : mainWindow.add();
            break;

            case FIND_BOOK_BY_ID: mainWindow.findByIdBook();
            break;

            case CLEAN: mainWindow.cleanFields();
            break;
        }
    }
}
