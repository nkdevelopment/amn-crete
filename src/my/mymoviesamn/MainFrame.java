package my.mymoviesamn;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author amn
 */
public class MainFrame extends javax.swing.JFrame {

    private EntityManagerFactory emf; // Το EntityManagerFactory
    public static EntityManager em; // Ο EntityManager

    private JDesktopPane jdpDesktop;
    private static int openFrameCount = 0;
    private BufferedImage img;
//    private ImageIcon img;

//    public static String myIcon = "themoviesdb_logo.jpg";
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        connectToDb(); // Σύνδεση με την βάση δεδομένων

        try {
            // Η εικόμα του background
            img = ImageIO.read(getClass().getResource("/Images/filmtransparent.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        initComponents(); // Αρχικοποίηση του γραφικού περιβάλλοντος
        this.setLocationRelativeTo(null); // Παράθυρο εμφανίζεται στο κέντρο της οθόνης

        // ορίζονται τα χρώματα των Labels
        lblInfoLabel1.setBackground(new java.awt.Color(136, 23, 152));
        lblInfoLabel2.setBackground(new java.awt.Color(136, 23, 152));
        lblInfoLabel3.setBackground(new java.awt.Color(136, 23, 152));
        lblInfoLabel1.setForeground(java.awt.Color.white);
        lblInfoLabel2.setForeground(java.awt.Color.white);
        lblInfoLabel3.setForeground(java.awt.Color.white);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myMoviesAMNPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("myMoviesAMNPU").createEntityManager();
        movieQuery = java.beans.Beans.isDesignTime() ? null : myMoviesAMNPUEntityManager.createQuery("SELECT m FROM Movie m");
        movieList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(movieQuery.getResultList());
        dsktpMain = new javax.swing.JDesktopPane(){
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                grphcs.drawImage(img, 0, 0, null);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(img.getWidth(), img.getHeight());
            }
        };
        btnLoadDataBase = new javax.swing.JButton();
        btnMovieSearch = new javax.swing.JButton();
        btnFavorites = new javax.swing.JButton();
        btnstatistics = new javax.swing.JButton();
        btnExitApp = new javax.swing.JButton();
        pnlInfoPanel = new javax.swing.JPanel();
        lblInfoLabel1 = new javax.swing.JLabel();
        lblInfoLabel2 = new javax.swing.JLabel();
        lblInfoLabel3 = new javax.swing.JLabel();
        lblInfoLabel4 = new javax.swing.JLabel();
        lblInfoLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("myMovies");
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/Images/movies.png")));
        setResizable(false);

        btnLoadDataBase.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnLoadDataBase.setText("ΑΝΑΚΤΗΣΗ ΚΑΙ ΑΠΟΘΗΚΕΥΣΗ ΔΕΔΟΜΕΝΩΝ ΤΑΙΝΙΩΝ");
        btnLoadDataBase.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLoadDataBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDataBaseActionPerformed(evt);
            }
        });

        btnMovieSearch.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnMovieSearch.setText("ΑΝΑΖΗΤΗΣΗ ΤΑΙΝΙΩΝ");
        btnMovieSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovieSearchActionPerformed(evt);
            }
        });

        btnFavorites.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnFavorites.setText("ΔΙΑΧΕΙΡΙΣΗ ΛΙΣΤΩΝ ΑΓΑΠΗΜΕΝΩΝ ΤΑΙΝΙΩΝ");
        btnFavorites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFavoritesActionPerformed(evt);
            }
        });

        btnstatistics.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnstatistics.setText("ΣΤΑΤΙΣΤΙΚΑ");
        btnstatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstatisticsActionPerformed(evt);
            }
        });

        btnExitApp.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnExitApp.setForeground(java.awt.Color.red);
        btnExitApp.setText("ΕΞΟΔΟΣ");
        btnExitApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitAppActionPerformed(evt);
            }
        });

        dsktpMain.setLayer(btnLoadDataBase, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dsktpMain.setLayer(btnMovieSearch, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dsktpMain.setLayer(btnFavorites, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dsktpMain.setLayer(btnstatistics, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dsktpMain.setLayer(btnExitApp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dsktpMainLayout = new javax.swing.GroupLayout(dsktpMain);
        dsktpMain.setLayout(dsktpMainLayout);
        dsktpMainLayout.setHorizontalGroup(
            dsktpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dsktpMainLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(dsktpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dsktpMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExitApp, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dsktpMainLayout.createSequentialGroup()
                        .addGroup(dsktpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnFavorites, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoadDataBase))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(dsktpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMovieSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnstatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(81, 81, 81))
        );
        dsktpMainLayout.setVerticalGroup(
            dsktpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dsktpMainLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(dsktpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadDataBase, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMovieSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(dsktpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFavorites, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnstatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(btnExitApp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        lblInfoLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfoLabel1.setText("ΠΛΗ 24 - ΗΛΕ 1");
        lblInfoLabel1.setOpaque(true);

        lblInfoLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfoLabel2.setText("ΠΟΥΛΙΟΥ ΑΛΕΞΑΝΔΡΑ - ΜΑΚΑΡΩΝΑΣ ΕΜΜΑΝΟΥΗΛ - ΚΟΝΤΟΛΑΙΜΑΚΗΣ ΝΕΚΤΑΡΙΟΣ");
        lblInfoLabel2.setOpaque(true);

        lblInfoLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfoLabel3.setText("ΗΜ/ΝΙΑ");
        lblInfoLabel3.setOpaque(true);

        lblInfoLabel4.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        lblInfoLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfoLabel4.setText("This product uses the TMDb API but is not endorsed or certified by TMDb.");

        lblInfoLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfoLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/126x50-powered-by-rectangle.png"))); // NOI18N

        javax.swing.GroupLayout pnlInfoPanelLayout = new javax.swing.GroupLayout(pnlInfoPanel);
        pnlInfoPanel.setLayout(pnlInfoPanelLayout);
        pnlInfoPanelLayout.setHorizontalGroup(
            pnlInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlInfoPanelLayout.createSequentialGroup()
                        .addComponent(lblInfoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblInfoLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblInfoLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfoLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                    .addComponent(lblInfoLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlInfoPanelLayout.setVerticalGroup(
            pnlInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInfoLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInfoLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblInfoLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInfoLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInfoLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dsktpMain))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dsktpMain)
                .addGap(18, 18, 18)
                .addComponent(pnlInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMovieSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovieSearchActionPerformed
        // Πατώντας το κουμπί "Αναζήτηση ταινιών"
        movieSearchForm();
    }//GEN-LAST:event_btnMovieSearchActionPerformed

    private void btnLoadDataBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataBaseActionPerformed
        // Πατώντας το κουμπί "Ανάκτηση και αποθήκευση δεδομένων ταινιών"
        loadTables();
    }//GEN-LAST:event_btnLoadDataBaseActionPerformed

    private void btnExitAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitAppActionPerformed
        // Πατώντας το κουμπί "Έξοδος"
        String message = "Τερματισμός της εφαρμογής;";
        String title = "Μήνυμα επιβεβαίωσης";
        // Εμφάνιση μηνύματος επιβεβαίωσης τερματισμού της εφαρμογής
        int reply = JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            System.exit(0); // Τερματισμός εφαρμογής
        } else {
        }
    }//GEN-LAST:event_btnExitAppActionPerformed

    private void btnFavoritesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFavoritesActionPerformed
        // Πατώντας το κουμπί "Διαχείριση λιστών αγαπημένων
        favoritesForm();
    }//GEN-LAST:event_btnFavoritesActionPerformed

    private void btnstatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstatisticsActionPerformed
        // Πατώντας το κουμπί "Στατιστικά"
        statisticsForm();
    }//GEN-LAST:event_btnstatisticsActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExitApp;
    private javax.swing.JButton btnFavorites;
    private javax.swing.JButton btnLoadDataBase;
    private javax.swing.JButton btnMovieSearch;
    private javax.swing.JButton btnstatistics;
    private javax.swing.JDesktopPane dsktpMain;
    private javax.swing.JLabel lblInfoLabel1;
    private javax.swing.JLabel lblInfoLabel2;
    private javax.swing.JLabel lblInfoLabel3;
    private javax.swing.JLabel lblInfoLabel4;
    private javax.swing.JLabel lblInfoLabel5;
    private java.util.List<model.Movie> movieList;
    private javax.persistence.Query movieQuery;
    private javax.persistence.EntityManager myMoviesAMNPUEntityManager;
    private javax.swing.JPanel pnlInfoPanel;
    // End of variables declaration//GEN-END:variables

    private void connectToDb() {
        try {
            Persistence.generateSchema("myMoviesAMNPU", null);
            // Δημιουργία ενός EntityManagerFactory το οποίο συνδέεται στο
            // Persistence Unit που αντιστοιχεί στην Βάση Δεδομένων μας
            emf = Persistence.createEntityManagerFactory("myMoviesAMNPU");
            // Δημιουργία ενός EntityManager
            em = emf.createEntityManager();
        } catch (Exception ex) {
            System.out.println("Not connected to DB");
            System.exit(1);
        }
    }

    // Πατώντας το κουμπί "Διαχείριση λιστών αγαπημένων
    private void favoritesForm() {
        // Δημιουργία αντικειμένου JInternalFrame_Favorites
        JInternalFrame_Favorites fFavorites = new JInternalFrame_Favorites();

        // Τοποθέτηση της νέας φόρμας jDesktopPane1 στη μέση
        Dimension desktopSize = dsktpMain.getSize();
        Dimension jInternalFrameSize = fFavorites.getSize();
        fFavorites.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
        fFavorites.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        dsktpMain.add(fFavorites); // προσθήκη φόρμας
        fFavorites.setVisible(true); // κάνε ορατή τη φόρμα
    }

    // Πατώντας το κουμπί "Στατιστικά"
    private void statisticsForm() {
        // Δημιουργία αντικειμένου JInternalFrame_Statistics
        JInternalFrame_Statistics fStatistics = new JInternalFrame_Statistics();

        // Τοποθέτηση της νέας φόρμας jDesktopPane1 στη μέση
        Dimension desktopSize = dsktpMain.getSize();
        Dimension jInternalFrameSize = fStatistics.getSize();
        fStatistics.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
        fStatistics.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        dsktpMain.add(fStatistics); // προσθήκη φόρμας
        fStatistics.setVisible(true); // κάνε ορατή τη φόρμα

    }

    // Πατώντας το κουμπί "Αναζήτηση ταινιών"
    private void movieSearchForm() {
        // Δημιουργία αντικειμένου JInternalFrame_MovieSearch
        JInternalFrame_MovieSearch mSearch = new JInternalFrame_MovieSearch();

        // Τοποθέτηση της νέας φόρμας jDesktopPane1 στη μέση
        Dimension desktopSize = dsktpMain.getSize();
        Dimension jInternalFrameSize = mSearch.getSize();
        mSearch.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
        mSearch.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        dsktpMain.add(mSearch); // προσθήκη φόρμας
        mSearch.setVisible(true); // κάνε ορατή τη φόρμα
    }

    // Πατώντας το κουμπί "Ανάκτηση και αποθήκευση δεδομένων ταινιών"
    private void loadTables() {

        // Δημιουργία αντικειμένου DatabasesConnections
        DatabasesConnections m = new DatabasesConnections();
        m.clearDatabase(); // εκτέλεση μεθόδου clearDatabase της DatabasesConnections
        m.loadGenreTable(); // εκτέλεση μεθόδου loadGenreTable της DatabasesConnections

        // Αν ληφθούν οι ταινίες (m.getMovies) εκτέλεσε τα παρακάτω:
        if (m.getMovies(this)) {
            String message = "Τα δεδομένα κατέβηκαν και αποθηκεύτηκαν στη Βάση Δεδομένων";
            String title = "Μήνυμα ενημέρωσης";
            JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
