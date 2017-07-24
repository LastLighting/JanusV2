package topprogersgroup.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import topprogersgroup.entity.Bid;
import topprogersgroup.entity.Owner;
import topprogersgroup.entity.User;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner,Integer> {
    List<Owner> findByIsDeleted(boolean isDeleted, Pageable pageable);
    Owner findOneByDocumentNumber(String documentnumber);
}


