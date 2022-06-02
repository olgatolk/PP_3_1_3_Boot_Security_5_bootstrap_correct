package applicSpring.service;

import applicSpring.dao.UserRepository;
import applicSpring.models.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class UserServiceImp implements UserService{

    final UserRepository userRepository;
    final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImp(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public boolean editUser (User user) {
        User userFromDB = userRepository.findByEmail(user.getEmail());
        if (userFromDB != null) {
            return true;
        }
        if ((user.getPassword()).equals(userFromDB.getPassword())
                || user.getPassword() == null) {
            user.setPassword(userFromDB.getPassword());
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));}
        userRepository.save(user);
        return true;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    @Override
    public  boolean deleteUserByEmail(String email) {
        if (userRepository.findByEmail(email) != null) {
            userRepository.deleteById(userRepository.findByEmail(email).getId());
            return true;
        }
        return false;
    }
    @Override
     public  boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public User findByEmail(String email) {
       // Optional<User> userOptional1 = userRepository.findByEmail(email);
       // return userOptional1.orElse(new User());
        return userRepository.findByEmail(email);
    } //в примере по-другому, через Optional

    @Transactional
    @Override
    public User findById(Long id) {
        Optional<User> userOptional= userRepository.findById(id);
    return userOptional.orElse(new User());}
}
