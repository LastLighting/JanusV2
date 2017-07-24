package topprogersgroup.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import topprogersgroup.entity.Bid;
import topprogersgroup.entity.Quarantine;

import java.util.List;

/**
 * Created by aalle on 16.06.2017.
 */
public interface QuarantineRepository extends JpaRepository<Quarantine,Integer> {
    List<Quarantine> findByIsDeleted(boolean isDeleted);
}
