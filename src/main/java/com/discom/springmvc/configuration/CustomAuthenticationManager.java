package com.discom.springmvc.configuration;


import com.discom.springmvc.model.User;
import com.discom.springmvc.model.UserProfile;
import com.discom.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * A custom authentication manager that allows access if the user details
 * exist in the database and if the username and password are not the same.
 * Otherwise, throw a {@link BadCredentialsException}
 */
public class CustomAuthenticationManager implements AuthenticationManager {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;
    // Our custom DAO layer
    //private UserDAO userDAO = new UserDAO();

    // We need an Md5 encoder since our passwords in the database are Md5 encoded.
    //private Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

    public Authentication authenticate(Authentication auth)
            throws AuthenticationException {


        User user = null;
        System.out.println("name  " + auth.getName());
        System.out.println("pass  " + (String) auth.getCredentials());
        // Init a database user object
        //DbUser user = null;

        try {
            // Retrieve user details from database
            user = userService.findBySSO(auth.getName());
            System.out.println("user " + user);
        } catch (Exception e) {

            throw new BadCredentialsException("User does not exists!");
        }
        if (user == null) {
            throw new BadCredentialsException("User does not exists!");
        }
        // Compare passwords
        // Make sure to encode the password first before comparing
        if (user.getPassword().equals((String) auth.getCredentials()) == false) {

            throw new BadCredentialsException("Wrong password!");
        }

        // Here's the main logic of this custom authentication manager
        // Username and password must be the same to authenticate
        if (auth.getName().equals(auth.getCredentials()) == true) {

            throw new BadCredentialsException("Entered username and password are the same!");

        } else {


            return new UsernamePasswordAuthenticationToken(
                    auth.getName(),
                    auth.getCredentials(),
                    getGrantedAuthorities(user));
        }
    }

    /**
     * Retrieves the correct ROLE type depending on the access level, where access level is an Integer.
     * Basically, this interprets the access value whether it's for a regular user or admin.
     *
     * @param access an integer value representing the access of the user
     * @return collection of granted authorities
     */

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserProfile userProfile : user.getUserProfiles()) {

            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        }

        return authorities;
    }
	/*
	 public Collection<GrantedAuthority> getAuthorities(Integer access) {
			// Create a list of grants for this user
			List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
			
			// All users are granted with ROLE_USER access
			// Therefore this user gets a ROLE_USER by default
			
			authList.add(new GrantedAuthorityImpl("ROLE_USER"));
			
			// Check if this user has admin access 
			// We interpret Integer(1) as an admin user
			if ( access.compareTo(1) == 0) {
				// User has admin access
			
				authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
			}

			// Return list of granted authorities
			return authList;
	  }
*/
}