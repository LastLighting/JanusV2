package topprogersgroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import topprogersgroup.entity.SpecialNotes;
import topprogersgroup.entity.VeterinaryDocument;

import java.util.List;

@Repository
public interface SpecialNotesRepository extends JpaRepository<SpecialNotes, Integer> {
    List<SpecialNotes> findByVeterinaryDocumentAndIsDeleted(VeterinaryDocument veterinaryDocument, boolean isDeleted);
}
