package com.discom.springmvc.controller;

import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.model.UserProfile;
import com.discom.springmvc.service.AddService;
import com.discom.springmvc.service.ListService;
import com.discom.springmvc.service.UserProfileService;
import com.discom.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class ViewController {

    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;
    @Autowired
    ListService listService;
    @Autowired
    AddService addService;
    @Autowired
    MessageSource messageSource;
    @Autowired
    HttpServletRequest request;
    @Autowired
    SearchDao searchDao;
    @Autowired
    private HttpSession httpSession;


    @RequestMapping(value = {"/headerDefault"}, method = RequestMethod.GET)
    public String headerDefault(ModelMap model) {


        return "defaultheader";
    }


    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}