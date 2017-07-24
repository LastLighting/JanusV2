package topprogersgroup.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import topprogersgroup.entity.CheckPoint;
import topprogersgroup.entity.Passport;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Repository
public interface PassportService {

    void uploadPassportImage(MultipartFile image, Passport passport);

    Passport save(Passport passport);

    Passport findOne(Integer id);

    Passport findByGuid(String guid);

    Passport update(Passport passport);

    void delete(Passport passport);
}
