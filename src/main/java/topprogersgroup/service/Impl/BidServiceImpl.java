package topprogersgroup.service.Impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.Bid;
import topprogersgroup.entity.Owner;
import topprogersgroup.entity.Pet;
import topprogersgroup.repository.BidRepository;
import topprogersgroup.service.BidService;

import javax.persistence.EntityManagerFactory;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aalle on 16.06.2017.
 */
@Service
public class BidServiceImpl implements BidService {


    @Autowired
    private BidRepository bidRepository;

    @Override
    public Bid save(Bid bid) {
        return bidRepository.save(bid);
    }

    @Override
    public Bid findOne(Integer id) {
        return bidRepository.findOne(id);
    }

    @Override
    public List<Bid> findForPageByStatusAndSortDate(String status, boolean isDeleted, Pageable pageable) {
        return bidRepository.findByStatusAndIsDeletedOrderByDepartureDate(status,isDeleted,pageable);
    }

    @Override
    public List<Bid> findForPageIsDeleted(Pageable pageable) {
        return bidRepository.findByIsDeleted(true, pageable);
    }

    @Override
    public List<Bid> findForPageIsNotDeleted(Pageable pageable) {
        return bidRepository.findByIsDeleted(false, pageable);
    }

    @Override
    public Set<Bid> findByDocumentNumberAndStatus(String status, String documentNumber, boolean isDeleted) {
        List<Bid> bids = bidRepository.findByStatusAndPetsOwnerDocumentNumberAndIsDeleted(status,documentNumber,isDeleted);
        Set<Bid> bidSet = new HashSet<Bid>(bids);
        return bidSet;
    }

    @Override
    public Set<Bid> findByEmailUser(String email, boolean isDeleted) {
        List<Bid> bids = bidRepository.findByPetsOwnerUserEmailAndIsDeleted(email,isDeleted);
        Set<Bid> bidSet = new HashSet<Bid>(bids);
        return bidSet;
    }

    @Override
    public void delete(Bid bid) {
        bid.setDeleted(true);
        bidRepository.save(bid);
    }
}
