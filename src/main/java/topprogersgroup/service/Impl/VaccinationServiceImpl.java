package topprogersgroup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.Vaccination;
import topprogersgroup.repository.VaccinationRepository;
import topprogersgroup.service.VaccinationService;

import java.util.List;

/**
 * Created by aalle on 16.06.2017.
 */
@Service
public class VaccinationServiceImpl implements VaccinationService {

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Override
    public Vaccination save(Vaccination vaccination) {
        return vaccinationRepository.save(vaccination);
    }

    @Override
    public Vaccination findOne(Integer id) {
        return vaccinationRepository.findOne(id);
    }

    @Override
    public void delete(Vaccination vaccination) {
        vaccinationRepository.delete(vaccination);
    }

    @Override
    public List<Vaccination> saveAll(List<Vaccination> vaccinations) {
        vaccinations = vaccinationRepository.save(vaccinations);
        return vaccinations;
    }
}
