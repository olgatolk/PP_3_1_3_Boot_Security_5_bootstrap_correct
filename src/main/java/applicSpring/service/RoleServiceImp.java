package applicSpring.service;

import applicSpring.dao.RoleDao;
import applicSpring.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService{

    private RoleDao roleDao;
    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Role findRoleByName(String name) {
        return roleDao.findRoleByName(name);
    }


}
