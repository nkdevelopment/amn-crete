package my.mymoviesamn;

import java.awt.Container;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.border.Border;

import model.FavoriteList;
import model.Genre;
import model.Movie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author amn
 */
public class DatabasesConnections {

    private static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static final String AMN_API_KEY = "api_key=52cae95ba786564836e9d738e0a0f439";
    private final EntityManager em;

    // constructor
    public DatabasesConnections() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myMoviesAMNPU");
        this.em = emf.createEntityManager();
    }

    //Επιστροφή λίστας Favorites από τη database.
    public List<FavoriteList> loadFavorites() {
        try {
            Query q = em.createQuery("SELECT f FROM FavoriteList f");
            List<FavoriteList> mFavorites = q.getResultList();
            return mFavorites; // επιστροφή λίστας FavoriteList
        } catch (Exception e) {
            System.out.println("Error: Check database connection.");
            return null;
        }
    }

    //Επιστροφή λίστας που περιλαμβάνει το νέο σωσμένο Favorite
    public List<FavoriteList> saveNewFavorite(String newFavoriteName) {
        try {
            FavoriteList newFavorite = new FavoriteList(); // νέο αντικείμενο FavoriteList
            newFavorite.setName(newFavoriteName); // δώσε το όνομα στο νέο FavoriteList
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(newFavorite); // πρόσθεσε στη ΒΔ το νέο αντικείμενο
            em.merge(newFavorite);
            em.getTransaction().commit();

            // Πάρε τη λίστα με όλα τα FavoriteList 
            Query q = em.createQuery("SELECT f FROM FavoriteList f");
            List<FavoriteList> mFavorites = q.getResultList();
            return mFavorites; // επέστρεψε τη νέα λίστα με όλα τα FavoriteList
        } catch (Exception e) {
            System.out.println("Error: Check database connection.");
            return null;
        }
    }

    // Επιστροφή λίστας με αλλαγμένο Favorite από τη database.
    public List<FavoriteList> updateFavorite(String oldName, String newName) {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            // Επέλεξε το FavoriteList με το παλιό όνομα oldName
            Query q1 = em.createNativeQuery("SELECT ID FROM FAVORITE_LIST WHERE NAME= '" + oldName + "'");
            List r1 = q1.getResultList(); // Πάρε τη λίστα του αποτελέσματος του query
            FavoriteList fl1 = em.find(FavoriteList.class, r1.get(0)); // Πάρε το 1ο FavoriteList της λίστας
            fl1.setName(newName); // όρισε το νέο όνομα του favoriteList
            em.getTransaction().commit();

            // Πάρε τη λίστα με όλα τα FavoriteList 
            Query q = em.createQuery("SELECT f FROM FavoriteList f");
            List<FavoriteList> mFavorites = q.getResultList();
            return mFavorites; // επέστρεψε τη νέα λίστα με όλα τα FavoriteList
        } catch (Exception e) {
            System.out.println("Error: Check database connection.");
            return null;
        }
    }

    //Επιστροφή λίστας που δεν περιλαμβάνει το διαγραμμένο Favorite
    public List<FavoriteList> deleteFavorite(List selectedNames) {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }

            // εκτέλεσε βρόγχο επανάληψης ανάμεσα σε όλα τα επιλεγμένα favoriteLists
            for (int i = 0; i < selectedNames.size(); i++) {

                // Αποσυσχέτιση ταινιών από τη συγκεκριμένη Favorite List (i)
                // query λήψης του id της favoriteList που επιλέχθηκε
                Query queryMovies = em.createNativeQuery("SELECT ID FROM FAVORITE_LIST WHERE NAME= '" + selectedNames.get(i) + "'");
                List moviesList = queryMovies.getResultList();
                String stringId = moviesList.get(0).toString(); // πάρε το id σε μορφή string
                // query λήψης όλων των ταινιών με το συγκεκριμένο id στο favorite_list_id
                Query q1 = em.createQuery("SELECT m FROM Movie m WHERE m.favoriteListId.id = " + stringId);
                List<Movie> moviesToChange = q1.getResultList();
                for (Movie movie : moviesToChange) {
                    movie.setFavoriteListId(null); // κάνε null το favorite_list_id τηε ταινίας (αποσυσχέτιση)
                }

                // Τώρα Διαγραφή Λίστας Αγαπημένων
                Query query = em.createNativeQuery("SELECT ID FROM FAVORITE_LIST WHERE NAME= '" + selectedNames.get(i) + "'");
                List results = query.getResultList();
                FavoriteList fl = em.find(FavoriteList.class, results.get(0));
                em.remove(fl); // διαγραφή FavoriteList fl
            }
            em.getTransaction().commit();

            // Λήψη και επιστροφή της νέας λίστας FavoriteList για εμφάνιση
            Query q = em.createQuery("SELECT f FROM FavoriteList f");
            List<FavoriteList> mFavorites = q.getResultList();
            return mFavorites;
        } catch (Exception e) {
            System.out.println("Error: Check database connection.");
            return null;
        }
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

    // Λήψη διαθέσιμων ειδών ταινιών στον πίνακα GENRE
    public void loadGenreTable() {

        String localURL = "genre/movie/list?";
        String resultGenres = readFromURL(BASE_URL + localURL + AMN_API_KEY);

        // προσπάθεια ανάγνωσης του json αρχείου
        try {
            JSONObject response = new JSONObject(resultGenres);
            JSONArray genres = response.optJSONArray("genres");
            Genre genre;
            for (int i = 0; i < genres.length(); i++) {
                JSONObject aGenreObject = genres.optJSONObject(i);
                genre = new Genre();
                genre.setId(aGenreObject.getInt("id"));
                genre.setName(aGenreObject.getString("name"));
                // εάν το genreId είναι 28 ή 10749 ή 878 κάνε τα παρακάτω
                if (aGenreObject.getInt("id") == 28 || aGenreObject.getInt("id") == 10749 || aGenreObject.getInt("id") == 878) {
                    if (!em.getTransaction().isActive()) {
                        em.getTransaction().begin();
                    }
                    em.merge(genre); // πρόσθεσε το genre στον πίνακα Genre
                    em.flush();
                    em.getTransaction().commit();
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
// Διαγραφή της Βάσης Δεδομένων
    public void clearDatabase() {
        // queries αδειάζματος πινάκων της ΒΔ
        Query deleteFavorites = em.createQuery("DELETE FROM FavoriteList");
        Query deleteMovies = em.createQuery("DELETE FROM Movie");
        Query deleteGenres = em.createQuery("DELETE FROM Genre");

        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }

        deleteMovies.executeUpdate(); // Διαγραφή (άδειασμα) πίνακα Movie
        System.out.println("Movie table deleted");
        deleteFavorites.executeUpdate(); // Διαγραφή (άδειασμα) πίνακα FavoriteList
        System.out.println("Favorite list table deleted");
        deleteGenres.executeUpdate(); // Διαγραφή (άδειασμα) πίνακα Genre
        System.out.println("Genres table deleted");

        em.flush();
        em.getTransaction().commit();
    }

    // Λήψη δεδομένων ταινιών και αποθήκευση στον πίνακα MOVIES
    public boolean getMovies(MainFrame aThis) {

        // Αρχικές ρυθμίσεις για το παράθυρο downloading f...
        JWindow f = new JWindow();
        f.setAlwaysOnTop(true);
        Container content = f.getContentPane(); // λήψη του container του f
        JProgressBar progressBar = new JProgressBar(); // δημιουργία JProgressBar
        progressBar.setValue(0); // αρχική τιμή progressBar
        progressBar.setStringPainted(true);
        Border border = BorderFactory.createTitledBorder("Downloading...");
        progressBar.setBorder(border);
        content.add(progressBar); // προσθήκη progressBar στο content
        f.setSize(300, 60); // ορισμός μεγέθους f
        f.setLocationRelativeTo(null);
        f.setVisible(true); // κάνε ορατό το f

        // Υπολογίζω τον συνολικό αριθμό των σελίδων του αποτελέσματος

        int maxpages = 20; // αριθμός σελίδων (pages) που θα γίνουν download

        // βρόγχος διαβάσματος κάθε σελίδας 
        for (int m = 1; m <= maxpages; m++) {

            // ενημέρωση progressBar downloading
            progressBar.setValue((100 / maxpages) * m);
            progressBar.update(progressBar.getGraphics());

            // το κείμενο της σελίδας m που διαβάζω
            String resultPerPage = readFromURL(BASE_URL + "discover/movie?with_genres=28|10749|878&primary_release_date.gte=2000-01-01&" + AMN_API_KEY + "&language=el" + "&page=" + m);
            System.out.println("resultPerPage= " + resultPerPage);

            // προσπάθεια διαβάσματος αρχείου json και ανάκτησης απαραίτητων πληροφοριών
            // για δημιουργία και σώσιμο στην ΒΔ αντικειμένου Movie (item)
            try {
                JSONObject response = new JSONObject(resultPerPage);

                JSONArray results = response.optJSONArray("results");
                Movie item; // αντικείμενο Movie

                for (int i = 0; i < results.length(); i++) {
                    JSONObject aMovieObject = results.optJSONObject(i);
                    item = new Movie();
                    item.setId(aMovieObject.getInt("id")); // διάβασε και δώσε το id στο αντικείμενο item
                    item.setTitle(aMovieObject.getString("title")); // διάβασε και δώσε το title στο αντικείμενο item

                    // Ανάλογα τον αριθμό του genre_ids όρισε το Genre του αντικειμένου item
                    JSONArray genre_ids = aMovieObject.optJSONArray("genre_ids");
                    OUTER:
                    for (int k = 0; k < genre_ids.length(); k++) {
                        switch (genre_ids.getInt(k)) {
                            case 28:
                                item.setGenreId(new Genre(28));
                                break OUTER;
                            case 10749:
                                item.setGenreId(new Genre(10749));
                                break OUTER;
                            case 878:
                                item.setGenreId(new Genre(878));
                                break OUTER;
                            default:
                                break;
                        }
                    }

                    // Διάβασε τη release_date και κάνε την string
                    String releaseDateString = aMovieObject.getString("release_date");
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    Date releaseDate = new Date();
                    try {
                        releaseDate = df.parse(releaseDateString);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    item.setReleaseDate(releaseDate); // διάβασε και δώσε το releaseDate στο item
                    item.setRating(aMovieObject.getFloat("vote_average")); // διάβασε και δώσε το vote_average στο item
                    String s = aMovieObject.getString("overview"); // διάβασε το overview
                    if (s.length() >= 500) { // αν το μήκος είναι μεγαλύτερο από 500 χαρακτήρες
                        s = s.substring(0, 499); // κράτησε τους 500 πρώτους χαρακτήρες
                    }

                    item.setOverview(s); // δώσε το overview στο item
                    if (!em.getTransaction().isActive()) {
                        em.getTransaction().begin();
                    }

                    em.merge(item); // πρόσθεσε το item στον πίνακα Movie
                    em.flush();
                    em.getTransaction().commit();
                }
            } catch (JSONException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        f.setVisible(false);
        f.dispose();

        return true;
    }

    // Η μέθοδος επιστρέφει τις ταινίες που περιέχει η επιλεγμένη Λίστα αγαπημένων
    List<Movie> loadFavoritesListMovies(List selected) {

        // εύρεση του id της λίστας αγαπημένων που έχουμε επιλέξει
        Query query = em.createNativeQuery("SELECT ID FROM FAVORITE_LIST WHERE NAME= '" + selected.get(0) + "'");
        List results = query.getResultList();

        // Δημιουργία query που επιστρέφει όλες τις ταινίες που έχουν favorite_list_id το παραπανω id
        String stringId = results.get(0).toString();
        Query q1 = em.createQuery("SELECT m FROM Movie m WHERE m.favoriteListId.id = " + stringId);

        return q1.getResultList(); // επιστροφή της λίστας των ταινιών 
    }

}