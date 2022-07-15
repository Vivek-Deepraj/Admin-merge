package com.discom.springmvc.service;

import com.discom.springmvc.model.User;

import java.util.List;


public interface UserService {

    User findById(int id);

    User findBySSO(String sso);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserBySSO(String sso);

    //  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    List<User> findAllUsers();

    boolean isUserSSOUnique(Integer id, String sso);

}