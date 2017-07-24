package topprogersgroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import topprogersgroup.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {

}
