package com.example.springboot2.security;

import com.example.springboot2.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDetails implements UserDetails {
    private Users users;

    public AppUserDetails(Users users) {
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> permissonList = this.users.getPermissonList();
        for (String p:permissonList) {
            GrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(p);
            authorities.add(simpleGrantedAuthority);
        }
        List<String> rollList = this.users.getRollList();
        for (String r : rollList) {
            GrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(r);
            authorities.add(simpleGrantedAuthority);
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.users.getPassWord();
    }

    @Override
    public String getUsername() {
        return this.users.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.users.getActive()==1 ;
    }
}
