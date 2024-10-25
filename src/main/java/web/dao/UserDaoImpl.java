package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "getEntityManagerFactory")
    private EntityManager entityManager;

    public void add(User user) {
        entityManager.persist(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    public User getUserById(int id) {
        return entityManager.find(User.class, id );
    }

    public void update(User user, int id) {
        User updUser = getUserById(id);
        updUser.setFirstName(user.getFirstName());
        updUser.setLastName(user.getLastName());
        updUser.seteMail(user.geteMail());
    }

    public void deleteUser(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }
}
