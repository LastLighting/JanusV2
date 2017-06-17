package topprogersgroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import topprogersgroup.entity.StateVeterinaryService;

/**
 * Created by aalle on 16.06.2017.
 */
public interface StateVeterinaryServiceRepository extends JpaRepository<StateVeterinaryService, Integer> {
}