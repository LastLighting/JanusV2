package topprogersgroup.service;

import org.springframework.data.domain.Pageable;
import topprogersgroup.entity.Bid;
import topprogersgroup.entity.Owner;

import java.util.List;
import java.util.Set;

/**
 * Created by aalle on 16.06.2017.
 */
public interface BidService {

    Bid save(Bid bid);

    Bid findOne(Integer id);

    List<Bid> findForPageByStatusAndSortDate(String status, boolean isDeleted, Pageable pageable);

    List<Bid> findForPageIsDeleted(Pageable pageable);

    List<Bid> findForPageIsNotDeleted(Pageable pageable);

    Set<Bid> findByDocumentNumberAndStatus(String status,String documentNumber,boolean isDeleted);

    Set<Bid> findByEmailUser(String email, boolean isDeleted);

    void delete(Bid bid);
}
