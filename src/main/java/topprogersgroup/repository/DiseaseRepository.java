package topprogersgroup.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import topprogersgroup.entity.Bid;
import topprogersgroup.entity.Disease;

import java.util.List;

/**
 * Created by aalle on 16.06.2017.
 */
@Repository
public interface DiseaseRepository extends JpaRepository<Disease,Integer>{
}
