package topprogersgroup.service;

import org.springframework.data.domain.Pageable;
import topprogersgroup.entity.CheckPoint;
import topprogersgroup.entity.Owner;
import topprogersgroup.entity.Pet;

import java.util.List;

/**
 * Created by aalle on 16.06.2017.
 */
public interface PetService {

    Pet save(Pet pet);

    Pet findOne(Integer id);

    List<Pet> findPetsByOwner(Integer id);

    List<Pet> findAllIsDeleted();

    List<Pet> findAllIsNotDeleted();

    List<Pet> findIsLastPetByOwner(Integer id);

    Pet update(Pet pet);

    void delete(Pet pet);
}
