package com.target.myRetail.service;

import com.target.myRetail.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.target.myRetail.repository.UserRepo;
import com.target.myRetail.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Shreya on 12/12/2017.
 */
@Service
public class UserRoleService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepo.findByUsername(username);
        if( user == null){
            throw new UsernameNotFoundException("User "+username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
    }

    private Collection<GrantedAuthority> getAuthorities (User user){
        Collection<GrantedAuthority> grantedAuthority = new ArrayList();
        List<Roles> rolesList = user.getRolesList();

        grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
        for (Roles roles : rolesList){
            if (roles.getRoleName().equalsIgnoreCase("admin")){
                grantedAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        }
        return grantedAuthority;
    }




}
