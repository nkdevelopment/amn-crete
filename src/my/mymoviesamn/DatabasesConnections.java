package my.mymoviesamn;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.FavoriteList;
import model.Genre;
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
    
    
     public void loadGenreTable() {
        
        String localURL = "genre/movie/list";
        String resultGenres = readFromURL(BASE_URL+localURL+AMN_API_KEY);

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
     
}
