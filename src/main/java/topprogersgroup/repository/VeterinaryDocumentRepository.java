package topprogersgroup.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import topprogersgroup.entity.Bid;
import topprogersgroup.entity.Employee;
import topprogersgroup.entity.VeterinaryDocument;

import java.util.List;

@Repository
public interface VeterinaryDocumentRepository extends JpaRepository<VeterinaryDocument, Integer> {
    List<VeterinaryDocument> findByIsDeleted(boolean isDeleted);
    VeterinaryDocument findByBidAndIsDeleted(Bid bid, boolean isDeleted);
    List<VeterinaryDocument> findByEmployeeAndIsDeleted(Employee employee, boolean isDeleted);
    List<VeterinaryDocument> findByStatusAndIsDeletedOrderByIssueDate(String status, boolean isDeleted, Pageable pageable);
}