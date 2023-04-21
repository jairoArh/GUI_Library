package view;

public class RunView {
    public static void main(String[] args) {
        MainWindow myWindow = new MainWindow("Ejemplo de GUI");
        myWindow.begin();
        myWindow.setVisible( true );
    }
}
