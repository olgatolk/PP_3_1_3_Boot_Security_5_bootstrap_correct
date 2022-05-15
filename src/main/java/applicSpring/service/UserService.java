package applicSpring.service;

import applicSpring.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User show(int id);
    void save(User user);
    void update(int id, User updatedUser);
    void delete(int id);
    public User findByEmail(String email);
}
