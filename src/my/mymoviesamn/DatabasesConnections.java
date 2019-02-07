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
}
