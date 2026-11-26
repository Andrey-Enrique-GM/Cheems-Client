
package mx.itson.cheems.views;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import mx.itson.cheems.entities.Comic;
import mx.itson.cheems.entities.Result;

// @author Andrey

public class LibraryForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LibraryForm.class.getName());
    
    // Comic a modificar (null si se esta creando uno nuevo)
    private Comic comicToModify = null;
    // Referencia a LibraryView para refrescar la tabla al terminar de modificar
    private LibraryView parentView = null;
    
    // Categoria actual
    private String currentCategory = "Comic"; // Por defecto Comic
    
    // Rutas de los banners personalizados
    private static final String BANNER_COMIC = "C:\\Users\\Propietario\\Documents\\ELEMENTOS\\banners\\kangel welcome.gif";
    private static final String BANNER_NOVEL = "C:\\Users\\Propietario\\Documents\\ELEMENTOS\\banners\\ame welcome.gif";
    private static final String BANNER_MANGA = "C:\\Users\\Propietario\\Documents\\ELEMENTOS\\banners\\lacey welcome.gif";
    
    
    
    // Constructor normal para CREAR
    public LibraryForm() {
        initComponents();
        setLocationRelativeTo(null); // Centrar pantalla
        setCategory("Comic"); // Inicializa textos y banner por defecto

        btnComic.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setCategory("Comic");
            }
        });

        btnNovel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setCategory("Novel");
            }
        });

        btnManga.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setCategory("Manga");
            }
        });
    }
    
    
    // Constructor para MODIFICAR
    public LibraryForm(Comic comic, LibraryView parentView) {
        setLocationRelativeTo(this);
        initComponents();
        
        setTitle("Cheems Client - Modify Comic");
        setLocationRelativeTo(null); // Centrar pantalla
        
        this.comicToModify = comic;
        this.parentView = parentView;
        lblAction.setText("Modify Comic");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // Precarga de datos en los campos de texto
        txtTitle.setText(comic.getTitle());
        txtDescription.setText(comic.getDescription());
        txtEditorial.setText(comic.getEditorial());

        // Al cerrarse esta ventana (con OK o con la X), refresca y vuelve a mostrar LibraryView y el formulario principal
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (parentView != null) {
                    if (parentView.getOwner() != null) {
                        parentView.getOwner().setVisible(true);
                    }
                    parentView.loadComics();
                    parentView.setVisible(true);
                }
            }
        });
    }
    
    
    
    private void setCategory(String category) {
        this.currentCategory = category;
        String actionPrefix = (comicToModify != null) ? "Modify " : "Create ";

        lblAction.setText(actionPrefix + category);
        setTitle("Cheems Client - " + actionPrefix + category);

        switch (category) {
            case "Novel" -> {
                lblBanner.setIcon(new javax.swing.ImageIcon(BANNER_NOVEL));
                applyTheme(
                    new java.awt.Color(180, 40, 120),   // Títulos y OK (Púrpura/Vino)
                    new java.awt.Color(230, 204, 255),  // Fondo inputs y LIBRARY (Lavanda)
                    new java.awt.Color(75, 0, 130)      // Bordes y texto LIBRARY (Índigo oscuro)
                );
            }
            case "Manga" -> {
                lblBanner.setIcon(new javax.swing.ImageIcon(BANNER_MANGA));
                applyTheme(
                    new java.awt.Color(255, 80, 170),   // Títulos y OK (Rosa chicle/fucsia)
                    new java.awt.Color(175, 238, 238),  // Fondo inputs y LIBRARY (Verde menta/Aqua)
                    new java.awt.Color(0, 128, 145)     // Bordes y texto LIBRARY (Cerceta/Teal oscuro)
                );
            }
            default -> { // Comic (KAngel)
                lblBanner.setIcon(new javax.swing.ImageIcon(BANNER_COMIC));
                applyTheme(
                    new java.awt.Color(255, 0, 255),    // Títulos y OK (Magenta)
                    new java.awt.Color(153, 255, 255),  // Fondo inputs y LIBRARY (Cian)
                    new java.awt.Color(51, 102, 255)    // Bordes y texto LIBRARY (Azul)
                );
            }
        }
    }

    
    
    private void applyTheme(java.awt.Color primary, java.awt.Color secondary, java.awt.Color borderAndText) {
        // Titulos y boton OK
        lblAction.setForeground(primary);
        jLabel1.setForeground(primary);
        jLabel2.setForeground(primary);
        jLabel4.setForeground(primary);
        btnOk.setBackground(primary);

        // Fondos y boton LIBRARY
        txtTitle.setBackground(secondary);
        txtDescription.setBackground(secondary);
        txtEditorial.setBackground(secondary);
        btnLibrary.setBackground(secondary);

        // Texto de inputs y boton LIBRARY
        txtTitle.setForeground(borderAndText);
        txtDescription.setForeground(borderAndText);
        txtEditorial.setForeground(borderAndText);
        btnLibrary.setForeground(borderAndText);

        // Bordes BevelBorder
        javax.swing.border.Border customBorder = javax.swing.BorderFactory.createBevelBorder(
            javax.swing.border.BevelBorder.RAISED,
            borderAndText, borderAndText, borderAndText, borderAndText
        );

        txtTitle.setBorder(customBorder);
        txtDescription.setBorder(customBorder);
        txtEditorial.setBorder(customBorder);
        btnLibrary.setBorder(customBorder);
        btnOk.setBorder(customBorder);
    }
    
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        lblBanner = new javax.swing.JLabel();
        txtEditorial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnLibrary = new javax.swing.JButton();
        lblAction = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnComic = new javax.swing.JMenu();
        btnNovel = new javax.swing.JMenu();
        btnManga = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtTitle.setBackground(new java.awt.Color(153, 255, 255));
        txtTitle.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(0, 51, 255));
        txtTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));

        txtDescription.setBackground(new java.awt.Color(153, 255, 255));
        txtDescription.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(0, 51, 255));
        txtDescription.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 255));
        jLabel1.setText("Title:");

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 255));
        jLabel2.setText("Description:");

        btnOk.setBackground(new java.awt.Color(255, 0, 255));
        btnOk.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        btnOk.setForeground(new java.awt.Color(255, 255, 255));
        btnOk.setText("OK");
        btnOk.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        lblBanner.setIcon(new javax.swing.ImageIcon("C:\\Users\\Propietario\\Documents\\ELEMENTOS\\banners\\kangel welcome.gif")); // NOI18N

        txtEditorial.setBackground(new java.awt.Color(153, 255, 255));
        txtEditorial.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        txtEditorial.setForeground(new java.awt.Color(0, 51, 255));
        txtEditorial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 255));
        jLabel4.setText("Editorial:");

        btnLibrary.setBackground(new java.awt.Color(153, 255, 255));
        btnLibrary.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        btnLibrary.setForeground(new java.awt.Color(51, 102, 255));
        btnLibrary.setText("LIBRARY");
        btnLibrary.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        btnLibrary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibraryActionPerformed(evt);
            }
        });

        lblAction.setFont(new java.awt.Font("OCR A Extended", 3, 36)); // NOI18N
        lblAction.setForeground(new java.awt.Color(255, 0, 255));
        lblAction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAction.setText("New Comic");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBanner, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescription)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLibrary)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEditorial)
                            .addComponent(txtTitle)
                            .addComponent(lblAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBanner)
                .addGap(18, 18, 18)
                .addComponent(lblAction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLibrary)
                    .addComponent(btnOk))
                .addGap(21, 21, 21))
        );

        btnComic.setBackground(new java.awt.Color(255, 0, 255));
        btnComic.setText("Comic");
        btnComic.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jMenuBar1.add(btnComic);

        btnNovel.setBackground(new java.awt.Color(255, 0, 255));
        btnNovel.setText("Novel");
        btnNovel.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jMenuBar1.add(btnNovel);

        btnManga.setBackground(new java.awt.Color(255, 0, 255));
        btnManga.setText("Manga");
        btnManga.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jMenuBar1.add(btnManga);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    // Evento del boton OK cuando se le da clic
    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

        try {
            // Lectura de campos de texto
            String title = txtTitle.getText();
            String description = txtDescription.getText();
            String editorial = txtEditorial.getText();

            // Creacion y asignacion de la entidad
            Comic comic = new Comic();
            boolean isModifyMode = (comicToModify != null);

            if (isModifyMode) {
                comic.setId(comicToModify.getId());
            } else {
                comic.setId(0);
            }

            comic.setTitle(title);
            comic.setDescription(description);
            comic.setEditorial(editorial);

            // Conversion a JSON usando GSON
            Gson gson = new Gson();
            String json = gson.toJson(comic);

            // Creacion de la solicitud HTTP (POST para crear, PUT para modificar)
            HttpRequest request;
            if (isModifyMode) {
                request = HttpRequest
                        .newBuilder()
                        .uri(URI.create("http://127.0.0.1:8000/comic/" + comic.getId()))
                        .header("Content-Type", "application/json")
                        .PUT(HttpRequest.BodyPublishers.ofString(json))
                        .build();
            } else {
                request = HttpRequest
                        .newBuilder()
                        .uri(URI.create("http://127.0.0.1:8000/comic"))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(json))
                        .build();
            }

            // Creacion del cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Envio y respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Respuesta: " + response.body());
            System.out.println("Codigo de estado: " + response.statusCode());

            if (response.statusCode() == 201 || response.statusCode() == 200) {
                Comic savedComic = gson.fromJson(response.body(), Comic.class);
                String successMsg = isModifyMode
                        ? "Comic '" + savedComic.getTitle() + "' modificado correctamente."
                        : "Comic '" + savedComic.getTitle() + "' registrado con ID: " + savedComic.getId();

                javax.swing.JOptionPane.showMessageDialog(this, successMsg, "Exito", javax.swing.JOptionPane.INFORMATION_MESSAGE);

                if (isModifyMode) {
                    // Cierra el formulario tras modificar para volver a la tabla
                    this.dispose();
                } else {
                    // Limpia los campos tras crear un nuevo registro
                    txtTitle.setText("");
                    txtDescription.setText("");
                    txtEditorial.setText("");
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error en el servidor. Codigo: " + response.statusCode(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException ex) {
            System.err.println("Error de conexion o red: " + ex.getMessage());
            javax.swing.JOptionPane.showMessageDialog(this, "Error de conexion: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            System.err.println("La operacion fue interrumpida: " + ex.getMessage());
            Thread.currentThread().interrupt();
        }

    }//GEN-LAST:event_btnOkActionPerformed

    
    
    // Evento del boton LIBRARY cuando se le da clic
    private void btnLibraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibraryActionPerformed
        
        LibraryView library = new LibraryView(this, true);
        library.setLocationRelativeTo(this);
        library.setVisible(true);
        
    }//GEN-LAST:event_btnLibraryActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new LibraryForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnComic;
    private javax.swing.JButton btnLibrary;
    private javax.swing.JMenu btnManga;
    private javax.swing.JMenu btnNovel;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAction;
    private javax.swing.JLabel lblBanner;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
