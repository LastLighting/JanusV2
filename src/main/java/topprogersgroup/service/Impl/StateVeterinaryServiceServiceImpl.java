package topprogersgroup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.StateVeterinaryService;
import topprogersgroup.repository.StateVeterinaryServiceRepository;
import topprogersgroup.service.StateVeterinaryServiceService;

import java.util.List;

/**
 * Created by aalle on 16.06.2017.
 */
@Service
public class StateVeterinaryServiceServiceImpl implements StateVeterinaryServiceService {

    @Autowired
    StateVeterinaryServiceRepository stateVeterinaryServiceRepository;

    @Override
    public StateVeterinaryService create(StateVeterinaryService stateVeterinaryService) {
        return stateVeterinaryServiceRepository.save(stateVeterinaryService);
    }

    @Override
    public StateVeterinaryService findOne(Integer id) {
        return stateVeterinaryServiceRepository.findOne(id);
    }

    @Override
    public List<StateVeterinaryService> findAllIsDeleted() {
        return stateVeterinaryServiceRepository.findByIsDeleted(true);
    }

    @Override
    public List<StateVeterinaryService> findAllIsNotDeleted() {
        return stateVeterinaryServiceRepository.findByIsDeleted(false);
    }

    @Override
    public void delete(StateVeterinaryService stateVeterinaryService) {
        stateVeterinaryService.setDeleted(true);
        stateVeterinaryServiceRepository.save(stateVeterinaryService);
    }


}
