package cv.opencv5.service.init;

import cv.opencv5.models.entities.UserEntity;
import cv.opencv5.models.entities.UserRoleEntity;
import cv.opencv5.models.enums.UserRoleEnum;
import cv.opencv5.repository.UserRepository;
import cv.opencv5.repository.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InitService {

    private UserRoleRepository userRoleRepository;
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public InitService(UserRoleRepository userRoleRepository,
                       UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       @Value("${app.default.password}") String defaultPassword) {
        //this @Value above is taken from the application properties file. It is defined there
        //with the "app.default.password" key
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }


    @PostConstruct
    public void init() {
        initRoles();
        initUsers();
    }

    private void initRoles() {
        if (userRoleRepository.count() == 0) {

            var userRole = new UserRoleEntity().setRole(UserRoleEnum.USER);
            var adminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);

            userRoleRepository.save(userRole);
            userRoleRepository.save(adminRole);


        }
    }

    private void initUsers() {
        if (userRepository.count() == 0) {
            initAdmin();
            initHrUser();
        }
    }


    private void initAdmin() {

        List<UserRoleEntity> listWithOnerole = new ArrayList<>();
        //UserRoleEntity userRoleEntity = new UserRoleEntity();

        Optional<UserRoleEntity> userRoleEntityByRole =
                userRoleRepository
                        .findUserRoleEntityByRole(UserRoleEnum.ADMIN);

        listWithOnerole.add(userRoleEntityByRole.orElse(null));
        //System.out.println();

        UserEntity adminUser = new UserEntity();
        adminUser.setUsername("admin");
        adminUser.setPassword(passwordEncoder.encode("topsecret"));
        adminUser.setRoles(listWithOnerole);

        userRepository.save(adminUser);
    }

    private void initHrUser(){

        List<UserRoleEntity> listWithOnerole = new ArrayList<>();
        Optional<UserRoleEntity> userRoleEntityByRole =
                userRoleRepository
                        .findUserRoleEntityByRole(UserRoleEnum.USER);

        listWithOnerole.add(userRoleEntityByRole.orElse(null));

        UserEntity hrUser = new UserEntity();
        hrUser.setUsername("hr1010");
        hrUser.setPassword(passwordEncoder.encode("topsecret"));
        hrUser.setRoles(listWithOnerole);

        userRepository.save(hrUser);
    }

}
