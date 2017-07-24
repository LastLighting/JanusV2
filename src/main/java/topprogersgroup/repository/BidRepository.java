package topprogersgroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import topprogersgroup.entity.Bid;

import org.springframework.data.domain.Pageable;
import topprogersgroup.entity.Pet;

import java.sql.Date;
import java.util.List;

/**
 * Created by aalle on 16.06.2017.
 */
public interface BidRepository extends JpaRepository<Bid,Integer> {
    List<Bid> findByIsDeleted(boolean isDeleted, Pageable pageable);
    List<Bid> findByStatusAndIsDeletedOrderByDepartureDate(String status, boolean isDeleted, Pageable pageable);
    List<Bid> findByStatusAndPetsOwnerDocumentNumberAndIsDeleted(String status, String documentNumber, boolean isDeleted);
    List<Bid> findByPetsOwnerUserEmailAndIsDeleted(String email, boolean isDeleted);
}
