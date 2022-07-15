package com.discom.springmvc.configuration;

import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.pojo.Activitylog;
import com.discom.springmvc.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    private SearchDao searchDao;
    @Autowired
    private AddService addService;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Authentication authentication) throws IOException, ServletException {
        System.out.println("User Successfully Logout " + httpServletRequest + " " + authentication);

        if (authentication != null) {
            Activitylog logModel = new Activitylog();
            try {
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            System.out.println("User Logged out" + authentication.getPrincipal());
            addService.saveActivitylog(logModel, "User Logged out");
        }

        if (authentication != null) {
            try {
                httpServletRequest.getSession().invalidate();
                System.out.println("User Successfully Logout");
                //you can add more codes here when the user successfully logs out,
                //such as updating the database for last active.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        //redirect to login
        httpServletResponse.sendRedirect("login");
    }


    private String getPrincipal(Authentication authentication) {
        String userName = null;
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}