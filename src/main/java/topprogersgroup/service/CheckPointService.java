package topprogersgroup.service;

import topprogersgroup.entity.CheckPoint;
import java.util.List;

/**
 * Created by aalle on 16.06.2017.
 */
public interface CheckPointService {

    CheckPoint save(CheckPoint checkPoint);

    CheckPoint findOne(Integer id);

    List<CheckPoint> findAllIsDeleted();

    List<CheckPoint> findAllIsNotDeleted();

    void delete(CheckPoint checkPoint);

}
