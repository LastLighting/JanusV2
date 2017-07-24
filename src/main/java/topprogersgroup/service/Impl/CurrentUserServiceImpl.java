package topprogersgroup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.Bid;
import topprogersgroup.entity.CurrentUser;
import topprogersgroup.entity.Pet;
import topprogersgroup.entity.Role;
import topprogersgroup.service.BidService;
import topprogersgroup.service.CurrentUserService;
import topprogersgroup.service.PetService;

import java.util.List;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    @Autowired
    private BidService bidService;

    @Autowired
    private PetService petService;

    public boolean canAccessOwnerBids(CurrentUser currentUser, int bidId) {
        return currentUser != null && (checkContainsBid(currentUser, bidId));
    }

    public boolean checkContainsBid(CurrentUser currentUser, int bidId) {
        boolean access = false;
        for (Pet pet : currentUser.getUser().getOwner().getPet()) {
            if (pet.getBids().contains(bidService.findOne(bidId)))
                access = true;
        }
        return access;
    }

    public boolean canAccessOwnerPets(CurrentUser currentUser, int petId) {
        boolean access = false;
        if (currentUser != null) {
            for (Pet pet : currentUser.getUser().getOwner().getPet()) {
                if (pet.getGuid().equals(petService.findOne(petId).getGuid())) {
                    access = true;
                    break;
                }
            }
        }
        return access;
    }

    @Override
    public String getUserEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
