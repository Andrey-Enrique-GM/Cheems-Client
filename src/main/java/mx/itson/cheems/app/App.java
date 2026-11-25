
package mx.itson.cheems.app;

// @author Andrey

import mx.itson.cheems.views.ComicForm;


public class App 
{
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ComicForm form = new ComicForm();
                form.setVisible(true);
                form.setLocationRelativeTo(null); // Centra la ventana en la pantalla
            }
        });
    }
    
}
