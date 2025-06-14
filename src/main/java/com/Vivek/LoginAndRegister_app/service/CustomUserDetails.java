package com.Vivek.LoginAndRegister_app.service;

import com.Vivek.LoginAndRegister_app.model.User;
import com.Vivek.LoginAndRegister_app.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetails implements UserDetailsService {
    private UserRepository userRepository;
    public CustomUserDetails(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found with given name");
        }
        return org.springframework.security.core.userdetails.User.withUsername(user.getUserName()).password(user.getPassword()).roles(user.getRole()).build();
    }
}
