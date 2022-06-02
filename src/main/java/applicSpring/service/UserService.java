package applicSpring.service;

import applicSpring.models.User;
import java.util.List;

public interface UserService {
    List<User> getAll();
    void saveUser(User user);
    boolean editUser(User user);
    boolean deleteUser(Long userId);
    User findByEmail(String email);
    User findById(Long id);
    boolean deleteUserByEmail(String email);
}
