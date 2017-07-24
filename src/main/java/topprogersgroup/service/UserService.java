package topprogersgroup.service;

import topprogersgroup.entity.RegistrationForm;
import topprogersgroup.entity.User;
import topprogersgroup.entity.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserById(int id);
    User create(UserCreateForm form);
}
