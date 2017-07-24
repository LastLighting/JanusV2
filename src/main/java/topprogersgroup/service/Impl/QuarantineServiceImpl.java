package topprogersgroup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.Quarantine;
import topprogersgroup.repository.QuarantineRepository;
import topprogersgroup.service.QuarantineService;

import java.util.List;

/**
 * Created by aalle on 16.06.2017.
 */
@Service
public class QuarantineServiceImpl implements QuarantineService {

    @Autowired
    private QuarantineRepository quarantineRepository;

    @Override
    public Quarantine save(Quarantine quarantine) {
        return quarantineRepository.save(quarantine);
    }

    @Override
    public Quarantine findOne(Integer id) {
        return quarantineRepository.getOne(id);
    }

    @Override
    public void delete(Quarantine quarantine) {
        quarantine.setDeleted(true);
        quarantineRepository.save(quarantine);
    }
}
