package topprogersgroup.service;

import org.springframework.data.domain.Pageable;
import topprogersgroup.entity.Pet;
import topprogersgroup.entity.Quarantine;

import java.util.List;

/**
 * Created by aalle on 16.06.2017.
 */
public interface QuarantineService {

    Quarantine save(Quarantine quarantine);

    Quarantine findOne(Integer id);

    void delete(Quarantine quarantine);
}
