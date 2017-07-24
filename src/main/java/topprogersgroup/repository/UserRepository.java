package topprogersgroup.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import topprogersgroup.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmailAndIsDeleted(String email, boolean isDeleted);
    Optional<User> findUserByIdAndIsDeleted(int id, boolean isDeleted);
    Optional<User> findUserByRoleAndIsDeleted(String role, boolean isDeleted);
}
