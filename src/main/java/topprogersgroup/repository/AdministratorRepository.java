package topprogersgroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import topprogersgroup.entity.Administrator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    List<Administrator> findByIsDeleted(boolean isDeleted);
    Administrator findByIdAndIsDeleted(int id, boolean isDeleted);

}
