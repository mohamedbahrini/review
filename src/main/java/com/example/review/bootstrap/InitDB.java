package com.example.review.bootstrap;

import com.example.review.model.Review;
import com.example.review.model.Role;
import com.example.review.model.RoleName;
import com.example.review.model.User;
import com.example.review.repository.ReviewRepository;
import com.example.review.service.IRoleService;
import com.example.review.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InitDB implements CommandLineRunner {
    private ReviewRepository reviewRepository;
    private IRoleService roleService;
    private IUserService userService;

    @Autowired
    public InitDB(ReviewRepository reviewRepository, IRoleService roleService, IUserService userService) {
        this.reviewRepository = reviewRepository;
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<RoleName> roles = Arrays.asList(RoleName.ROLE_ADMIN, RoleName.ROLE_USER);
        createRoles(roles);
        createUser();
        createReviews();
    }

    private void createReviews() {
        reviewRepository.save(new Review(null, "4", "1"));
        reviewRepository.save(new Review(null, "3", "1"));
        reviewRepository.save(new Review(null, "5", "1"));
        reviewRepository.save(new Review(null, "4", "2"));
    }

    void createRoles(List<RoleName> roleNames) {
        roleNames.forEach(roleName -> roleService.saveRole(new Role(roleName)));
    }

    void createUser() {
        User user = new User();
        user.setUsername("mohamed");
        user.setFirstname("Mohamed");
        user.setLastname("BAHRINI");
        user.setEmail("email@gmail.com");
        user.setPassword("12345");
        user.setEnabled(true);
        user.setRoles(roleService.getAllRoles().stream().collect(Collectors.toSet()));

        userService.saveUser(user);
    }
}
