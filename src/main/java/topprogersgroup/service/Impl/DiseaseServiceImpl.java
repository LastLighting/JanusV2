package topprogersgroup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.Disease;
import topprogersgroup.repository.DiseaseRepository;
import topprogersgroup.service.DiseaseService;

import java.util.List;

/**
 * Created by aalle on 16.06.2017.
 */
@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Override
    public Disease save(Disease disease) {
        return diseaseRepository.save(disease);
    }

    @Override
    public Disease findOne(Integer id) {
        return diseaseRepository.findOne(id);
    }

    @Override
    public void delete(Disease disease) {
        diseaseRepository.delete(disease);
    }
}
