package com.andymitchell.divedb.logic.user;

import com.andymitchell.divedb.logic.role.Role;
import com.andymitchell.divedb.logic.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private UserRoleRepository userRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserRoleRepository userRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User validateUser (User user) {
        User userByEmail = findUserByEmail(user.getEmail());

        if (userByEmail != null &&
                bCryptPasswordEncoder.matches(user.getPassword(), userByEmail.getPassword())) {
            return userByEmail;
        } else {
            return null;
        }
    }

    @Transactional
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");

        User savedUser = userRepository.save(user);
        userRoleRepository.addUserRoleLink(savedUser.getId(),userRole.getId());
    }
}
