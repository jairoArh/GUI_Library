package view;

import javax.swing.*;
import java.awt.*;

public class PanelTop extends JPanel {
    private JLabel title;

    public PanelTop(String title) {
        this.title = new JLabel( title );

        setLayout( new FlowLayout());
        add( this.title);
    }
}
