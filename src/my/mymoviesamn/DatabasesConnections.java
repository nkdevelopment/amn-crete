package my.mymoviesamn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

import model.FavoriteList;

/**
 *
 * @author nekont
 */
public class DatabasesConnections {

    private static final String SERVICEURL = "http://api.themoviedb.org/3/";
    private static final String MYAPIKEY = "&api_key=52cae95ba786564836e9d738e0a0f439";
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

    //Επιστροφή λίστας Favorites από τη database.
    public List<FavoriteList> saveNewFavorite(String newFavoriteName) {
        try {
            FavoriteList newFavorite = new FavoriteList();
            newFavorite.setName(newFavoriteName);

            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(newFavorite);
//            em.merge(newFavorite);
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

}
