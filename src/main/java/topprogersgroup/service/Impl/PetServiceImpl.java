package topprogersgroup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.Pet;
import topprogersgroup.repository.OwnerRepository;
import topprogersgroup.repository.PetRepository;
import topprogersgroup.service.OwnerService;
import topprogersgroup.service.PetService;

import java.util.List;
import java.util.UUID;

/**
 * Created by aalle on 16.06.2017.
 */
@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerService ownerService;

    @Override
    public Pet save(Pet pet) {
        UUID uuid = UUID.randomUUID();
        pet.setGuid(uuid);
        return petRepository.save(pet);
    }

    @Override
    public Pet findOne(Integer id) {
        return petRepository.findOne(id);
    }

    @Override
    public List<Pet> findPetsByOwner(Integer id) {
        return ownerService.findOne(id).getPet();
    }

    @Override
    public List<Pet> findAllIsDeleted() {
        return petRepository.findByIsDeletedAndIsLast(true, true);
    }

    @Override
    public List<Pet> findAllIsNotDeleted() {
        return petRepository.findByIsDeletedAndIsLast(false, true);
    }

    @Override
    public Pet update(Pet pet) {
        pet.setLast(false);
        petRepository.save(pet);
        pet.setId(0);
        pet.setLast(true);
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        pet.setDeleted(true);
        petRepository.save(pet);
    }
}
