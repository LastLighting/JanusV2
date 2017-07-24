package topprogersgroup.service;

import org.springframework.data.domain.Pageable;
import topprogersgroup.entity.Vaccination;

import java.util.List;

/**
 * Created by aalle on 16.06.2017.
 */
public interface VaccinationService {

    Vaccination save(Vaccination vaccination);

    Vaccination findOne(Integer id);

    void delete(Vaccination vaccination);

    List<Vaccination> saveAll(List<Vaccination> vaccinations);
}
