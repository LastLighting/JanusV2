package topprogersgroup.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import topprogersgroup.entity.Bid;
import topprogersgroup.entity.Passport;

import java.util.List;
import java.util.UUID;

/**
 * Created by aalle on 16.06.2017.
 */
public interface PassportRepository extends JpaRepository<Passport, Integer> {
    Passport findOneByGuidAndIsDeletedAndIsLast(String guid, boolean isDeleted, boolean isLast);
}
