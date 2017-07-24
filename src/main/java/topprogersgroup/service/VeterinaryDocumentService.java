package topprogersgroup.service;

import org.springframework.data.domain.Pageable;
import topprogersgroup.entity.Bid;
import topprogersgroup.entity.Employee;
import topprogersgroup.entity.VeterinaryDocument;

import java.util.List;

public interface VeterinaryDocumentService extends BaseService<VeterinaryDocument> {
    List<VeterinaryDocument> getVeterinaryDocumentPagingList();
    List<VeterinaryDocument> getAllVeterinaryDocumentPagingList(Pageable pageable);
    List<VeterinaryDocument> getVeterinaryDocumentPagingListByEmployee(Employee employee);
    VeterinaryDocument getVeterinaryDocumentByBid(Bid bid);
    VeterinaryDocument getVeterinaryDocumentById(Integer id);
    List<VeterinaryDocument> findForPageByStatusAndSortDate(String status, boolean isDeleted, Pageable pageable);
}
