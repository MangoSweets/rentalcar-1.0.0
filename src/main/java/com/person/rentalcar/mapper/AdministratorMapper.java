package com.person.rentalcar.mapper;

import com.person.rentalcar.model.Administrator;

import java.util.List;

public interface AdministratorMapper {
    boolean addAdministrator(Administrator administrator);

    boolean updateAdministrator(Administrator administrator);

    boolean deleteAdministrator(Integer administratorId);

    boolean isExistAdminByUsername(String admin);

    Administrator selectAdministratorByadmin(String admin);

    List<Administrator> selectAllAdministrator();

}
