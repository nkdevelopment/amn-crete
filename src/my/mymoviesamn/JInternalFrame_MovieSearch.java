/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author AMN
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
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
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
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(lblGenre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(lblYear, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCriteria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblWarnCriteria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                                .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(54, 54, 54))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addContainerGap(17, Short.MAX_VALUE))
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
        cbGenre.setSelectedIndex(-1);
        cbFavoriteLists.setSelectedIndex(-1);
    }//GEN-LAST:event_formInternalFrameOpened

    private void cbGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGenreActionPerformed
        // TODO add your handling code here:
        doActivateSearchButton();
    }//GEN-LAST:event_cbGenreActionPerformed

    private void btnRemoveFromListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromListActionPerformed

        if (tblMovieList.getSelectedRowCount() == 0) {
            return;
        }
        for (int row : tblMovieList.getSelectedRows()) {
            int movieId = (int) tblMovieList.getModel().getValueAt(row, 0);

            if (!myMoviesAMNPUEntityManager.getTransaction().isActive()) {
                myMoviesAMNPUEntityManager.getTransaction().begin();
            }

            Movie m = myMoviesAMNPUEntityManager.find(Movie.class, movieId);
            m.setFavoriteListId(null);

            tblMovieList.getModel().setValueAt(null, row, 5);
            cbFavoriteLists.setSelectedIndex(-1);

            myMoviesAMNPUEntityManager.persist(m);
            myMoviesAMNPUEntityManager.getTransaction().commit();
        }
        changeSelectedFavoriteList();
    }//GEN-LAST:event_btnRemoveFromListActionPerformed

    private void btnAddToListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToListActionPerformed
        if (tblMovieList.getSelectedRowCount() == 0) {
            return;
        }

        final Object[] favoriteLists = favoriteListList.toArray();
        FavoriteList selectedFavoritelist = (FavoriteList) JOptionPane.showInputDialog(this, "Επιλογή λίστας",
                "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, favoriteLists, favoriteLists[0]);
        if (selectedFavoritelist == null) {
            return;
        }
        for (int row : tblMovieList.getSelectedRows()) {
            int movieId = (int) tblMovieList.getModel().getValueAt(row, 0);

            if (!myMoviesAMNPUEntityManager.getTransaction().isActive()) {
                myMoviesAMNPUEntityManager.getTransaction().begin();
            }

            Movie m = myMoviesAMNPUEntityManager.find(Movie.class, movieId);
            m.setFavoriteListId(selectedFavoritelist);

            tblMovieList.getModel().setValueAt(selectedFavoritelist, row, 5);

            myMoviesAMNPUEntityManager.persist(m);
            myMoviesAMNPUEntityManager.getTransaction().commit();
        }
        changeSelectedFavoriteList();
    }//GEN-LAST:event_btnAddToListActionPerformed

    private void addMovieToFavoritesList() {
        if (tblMovieList.getSelectedRowCount() == 0) {
            return;
        }
        if (cbFavoriteLists.getSelectedIndex() < 0) {
            return;
        }
        FavoriteList favList = (FavoriteList) cbFavoriteLists.getSelectedItem();
        for (int row : tblMovieList.getSelectedRows()) {
            int movieId = (int) tblMovieList.getModel().getValueAt(row, 0);

            if (!myMoviesAMNPUEntityManager.getTransaction().isActive()) {
                myMoviesAMNPUEntityManager.getTransaction().begin();
            }

            Movie m = myMoviesAMNPUEntityManager.find(Movie.class, movieId);
            m.setFavoriteListId(favList);

            tblMovieList.getModel().setValueAt(favList, row, 5);

            myMoviesAMNPUEntityManager.persist(m);
            myMoviesAMNPUEntityManager.getTransaction().commit();
        }
        changeSelectedFavoriteList();
    }

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        cbGenre.setSelectedIndex(-1);
        txtYear.setText("");
        doActivateSearchButton();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        doSearch();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void doSearch() {
        String queryText = "SELECT m FROM Movie m";
        boolean putWhere = false;
        if (cbGenre.getSelectedIndex() >= 0) {
            Genre selectedGenre = (Genre) cbGenre.getSelectedItem();
            queryText += " WHERE m.genreId.id = " + selectedGenre.getId().toString();
            putWhere = true;
        }
        if (!txtYear.getText().isEmpty()) {
            queryText += putWhere ? " AND " : " WHERE ";
            queryText += "FUNC('YEAR', m.releaseDate) = " + txtYear.getText();
        }
        if (chkSortByRating.isSelected()) {
            queryText += " ORDER BY m.rating DESC";
        }
        Query movieQuery = myMoviesAMNPUEntityManager.createQuery(queryText);
        List<Movie> movieList = movieQuery.getResultList();
        DefaultTableModel model = new DefaultTableModel();

        // το ID χρειάζεται για να βρούμε την ταινία όταν είναι
        // να την προσθέσουμε σε λίστα ή να την αφαιρέσουμε από λίστα
        model.setColumnIdentifiers(new String[]{"ID", "Τίτλος Ταινίας",
            "Βαθμολογία", "Περίληψη", "Genre", "Favorite_List_ID"});
        movieList.forEach((Movie m) -> {
            String genreText = "";
            String favoriteListText = "";
            String dateText = "";
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

        tblMovieList.setModel(model);

        tblMovieList.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblMovieList.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblMovieList.getColumnModel().getColumn(3).setPreferredWidth(1000);
        tblMovieList.getColumnModel().removeColumn(tblMovieList.getColumn("ID"));
        tblMovieList.getColumnModel().removeColumn(tblMovieList.getColumn("Genre"));
        tblMovieList.getColumnModel().removeColumn(tblMovieList.getColumn("Favorite_List_ID"));
    }

    private void txtYearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtYearKeyReleased
        doActivateSearchButton();
    }//GEN-LAST:event_txtYearKeyReleased

    private void cbFavoriteListsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFavoriteListsActionPerformed
        addMovieToFavoritesList();
    }//GEN-LAST:event_cbFavoriteListsActionPerformed


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

    private void doActivateSearchButton() {
        final boolean criteriaOk = areCriteriaOk();
        btnSearch.setEnabled(criteriaOk);
        lblWarnCriteria.setText(criteriaOk ? "" : "Συμπληρώστε σωστές τιμές για το έτος και το είδος της ταινίας");
    }

    private boolean areCriteriaOk() throws NumberFormatException {
        String yearText = txtYear.getText();
        if (cbGenre.getSelectedIndex() < 0) {
            return false;
        }
        if (4 != yearText.length()) {
            return false;
        }
        //Check if 4 digits
        for (int i = 0; i < yearText.length(); i++) {
            char chr = yearText.charAt(i);
            if (chr < '0' || chr > '9') {
                return false;
            }
        }
        //Check if year in proper range
        int yearValue = Integer.parseInt(yearText);
        if (yearValue < 2000) {
            return false;
        }
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (yearValue > currentYear) {
            return false;
        }
        return true;
    }

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
            changeSelectedFavoriteList();
        }

    }
}
