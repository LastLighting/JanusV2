package topprogersgroup.service;

import org.springframework.data.domain.Pageable;
import topprogersgroup.entity.Bid;
import topprogersgroup.entity.CheckPoint;
import topprogersgroup.entity.StateVeterinaryService;

import java.util.List;

public interface StateVeterinaryServiceService  {

    StateVeterinaryService create(StateVeterinaryService stateVeterinaryService);

    StateVeterinaryService findOne(Integer id);

    List<StateVeterinaryService> findAllIsDeleted();

    List<StateVeterinaryService> findAllIsNotDeleted();

    void delete(StateVeterinaryService stateVeterinaryService);
}
