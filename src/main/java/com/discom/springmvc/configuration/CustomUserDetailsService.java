package com.discom.springmvc.configuration;

import com.discom.springmvc.model.User;
import com.discom.springmvc.model.UserProfile;
import com.discom.springmvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserService userService;

    //@Autowired
    //private HttpServletRequest request;
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String ssoId)
            throws UsernameNotFoundException {

        System.out.println(ssoId + " -SSO ID");
        User user = userService.findBySSO(ssoId);
        System.out.println(user.getUserid() + " -User");
        logger.info("User : {}", user);
        //	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        //UserDetails userDetail = (UserDetails) auth.getPrincipal();
        if (user == null) {
            logger.info("User not found");
            throw new BadCredentialsException("Username not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getUserid(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));

    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserProfile userProfile : user.getUserProfiles()) {
            logger.info("UserProfile : {}", userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        }
        logger.info("authorities : {}", authorities);
        return authorities;
    }

}
