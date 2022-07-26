package com.baranskagata.optometry.service;

import com.baranskagata.optometry.dto.UpdatePasswordDto;
import com.baranskagata.optometry.dao.AppUser;
import com.baranskagata.optometry.dao.Optometrist;
import com.baranskagata.optometry.dao.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UserService {
    Page<AppUser> getUsers(Pageable pageable);
    Page<AppUser> getUsersByLastName(String lastName, Pageable pageable);


    AppUser saveUser(AppUser user);

    AppUser updateUser(String username, AppUser userData);

    void deleteUser(Long id);


    AppUser updatePassword(Long userId, UpdatePasswordDto updatePasswordDto);

    List<Role> getAllAppRoles();

    List<Role>  getUserRoles(String username);


    void addRoleToUser(String username, String roleName);

    AppUser getUser(String username);

    Optometrist getOptometristById(Long id);




    void removeRoleFromUser(String username, String roleName);

}
