/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.mymoviesamn;

//import com.sun.xml.internal.ws.util.StringUtils;
import java.awt.Dimension;
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
import javax.swing.JInternalFrame;
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

        myMoviesAMNPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("myMoviesAMNPU").createEntityManager();
        movieQuery = java.beans.Beans.isDesignTime() ? null : myMoviesAMNPUEntityManager.createQuery("SELECT m FROM Movie m");
        movieList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(movieQuery.getResultList());
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("myMovies");
        setAlwaysOnTop(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("movies.png")));

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
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Στατιστικά");

        jButton8.setText("Έξοδος");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(42, 42, 42)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addGap(83, 83, 83)
                .addComponent(jButton8)
                .addGap(155, 155, 155))
        );

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("ΠΛΗ 24 - ΗΛΕ 1");

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Πούλιου Αλεξάνδρα, Μακαρώνας Εμμανουήλ, Κοντολαιμάκης Νεκτάριος");

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("...ημερομηνία...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jMenu1.setText("Ανάκτηση και Αποθήκευση Δεδομένων Ταινιών");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Διαχείριση Λιστών Αγαπημένων Ταινιών");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Αναζήτηση Ταινιών");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Στατιστικά");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Έξοδος");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDesktopPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
        int reply = JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            //            JOptionPane.showMessageDialog(null, "Η εφαρμογή τερματίζεται!", "Ενημερωτικό μήνυμα", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else {
            //            JOptionPane.showMessageDialog(null, "Ο τερματισμός της εφαρμογής ακυρώθηκε!");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        favoritesForm();
               
    }//GEN-LAST:event_jButton6ActionPerformed

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
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private java.util.List<model.Movie> movieList;
    private javax.persistence.Query movieQuery;
    private javax.persistence.EntityManager myMoviesAMNPUEntityManager;
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
        JOptionPane.showMessageDialog(this,  message, title,  JOptionPane.INFORMATION_MESSAGE);
        
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
    
    //Φόρμα "Ο Καιρός τώρα"
    private void favoritesForm(){
        JInternalFrame_Favorites fFavorites = new JInternalFrame_Favorites();   
//        FormCurrentWeather fCurrent = new FormCurrentWeather();

        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = fFavorites.getSize();
        fFavorites.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                (desktopSize.height - jInternalFrameSize.height)/2);
        fFavorites.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        jDesktopPane1.add(fFavorites);
        fFavorites.setVisible(true);  
    }
}
