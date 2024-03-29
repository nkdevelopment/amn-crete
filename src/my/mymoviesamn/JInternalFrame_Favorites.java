package my.mymoviesamn;

import java.util.List;
import model.FavoriteList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Movie;

/**
 *
 * @author amn
 */
public class JInternalFrame_Favorites extends javax.swing.JInternalFrame {

    private List<FavoriteList> mFavoriteList = null;

    /**
     * Creates new form JInternalFrame_Favorites
     */
    public JInternalFrame_Favorites() {
        initComponents();

        btnModifyFavoriteList.setEnabled(false); // Αρχικά απενεργοποιώ το κουμπί της Επεξεργασίας
        btnDeleteFavoriteList.setEnabled(false); // Αρχικά απενεργοποιώ το κουμπί της Διαγραφής

        // Ελέγχω αν έχουν γίνει μία ή περισσότερες επιλογές στην jList
        // Ενεργοποιώ έναν Listener που "ακούει" αν έχουν επιλεγεί 1 ή περισσότερες FavoriteList
        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                JList list = (JList) listSelectionEvent.getSource();
                int selections[] = list.getSelectedIndices(); // πίνακας FavoriteList που έχουν επιλεχθεί
                int selectionLength = selections.length; // μέγεθος πίνακα selections

                // Εάν έχω κάνει μία (1) επιλογή
                if (selectionLength == 1) {
                    btnModifyFavoriteList.setEnabled(true); // ενεργοποιώ κουμπί Επεξεργασία
                    btnDeleteFavoriteList.setEnabled(true); // ενεργοποιώ κουμπί Διαγραφή

                    showFavoritesListMovies(); // Δείξε τις ταινίες της συγκεκριμένης Favorite List

                    // Εάν έχω κάνει περισσότερες από μία επιλογές
                } else if (selectionLength > 1) {
                    btnModifyFavoriteList.setEnabled(false); // απενεργοποιώ κουμπί Επεξεργασία
                    btnDeleteFavoriteList.setEnabled(true); // ενεργοποιώ κουμπί Διαγραφή
                } else {
                    btnModifyFavoriteList.setEnabled(false); // απενεργοποιώ κουμπί Επεξεργασία
                }
            }

            // Δείξε τις ταινίες της συγκεκριμένης Favorite List 
            private void showFavoritesListMovies() {

                // παίρνω τη λίστα των FavoriteList που έχω επιλέξει
                List selected = lstFavoriteListView.getSelectedValuesList();
                DatabasesConnections m = new DatabasesConnections(); // δημιουργώ αντικείμενο DatabasesConnections
                // διαβάζω τις ταινίες της συγκεκριμένης Favorite List
                List<Movie> movies = m.loadFavoritesListMovies(selected);

                // δημιουργώ νέο μοντέλο DefaultTableModel και μετά ορίζω τις στήλες του πίνακα
                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(new String[]{"Τίτλος Ταινίας", "Βαθμολογία", "Περιγραφή"});

                // διατρέχω όλες τια ταινίες movies και προσθέτω γραμμές στο model με τις ανάλογες τιμές των στηλών 
                movies.forEach((movie) -> {
                    String rating = Float.toString(movie.getRating());
                    model.addRow(new String[]{movie.getTitle(), rating, movie.getOverview()});
                });

                tblFavoriteListMovieView.setModel(model); // ορισμός μοντέλου του jTable
            }

        };
        lstFavoriteListView.addListSelectionListener(listSelectionListener); // προσθήκη του listener στην jList
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        myMoviesAMNPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("myMoviesAMNPU").createEntityManager();
        favoriteListQuery = java.beans.Beans.isDesignTime() ? null : myMoviesAMNPUEntityManager.createQuery("SELECT f FROM FavoriteList f");
        favoriteListList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(favoriteListQuery.getResultList());
        movieTableQuery = java.beans.Beans.isDesignTime() ? null : myMoviesAMNPUEntityManager.createQuery("SELECT m FROM Movie m WHERE m.rating > 8.0");
        movieTableList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(movieTableQuery.getResultList());
        scrlpnFavoriteListViewSpane = new javax.swing.JScrollPane();
        lstFavoriteListView = new javax.swing.JList<>();
        btnCreateFavoriteList = new javax.swing.JButton();
        btnModifyFavoriteList = new javax.swing.JButton();
        btnDeleteFavoriteList = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        scrlpnFavoriteListMovieViewSpane = new javax.swing.JScrollPane();
        tblFavoriteListMovieView = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 102, 102));
        setClosable(true);
        setTitle("Διαχείριση Λιστών Αγαπημένων Ταινιών");

        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, favoriteListList, lstFavoriteListView);
        jListBinding.setDetailBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        bindingGroup.addBinding(jListBinding);

        scrlpnFavoriteListViewSpane.setViewportView(lstFavoriteListView);

        btnCreateFavoriteList.setText("Δημιουργία");
        btnCreateFavoriteList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateFavoriteListActionPerformed(evt);
            }
        });

        btnModifyFavoriteList.setText("Επεξεργασία");
        btnModifyFavoriteList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyFavoriteListActionPerformed(evt);
            }
        });

        btnDeleteFavoriteList.setText("Διαγραφή");
        btnDeleteFavoriteList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFavoriteListActionPerformed(evt);
            }
        });

        btnClose.setText("Επιστροφή");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        scrlpnFavoriteListMovieViewSpane.setViewportView(tblFavoriteListMovieView);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrlpnFavoriteListViewSpane, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreateFavoriteList, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnModifyFavoriteList, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(btnDeleteFavoriteList, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrlpnFavoriteListMovieViewSpane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreateFavoriteList)
                            .addComponent(btnModifyFavoriteList)
                            .addComponent(btnDeleteFavoriteList))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrlpnFavoriteListMovieViewSpane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClose)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrlpnFavoriteListViewSpane, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // πατώντας το κουμπί Επιστροφή και κλείνοντας το παράθυρο
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    // Μέθοδος που τρέχει όταν πατηθεί το κουμπί της Δημιουργίας
    private void btnCreateFavoriteListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateFavoriteListActionPerformed

        // πίνακας κουμπιών μηνύματος
        Object[] options1 = {"Αποθήκευση", "Ακύρωση"};

        JPanel panel = new JPanel(); // δημιουργία JPanel
        panel.add(new JLabel("Δώστε το όνομα της νέας λίστας αγαπημενων ταινιών:"));
        JTextField textField = new JTextField(10);
        panel.add(textField);

        // Δημιουργία μηνύματος (παραθύρου) με επιλογές options1 (Αποθήκευση και Ακύρωση)
        int result = JOptionPane.showOptionDialog(this, panel, "Νέα κατηγορία αγαπημένων ταινιών",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, textField.getText()); // μήνυμα εμφάνισης ονόματος νέας FavoriteList
        }
        String fvName = textField.getText();
        System.out.println(fvName);

        // αν δεν είναι null και έχει μήκος >0 
        if ((fvName != null) && (fvName.length() > 0)) {
            saveNewFavorite(fvName); // δημιουργία και αποθήκευση νέας Favorite List
        }

    }//GEN-LAST:event_btnCreateFavoriteListActionPerformed

    // Μέθοδος που τρέχει όταν πατηθεί το κουμπί της Επεξεργασίας
    private void btnModifyFavoriteListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyFavoriteListActionPerformed
        String oldName = lstFavoriteListView.getSelectedValue(); // διάβασμα ονόματος FavoriteList από την jList1

        // πίνακας κουμπιών μηνύματος
        Object[] options1 = {"Αποθήκευση", "Ακύρωση"};

        // Δημιουργία και εμφάνιση παραθύρου αλλαγής του ονόματος
        JPanel panel = new JPanel();
        panel.add(new JLabel("Δώστε το νέο όνομα της λίστας αγαπημενων ταινιών:"));
        JTextField textField = new JTextField(10);
        panel.add(textField);
        textField.setText(oldName); // βάλε για αρχή το παλιό όνονα στο textField
        int result = JOptionPane.showOptionDialog(this, panel, "Επεξεργασία κατηγορίας αγαπημένων ταινιών",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);

        String fvName = textField.getText(); // διάβασε το νέο όνομα της Favorite List από το textField
        if (result == JOptionPane.YES_OPTION) { // αν πατήσεις Αποθήκευση
            JOptionPane.showMessageDialog(this, textField.getText()); // εμφάνισε μήνυμα με το νέο όνομα

            if ((fvName != null) && (!fvName.equals(oldName)) && (fvName.length() > 0)) {
                updateFavorite(oldName, fvName); // ενημέρωσε την Favorite List με το νέο όνομα
            }
        }
    }//GEN-LAST:event_btnModifyFavoriteListActionPerformed

    // Μέθοδος που τρέχει όταν πατηθεί το κουμπί της Διαγραφής
    private void btnDeleteFavoriteListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFavoriteListActionPerformed
        // πατώντας το κουμπί Διαγραφή
        deleteFavorite();
    }//GEN-LAST:event_btnDeleteFavoriteListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCreateFavoriteList;
    private javax.swing.JButton btnDeleteFavoriteList;
    private javax.swing.JButton btnModifyFavoriteList;
    private java.util.List<model.FavoriteList> favoriteListList;
    private javax.persistence.Query favoriteListQuery;
    private javax.swing.JList<String> lstFavoriteListView;
    private java.util.List<model.Movie> movieTableList;
    private javax.persistence.Query movieTableQuery;
    private javax.persistence.EntityManager myMoviesAMNPUEntityManager;
    private javax.swing.JScrollPane scrlpnFavoriteListMovieViewSpane;
    private javax.swing.JScrollPane scrlpnFavoriteListViewSpane;
    private javax.swing.JTable tblFavoriteListMovieView;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    // δημιουργία και αποθήκευση νέας Favorite List με το όνομα fvName
    private void saveNewFavorite(String fvName) {

        DatabasesConnections m = new DatabasesConnections(); // νέο αντικείμενο DatabasesConnections
        mFavoriteList = m.saveNewFavorite(fvName); // εκτέλεσε τη μέθοδο saveNewFavorite του m

        // δημιουργήσε ένα νέο DefaultListModel με Strings
        DefaultListModel<String> listModel = new DefaultListModel<>();
        mFavoriteList.forEach((favorite) -> {
            listModel.addElement(favorite.getName()); // πρόσθεσε στο μοντέλο το όνομα της favorite
        });
        lstFavoriteListView.setModel(listModel); // όρισε το μοντέλο της jList

    }

    // ενημέρωσε τη favorite list που έχει παλιό όνομα oldName με το νέο όνομα updatedName
    private void updateFavorite(String oldName, String updatedName) {

        DatabasesConnections m = new DatabasesConnections(); // νέο αντικείμενο DatabasesConnections
        mFavoriteList = m.updateFavorite(oldName, updatedName); // εκτέλεσε τη μέθοδο updateFavorite του m

        // δημιουργήσε ένα νέο DefaultListModel με Strings
        DefaultListModel<String> listModel = new DefaultListModel<>();
        mFavoriteList.forEach((favorite) -> { // διάτρεξε όλη τη λίστα mFavoriteList
            listModel.addElement(favorite.getName()); // πρόσθεσε στο μοντέλο το όνομα της favorite
        });
        lstFavoriteListView.setModel(listModel); // όρισε το μοντέλο της jList

        btnDeleteFavoriteList.setEnabled(false); // Απενεργοποιώ το κουμπί της Διαγραφής
    }

    // πατώντας το κουμπί Διαγραφή
    private void deleteFavorite() {
        // Λίστα επιλεγμένων ταινιών
        List selectedNames = lstFavoriteListView.getSelectedValuesList();

        // δημιουργία πανελ μηνύματος επιβεβαίωσης Διαγραφής
        Object[] options1 = {"Διαγραφή", "Ακύρωση"};
        JPanel panel = new JPanel();
        panel.add(new JLabel("Σίγουρα διαγραφή των παρακάτω;"));
        // Δημιουργία λίστας ταινιών που επιλέχθηκαν προς Διαγραφή και προσθήκη στο panel
        JList listToDelete = new JList(selectedNames.toArray());
        panel.add(listToDelete);

        // εμφάνιση μηνύματος επιβεβαίωσης Διαγραφής
        int result = JOptionPane.showOptionDialog(this, panel, "Διαγραφή κατηγορίας αγαπημένων ταινιών",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);

        if (result == JOptionPane.YES_OPTION) { // εάν επιβεβαιωθεί η Διαγραφή προχωράμε στη διαγραφή
            DatabasesConnections m = new DatabasesConnections(); // νέο αντικείμενο DatabasesConnections

            // εκτέλεση μεθόδου deleteFavorite του m
            // που επιστρέφει τη νέα λίστα χωρίς τη/τις προς δοαγραφή favorite lists
            mFavoriteList = m.deleteFavorite(selectedNames);

            // δημιουργήσε ένα νέο DefaultListModel με Strings
            DefaultListModel<String> listModel = new DefaultListModel<>();
            mFavoriteList.forEach((favorite) -> { // διάτρεξε όλη τη λίστα mFavoriteList
                listModel.addElement(favorite.getName());// πρόσθεσε στο μοντέλο το όνομα της favorite 
            });
            lstFavoriteListView.setModel(listModel); // όρισε το μοντέλο της jList

            // Αδειάζοντας τον πίνακα από τις ταινίες αφού εκτελέσαμ Διαγραφή και πλέον δεν είναι καμία favorite list επιλεγμένη
            DefaultTableModel modelEmpty = new DefaultTableModel();
            modelEmpty.setColumnIdentifiers(new String[]{"Τίτλος Ταινίας", "Βαθμολογία", "Περιγραφή"});
            tblFavoriteListMovieView.setModel(modelEmpty);

            btnDeleteFavoriteList.setEnabled(false); // Απενεργοποιώ το κουμπί της Διαγραφής
        } else { // διαφορετικά δεν κάνουμε τίποτα - δεν διαγράφουμε κάτι
        }
    }
}
