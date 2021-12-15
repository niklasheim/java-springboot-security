package net.tempest.rimuru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.tempest.rimuru.model.AuthenticatedUser;
import net.tempest.rimuru.model.User;
import net.tempest.rimuru.repo.userRepo;

@Service
public class userServ implements UserDetailsService {
    
    @Autowired
    private userRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username){
        User user = repo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("The user " + username + " does not exist");
        }
        return new AuthenticatedUser(user);
    }

    public User findByUsername(String username){
        return repo.findByUsername(username);
    }
}
