package topprogersgroup.service;


import topprogersgroup.entity.CurrentUser;

public interface CurrentUserService {
    boolean canAccessOwnerBids(CurrentUser currentUser, int bidId);
    String getUserEmail();
}
