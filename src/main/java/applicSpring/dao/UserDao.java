package applicSpring.dao;

import applicSpring.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User show(int id);
    void save(User user);
    void update(int id, User updatedUser);
    void delete(int id);
    public User findByEmail(String email);
}
