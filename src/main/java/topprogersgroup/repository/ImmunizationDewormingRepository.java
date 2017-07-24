package topprogersgroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import topprogersgroup.entity.ImmunizationDeworming;
import topprogersgroup.entity.Passport;

import java.util.List;

@Repository
public interface ImmunizationDewormingRepository extends JpaRepository<ImmunizationDeworming, Integer> {
    List<ImmunizationDeworming> findByPassport(Passport passport);
}
