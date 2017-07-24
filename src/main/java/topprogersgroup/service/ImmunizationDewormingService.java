package topprogersgroup.service;

import topprogersgroup.entity.ImmunizationDeworming;
import topprogersgroup.entity.Passport;

import java.util.List;

public interface ImmunizationDewormingService extends BaseService<ImmunizationDeworming> {

    List<ImmunizationDeworming> getImmunizationDewormingListByPassport(Passport passport);

    List<ImmunizationDeworming> saveAll(List<ImmunizationDeworming> immunizationDewormings);
}
