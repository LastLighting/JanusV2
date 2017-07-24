package topprogersgroup.service;


import org.springframework.data.domain.Pageable;
import topprogersgroup.entity.Bid;
import topprogersgroup.entity.VeterinaryCertificate;
import topprogersgroup.entity.VeterinaryDocument;

import java.util.List;

public interface VeterinaryCertificateService extends BaseService<VeterinaryCertificate> {
    VeterinaryCertificate getVeterinaryCertificateListByVeterinaryDocument(VeterinaryDocument veterinaryDocument);
    List<VeterinaryCertificate> getVeterinaryCertificateList();
    List<VeterinaryCertificate> findForPageByStatusAndSortDate(String status, boolean isDeleted, Pageable pageable);
    String getStatusFromForeignSystem(VeterinaryCertificate veterinaryCertificate);
    List<VeterinaryCertificate> findForPageBySortDate(boolean isDeleted, Pageable pageable);
    VeterinaryCertificate findById(int idVeterinaryCertificate);
}
