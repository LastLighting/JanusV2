package topprogersgroup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.Owner;
import topprogersgroup.entity.RegistrationForm;
import topprogersgroup.entity.User;
import topprogersgroup.entity.UserCreateForm;
import topprogersgroup.repository.UserRepository;
import topprogersgroup.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmailAndIsDeleted(email, false);
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findUserByIdAndIsDeleted(id, false);
    }

    public Optional<User> getUserByRole(String role) {
        return userRepository.findUserByRoleAndIsDeleted(role, false);
    }

    public User create(UserCreateForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }

    public void delete(User user) {
        user.setDeleted(true);
        userRepository.save(user);
    }
}
