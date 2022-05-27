package applicSpring.dao;

import applicSpring.models.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    public User findByEmail(String email) {
         Query query =  entityManager.createQuery("SELECT u FROM User u WHERE u.email=:email", User.class);
         query.setParameter("email", email);
         User user = (User) query.getSingleResult();
         return user;
    }
    //entityManager.createQuery("SELECT email AS username,password FROM User WHERE email=#{username}", User.class);
    //  User user = entityManager.find(User.class, email);
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
        userToBeUpdated.setFirstName(updatedUser.getFirstName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
        userToBeUpdated.setPassword(updatedUser.getPassword());
   }

    public  void delete(int id) {
         entityManager.remove(show(id));
    }
}
