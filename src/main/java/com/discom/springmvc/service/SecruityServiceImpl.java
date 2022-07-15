package com.discom.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Component(value = "securityService1")
public class SecruityServiceImpl {

    @Autowired
    private HttpServletRequest request;

    public boolean userHasPermissionForURL(final Authentication auth, String url) {
        System.out.println("in test");
        HttpSession session = request.getSession();
        HashMap<String, Boolean> permList = (HashMap) (session.getAttribute("permList"));
        Boolean perm = permList.get(url);

        return perm;
    }
}