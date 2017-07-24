package topprogersgroup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.ImmunizationDeworming;
import topprogersgroup.entity.Passport;
import topprogersgroup.repository.ImmunizationDewormingRepository;
import topprogersgroup.service.ImmunizationDewormingService;

import java.util.List;

@Service
public class ImmunizationDewormingServiceImpl implements ImmunizationDewormingService {

    @Autowired
    private ImmunizationDewormingRepository immunizationDewormingRepository;

    public ImmunizationDeworming create(ImmunizationDeworming immunizationDeworming) {
        return immunizationDewormingRepository.save(immunizationDeworming);
    }

    public void delete(ImmunizationDeworming immunizationDeworming) {
        immunizationDewormingRepository.delete(immunizationDeworming);
    }

    public ImmunizationDeworming edit(ImmunizationDeworming immunizationDeworming) {
        return immunizationDewormingRepository.save(immunizationDeworming);
    }

    public List<ImmunizationDeworming> getImmunizationDewormingListByPassport(Passport passport) {
        return immunizationDewormingRepository.findByPassport(passport);
    }

    @Override
    public List<ImmunizationDeworming> saveAll(List<ImmunizationDeworming> immunizationDewormings) {
        immunizationDewormings = immunizationDewormingRepository.save(immunizationDewormings);
        return immunizationDewormings;
    }
}
