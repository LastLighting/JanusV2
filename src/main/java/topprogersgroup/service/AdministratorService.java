package topprogersgroup.service;


import topprogersgroup.entity.Administrator;

import java.util.List;

public interface AdministratorService extends BaseService<Administrator> {
    List<Administrator> getAdministratorList();
    Administrator getAdministratorById(int id);
}
