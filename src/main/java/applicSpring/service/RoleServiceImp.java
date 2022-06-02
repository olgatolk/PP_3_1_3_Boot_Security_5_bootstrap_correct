package applicSpring.service;

import applicSpring.dao.RoleRepository;
import applicSpring.models.Role;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Data
@Service
public class RoleServiceImp implements RoleService{

    private RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

//    @Override
 /*   public void addRole(Role role) {
        roleRepository.save(role);
    }*/
    @Override
    public Set<Role> getAllRoles() {
        Set<Role> roles = new HashSet<>();
        roles.addAll(roleRepository.findAll());
        return roles;
    }
}
