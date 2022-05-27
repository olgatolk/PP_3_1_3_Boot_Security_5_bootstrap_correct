package applicSpring.controllers;


import applicSpring.models.Role;
import applicSpring.models.User;
import applicSpring.service.RoleService;
import applicSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/admin")
//@Secured
public class UsersController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UsersController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    //@Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String index(Model model){
        model.addAttribute("users", userService.getAll());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create (@ModelAttribute("user") User user,
                          @RequestParam(value = "role") String selectResult) {
        Collection<Role> roles = null;
        roles.add(roleService.findRoleByName(selectResult));
        user.setRoles(roles);
        userService.save(user);

        return "redirect:/admin";
    }
   /* @PostMapping
    public String create (@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    */

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/admin";
    }

    @GetMapping ("delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}

