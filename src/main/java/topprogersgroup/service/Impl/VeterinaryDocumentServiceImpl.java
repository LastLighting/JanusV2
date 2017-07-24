package topprogersgroup.service.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.Bid;
import topprogersgroup.entity.Employee;
import topprogersgroup.entity.VeterinaryDocument;
import topprogersgroup.repository.VeterinaryDocumentRepository;
import topprogersgroup.service.VeterinaryDocumentService;

import java.util.List;

@Service
public class VeterinaryDocumentServiceImpl implements VeterinaryDocumentService {

    @Autowired
    private VeterinaryDocumentRepository veterinaryDocumentRepository;

    public VeterinaryDocument create(VeterinaryDocument veterinaryDocument) {
        return veterinaryDocumentRepository.save(veterinaryDocument);
    }

    //todo: Error Lex + Nic
    public List<VeterinaryDocument> getVeterinaryDocumentPagingList() {
        return veterinaryDocumentRepository.findByIsDeleted(false);
    }

    public List<VeterinaryDocument> getAllVeterinaryDocumentPagingList(Pageable pageable) {
        return (List<VeterinaryDocument>) veterinaryDocumentRepository.findAll(pageable);
    }

    public List<VeterinaryDocument> getVeterinaryDocumentPagingListByEmployee(Employee employee) {
        return veterinaryDocumentRepository.findByEmployeeAndIsDeleted(employee, false);
    }

    @Override
    public VeterinaryDocument getVeterinaryDocumentByBid(Bid bid) {
        return veterinaryDocumentRepository.findByBidAndIsDeleted(bid, false);
    }

    @Override
    public VeterinaryDocument getVeterinaryDocumentById(Integer id) {
        return veterinaryDocumentRepository.findOne(id);
    }
  
    public List<VeterinaryDocument> findForPageByStatusAndSortDate(String status, boolean isDeleted, Pageable pageable) {
        return veterinaryDocumentRepository.findByStatusAndIsDeletedOrderByIssueDate(status,isDeleted,pageable);
    }

    public void delete(VeterinaryDocument veterinaryDocument) {
        veterinaryDocument.setDeleted(true);
        veterinaryDocumentRepository.save(veterinaryDocument);
    }

    public VeterinaryDocument edit(VeterinaryDocument veterinaryDocument) {
        return veterinaryDocumentRepository.save(veterinaryDocument);
    }
}
