package topprogersgroup.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import topprogersgroup.entity.Bid;
import topprogersgroup.entity.VeterinaryCertificate;
import topprogersgroup.entity.VeterinaryDocument;

import java.util.List;

@Repository
public interface VeterinaryCertificateRepository extends JpaRepository<VeterinaryCertificate, Integer> {
    VeterinaryCertificate findByVeterinaryDocumentAndIsDeleted(VeterinaryDocument veterinaryDocument, boolean isDeleted);
    List<VeterinaryCertificate> findByStatusAndIsDeletedOrderByIssueDate(String status, boolean isDeleted, Pageable pageable);
    List<VeterinaryCertificate> findByIsDeletedOrderByIssueDate(boolean isDeleted, Pageable pageable);
}
