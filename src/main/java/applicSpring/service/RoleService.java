package applicSpring.service;

import applicSpring.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role findRoleByName(String name);
   /* User show(int id);
    void save(User user);
    void update(int id, User updatedUser);
    void delete(int id);
    public User findByEmail(String email);*/
}
