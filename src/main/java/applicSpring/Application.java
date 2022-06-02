package applicSpring;

import applicSpring.dao.RoleRepository;
import applicSpring.dao.UserRepository;
import applicSpring.models.Role;
import applicSpring.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner setFirstData(UserRepository userRepository, RoleRepository roleRepository) {

        return args -> {
            Role roleAdmin;
            Role roleUser;


            if (!roleRepository.existsRoleByName("ROLE_ADMIN")) {
                roleAdmin = roleRepository.save(new Role("ROLE_ADMIN"));
            } else {
                roleAdmin = roleRepository.findRoleByName("ROLE_ADMIN");
            }
            if (!roleRepository.existsRoleByName("ROLE_USER")) {
                roleUser = roleRepository.save(new Role("ROLE_USER"));
            } else {
                roleUser = roleRepository.findRoleByName("ROLE_USER");
            }

            Set<Role> roles = Stream.of(roleAdmin, roleUser).collect(Collectors.toSet());

            if (!userRepository.existsUserByEmail("admin@mail.com")) {
                User userAdmin = new User("Admin", "Adminov", 22,
                        "admin@mail.com");
                userAdmin.setPassword(new BCryptPasswordEncoder().encode("admin"));
                userAdmin.setRoles(roles);
                userRepository.save(userAdmin);
            }
        };
    }
}