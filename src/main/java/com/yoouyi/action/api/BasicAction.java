package com.yoouyi.action.api;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.yoouyi.security.CustomUserDetail;

public class BasicAction {

    protected CustomUserDetail getUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object userDetail = authentication.getPrincipal();
        CustomUserDetail user = null;
        
        if (userDetail instanceof UserDetails) {
            user = (CustomUserDetail) userDetail;
        }
        return user;
    }

}
