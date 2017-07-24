package topprogersgroup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.Passport;
import topprogersgroup.entity.Pet;
import topprogersgroup.entity.Quarantine;
import topprogersgroup.repository.OwnerRepository;
import topprogersgroup.repository.PassportRepository;
import topprogersgroup.repository.PetRepository;
import topprogersgroup.service.OwnerService;
import topprogersgroup.service.PassportService;
import topprogersgroup.service.PetService;
import topprogersgroup.service.QuarantineService;

import java.util.List;
import java.util.Random;
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

    @Autowired
    private PassportService passportService;

    @Autowired
    private QuarantineService quarantineService;

    @Override
    public Pet save(Pet pet) {
        String guid = UUID.randomUUID().toString();
        pet.setGuid(guid);
        pet.setLast(true);
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
    public List<Pet> findIsLastPetByOwner(Integer id) {
        return petRepository.findByIsDeletedAndIsLastAndOwnerId(false,true,id);
    }

    @Override
    public Pet update(Pet pet) {
        Pet oldPet = petRepository.findOne(pet.getId());
        oldPet.setLast(false);
        petRepository.save(oldPet);
        Quarantine quarantine = quarantineService.save(pet.getQuarantine());
        pet.setQuarantine(quarantine);
        pet.setId(0);
        pet.setLast(true);
        pet.setGuid(oldPet.getGuid());
        pet.setOwner(oldPet.getOwner());
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        Passport passport = pet.getPassport();
        passport.setDeleted(true);
        passportService.update(passport);
        Quarantine quarantine = pet.getQuarantine();
        quarantine.setDeleted(true);
        quarantineService.delete(quarantine);
        pet.setDeleted(true);
        petRepository.save(pet);
    }
}
