package applicSpring.dao;

import applicSpring.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    boolean existsRoleByName(String name);
    Role findRoleByName(String name);
}
