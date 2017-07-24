package topprogersgroup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.Administrator;
import topprogersgroup.entity.User;
import topprogersgroup.repository.AdministratorRepository;
import topprogersgroup.repository.UserRepository;
import topprogersgroup.service.AdministratorService;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private UserRepository userRepository;

    public Administrator create(Administrator administrator) {
        return  administratorRepository.save(administrator);
    }

    public void delete(Administrator administrator) {
        administrator.setDeleted(true);
        administratorRepository.save(administrator);
        Optional<User> user = userRepository.findUserByIdAndIsDeleted(administrator.getUser().getId(), false);
        user.get().setDeleted(true);
        userRepository.save(user.get());
    }

    public Administrator edit(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public List<Administrator> getAdministratorList() {
        return administratorRepository.findByIsDeleted(false);
    }

    public Administrator getAdministratorById(int id) {
        return administratorRepository.findByIdAndIsDeleted(id, false);
    }
}
