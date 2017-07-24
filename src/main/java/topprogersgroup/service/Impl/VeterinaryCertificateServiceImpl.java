package topprogersgroup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.VeterinaryCertificate;
import topprogersgroup.entity.VeterinaryDocument;
import topprogersgroup.repository.VeterinaryCertificateRepository;
import topprogersgroup.service.VeterinaryCertificateService;
import topprogersgroup.ws.client.WebServiceClient;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;

@Service
public class VeterinaryCertificateServiceImpl implements VeterinaryCertificateService {

    @Autowired
    private VeterinaryCertificateRepository veterinaryCertificateRepository;

    @Autowired
    private WebServiceClient webServiceClient;

    public VeterinaryCertificate create(VeterinaryCertificate veterinaryCertificate) {
        return veterinaryCertificateRepository.save(veterinaryCertificate);
    }

    public void delete(VeterinaryCertificate veterinaryCertificate) {
        veterinaryCertificate.setDeleted(true);
        veterinaryCertificateRepository.save(veterinaryCertificate);
    }

    public VeterinaryCertificate edit(VeterinaryCertificate veterinaryCertificate) {
        return veterinaryCertificateRepository.save(veterinaryCertificate);
    }

    public VeterinaryCertificate getVeterinaryCertificateListByVeterinaryDocument(VeterinaryDocument veterinaryDocument) {
        return veterinaryCertificateRepository.findByVeterinaryDocumentAndIsDeleted(veterinaryDocument, false);
    }

    public List<VeterinaryCertificate> getVeterinaryCertificateList() {
        return veterinaryCertificateRepository.findAll();
    }

    public String getStatusFromForeignSystem(VeterinaryCertificate veterinaryCertificate) {
        try {
            return webServiceClient.getVeterinaryCertificateStatus(veterinaryCertificate);
        }
        catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public List<VeterinaryCertificate> findForPageByStatusAndSortDate(String status, boolean isDeleted, Pageable pageable) {
        return veterinaryCertificateRepository.findByStatusAndIsDeletedOrderByIssueDate(status,isDeleted,pageable);
    }

    @Override
    public List<VeterinaryCertificate> findForPageBySortDate(boolean isDeleted, Pageable pageable) {
        return veterinaryCertificateRepository.findByIsDeletedOrderByIssueDate(isDeleted,pageable);
    }

    @Override
    public VeterinaryCertificate findById(int idVeterinaryCertificate) {
        return veterinaryCertificateRepository.findOne(idVeterinaryCertificate);
    }
}
