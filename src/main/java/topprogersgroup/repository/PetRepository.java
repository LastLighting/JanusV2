package topprogersgroup.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import topprogersgroup.entity.Bid;
import topprogersgroup.entity.Owner;
import topprogersgroup.entity.Pet;

import java.util.List;
import java.util.UUID;

/**
 * Created by aalle on 16.06.2017.
 */
public interface PetRepository extends JpaRepository<Pet,Integer> {
    List<Pet> findByIsDeletedAndIsLast(boolean isDeleted, boolean isLast);
    Pet findOneByGuidAndIsDeletedAndIsLast(String guid, boolean isDeleted, boolean isLast);
    List<Pet> findByIsDeletedAndIsLastAndOwnerId(boolean isDeleted, boolean isLast,Integer id);
}
