package applicSpring.dao;

import applicSpring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN FETCH u.roles r WHERE u.email=:email")
    User findByEmail(String email);

    List<User> findAll();
    boolean existsUserByEmail (String email);
}
