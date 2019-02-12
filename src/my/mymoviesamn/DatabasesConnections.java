package my.mymoviesamn;

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
import javax.swing.JOptionPane;

import model.FavoriteList;
import model.Genre;
import model.Movie;
import static my.mymoviesamn.MainFrame.em;
import static my.mymoviesamn.MainFrame.readFromURL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author nekont
 */
public class DatabasesConnections {

    private static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static final String AMN_API_KEY = "?api_key=52cae95ba786564836e9d738e0a0f439";
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
            return mFavorites;
        } catch (Exception e) {
            System.out.println("Error: Check database connection.");
            return null;
        }
    }

    //Επιστροφή λίστας που περιλαμβάνει το νέο Favorite
    public List<FavoriteList> saveNewFavorite(String newFavoriteName) {
        try {
            FavoriteList newFavorite = new FavoriteList();
            newFavorite.setName(newFavoriteName);
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(newFavorite);
            em.merge(newFavorite);
//            em.flush();
            em.getTransaction().commit();

            Query q = em.createQuery("SELECT f FROM FavoriteList f");
            List<FavoriteList> mFavorites = q.getResultList();
            return mFavorites;
        } catch (Exception e) {
            System.out.println("Error: Check database connection.");
            return null;
        }
    }

    //Επιστροφή λίστας με αλλαγμένο Favorite από τη database.
    public List<FavoriteList> updateFavorite(String oldName, String newName) {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            Query q1 = em.createNativeQuery("SELECT ID FROM FAVORITE_LIST WHERE NAME= '" + oldName + "'");
            List r1 = q1.getResultList();
            FavoriteList fl1 = em.find(FavoriteList.class, r1.get(0));
            fl1.setName(newName);
            em.getTransaction().commit();

            Query q = em.createQuery("SELECT f FROM FavoriteList f");
            List<FavoriteList> mFavorites = q.getResultList();
            return mFavorites;
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
            for (int i = 0; i < selectedNames.size(); i++) {
                Query query = em.createNativeQuery("SELECT ID FROM FAVORITE_LIST WHERE NAME= '" + selectedNames.get(i) + "'");
//            Query query = em.createNamedQuery("FavoriteList.findByName").setParameter("name", name);
                List results = query.getResultList();
                FavoriteList fl = em.find(FavoriteList.class, results.get(0));
                em.remove(fl);
            }
            em.getTransaction().commit();

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

        String localURL = "genre/movie/list";
        String resultGenres = readFromURL(BASE_URL + localURL + AMN_API_KEY);

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

    // Λήψη δεδομένων ταινιών και αποθήκευση στον πίνακα MOVIES
    public boolean getMovies() {

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
        
        boolean downloaded = true;
        
        return downloaded;

    }

}
