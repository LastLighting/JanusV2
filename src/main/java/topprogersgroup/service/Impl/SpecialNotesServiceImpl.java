package topprogersgroup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.SpecialNotes;
import topprogersgroup.entity.VeterinaryDocument;
import topprogersgroup.repository.SpecialNotesRepository;
import topprogersgroup.service.SpecialNotesService;

import java.util.List;

@Service
public class SpecialNotesServiceImpl implements SpecialNotesService {

    @Autowired
    private SpecialNotesRepository specialNotesRepository;

    public void create(SpecialNotes specialNotes) {
        specialNotesRepository.save(specialNotes);
    }

    public void delete(SpecialNotes specialNotes) {
        specialNotes.setDeleted(true);
        specialNotesRepository.save(specialNotes);
    }

    public void edit(SpecialNotes specialNotes) {
        specialNotesRepository.save(specialNotes);
    }

    public List<SpecialNotes> getSpecialNotesListByVeterinaryDocument(VeterinaryDocument veterinaryDocument) {
        return specialNotesRepository.findByVeterinaryDocumentAndIsDeleted(veterinaryDocument, false);
    }
}