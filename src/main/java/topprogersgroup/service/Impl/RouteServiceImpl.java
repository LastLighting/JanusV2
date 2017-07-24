package topprogersgroup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.Route;
import topprogersgroup.repository.RouteRepository;
import topprogersgroup.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public Route create(Route route) {
        return routeRepository.save(route);
    }

    public void delete(Route route) {
        route.setDeleted(true);
        routeRepository.save(route);
    }

    public Route edit(Route route) {
        return routeRepository.save(route);
    }
}
