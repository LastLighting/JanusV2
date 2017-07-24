package topprogersgroup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.CheckPoint;
import topprogersgroup.repository.CheckPointRepository;
import topprogersgroup.service.CheckPointService;

import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Created by aalle on 16.06.2017.
 */
@Service
public class CheckPointServiceImpl implements CheckPointService {

    @Autowired
    CheckPointRepository checkPointRepository;

    @Override
    public CheckPoint save(CheckPoint checkPoint) {
        return checkPointRepository.save(checkPoint);
    }

    @Override
    public CheckPoint findOne(Integer id) {
        return checkPointRepository.findOne(id);
    }

    @Override
    public List<CheckPoint> findAllIsDeleted() {
        return checkPointRepository.findByIsDeleted(true);
    }

    @Override
    public List<CheckPoint> findAllIsNotDeleted() {
        return checkPointRepository.findByIsDeleted(false);
    }

    @Override
    public void delete(CheckPoint checkPoint) {
        checkPoint.setDeleted(true);
        checkPointRepository.save(checkPoint);
    }
}
