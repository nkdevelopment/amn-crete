/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.mymoviesamn;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import model.FavoriteList;
import model.Movie;

/**
 *
 * @author amn
 */
public class JInternalFrame_Statistics extends javax.swing.JInternalFrame {
//Δημιουργία Entity Manager Factory & Entity Manager (Διαχειριστή Οντοτήτων)

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myMoviesAMNPU");
    EntityManager em = emf.createEntityManager();

    /**
     * Creates new form JInternalFrame_Statistics
     */
    public JInternalFrame_Statistics() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBestMoviesStatistics = new javax.swing.JPanel();
        btnBestMoviesStatistics = new javax.swing.JButton();
        scrlpnBestMoviesStatistics = new javax.swing.JScrollPane();
        tblBestMoviesStatistics = new javax.swing.JTable();
        pnlBestFavoriteMoviesStatistics = new javax.swing.JPanel();
        btnBestFavoriteMoviesStatistics = new javax.swing.JButton();
        scrlpnBestFavoriteMoviesStatistics = new javax.swing.JScrollPane();
        tblBestFavoriteMoviesStatistics = new javax.swing.JTable();
        btncloseStatistics = new java.awt.Button();

        setClosable(true);
        setTitle("ΣΤΑΤΙΣΤΙΚΑ");

        pnlBestMoviesStatistics.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnBestMoviesStatistics.setText("Οι καλύτερες 10 Ταινίες");
        btnBestMoviesStatistics.setMaximumSize(new java.awt.Dimension(200, 35));
        btnBestMoviesStatistics.setMinimumSize(new java.awt.Dimension(200, 35));
        btnBestMoviesStatistics.setPreferredSize(new java.awt.Dimension(220, 35));
        btnBestMoviesStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBestMoviesStatisticsActionPerformed(evt);
            }
        });

        tblBestMoviesStatistics.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        scrlpnBestMoviesStatistics.setViewportView(tblBestMoviesStatistics);

        javax.swing.GroupLayout pnlBestMoviesStatisticsLayout = new javax.swing.GroupLayout(pnlBestMoviesStatistics);
        pnlBestMoviesStatistics.setLayout(pnlBestMoviesStatisticsLayout);
        pnlBestMoviesStatisticsLayout.setHorizontalGroup(
            pnlBestMoviesStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBestMoviesStatisticsLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(btnBestMoviesStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlBestMoviesStatisticsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrlpnBestMoviesStatistics)
                .addContainerGap())
        );
        pnlBestMoviesStatisticsLayout.setVerticalGroup(
            pnlBestMoviesStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBestMoviesStatisticsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBestMoviesStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrlpnBestMoviesStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pnlBestFavoriteMoviesStatistics.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnBestFavoriteMoviesStatistics.setText("Οι καλύτερες Ταινίες ανα Λίστα");
        btnBestFavoriteMoviesStatistics.setPreferredSize(new java.awt.Dimension(220, 35));
        btnBestFavoriteMoviesStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBestFavoriteMoviesStatisticsActionPerformed(evt);
            }
        });

        tblBestFavoriteMoviesStatistics.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        scrlpnBestFavoriteMoviesStatistics.setViewportView(tblBestFavoriteMoviesStatistics);

        btncloseStatistics.setLabel("Επιστροφή");
        btncloseStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseStatisticsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBestFavoriteMoviesStatisticsLayout = new javax.swing.GroupLayout(pnlBestFavoriteMoviesStatistics);
        pnlBestFavoriteMoviesStatistics.setLayout(pnlBestFavoriteMoviesStatisticsLayout);
        pnlBestFavoriteMoviesStatisticsLayout.setHorizontalGroup(
            pnlBestFavoriteMoviesStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBestFavoriteMoviesStatisticsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBestFavoriteMoviesStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBestFavoriteMoviesStatisticsLayout.createSequentialGroup()
                        .addComponent(scrlpnBestFavoriteMoviesStatistics)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBestFavoriteMoviesStatisticsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBestFavoriteMoviesStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBestFavoriteMoviesStatisticsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncloseStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBestFavoriteMoviesStatisticsLayout.setVerticalGroup(
            pnlBestFavoriteMoviesStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBestFavoriteMoviesStatisticsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBestFavoriteMoviesStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrlpnBestFavoriteMoviesStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncloseStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBestMoviesStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBestFavoriteMoviesStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBestFavoriteMoviesStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBestMoviesStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//ΚΟΥΜΠΙ: ΟΙ ΚΑΛΥΤΕΡΕΣ ΤΑΙΝΙΕΣ ΑΝΑ ΛΙΣΤΑ
    private void btnBestFavoriteMoviesStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBestFavoriteMoviesStatisticsActionPerformed
        /* Περιγραφή: Όταν πατηθεί, θα εμφανίζεται ένας πίνακας (jTable2) με μία
        στήλη (Όνομα Ταινίας) και τόσες γραμμές όσες οι λίστες αγαπημένων που 
        έχουν οριστεί στη ΒΔ. Αυτός θα περιέχει τις ταινίες με την υψηλότερη
        βαθμολογία από την κάθε λίστα αγαπημένων.*/

        /*Δημιουργία ερωτήματος (query) που μου επιστρέφει τις Ταινίες των
        Αγαπημένων Λιστών ταξινομημένες ανά Βαθμολογία*/
        Query q1 = em.createQuery("SELECT m FROM Movie m WHERE m.favoriteListId.id>0 ORDER BY m.rating DESC");

        //Εισαγωγή των αποτελεσμάτων σε μία Λίστα 1
        List<Movie> movies = q1.getResultList();

        //Δημιουργία νέου ερωτήματος (query) που μου επιστρέφει τις Λίστες Αγαπημένων
        Query q2 = em.createQuery("SELECT f FROM FavoriteList f");

        //Εισαγωγή των αποτελεσμάτων σε μία Λίστα 2
        List<FavoriteList> flist = q2.getResultList();

        /*Σετάρω έναν βοηθητικό πίνακα (model) που να περιέχει δύο στήλες με
        πεδία Τίτλος Ταινίας & Βαθμολογία*/
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Τίτλος Ταινίας", "Βαθμολογία"});
        
        for (int i = 0; i < flist.size(); i++) {
            
            // Βρίσκω ID της Λίστας αγαπημένων
            System.out.println("flist id = "+flist.get(i).getId());

            String myQuery = "SELECT m FROM Movie m WHERE m.favoriteListId.id ="+flist.get(i).getId()+" ORDER BY m.rating DESC";
            // Βρίσκω όλες οι ταινίες με το παραπάνω ID και σετάρω DESC
            Query q3 = em.createQuery(myQuery);
            
            // Τοποθετώ τα αποτελέσματα του q3 σε μια λίστα <Movies>
            List<Movie> moviesF = q3.getResultList();
            
            // Εάν υπάρχουν ταινίες με αυτό το ID τότε..
            if(moviesF.size()>0) {
                // Το μηδέν είναι για να διαβάζω την 1η ταινία της λίστας (με το υψηλότερο rating)
                String ratingF = Float.toString(moviesF.get(0).getRating());
                model.addRow(new String[]{moviesF.get(0).getTitle(),ratingF});
            }
        }
        
        //Κι ενημερώνω το jTable2
        tblBestFavoriteMoviesStatistics.setModel(model);
    }//GEN-LAST:event_btnBestFavoriteMoviesStatisticsActionPerformed
//ΚΟΥΜΠΙ: ΟΙ ΚΑΛΥΤΕΡΕΣ 10 ΤΑΙΝΙΕΣ
    private void btnBestMoviesStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBestMoviesStatisticsActionPerformed
        /* Περιγραφή: Όταν πατηθεί, θα εμφανίζεται ένας πίνακας (jTable1) με 2
        στήλες και 10 γραμμές, που θα περιέχει τις 10 ταινίες με την υψηλότερη
        βαθμολογία ανεξαρτήτου είδους ταινίας.*/

        /*Δημιουργία ερωτήματος (query) που μου επιστρέφει τις Ταινίες ταξινομημένες
        ανά Βαθμολογία*/
        Query q1 = em.createQuery("SELECT m FROM Movie m ORDER BY m.rating DESC");
        //Εμφάνιση μόνο των πρώτων 10 Ταινιών
        q1.setMaxResults(10);
        //...τις οποίες τοποθετώ σε μία Λίστα 
        List<Movie> movies = q1.getResultList();
        //Σετάρω έναν βοηθητικό πίνακα (model) όπως ζητείται από την εκφώνηση 
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Ταινία", "Βαθμολογία"});
        //Με ένα for διαβάζω τη Λίστα και την περνάω στον βοηθητικό πίνακα
        movies.forEach((movie) -> {
            //αφού μετατρέψω τη βαθμολογία από float σε string
            String rating = Float.toString(movie.getRating());
            //Προσθέτω μία μία γραμμή της Λίστας στον Πίνακα
            model.addRow(new String[]{movie.getTitle(), rating});
        });
        //Κι ενημερώνω το jTable1 1
        tblBestMoviesStatistics.setModel(model);
    }//GEN-LAST:event_btnBestMoviesStatisticsActionPerformed

//ΚΟΥΜΠΙ ΕΞΟΔΟΥ - ΕΠΙΣΤΡΟΦΗΣ
    private void btncloseStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseStatisticsActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncloseStatisticsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBestFavoriteMoviesStatistics;
    private javax.swing.JButton btnBestMoviesStatistics;
    private java.awt.Button btncloseStatistics;
    private javax.swing.JPanel pnlBestFavoriteMoviesStatistics;
    private javax.swing.JPanel pnlBestMoviesStatistics;
    private javax.swing.JScrollPane scrlpnBestFavoriteMoviesStatistics;
    private javax.swing.JScrollPane scrlpnBestMoviesStatistics;
    private javax.swing.JTable tblBestFavoriteMoviesStatistics;
    private javax.swing.JTable tblBestMoviesStatistics;
    // End of variables declaration//GEN-END:variables
}
