package com.discom.springmvc.service;

import com.discom.springmvc.model.UserProfile;

import java.util.List;


public interface UserProfileService {

    UserProfile findById(int id);

    UserProfile findByType(String type);

    List<UserProfile> findAll();

}
