package applicSpring.dao;

import applicSpring.models.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Transactional
@Component
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public User show(int id) {
        return (User) entityManager.find(User.class, id);
    }

    public void save(User user) {
        Integer id = user.getId();
        if (id == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
   }

    public  void delete(int id) {
         entityManager.remove(show(id));
    }
}
