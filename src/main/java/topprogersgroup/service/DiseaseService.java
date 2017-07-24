package topprogersgroup.service;

import org.springframework.data.domain.Pageable;
import topprogersgroup.entity.Disease;
import java.util.List;

/**
 * Created by aalle on 16.06.2017.
 */
public interface DiseaseService {

    Disease save(Disease disease);

    Disease findOne(Integer id);

    void delete(Disease disease);
}
