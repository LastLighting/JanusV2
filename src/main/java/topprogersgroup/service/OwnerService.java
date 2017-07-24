package topprogersgroup.service;

import org.springframework.data.domain.Pageable;
import topprogersgroup.entity.Owner;
import topprogersgroup.entity.User;

import java.util.List;

public interface OwnerService {

    Owner save(Owner owner);

    Owner findOne(Integer id);

    Owner findOwnerByEmailUser(String email);

    List<Owner> findForPageIsDeleted(Pageable pageable);

    List<Owner> findForPageIsNotDeleted(Pageable pageable);

    void delete(Owner owner);

}
