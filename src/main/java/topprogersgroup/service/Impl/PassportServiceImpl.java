package topprogersgroup.service.Impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import topprogersgroup.entity.ImmunizationDeworming;
import topprogersgroup.entity.Passport;
import topprogersgroup.entity.UploadImage;
import topprogersgroup.entity.Vaccination;
import topprogersgroup.repository.ImageRepository;
import topprogersgroup.repository.PassportRepository;
import topprogersgroup.service.ImmunizationDewormingService;
import topprogersgroup.service.PassportService;
import topprogersgroup.service.VaccinationService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class PassportServiceImpl implements PassportService {

    @Autowired
    private PassportRepository passportRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private VaccinationService vaccinationService;

    @Autowired
    private ImmunizationDewormingService immunizationDewormingService;

    public void uploadPassportImage(MultipartFile image, Passport passport) {
        ClassLoader classLoader = getClass().getClassLoader();
        String projectPath = classLoader.getResource("").getPath();
        String basicProjectPath = projectPath.substring(1, projectPath.indexOf("target"));
        String absoluteImagePath = basicProjectPath + "src/main/webapp/resources/images/passport/" +
                passport.getGuid() + "/" + passport.getId() + "/" +
                generateImageName() + getFileExtension(image.getOriginalFilename());
        String imagePathForPage = absoluteImagePath.substring(absoluteImagePath.indexOf("/resources"),
                absoluteImagePath.length()).replace("\\", "/");
        try {
            File dir = new File(absoluteImagePath);
            if (!dir.exists()) {
                dir.getParentFile().mkdirs();
            }
            image.transferTo(dir);
            UploadImage uploadImage = new UploadImage();
            uploadImage.setName(image.getOriginalFilename());
            uploadImage.setPath(imagePathForPage);
            uploadImage.setPassport(passport);
            imageRepository.save(uploadImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileExtension(String fileName) {
        int index = 0;
        for (int i = 0; i < fileName.length(); i++) {
            if (fileName.charAt(i) == '.') {
                index = i;
            }
        }
        return fileName.substring(index, fileName.length());
    }

    public String generateImageName() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        char[] text = new char[10];
        for (int i = 0; i < text.length; i++) {
            text[i] = alphabet.charAt(new Random().nextInt(60));
        }
        return new String(text);
    }

    @Override
    public Passport save(Passport passport) {
        String guid = UUID.randomUUID().toString();
        passport.setGuid(guid);
        passport.setLast(true);
        passport = passportRepository.save(passport);
        for (Vaccination vaccination : passport.getVaccination()) {
            vaccination.setPassport(passport);
        }
        for (ImmunizationDeworming immunizationDeworming : passport.getImmunizationDeworming()) {
            immunizationDeworming.setPassport(passport);
        }
        vaccinationService.saveAll(passport.getVaccination());
        immunizationDewormingService.saveAll(passport.getImmunizationDeworming());
        return passport;
    }

    @Override
    public Passport findOne(Integer id) {
        return passportRepository.findOne(id);
    }

    @Override
    public Passport findByGuid(String guid) {
        return passportRepository.findOneByGuidAndIsDeletedAndIsLast(guid, false, true);
    }

    @Override
    public Passport update(Passport passport) {
        Passport oldPassport = passportRepository.findOne(passport.getId());
        oldPassport.setLast(false);
        passportRepository.save(oldPassport);
        passport.setId(0);
        passport.setLast(true);
        passport.setOwner(oldPassport.getOwner());
        passport.setGuid(oldPassport.getGuid());
        passport = passportRepository.save(passport);
        for (Vaccination vaccination : passport.getVaccination()) {
            vaccination.setPassport(passport);
        }
        for (ImmunizationDeworming immunizationDeworming : passport.getImmunizationDeworming()) {
            immunizationDeworming.setPassport(passport);
        }
        vaccinationService.saveAll(passport.getVaccination());
        immunizationDewormingService.saveAll(passport.getImmunizationDeworming());
        return passport;
    }

    @Override
    public void delete(Passport passport) {
        passport.setLast(false);
        passport.setDeleted(true);
        passportRepository.save(passport);
    }
}
