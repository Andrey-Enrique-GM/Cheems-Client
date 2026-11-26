
package mx.itson.cheems.app;

// @author Andrey

import mx.itson.cheems.views.LibraryForm;


public class App 
{
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LibraryForm form = new LibraryForm();
                form.setVisible(true);
                form.setLocationRelativeTo(null); // Centra la ventana en la pantalla
            }
        });
    }
    
}
