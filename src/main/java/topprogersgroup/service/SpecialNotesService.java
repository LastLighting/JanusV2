package topprogersgroup.service;

import topprogersgroup.entity.SpecialNotes;
import topprogersgroup.entity.VeterinaryDocument;

import java.util.List;

public interface SpecialNotesService extends BaseService<SpecialNotes> {
    List<SpecialNotes> getSpecialNotesListByVeterinaryDocument(VeterinaryDocument veterinaryDocument);
}
