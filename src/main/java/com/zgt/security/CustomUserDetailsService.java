package com.zgt.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.zgt.model.RolePO;
import com.zgt.model.UserPO;
import com.zgt.service.UserService;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    Logger logger = Logger.getLogger("CustomUserDetailsService");

    private UserService usersService;

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserPO user = usersService.getUserByName(username);
        Collection<GrantedAuthority> authorities = obtionGrantedAuthorities(user);
        logger.info("user name: " + user.getUsername());
        User userDetails = new User(user.getUsername(), user.getPassword(),
                user.isEnable(), true, true, true, authorities);
        return userDetails;
    }

    private Collection<GrantedAuthority> obtionGrantedAuthorities(UserPO user) {
        Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
        RolePO role = user.getRole();

        authSet.add(new GrantedAuthorityImpl(role.getName()));
        return authSet;
    }

    public UserService getUsersService() {
        return usersService;
    }

    @Resource
    public void setUsersService(UserService usersService) {
        this.usersService = usersService;
    }

}