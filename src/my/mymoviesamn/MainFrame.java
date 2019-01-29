/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.mymoviesamn;

//import com.sun.xml.internal.ws.util.StringUtils;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.Genre;
import model.Movie;
import org.json.*;

/**
 *
 * @author nekont
 */
public class MainFrame extends javax.swing.JFrame {

    private EntityManagerFactory emf; // Το EntityManagerFactory
    public static EntityManager em; // Ο EntityManager

//    public static String myIcon = "themoviesdb_logo.jpg";
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        connectToDb(); // Σύνδεση με την βάση δεδομένων
        deleteTables();
        loadGenreTable();
//        getMovies();

        initComponents(); // Αρχικοποίηση του γραφικού περιβάλλοντος
        this.setLocationRelativeTo(null); // Παράθυρο εμφανίζεται στο κέντρο της οθόνης
//        jTable1.setVisible(false);
//        jPanel1.setVisible(false);
//        CommonMethods.getNewCurrentWeather(); //Διάβασε απο το Api για τον τρέχων καιρό
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
        movieQuery = java.beans.Beans.isDesignTime() ? null : myMoviesAMNPUEntityManager.createQuery("SELECT m FROM Movie m");
        movieList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(movieQuery.getResultList());
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("myMovies by Alexandra,Manolis,Nektarios");
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("movies.png")));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, movieList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${title}"));
        columnBinding.setColumnName("Title");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${genreId.id}"));
        columnBinding.setColumnName("Genre Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${releaseDate}"));
        columnBinding.setColumnName("Release Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${overview}"));
        columnBinding.setColumnName("Overview");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${rating}"));
        columnBinding.setColumnName("Rating");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${favoriteListId.id}"));
        columnBinding.setColumnName("Favorite List Id");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        jButton4.setText("Ανάκτηση και Αποθήκευση Δεδομένων Ταινιών");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Αναζήτηση Ταινιών");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Διαχείριση Λιστών Αγαπημένων Ταινιών");

        jButton7.setText("Στατιστικά");

        jButton8.setText("Έξοδος");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(235, 235, 235))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addGap(68, 68, 68)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        getMovies();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        String message = "Τερματισμός της εφαρμογής;";
        String title = "Μήνυμα επιβεβαίωσης";
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            //            JOptionPane.showMessageDialog(null, "Η εφαρμογή τερματίζεται!", "Ενημερωτικό μήνυμα", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else {
            //            JOptionPane.showMessageDialog(null, "Ο τερματισμός της εφαρμογής ακυρώθηκε!");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.util.List<model.Movie> movieList;
    private javax.persistence.Query movieQuery;
    private javax.persistence.EntityManager myMoviesAMNPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void connectToDb() {
        try {
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

    private void getMovies() {

        int numberOfPages = 1;
        String result = readFromURL("http://api.themoviedb.org/3/discover/movie?with_genres=28|10749|878&primary_release_date.gte=2000-01-01&api_key=52cae95ba786564836e9d738e0a0f439&language=el");
        try {
            JSONObject response = new JSONObject(result);
            numberOfPages = response.getInt("total_pages");
            System.out.println("numberOfPages= " + numberOfPages);
        } catch (JSONException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int m = 1; m <= 3; m++) {
            String resultPerPage = readFromURL("http://api.themoviedb.org/3/discover/movie?with_genres=28|10749|878&primary_release_date.gte=2000-01-01&api_key=52cae95ba786564836e9d738e0a0f439&language=el" + "&page=" + m);
            System.out.println("resultPerPage= " + resultPerPage);

            try {
                JSONObject response = new JSONObject(resultPerPage);

                JSONArray results = response.optJSONArray("results");
                Movie item;

                for (int i = 0; i < results.length(); i++) {
                    JSONObject aMovieObject = results.optJSONObject(i);
                    item = new Movie();
                    item.setId(aMovieObject.getInt("id"));
                    item.setTitle(aMovieObject.getString("title"));

                    JSONArray genre_ids = aMovieObject.optJSONArray("genre_ids");
                    for (int k = 0; k < genre_ids.length(); k++) {
                        if (genre_ids.getInt(k) == 28) {
                            item.setGenreId(new Genre(28));
                            break;
                        } else if (genre_ids.getInt(k) == 10749) {
                            item.setGenreId(new Genre(10749));
                            break;
                        } else if (genre_ids.getInt(k) == 878) {
                            item.setGenreId(new Genre(878));
                            break;
                        }
                    }

                    String releaseDateString = aMovieObject.getString("release_date");
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    Date releaseDate = new Date();
                    try {
                        releaseDate = df.parse(releaseDateString);
//                    String newDateString = df.format(releaseDate);
//                    System.out.println(newDateString);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    item.setReleaseDate(releaseDate);
                    item.setRating(aMovieObject.getDouble("vote_average"));
                    String s = aMovieObject.getString("overview");
                    if (s.length() >= 500) {
                        s = s.substring(0, 499);
                    }

                    item.setOverview(s);
//                item.setImage("http://image.tmdb.org/t/p/w185/" + aMovieObject.getString("poster_path"));

//                System.out.println("id= " + item.getId() + ", title= " + item.getTitle() + ", release_date= " + item.getReleaseDate());
                    if (!em.getTransaction().isActive()) {
                        em.getTransaction().begin();
                    }
                    em.merge(item);
                    em.flush();
                    em.getTransaction().commit();
                }
            } catch (JSONException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        String message = "Τα δεδομένα κατέβηκαν και αποθηκεύτηκαν στη Βάση Δεδομένων";
        String title = "Μήνυμα ενημέρωσης";
        JOptionPane.showMessageDialog(null,  message, title,  JOptionPane.INFORMATION_MESSAGE);
    }
    //μέθοδος ανάγνωσης URL του api και επιστροφής σε string το αποτέλεσμα

    public static String readFromURL(String webPage) {
        StringBuffer sb = new StringBuffer();

        try {
            //δημιουργία url από string
            URL uri = new URL(webPage);
            //σύνδεση με το url
            URLConnection urlConnection = uri.openConnection();
            //γέφυρα μετατροπής από bytes σε chars του αποτελέσματος
            InputStreamReader isr;
            try (InputStream is = urlConnection.getInputStream()) {
                isr = new InputStreamReader(is);
                int numCharsRead;
                char[] charArray = new char[1024];
                while ((numCharsRead = isr.read(charArray)) > 0) {
                    sb.append(charArray, 0, numCharsRead);
                }
            }
            //κλείσιμο της γέφυρας
            isr.close();
        } catch (IOException e) { //αν δεν μπορεί να κάνει την μετατροπή
            System.err.println(e.toString());
        }
        //επιστροφή του αποτελέσματος σε string
        return sb.toString();
    }

    private void loadGenreTable() {

        String resultGenres = readFromURL("http://api.themoviedb.org/3/genre/movie/list?api_key=52cae95ba786564836e9d738e0a0f439");

        try {
            JSONObject response = new JSONObject(resultGenres);
            JSONArray genres = response.optJSONArray("genres");
            Genre genre;
            for (int i = 0; i < genres.length(); i++) {
                JSONObject aGenreObject = genres.optJSONObject(i);
                genre = new Genre();
                genre.setId(aGenreObject.getInt("id"));
                genre.setName(aGenreObject.getString("name"));
                if (aGenreObject.getInt("id") == 28 || aGenreObject.getInt("id") == 10749 || aGenreObject.getInt("id") == 878) {
                    if (!em.getTransaction().isActive()) {
                        em.getTransaction().begin();
                    }
                    em.merge(genre);
                    em.flush();
                    em.getTransaction().commit();
//                    System.out.println("id= " + genre.getId() + ", name= " + genre.getName());
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void deleteTables() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/myMoviesDB", "pli24", "pli24");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            Statement stmt = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();

           

            ResultSet rs2 = dbm.getTables(null, null, "GENRE", null);
            if (rs2.next()) {
                System.out.println("Table exists");
                stmt.executeUpdate("DELETE FROM MOVIE");
                stmt.executeUpdate("DELETE FROM GENRE");
            } else {
                System.out.println("Table does not exist");
                stmt.execute("CREATE TABLE GENRE (id integer PRIMARY KEY NOT NULL,name varchar(20))");
            }

            ResultSet rs3 = dbm.getTables(null, null, "FAVORITE_LIST", null);
            if (rs3.next()) {
                System.out.println("Table exists");
                stmt.executeUpdate("DELETE FROM FAVORITE_LIST");
            } else {
                System.out.println("Table does not exist");
                stmt.execute("CREATE TABLE FAVORITE_LIST (id integer PRIMARY KEY NOT NULL, name varchar(50))");
            }
            
             ResultSet rs1 = dbm.getTables(null, null, "MOVIE", null);
            if (rs1.next()) {
                System.out.println("Table exists");
                stmt.executeUpdate("DELETE FROM MOVIE");
            } else {
                System.out.println("Table does not exist");
                stmt.execute("CREATE TABLE MOVIE (id integer PRIMARY KEY NOT NULL,title varchar (100) NOT NULL,genre_id integer,release_date date,rating float,overview varchar (500),favorite_list_id integer,FOREIGN KEY(genre_id) REFERENCES GENRE(id),FOREIGN KEY(favorite_list_id) REFERENCES FAVORITE_LIST(id))");
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
