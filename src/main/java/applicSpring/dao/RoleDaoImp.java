package applicSpring.dao;

import applicSpring.models.Role;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class RoleDaoImp implements RoleDao{
    @PersistenceContext
    private EntityManager entityManager;

    public List<Role> getAllRoles() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }
    public Role findRoleByName(String name) {
        Query query =  entityManager.createQuery("SELECT r FROM Role r WHERE r.name=:name", Role.class);
        query.setParameter("name", name);
        Role role = (Role) query.getSingleResult();
        return role;
    }

}
