/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.mymoviesamn;

import java.sql.ResultSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myMoviesAMNPU");
    EntityManager em = emf.createEntityManager();

    private List<FavoriteList> mFavoriteList = null;

    /**
     * Creates new form JInternalFrame_Favorites
     */
    public JInternalFrame_Favorites() {
        initComponents();

        jButton2.setEnabled(false); // Αρχικά απενεργοποιώ το κουμπί της Επεξεργασίας
        jButton3.setEnabled(false); // Αρχικά απενεργοποιώ το κουμπί της Διαγραφής

        // Ελέγχω αν έχω κάνει μία ή περισσότερες επιλογές στην jList και ενεργοποιώ/απενεργοποιώ το κουμπί της Επεξεργασίας
        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                JList list = (JList) listSelectionEvent.getSource();
                int selections[] = list.getSelectedIndices();
                int selectionLength = selections.length;
                

                if (selectionLength == 1) {
                    jButton2.setEnabled(true);
                    jButton3.setEnabled(true);
                    
                    String objectName = jList1.getSelectedValue();
                    System.out.println(objectName);
                    
                    List selected = jList1.getSelectedValuesList();
                 
                    Query query = em.createNativeQuery("SELECT ID FROM FAVORITE_LIST WHERE NAME= '" + selected.get(0) + "'");
                    List results = query.getResultList();
                    System.out.println("results= "+results);
                    
                    int resultId = Integer.parseInt(results.get(0).toString());
                    String stringId = results.get(0).toString();
                    System.out.println("resultId= "+resultId);
                    
//                    Query q2 = em.createQuery("SELECT m FROM Movie m WHERE m.favoriteListId ="+resultId+"");
                    
                    
                    Query q1 = em.createQuery("SELECT m FROM Movie m WHERE m.favoriteListId = :favoriteListId");
//                    q1.setParameter("FAVORITE_LIST_ID", resultId);
                    q1.setParameter("favoriteListId", "25");
                    
                    
                    List<Movie> movies = q1.getResultList();
                    
                    DefaultTableModel model = new DefaultTableModel();
                    model.setColumnIdentifiers(new String[]{"Τίτλος Ταινίας","Βαθμολογία", "Περιγραφή"});
                    
                    for (Movie movie:movies){
                        String rating = Double.toString(movie.getRating());
                        model.addRow(new String[]{movie.getTitle(), rating, movie.getOverview()});
                    }
                    jTable1.setModel(model);

                    // https://stackoverflow.com/questions/27815400/retrieving-data-from-jdbc-database-into-jtable

//                    DefaultTableModel model = new DefaultTableModel(new String[]{"Class Name", "Home work", "Due Date"}, 0);
//                    String sql="SELECT * FROM hwList";
//                    ResultSet rs = st.executeQuery(sql); 
//                    while(rs.next())
//                    {
//                        String d = rs.getString("className");
//                        String e = rs.getString("homeWork");
//                        String f = rs.getString("dueDate");
//                        model.addRow(new Object[]{d, e, f});
//                    }
//                    table.setModel(model);
                    
                    
                    
                } else if (selectionLength > 1) {
                    jButton2.setEnabled(false);
                    jButton3.setEnabled(true);
                } else {
                    jButton2.setEnabled(false);
                }
            }

            
        };
        jList1.addListSelectionListener(listSelectionListener);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 102, 102));
        setClosable(true);
        setTitle("Διαχείριση Λιστών Αγαπημένων Ταινιών");

        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, favoriteListList, jList1);
        jListBinding.setDetailBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        bindingGroup.addBinding(jListBinding);

        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Δημιουργία");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Επεξεργασία");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Επιστροφή");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, movieTableList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${title}"));
        columnBinding.setColumnName("Title");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${rating}"));
        columnBinding.setColumnName("Rating");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${overview}"));
        columnBinding.setColumnName("Overview");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    // Μέθοδος που τρέχει όταν πατηθεί το κουμπί της Δημιουργίας
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Object[] options1 = {"Αποθήκευση", "Ακύρωση"};

        JPanel panel = new JPanel();
        panel.add(new JLabel("Δώστε το όνομα της νέας λίστας αγαπημενων ταινιών:"));
        JTextField textField = new JTextField(10);
        panel.add(textField);

        int result = JOptionPane.showOptionDialog(this, panel, "Νέα κατηγορία αγαπημένων ταινιών",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, textField.getText());
        }
        String fvName = textField.getText();
        System.out.println(fvName);

        if ((fvName != null) && (fvName.length() > 0)) {

            saveNewFavorite(fvName);

            return;
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    // Μέθοδος που τρέχει όταν πατηθεί το κουμπί της Επεξεργασίας
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String oldName = jList1.getSelectedValue();

        Object[] options1 = {"Αποθήκευση", "Ακύρωση"};

        JPanel panel = new JPanel();
        panel.add(new JLabel("Δώστε το νέο όνομα της λίστας αγαπημενων ταινιών:"));
        JTextField textField = new JTextField(10);
        panel.add(textField);
        textField.setText(oldName);

        int result = JOptionPane.showOptionDialog(this, panel, "Επεξεργασία κατηγορίας αγαπημένων ταινιών",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
        
        String fvName = textField.getText();
        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, textField.getText());
            
            if ((fvName != null) && (!fvName.equals(oldName)) && (fvName.length() > 0)) {
                updateFavorite(oldName, fvName);
                return;
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Μέθοδος που τρέχει όταν πατηθεί το κουμπί της Διαγραφής
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        deleteFavorite();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<model.FavoriteList> favoriteListList;
    private javax.persistence.Query favoriteListQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private java.util.List<model.Movie> movieTableList;
    private javax.persistence.Query movieTableQuery;
    private javax.persistence.EntityManager myMoviesAMNPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables


    private void saveNewFavorite(String fvName) {

        DatabasesConnections m = new DatabasesConnections();
        mFavoriteList = m.saveNewFavorite(fvName);

//        jList1.removeAll();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        mFavoriteList.forEach((favorite) -> {
            listModel.addElement(favorite.getName());
        });
        jList1.setModel(listModel);

    }

    private void updateFavorite(String oldName, String updatedName) {

        DatabasesConnections m = new DatabasesConnections();
        mFavoriteList = m.updateFavorite(oldName, updatedName);

//        jList1.removeAll();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        mFavoriteList.forEach((favorite) -> {
            listModel.addElement(favorite.getName());
        });
        jList1.setModel(listModel);

        jButton3.setEnabled(false); // Απενεργοποιώ το κουμπί της Διαγραφής
    }

    private void deleteFavorite() {
        // Λίστα επιλεγμένων ταινιών
        List selectedNames = jList1.getSelectedValuesList();

        Object[] options1 = {"Διαγραφή", "Ακύρωση"};
        JPanel panel = new JPanel();
        panel.add(new JLabel("Σίγουρα διαγραφή των παρακάτω;"));

        // Δημιουργία λίστας ταινιών προς Διαγραφή και προσθήκη στο panel
        JList listToDelete = new JList(selectedNames.toArray());
        panel.add(listToDelete);

        int result = JOptionPane.showOptionDialog(this, panel, "Διαγραφή κατηγορίας αγαπημένων ταινιών",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);

        if (result == JOptionPane.YES_OPTION) {
            DatabasesConnections m = new DatabasesConnections();
            mFavoriteList = m.deleteFavorite(selectedNames);

            DefaultListModel<String> listModel = new DefaultListModel<>();
            mFavoriteList.forEach((favorite) -> {
                listModel.addElement(favorite.getName());
            });
            jList1.setModel(listModel);
            jButton3.setEnabled(false); // Απενεργοποιώ το κουμπί της Διαγραφής
        } else {
            return;
        }
    }

}
