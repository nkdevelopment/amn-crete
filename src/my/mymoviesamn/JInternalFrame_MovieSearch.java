package my.mymoviesamn;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.FavoriteList;
import model.Genre;
import model.Movie;

/**
 *
 * @author amn
 */
public class JInternalFrame_MovieSearch extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrame_MovieSearch
     */
    public JInternalFrame_MovieSearch() {
        initComponents();
        tblMovieList.getSelectionModel().addListSelectionListener(new RowListener());
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
        favoriteListList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : favoriteListQuery.getResultList();
        genreQuery = java.beans.Beans.isDesignTime() ? null : myMoviesAMNPUEntityManager.createQuery("SELECT g FROM Genre g");
        genreList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : genreQuery.getResultList();
        pnlMain = new javax.swing.JPanel();
        cbGenre = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtYear = new javax.swing.JTextField();
        lblCriteria = new javax.swing.JLabel();
        lblGenre = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        scrollMovieList = new javax.swing.JScrollPane();
        tblMovieList = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        cbFavoriteLists = new javax.swing.JComboBox<>();
        lblFavoriteLists = new javax.swing.JLabel();
        btnRemoveFromList = new javax.swing.JButton();
        btnAddToList = new javax.swing.JButton();
        chkSortByRating = new javax.swing.JCheckBox();
        lblWarnCriteria = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Αναζήτηση Ταινιών");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        pnlMain.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnlMain.setToolTipText("");
        pnlMain.setPreferredSize(new java.awt.Dimension(1000, 550));

        cbGenre.setMaximumRowCount(3);
        cbGenre.setToolTipText("");
        cbGenre.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        cbGenre.setName("Είδος Ταινίας"); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, genreList, cbGenre);
        bindingGroup.addBinding(jComboBoxBinding);

        cbGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGenreActionPerformed(evt);
            }
        });

        btnSearch.setText("Αναζήτηση");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnClear.setText("Καθαρισμός Κριτηρίων");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        txtYear.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        txtYear.setName("Έτος Κυκλοφορίας"); // NOI18N
        txtYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtYearKeyReleased(evt);
            }
        });

        lblCriteria.setText("Κριτήρια Αναζήτησης");

        lblGenre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGenre.setLabelFor(cbGenre);
        lblGenre.setText("Έιδος Ταινίας:");

        lblYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblYear.setLabelFor(txtYear);
        lblYear.setText("Έτος Κυκλοφορίας:");

        scrollMovieList.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        tblMovieList.setAutoCreateRowSorter(true);
        tblMovieList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblMovieList.setFillsViewportHeight(true);
        tblMovieList.setName("Αποτελέσματα Αναζήτησης"); // NOI18N
        scrollMovieList.setViewportView(tblMovieList);

        btnClose.setText("Επιστροφή");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, favoriteListList, cbFavoriteLists);
        bindingGroup.addBinding(jComboBoxBinding);

        cbFavoriteLists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFavoriteListsActionPerformed(evt);
            }
        });

        lblFavoriteLists.setLabelFor(cbFavoriteLists);
        lblFavoriteLists.setText("Λίστες Αγαπημένων");

        btnRemoveFromList.setText("Αφαίρεση από Λίστα");
        btnRemoveFromList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFromListActionPerformed(evt);
            }
        });

        btnAddToList.setText("Προσθήκη σε λίστα");
        btnAddToList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToListActionPerformed(evt);
            }
        });

        chkSortByRating.setText("Ταξινόμηση με βάση τη Βαθμολογία");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblFavoriteLists)
                        .addGap(20, 20, 20)
                        .addComponent(cbFavoriteLists, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddToList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemoveFromList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkSortByRating))
                    .addComponent(scrollMovieList)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMainLayout.createSequentialGroup()
                        .addComponent(lblGenre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(lblYear, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMainLayout.createSequentialGroup()
                        .addComponent(lblCriteria)
                        .addGap(44, 44, 44)
                        .addComponent(lblWarnCriteria, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(54, 54, 54))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCriteria)
                    .addComponent(lblWarnCriteria))
                .addGap(17, 17, 17)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblYear)
                    .addComponent(cbGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGenre)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnClear)
                    .addComponent(btnClose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollMovieList, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveFromList)
                    .addComponent(btnAddToList)
                    .addComponent(cbFavoriteLists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFavoriteLists)
                    .addComponent(chkSortByRating))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        cbGenre.setSelectedIndex(-1); // ορισμός επιλογής JComboBox cbGenre σε -1
        cbFavoriteLists.setSelectedIndex(-1); // ορισμός επιλογής JComboBox cbFavoriteLists σε -1
    }//GEN-LAST:event_formInternalFrameOpened

    private void cbGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGenreActionPerformed
        // ενεργοποίησε το κουμπί Αναζήτηση
        doActivateSearchButton();
    }//GEN-LAST:event_cbGenreActionPerformed

    // Πατώντας το κουμπί "Αφαίρεση από λίστα"
    private void btnRemoveFromListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromListActionPerformed

        if (tblMovieList.getSelectedRowCount() == 0) {
            return; // αν δεν έχει επιλεχθεί τίποτα επέστρεψε
        }
        // βρόγχος που διατρέχει όλες τις επιλεχθέντες ταινίες
        for (int row : tblMovieList.getSelectedRows()) {
            int movieId = (int) tblMovieList.getModel().getValueAt(row, 0);

            if (!myMoviesAMNPUEntityManager.getTransaction().isActive()) {
                myMoviesAMNPUEntityManager.getTransaction().begin();
            }

            // διάβασε την ταινία με id το movieId
            Movie m = myMoviesAMNPUEntityManager.find(Movie.class, movieId);
            m.setFavoriteListId(null); // αφαίρεσε από τη λίστα ορίζοντας το favorite list id σε null

            // διάβασε το μοντέλο και όρισε τη νέα τιμή
            tblMovieList.getModel().setValueAt(null, row, 5);
            cbFavoriteLists.setSelectedIndex(-1); // όρισε να μην είναι τίποτα επιλεγμένο στο cbFavoriteLists

            myMoviesAMNPUEntityManager.persist(m); // ενημέρωσε τη ΒΔ με την την αλλαγμένη ταινία m
            myMoviesAMNPUEntityManager.getTransaction().commit();
        }
        changeSelectedFavoriteList(); // ενημέρωσε τη λίστα αγαπημένων του combobox Λίστες αγαπημένων
    }//GEN-LAST:event_btnRemoveFromListActionPerformed

    // Πατώντας το κουμπι "Προσθήκη σε λίστα" αναδύετε το παράθυρο επιλογής λίστας αγαπημένων
    private void btnAddToListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToListActionPerformed
        if (tblMovieList.getSelectedRowCount() == 0) {
            return; // αν δεν υπάρχει επιλογή επέστρεψε
        }

        final Object[] favoriteLists = favoriteListList.toArray();
        FavoriteList selectedFavoritelist = (FavoriteList) JOptionPane.showInputDialog(this, "Επιλογή λίστας αγαπημένων τανιών",
                "Παρακαλώ επιλέξτε...", JOptionPane.QUESTION_MESSAGE, null, favoriteLists, favoriteLists[0]);
        if (selectedFavoritelist == null) {
            return;
        }
        for (int row : tblMovieList.getSelectedRows()) {
            int movieId = (int) tblMovieList.getModel().getValueAt(row, 0); // διάβασε το id της ταινίας

            if (!myMoviesAMNPUEntityManager.getTransaction().isActive()) {
                myMoviesAMNPUEntityManager.getTransaction().begin();
            }

            Movie m = myMoviesAMNPUEntityManager.find(Movie.class, movieId);// βρες την ταινία m
            m.setFavoriteListId(selectedFavoritelist); // όρισε το favorite list id της ταινίας m

            tblMovieList.getModel().setValueAt(selectedFavoritelist, row, 5);

            myMoviesAMNPUEntityManager.persist(m); // ενημέρωσε τη ΒΔ με την αλλαγμένη ταινία
            myMoviesAMNPUEntityManager.getTransaction().commit();
        }
        changeSelectedFavoriteList(); // ενημέρωσε τη λίστα αγαπημένων του combobox Λίστες αγαπημένων
    }//GEN-LAST:event_btnAddToListActionPerformed

    // 
    private void addMovieToFavoritesList() {
        if (tblMovieList.getSelectedRowCount() == 0) {
            return; // επέστρεψε αν δεν έχεις επιλέξει κάτι
        }
        if (cbFavoriteLists.getSelectedIndex() < 0) {
            return; // επέστρεψε αν δεν έχεις επιλέξει κάτι (<0)
        }
        FavoriteList favList = (FavoriteList) cbFavoriteLists.getSelectedItem(); // πάρε τη favorite list που είναι επιλεγμένη
        for (int row : tblMovieList.getSelectedRows()) {
            int movieId = (int) tblMovieList.getModel().getValueAt(row, 0); // διάβασε το id της ταινίας

            if (!myMoviesAMNPUEntityManager.getTransaction().isActive()) {
                myMoviesAMNPUEntityManager.getTransaction().begin();
            }

            Movie m = myMoviesAMNPUEntityManager.find(Movie.class, movieId); // βρες την ταινία m
            m.setFavoriteListId(favList); // όρισε το favorite list id της ταινίας m

            tblMovieList.getModel().setValueAt(favList, row, 5);

            myMoviesAMNPUEntityManager.persist(m); // ενημέρωσε τη ΒΔ με την αλλαγμένη ταινία
            myMoviesAMNPUEntityManager.getTransaction().commit();
        }

        changeSelectedFavoriteList(); // ενημέρωσε τη λίστα αγαπημένων του combobox Λίστες αγαπημένων
    }

    // όταν πατηθεί το κουμπί Καθαρισμός Κριτηρίων
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        cbGenre.setSelectedIndex(-1); // αφαίρεσε τυχόν επιλογή από το combobox "Είδος ταινίας"
        txtYear.setText(""); // καθάρισε το κείμενο "Έτος κυκλοφορίας"
        doActivateSearchButton(); // ενεργοποίησε το κουμπί Αναζήτηση
    }//GEN-LAST:event_btnClearActionPerformed

    // Πατώντας το κουμπί "Επιστροφή"
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose(); // κλείσε το πάνελ
    }//GEN-LAST:event_btnCloseActionPerformed

    // Πατώντας το κουμπί "Αναζήτηση"
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        doSearch(); // εκτέλεση μεθόδου doSearch()
    }//GEN-LAST:event_btnSearchActionPerformed

    // Μέθοδος αναζήτησης ταινιών βάση των κριτηρίων αναζήτησης
    private void doSearch() {
        String queryText = "SELECT m FROM Movie m"; // Αρχικό query (string)
        boolean putWhere = false;

        // αν έχει επιλεγεί Είδος ταινίας λάβε το genre id και πρόσθεσε το στο αρχικο queryText
        if (cbGenre.getSelectedIndex() >= 0) {
            Genre selectedGenre = (Genre) cbGenre.getSelectedItem();
            queryText += " WHERE m.genreId.id = " + selectedGenre.getId().toString();
            putWhere = true;
        }

        // αν έχει επιλεγεί Έτος πρόσθεσε το στο queryText
        if (!txtYear.getText().isEmpty()) {
            queryText += putWhere ? " AND " : " WHERE ";
            queryText += "FUNC('YEAR', m.releaseDate) = " + txtYear.getText();
        }

        // αν είναι πατημένο το κουμπί "Ταξινόμηση με βάση τη Βαθμολογία" πρόσθεσε στο queryText την ταξινόμηση
        if (chkSortByRating.isSelected()) {
            queryText += " ORDER BY m.rating DESC";
        }

        // Εκτέλεση query
        Query movieQuery = myMoviesAMNPUEntityManager.createQuery(queryText);
        List<Movie> movieList = movieQuery.getResultList(); // πάρε τη λίστα ταινιών από το query
        DefaultTableModel model = new DefaultTableModel(); // δημιούργησε νέο μοντέλο DefaultTableModel

        // το ID χρειάζεται για να βρούμε την ταινία όταν είναι
        // να την προσθέσουμε σε λίστα ή να την αφαιρέσουμε από λίστα
        model.setColumnIdentifiers(new String[]{"ID", "Τίτλος Ταινίας",
            "Βαθμολογία", "Περίληψη", "Genre", "Favorite_List_ID"});

        // βρόγχος προσθήκης κάθε ταινίας στο model
        movieList.forEach((Movie m) -> {
            String genreText = "";
            String favoriteListText = "";
            Genre genre = m.getGenreId();
            if (genre != null) {
                genreText = genre.getName();
            }
            FavoriteList list = m.getFavoriteListId();
            if (list != null) {
                favoriteListText = list.getName();
            }
            model.addRow(new Object[]{m.getId(), m.getTitle(), m.getRating(), m.getOverview(), m.getGenreId(), m.getFavoriteListId()});
        });

        tblMovieList.setModel(model); // όρισε το μοντέλο της tblMovieList

        // όρισε τις διαστάσεις του tblMovieList
        tblMovieList.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblMovieList.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblMovieList.getColumnModel().getColumn(3).setPreferredWidth(1000);

        // αφαίρεσε τις παρακάτω στήλες (να μην εμφανίζονται) του tblMovieList
        tblMovieList.getColumnModel().removeColumn(tblMovieList.getColumn("ID"));
        tblMovieList.getColumnModel().removeColumn(tblMovieList.getColumn("Genre"));
        tblMovieList.getColumnModel().removeColumn(tblMovieList.getColumn("Favorite_List_ID"));
    }

    // αν έχει προστεθεί κείμενο στο "Έτος κυκλοφορίας"
    private void txtYearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtYearKeyReleased
        doActivateSearchButton(); // ενεργοποίησε το κουμπί "Αναζήτηση"
    }//GEN-LAST:event_txtYearKeyReleased

    private void cbFavoriteListsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFavoriteListsActionPerformed
        // επιλέγοντας favorite list από το combobox FavoriteLists
        addMovieToFavoritesList(); // πρόσθεσε την ταινία στη λίστα αγαπημένων
    }//GEN-LAST:event_cbFavoriteListsActionPerformed

    // Ενεργοποίηση του κουμπιού Αναζήτηση
    private void doActivateSearchButton() {
        final boolean criteriaOk = areCriteriaOk(); // έλεγχος αν υπάρχουν τα κριτήρια για την επιλογή του κουμπιού
        btnSearch.setEnabled(criteriaOk); // αν εκπληρώνονται τα κριτήρια ενεργοποίησε το κουμπί
        // όρισε το κείμενο του JLabel lblWarnCriteria
        lblWarnCriteria.setText(criteriaOk ? "" : "Παρακαλώ εισάγετε τιμές για το είδος της ταινίας(Action, Romance, Science Fiction)  και το έτος κυκλοφορίας(2000 έως σήμερα)");
    }

    //Έλεγχος αν έχει επιλεγεί το είδος τανίας 
    private boolean areCriteriaOk() throws NumberFormatException {
        String yearText = txtYear.getText();
        if (cbGenre.getSelectedIndex() < 0) {
            return false; // επιστροφή false αν δεν έχω επιλέξει genre στο combobox
        }
        if (4 != yearText.length()) {
            return false; // επιστροφή false αν δεν έχω πληκτρολογήσει 4 ψηφία στο Έτος κυκλοφορίας
        }
        //Έλεγχος αν έχουν εισαχθεί τέσσερεις αριθμοί (0 έως 9) για το έτος κυκλοφορίας
        for (int i = 0; i < yearText.length(); i++) {
            char chr = yearText.charAt(i);
            if (chr < '0' || chr > '9') {
                return false; // επιστροφή false αν έχει πατηθεί άλλο ψηφίο εκτός από αριθμό
            }
        }

        //Έλεγχος αν το έτος κυκλοφορίας βρίσκεται εντος του εύρους που καλύπτει η εφαρμογή (2000 έως σήμερα)
        int yearValue = Integer.parseInt(yearText);
        if (yearValue < 2000) {
            return false;
        }

        // Έλεγχος αν έχω εισάγει έτος μελλοντικό
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (yearValue > currentYear) {
            return false;
        }
        return true;
    }

    // ενημέρωσε τη λίστα αγαπημένων του combobox Λίστες αγαπημένων
    private void changeSelectedFavoriteList() {
        FavoriteList favoriteList = null;
        for (int row : tblMovieList.getSelectedRows()) {
            favoriteList = (FavoriteList) tblMovieList.getModel().getValueAt(row, 5);
        }
        cbFavoriteLists.setSelectedItem(favoriteList);
        cbFavoriteLists.setVisible(favoriteList != null);
        btnAddToList.setVisible(favoriteList == null);
    }

    private class RowListener implements ListSelectionListener {

        public RowListener() {
        }

        public void valueChanged(ListSelectionEvent event) {
            if (event.getValueIsAdjusting()) {
                return;
            }
            changeSelectedFavoriteList(); // ενημέρωσε τη λίστα αγαπημένων του combobox Λίστες αγαπημένων
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToList;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRemoveFromList;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbFavoriteLists;
    private javax.swing.JComboBox<String> cbGenre;
    private javax.swing.JCheckBox chkSortByRating;
    private java.util.List<model.FavoriteList> favoriteListList;
    private javax.persistence.Query favoriteListQuery;
    private java.util.List<model.Genre> genreList;
    private javax.persistence.Query genreQuery;
    private javax.swing.JLabel lblCriteria;
    private javax.swing.JLabel lblFavoriteLists;
    private javax.swing.JLabel lblGenre;
    private javax.swing.JLabel lblWarnCriteria;
    private javax.swing.JLabel lblYear;
    private javax.persistence.EntityManager myMoviesAMNPUEntityManager;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JScrollPane scrollMovieList;
    private javax.swing.JTable tblMovieList;
    private javax.swing.JTextField txtYear;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
